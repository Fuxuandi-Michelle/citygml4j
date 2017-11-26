package org.citygml4j.builder.json.unmarshal.citygml.appearance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.citygml4j.builder.json.objects.appearance.AbstractMaterialObject;
import org.citygml4j.builder.json.objects.appearance.AbstractTextureObject;
import org.citygml4j.builder.json.objects.appearance.AppearanceType;
import org.citygml4j.builder.json.objects.appearance.MaterialType;
import org.citygml4j.builder.json.objects.appearance.TextureType;
import org.citygml4j.builder.json.unmarshal.CityJSONUnmarshaller;
import org.citygml4j.model.citygml.appearance.AbstractSurfaceData;
import org.citygml4j.model.citygml.appearance.Appearance;
import org.citygml4j.model.citygml.appearance.AppearanceProperty;
import org.citygml4j.model.citygml.appearance.Color;
import org.citygml4j.model.citygml.appearance.ColorPlusOpacity;
import org.citygml4j.model.citygml.appearance.ParameterizedTexture;
import org.citygml4j.model.citygml.appearance.SurfaceDataProperty;
import org.citygml4j.model.citygml.appearance.TexCoordList;
import org.citygml4j.model.citygml.appearance.TextureAssociation;
import org.citygml4j.model.citygml.appearance.TextureCoordinates;
import org.citygml4j.model.citygml.appearance.WrapMode;
import org.citygml4j.model.citygml.appearance.X3DMaterial;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.gml.basicTypes.Code;
import org.citygml4j.model.gml.geometry.primitives.AbstractSurface;
import org.citygml4j.model.gml.geometry.primitives.LinearRing;
import org.citygml4j.util.gmlid.DefaultGMLIdManager;
import org.citygml4j.util.gmlid.GMLIdManager;
import org.citygml4j.util.walker.GeometryWalker;

public class AppearanceUnmarshaller {
	private List<MaterialType> materials;
	private List<TextureType> textures;
	private List<List<Double>> textureVertices;
	
	private int numTextureVertices;
	private String textureFolder = "appearances";
	private GMLIdManager gmlIdManager;
	
	public void setAppearanceInfo(AppearanceType appearanceType) {
		this.materials = appearanceType.isSetMaterials() ? appearanceType.getMaterials() : Collections.emptyList();
		this.textures = appearanceType.isSetTextures() ? appearanceType.getTextures() : Collections.emptyList();
		this.textureVertices = appearanceType.isSetTextureVertices() ? appearanceType.getTextureVertices() : Collections.emptyList();
		
		numTextureVertices = textureVertices.size();
		gmlIdManager = DefaultGMLIdManager.getInstance();
	}

	public void unmarshalMaterial(AbstractMaterialObject src, Map<Integer, List<AbstractSurface>> surfaces, AbstractCityObject parent) {
		Appearance appearance = getOrCreateAppearance(src.getTheme(), parent);

		for (Entry<Integer, List<AbstractSurface>> entry : surfaces.entrySet()) {
			MaterialType materialType = materials.get(entry.getKey());
			if (materialType == null)
				continue;

			X3DMaterial material = getOrCreateX3DMaterial(materialType, entry.getKey(), appearance);
			for (AbstractSurface surface : entry.getValue()) {
				if (!surface.isSetId())
					surface.setId(gmlIdManager.generateUUID());
				
				material.addTarget(new StringBuilder("#").append(surface.getId()).toString());
			}
		}
	}

	@SuppressWarnings("unchecked")
	public void unmarshalParameterizedTexture(AbstractTextureObject src, Map<Integer, List<AbstractSurface>> surfaces, AbstractCityObject parent) {
		Appearance appearance = getOrCreateAppearance(src.getTheme(), parent);

		for (Entry<Integer, List<AbstractSurface>> entry : surfaces.entrySet()) {
			TextureType textureType = textures.get(entry.getKey());
			if (textureType == null)
				continue;

			ParameterizedTexture texture = getOrCreateParameterizedTexture(textureType, entry.getKey(), appearance);
			for (AbstractSurface surface : entry.getValue()) {
				TexCoordList texCoordList = new TexCoordList();
				List<List<Integer>> values = (List<List<Integer>>)surface.getLocalProperty(CityJSONUnmarshaller.TEXTURE_COORDINATES);
				int[] i = new int[]{-1};

				surface.accept(new GeometryWalker() {
					public void visit(LinearRing linearRing) {
						i[0]++;

						if (i[0] < values.size()) {
							List<Integer> value = values.get(i[0]);
							if (value == null || value.size() < 2)
								return;

							List<Double> coords = getTextureVertices(value);
							if (coords.isEmpty())
								return;

							if (!linearRing.isSetId())
								linearRing.setId(gmlIdManager.generateUUID());

							TextureCoordinates textureCoordinates = new TextureCoordinates();
							textureCoordinates.setRing(new StringBuilder("#").append(linearRing.getId()).toString());
							textureCoordinates.setValue(coords);
							texCoordList.addTextureCoordinates(textureCoordinates);
						}
					}
				});

				if (texCoordList.isSetTextureCoordinates()) {
					if (!surface.isSetId())
						surface.setId(gmlIdManager.generateUUID()); 
					
					TextureAssociation target = new TextureAssociation();
					target.setUri(new StringBuilder("#").append(surface.getId()).toString());
					target.setTextureParameterization(texCoordList);
					texture.addTarget(target);
				}
			}
		}
	}

	public void unmarshalParameterizedTexture(TextureType src, ParameterizedTexture dest) {
		if (src.isSetImage())
			dest.setImageURI(new StringBuilder(textureFolder).append("/").append(src.getImage()).toString());

		if (src.isSetType())
			dest.setMimeType(new Code(src.getType().getMimeType()));

		if (src.isSetWrapMode())
			dest.setWrapMode(WrapMode.fromValue(src.getWrapMode().getValue()));

		if (src.isSetTextureType())
			dest.setTextureType(org.citygml4j.model.citygml.appearance.TextureType.fromValue(src.getTextureType().getValue()));

		if (src.isSetBorderColor()) {
			List<Double> color = src.getBorderColor();
			if (color != null) {
				if (color.size() == 3)
					dest.setBorderColor(new ColorPlusOpacity(color.get(0), color.get(1), color.get(2)));
				else if (color.size() > 3)
					dest.setBorderColor(new ColorPlusOpacity(color.get(0), color.get(1), color.get(2), color.get(3)));
			}
		}
	}

	public ParameterizedTexture unmarshalParameterizedTexture(TextureType src) {
		ParameterizedTexture dest = new ParameterizedTexture();
		unmarshalParameterizedTexture(src, dest);

		return dest;
	}

	public void unmarshalMaterial(MaterialType src, X3DMaterial dest) {
		if (src.isSetName())
			dest.addName(new Code(src.getName()));

		if (src.isSetAmbientIntensity())
			dest.setAmbientIntensity(src.getAmbientIntensity());

		if (src.isSetDiffuseColor()) {
			List<Double> color = src.getDiffuseColor();
			if (color != null && color.size() > 2)
				dest.setDiffuseColor(new Color(color.get(0), color.get(1), color.get(2)));
		}

		if (src.isSetEmissiveColor()) {
			List<Double> color = src.getEmissiveColor();
			if (color != null && color.size() > 2)
				dest.setEmissiveColor(new Color(color.get(0), color.get(1), color.get(2)));
		}

		if (src.isSetSpecularColor()) {
			List<Double> color = src.getSpecularColor();
			if (color != null && color.size() > 2)
				dest.setSpecularColor(new Color(color.get(0), color.get(1), color.get(2)));
		}

		if (src.isSetShininess())
			dest.setShininess(src.getShininess());

		if (src.isSetTransparency())
			dest.setTransparency(src.getTransparency());

		if (src.isSmooth())
			dest.setIsSmooth(src.isSmooth());
	}

	public X3DMaterial unmarshalMaterial(MaterialType src) {
		X3DMaterial dest = new X3DMaterial();
		unmarshalMaterial(src, dest);

		return dest;
	}

	private Appearance getOrCreateAppearance(String theme, AbstractCityObject parent) {
		Appearance dest = null;

		for (AppearanceProperty property : parent.getAppearance()) {
			Appearance appearance = property.getAppearance();
			if ((!theme.isEmpty() && theme.equals(appearance.getTheme())) 
					|| (theme.isEmpty() && !appearance.isSetTheme())) {
				dest = appearance;
				break;
			}
		}

		if (dest == null) {
			dest = new Appearance();
			if (!theme.isEmpty())
				dest.setTheme(theme);
			
			parent.addAppearance(new AppearanceProperty(dest));
		}

		return dest;
	}

	private X3DMaterial getOrCreateX3DMaterial(MaterialType src, int surfaceDataId, Appearance appearance) {
		X3DMaterial dest = null;

		for (SurfaceDataProperty property : appearance.getSurfaceDataMember()) {
			AbstractSurfaceData surfaceData = property.getSurfaceData();
			if (!(surfaceData instanceof X3DMaterial))
				continue;

			X3DMaterial material = (X3DMaterial)surfaceData;
			if ((int)material.getLocalProperty(CityJSONUnmarshaller.SURFACE_DATA_ID) == surfaceDataId) {
				dest = material;
				break;
			}
		}

		if (dest == null) {
			dest = unmarshalMaterial(src);			
			dest.setLocalProperty(CityJSONUnmarshaller.SURFACE_DATA_ID, surfaceDataId);
			appearance.addSurfaceDataMember(new SurfaceDataProperty(dest));
		}

		return dest;
	}

	private ParameterizedTexture getOrCreateParameterizedTexture(TextureType src, int surfaceDataId, Appearance appearance) {
		ParameterizedTexture dest = null;

		for (SurfaceDataProperty property : appearance.getSurfaceDataMember()) {
			AbstractSurfaceData surfaceData = property.getSurfaceData();
			if (!(surfaceData instanceof ParameterizedTexture))
				continue;

			ParameterizedTexture texture = (ParameterizedTexture)surfaceData;
			if ((int)texture.getLocalProperty(CityJSONUnmarshaller.SURFACE_DATA_ID) == surfaceDataId) {
				dest = texture;
				break;
			}
		}

		if (dest == null) {
			dest = unmarshalParameterizedTexture(src);
			dest.setLocalProperty(CityJSONUnmarshaller.SURFACE_DATA_ID, surfaceDataId);
			appearance.addSurfaceDataMember(new SurfaceDataProperty(dest));
		}

		return dest;
	}

	private List<Double> getTextureVertices(List<Integer> indexes) {
		List<Double> vertices = new ArrayList<>();		
		for (int i = 1; i < indexes.size(); i++) {
			Integer index = indexes.get(i);
			if (index != null && index < numTextureVertices) {
				List<Double> vertex = this.textureVertices.get(index);
				if (vertex != null && vertex.size() == 2)
					vertices.addAll(vertex);
			}
		}

		return vertices;
	}

}