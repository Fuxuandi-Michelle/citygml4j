package org.citygml4j.model.citygml.buildingExtra;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.building.BoundarySurfaceProperty;
import org.citygml4j.model.citygml.building.BuildingInstallationProperty;
import org.citygml4j.model.citygml.building.IntBuildingInstallationProperty;
import org.citygml4j.model.citygml.building.InteriorFurnitureProperty;
import org.citygml4j.model.citygml.building.InteriorRoomProperty;
import org.citygml4j.model.citygml.core.AbstractSite;
import org.citygml4j.model.citygml.core.LodRepresentation;
import org.citygml4j.model.citygml.core.StandardObjectClassifier;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.common.visitor.FeatureFunctor;
import org.citygml4j.model.common.visitor.FeatureVisitor;
import org.citygml4j.model.common.visitor.GMLFunctor;
import org.citygml4j.model.common.visitor.GMLVisitor;
import org.citygml4j.model.gml.basicTypes.Code;
import org.citygml4j.model.gml.feature.BoundingShape;
import org.citygml4j.model.gml.geometry.AbstractGeometry;
import org.citygml4j.model.gml.geometry.GeometryProperty;
import org.citygml4j.model.gml.geometry.aggregates.MultiCurveProperty;
import org.citygml4j.model.gml.geometry.aggregates.MultiSurfaceProperty;
import org.citygml4j.model.gml.geometry.primitives.SolidProperty;
import org.citygml4j.model.gml.measures.Length;
import org.citygml4j.model.module.citygml.BuildingExtraModule;
import org.w3c.dom.Element;


public class Storey extends AbstractSite implements BuildingExtraModuleComponent, StandardObjectClassifier {
	private Code clazz;
	private List<Code> function;
	private List<Code> usage;
	private Length measuredHeight;
	
	private SolidProperty lod2Solid;
	private SolidProperty lod3Solid;
	private SolidProperty lod4Solid;
	
	private MultiSurfaceProperty lod2MultiSurface;
	private MultiSurfaceProperty lod3MultiSurface;
	private MultiSurfaceProperty lod4MultiSurface;
	
	private MultiCurveProperty lod2MultiCurve;
	private MultiCurveProperty lod3MultiCurve;
	private MultiCurveProperty lod4MultiCurve;
	
	private List<BuildingInstallationProperty> outerBuildingInstallation;
	private List<IntBuildingInstallationProperty> interiorBuildingInstallation;
	
	private List<InteriorRoomProperty> interiorRoom;
	private List<InteriorFurnitureProperty> interiorFurniture;
	
	private List<BoundarySurfaceProperty> boundedBySurface;

	private BuildingExtraModule module;	
	
	public Storey() {
		
	}
	
	public Storey(BuildingExtraModule module) {
		this.module = module;
	}
	
	public void addBoundedBySurface(BoundarySurfaceProperty boundedBySurface) {
		if (this.boundedBySurface == null)
			this.boundedBySurface = new ChildList<BoundarySurfaceProperty>(this);

		this.boundedBySurface.add(boundedBySurface);
	}

	
	public void addFunction(Code function) {
		if (this.function == null)
			this.function = new ChildList<Code>(this);

		this.function.add(function);
	}
	
	public void addUsage(Code function) {
		if (this.usage == null)
			this.usage = new ChildList<Code>(this);

		this.usage.add(function);
	}



	public void addInteriorBuildingInstallation(IntBuildingInstallationProperty interiorBuildingInstallation) {
		if (this.interiorBuildingInstallation == null)
			this.interiorBuildingInstallation = new ChildList<IntBuildingInstallationProperty>(this);

		this.interiorBuildingInstallation.add(interiorBuildingInstallation);
	}

	public void addInteriorRoom(InteriorRoomProperty interiorRoom) {
		if (this.interiorRoom == null)
			this.interiorRoom = new ChildList<InteriorRoomProperty>(this);

		this.interiorRoom.add(interiorRoom);
	}

	public void addOuterBuildingInstallation(BuildingInstallationProperty outerBuildingInstallation) {
		if (this.outerBuildingInstallation == null)
			this.outerBuildingInstallation = new ChildList<BuildingInstallationProperty>(this);

		this.outerBuildingInstallation.add(outerBuildingInstallation);
	}

	public void addInteriorFurniture(InteriorFurnitureProperty interiorFurniture) {
		if (this.interiorFurniture == null)
			this.interiorFurniture = new ChildList<InteriorFurnitureProperty>(this);

		this.interiorFurniture.add(interiorFurniture);
	}
	

	public List<BoundarySurfaceProperty> getBoundedBySurface() {
		if (boundedBySurface == null)
			boundedBySurface = new ChildList<BoundarySurfaceProperty>(this);

		return boundedBySurface;
	}

	public Code getClazz() {
		return clazz;
	}

	public List<Code> getFunction() {
		if (function == null)
			function = new ChildList<Code>(this);

		return function;
	}
	
	public List<Code> getUsage() {
		if (usage == null)
			usage = new ChildList<Code>(this);

		return usage;
	}

	
	

	public List<IntBuildingInstallationProperty> getInteriorBuildingInstallation() {
		if (interiorBuildingInstallation == null)
			interiorBuildingInstallation = new ChildList<IntBuildingInstallationProperty>(this);

		return interiorBuildingInstallation;
	}

	public List<InteriorRoomProperty> getInteriorRoom() {
		if (interiorRoom == null)
			interiorRoom = new ChildList<InteriorRoomProperty>(this);

		return interiorRoom;
	}

	public List<InteriorFurnitureProperty> getInteriorFurniture() {
		if (interiorFurniture == null)
			interiorFurniture = new ChildList<InteriorFurnitureProperty>(this);

		return interiorFurniture;
	}


	public MultiCurveProperty getLod2MultiCurve() {
		return lod2MultiCurve;
	}

	public MultiSurfaceProperty getLod2MultiSurface() {
		return lod2MultiSurface;
	}

	public SolidProperty getLod2Solid() {
		return lod2Solid;
	}

	

	public MultiCurveProperty getLod3MultiCurve() {
		return lod3MultiCurve;
	}

	public MultiSurfaceProperty getLod3MultiSurface() {
		return lod3MultiSurface;
	}

	public SolidProperty getLod3Solid() {
		return lod3Solid;
	}

	
	public MultiCurveProperty getLod4MultiCurve() {
		return lod4MultiCurve;
	}

	public MultiSurfaceProperty getLod4MultiSurface() {
		return lod4MultiSurface;
	}

	public SolidProperty getLod4Solid() {
		return lod4Solid;
	}

	
	public Length getMeasuredHeight() {
		return measuredHeight;
	}

	public List<BuildingInstallationProperty> getOuterBuildingInstallation() {
		if (outerBuildingInstallation == null)
			outerBuildingInstallation = new ChildList<BuildingInstallationProperty>(this);

		return outerBuildingInstallation;
	}



	public boolean isSetBoundedBySurface() {
		return boundedBySurface != null && !boundedBySurface.isEmpty();
	}

	public boolean isSetClazz() {
		return clazz != null;
	}

	

	public boolean isSetFunction() {
		return function != null && !function.isEmpty();
	}

	

	public boolean isSetInteriorBuildingInstallation() {
		return interiorBuildingInstallation != null && !interiorBuildingInstallation.isEmpty();
	}

	public boolean isSetInteriorRoom() {
		return interiorRoom != null && !interiorRoom.isEmpty();
	}

	public boolean isSetInteriorFurniture() {
		return interiorFurniture != null && !interiorFurniture.isEmpty();
	}
	
	public boolean isSetLod2MultiCurve() {
		return lod2MultiCurve != null;
	}

	public boolean isSetLod2MultiSurface() {
		return lod2MultiSurface != null;
	}

	public boolean isSetLod2Solid() {
		return lod2Solid != null;
	}

	

	public boolean isSetLod3MultiCurve() {
		return lod3MultiCurve != null;
	}

	public boolean isSetLod3MultiSurface() {
		return lod3MultiSurface != null;
	}

	public boolean isSetLod3Solid() {
		return lod3Solid != null;
	}

	

	public boolean isSetLod4MultiCurve() {
		return lod4MultiCurve != null;
	}

	public boolean isSetLod4MultiSurface() {
		return lod4MultiSurface != null;
	}

	public boolean isSetLod4Solid() {
		return lod4Solid != null;
	}

	
	public boolean isSetMeasuredHeight() {
		return measuredHeight != null;
	}

	public boolean isSetOuterBuildingInstallation() {
		return outerBuildingInstallation != null && !outerBuildingInstallation.isEmpty();
	}

	
	public boolean isSetUsage() {
		return usage != null && !usage.isEmpty();
	}

	
	
	public void setBoundedBySurface(List<BoundarySurfaceProperty> boundedBySurface) {
		this.boundedBySurface = new ChildList<BoundarySurfaceProperty>(this, boundedBySurface);
	}

	public void setClazz(Code clazz) {
		this.clazz = clazz;
	}

	public void setFunction(List<Code> function) {
		this.function = new ChildList<Code>(this, function);
	}
	
	public void setUsage(List<Code> usage) {
		this.usage = new ChildList<Code>(this, usage);
	}

	
	

	public void setInteriorBuildingInstallation(List<IntBuildingInstallationProperty> interiorBuildingInstallation) {
		this.interiorBuildingInstallation = new ChildList<IntBuildingInstallationProperty>(this, interiorBuildingInstallation);
	}

	public void setInteriorRoom(List<InteriorRoomProperty> interiorRoom) {
		this.interiorRoom = new ChildList<InteriorRoomProperty>(this, interiorRoom);
	}

	
	public void setInteriorFurniture(List<InteriorFurnitureProperty> interiorFurniture) {
		this.interiorFurniture = new ChildList<InteriorFurnitureProperty>(this, interiorFurniture);
	}
	
	public void setLod2MultiCurve(MultiCurveProperty lod2MultiCurve) {
		if (lod2MultiCurve != null)
			lod2MultiCurve.setParent(this);
		
		this.lod2MultiCurve = lod2MultiCurve;
	}

	public void setLod2MultiSurface(MultiSurfaceProperty lod2MultiSurface) {
		if (lod2MultiSurface != null)
			lod2MultiSurface.setParent(this);
		
		this.lod2MultiSurface = lod2MultiSurface;
	}

	public void setLod2Solid(SolidProperty lod2Solid) {
		if (lod2Solid != null)
			lod2Solid.setParent(this);
		
		this.lod2Solid = lod2Solid;
	}

	

	public void setLod3MultiCurve(MultiCurveProperty lod3MultiCurve) {
		if (lod3MultiCurve != null)
			lod3MultiCurve.setParent(this);
		
		this.lod3MultiCurve = lod3MultiCurve;
	}

	public void setLod3MultiSurface(MultiSurfaceProperty lod3MultiSurface) {
		if (lod3MultiSurface != null)
			lod3MultiSurface.setParent(this);
		
		this.lod3MultiSurface = lod3MultiSurface;
	}

	public void setLod3Solid(SolidProperty lod3Solid) {
		if (lod3Solid != null)
			lod3Solid.setParent(this);
		
		this.lod3Solid = lod3Solid;
	}

	

	public void setLod4MultiCurve(MultiCurveProperty lod4MultiCurve) {
		if (lod4MultiCurve != null)
			lod4MultiCurve.setParent(this);
		
		this.lod4MultiCurve = lod4MultiCurve;
	}

	public void setLod4MultiSurface(MultiSurfaceProperty lod4MultiSurface) {
		if (lod4MultiSurface != null)
			lod4MultiSurface.setParent(this);
		
		this.lod4MultiSurface = lod4MultiSurface;
	}

	public void setLod4Solid(SolidProperty lod4Solid) {
		if (lod4Solid != null)
			lod4Solid.setParent(this);
		
		this.lod4Solid = lod4Solid;
	}

	

	public void setMeasuredHeight(Length measuredHeight) {
		if (measuredHeight != null)
			measuredHeight.setParent(this);
		
		this.measuredHeight = measuredHeight;
	}

	public void setOuterBuildingInstallation(List<BuildingInstallationProperty> outerBuildingInstallation) {
		this.outerBuildingInstallation = new ChildList<BuildingInstallationProperty>(this, outerBuildingInstallation);
	}

	
	


	public void unsetBoundedBySurface() {
		if (isSetBoundedBySurface())
			boundedBySurface.clear();

		boundedBySurface = null;
	}

	public boolean unsetBoundedBySurface(BoundarySurfaceProperty boundedBySurface) {
		return isSetBoundedBySurface() ? this.boundedBySurface.remove(boundedBySurface) : false;
	}

	public void unsetClazz() {
		clazz = null;
	}

	

	

	public void unsetFunction() {
		function = null;
	}

	public boolean unsetFunction(Code function) {
		return isSetFunction() ? this.function.remove(function) : false;
	}
	
	public void unsetUsage() {
		usage = null;
	}

	public boolean unsetUsage(Code usage) {
		return isSetUsage() ? this.usage.remove(usage) : false;
	}

	

	

	public void unsetInteriorBuildingInstallation() {
		if (isSetInteriorBuildingInstallation())
			interiorBuildingInstallation.clear();
		interiorBuildingInstallation = null;
	}

	public boolean unsetInteriorBuildingInstallation(IntBuildingInstallationProperty interiorBuildingInstallation) {
		return isSetInteriorBuildingInstallation() ? this.interiorBuildingInstallation.remove(interiorBuildingInstallation) : false;
	}

	public void unsetInteriorRoom() {
		if (isSetInteriorRoom())
			interiorRoom.clear();

		interiorRoom = null;
	}

	public boolean unsetInteriorRoom(InteriorRoomProperty interiorRoom) {
		return isSetInteriorRoom() ? this.interiorRoom.remove(interiorRoom) : false;
	}


	public void unsetInteriorFurniture() {
		if (isSetInteriorFurniture())
			interiorFurniture.clear();

		interiorFurniture = null;
	}

	public boolean unsetInteriorFurniture(InteriorFurnitureProperty interiorFurniture) {
		return isSetInteriorFurniture() ? this.interiorFurniture.remove(interiorFurniture) : false;
	}
	

	public void unsetLod2MultiCurve() {
		if (isSetLod2MultiCurve())
			lod2MultiCurve.unsetParent();
		
		lod2MultiCurve = null;
	}

	public void unsetLod2MultiSurface() {
		if (isSetLod2MultiSurface())
			lod2MultiSurface.unsetParent();
		
		lod2MultiSurface = null;
	}

	public void unsetLod2Solid() {
		if (isSetLod2Solid())
			lod2Solid.unsetParent();
		
		lod2Solid = null;
	}

	

	public void unsetLod3MultiCurve() {
		if (isSetLod3MultiCurve())
			lod3MultiCurve.unsetParent();
		
		lod3MultiCurve = null;
	}

	public void unsetLod3MultiSurface() {
		if (isSetLod3MultiSurface())
			lod3MultiSurface.unsetParent();
		
		lod3MultiSurface = null;
	}

	public void unsetLod3Solid() {
		if (isSetLod3Solid())
			lod3Solid.unsetParent();
		
		lod3Solid = null;
	}

	

	public void unsetLod4MultiCurve() {
		if (isSetLod4MultiCurve())
			lod4MultiCurve.unsetParent();
		
		lod4MultiCurve = null;
	}

	public void unsetLod4MultiSurface() {
		if (isSetLod4MultiSurface())
			lod4MultiSurface.unsetParent();
		
		lod4MultiSurface = null;
	}

	public void unsetLod4Solid() {
		if (isSetLod4Solid())
			lod4Solid.unsetParent();
		
		lod4Solid = null;
	}

	
	public void unsetMeasuredHeight() {
		if (isSetMeasuredHeight())
			measuredHeight.unsetParent();
		
		measuredHeight = null;
	}

	public void unsetOuterBuildingInstallation() {
		if (isSetOuterBuildingInstallation())
			outerBuildingInstallation.clear();

		outerBuildingInstallation = null;
	}

	public boolean unsetOuterBuildingInstallation(BuildingInstallationProperty outerBuildingInstallation) {
		return isSetOuterBuildingInstallation() ? this.outerBuildingInstallation.remove(outerBuildingInstallation) : false;
	}

	public final BuildingExtraModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}

	@Override
	public BoundingShape calcBoundedBy(boolean setBoundedBy) {
		BoundingShape boundedBy = new BoundingShape();
		/*
		if (lod0FootPrint != null) {
			if (lod0FootPrint.isSetMultiSurface()) {
				calcBoundedBy(boundedBy, lod0FootPrint.getMultiSurface());
			} else {
				// xlink
			}
		}
		
		if (lod0RoofEdge != null) {
			if (lod0RoofEdge.isSetMultiSurface()) {
				calcBoundedBy(boundedBy, lod0RoofEdge.getMultiSurface());
			} else {
				// xlink
			}
		}
		*/

		SolidProperty solidProperty = null;
		for (int lod = 2; lod < 5; lod++) {
			switch (lod) {
			case 2:
				solidProperty = lod2Solid;
				break;
			case 3:
				solidProperty = lod3Solid;
				break;
			case 4:
				solidProperty = lod4Solid;
				break;
			}
			
			if (solidProperty != null) {
				if (solidProperty.isSetSolid()) {
					calcBoundedBy(boundedBy, solidProperty.getSolid());
				} else {
					// xlink
				}
			}
		}
		
		MultiSurfaceProperty multiSurfaceProperty = null;
		for (int lod = 2; lod < 5; lod++) {
			switch (lod) {
			case 2:
				multiSurfaceProperty = lod2MultiSurface;
				break;
			case 3:
				multiSurfaceProperty = lod3MultiSurface;
				break;
			case 4:
				multiSurfaceProperty = lod4MultiSurface;
				break;
			}
			
			if (multiSurfaceProperty != null) {
				if (multiSurfaceProperty.isSetMultiSurface()) {
					calcBoundedBy(boundedBy, multiSurfaceProperty.getMultiSurface());
				} else {
					// xlink
				}
			}
		}
		
		MultiCurveProperty multiCurveProperty = null;
		for (int lod = 2; lod < 5; lod++) {
			switch (lod) {
			case 2:
				multiCurveProperty = lod2MultiCurve;
				break;
			case 3:
				multiCurveProperty = lod3MultiCurve;
				break;
			case 4:
				multiCurveProperty = lod4MultiCurve;
				break;
			}
			
			if (multiCurveProperty != null) {
				if (multiCurveProperty.isSetMultiCurve()) {
					calcBoundedBy(boundedBy, multiCurveProperty.getMultiCurve());
				} else {
					// xlink
				}
			}
		}
		
		if (isSetBoundedBySurface()) {
			for (BoundarySurfaceProperty boundarySurfaceProperty : getBoundedBySurface()) {
				if (boundarySurfaceProperty.isSetObject()) {
					calcBoundedBy(boundedBy, boundarySurfaceProperty.getObject(), setBoundedBy);
				} else {
					// xlink?
				}
			}
		}
		
		if (isSetOuterBuildingInstallation()) {
			for (BuildingInstallationProperty buildingInstallationProperty : getOuterBuildingInstallation()) {
				if (buildingInstallationProperty.isSetObject()) {
					calcBoundedBy(boundedBy, buildingInstallationProperty.getObject(), setBoundedBy);
				} else {
					// xlink?
				}
			}
		}

		
		
		if (boundedBy.isSetEnvelope()) {
			if (setBoundedBy)
				setBoundedBy(boundedBy);

			return boundedBy;
		} else
			return null;
	}
	
	@Override
	public LodRepresentation getLodRepresentation() {
		LodRepresentation lodRepresentation = new LodRepresentation();
		
		/*if (lod0FootPrint != null)
			lodRepresentation.getLod0Geometry().add(lod0FootPrint);
		
		if (lod0RoofEdge != null)
			lodRepresentation.getLod0Geometry().add(lod0RoofEdge);
		*/

		GeometryProperty<? extends AbstractGeometry> property = null;		
		for (int lod = 2; lod < 5; lod++) {
			switch (lod) {
			case 2:
				property = lod2Solid;
				break;
			case 3:
				property = lod3Solid;
				break;
			case 4:
				property = lod4Solid;
				break;
			}
			
			if (property != null)
				lodRepresentation.getLodGeometry(lod).add(property);
		}
		
		property = null;
		for (int lod = 2; lod < 5; lod++) {
			switch (lod) {
	
			case 2:
				property = lod2MultiSurface;
				break;
			case 3:
				property = lod3MultiSurface;
				break;
			case 4:
				property = lod4MultiSurface;
				break;
			}
			
			if (property != null)
				lodRepresentation.getLodGeometry(lod).add(property);
		}
		
		property = null;
		for (int lod = 2; lod < 5; lod++) {
			switch (lod) {
			case 2:
				property = lod2MultiCurve;
				break;
			case 3:
				property = lod3MultiCurve;
				break;
			case 4:
				property = lod3MultiCurve;
				break;
			}
			
			if (property != null)
				lodRepresentation.getLodGeometry(lod).add(property);
		}
		
		return lodRepresentation;
	}
	
	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		if (target == null)
			throw new IllegalArgumentException("Target argument must not be null for abstract copyable classes.");

		Storey copy = (Storey)target;		
		super.copyTo(copy, copyBuilder);
		
		if (isSetClazz())
			copy.setClazz((Code)copyBuilder.copy(clazz));

		if (isSetFunction()) {
			for (Code part : function) {
				Code copyPart = (Code)copyBuilder.copy(part);
				copy.addFunction(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		if (isSetUsage()) {
			for (Code part : usage) {
				Code copyPart = (Code)copyBuilder.copy(part);
				copy.addUsage(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		

		if (isSetMeasuredHeight()) {
			copy.setMeasuredHeight((Length)copyBuilder.copy(measuredHeight));
			if (copy.getMeasuredHeight() == measuredHeight)
				measuredHeight.setParent(this);
		}
		
		
		
		if (isSetLod2Solid()) {
			copy.setLod2Solid((SolidProperty)copyBuilder.copy(lod2Solid));
			if (copy.getLod2Solid() == lod2Solid)
				lod2Solid.setParent(this);
		}
		
		if (isSetLod3Solid()) {
			copy.setLod3Solid((SolidProperty)copyBuilder.copy(lod3Solid));
			if (copy.getLod3Solid() == lod3Solid)
				lod3Solid.setParent(this);
		}
		
		if (isSetLod4Solid()) {
			copy.setLod4Solid((SolidProperty)copyBuilder.copy(lod4Solid));
			if (copy.getLod4Solid() == lod4Solid)
				lod4Solid.setParent(this);
		}
		
		
		
		if (isSetLod2MultiCurve()) {
			copy.setLod2MultiCurve((MultiCurveProperty)copyBuilder.copy(lod2MultiCurve));
			if (copy.getLod2MultiCurve() == lod2MultiCurve)
				lod2MultiCurve.setParent(this);
		}
		
		if (isSetLod3MultiCurve()) {
			copy.setLod3MultiCurve((MultiCurveProperty)copyBuilder.copy(lod3MultiCurve));
			if (copy.getLod3MultiCurve() == lod3MultiCurve)
				lod3MultiCurve.setParent(this);
		}
		
		if (isSetLod4MultiCurve()) {
			copy.setLod4MultiCurve((MultiCurveProperty)copyBuilder.copy(lod4MultiCurve));
			if (copy.getLod4MultiCurve() == lod4MultiCurve)
				lod4MultiCurve.setParent(this);
		}
		
		
		
		if (isSetLod2MultiSurface()) {
			copy.setLod2MultiSurface((MultiSurfaceProperty)copyBuilder.copy(lod2MultiSurface));
			if (copy.getLod2MultiSurface() == lod2MultiSurface)
				lod2MultiSurface.setParent(this);
		}
		
		if (isSetLod3MultiSurface()) {
			copy.setLod3MultiSurface((MultiSurfaceProperty)copyBuilder.copy(lod3MultiSurface));
			if (copy.getLod3MultiSurface() == lod3MultiSurface)
				lod3MultiSurface.setParent(this);
		}
		
		if (isSetLod4MultiSurface()) {
			copy.setLod4MultiSurface((MultiSurfaceProperty)copyBuilder.copy(lod4MultiSurface));
			if (copy.getLod4MultiSurface() == lod4MultiSurface)
				lod4MultiSurface.setParent(this);
		}

		
		
		if (isSetBoundedBySurface()) {
			for (BoundarySurfaceProperty part : boundedBySurface) {
				BoundarySurfaceProperty copyPart = (BoundarySurfaceProperty)copyBuilder.copy(part);
				copy.addBoundedBySurface(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		if (isSetOuterBuildingInstallation()) {
			for (BuildingInstallationProperty part : outerBuildingInstallation) {
				BuildingInstallationProperty copyPart = (BuildingInstallationProperty)copyBuilder.copy(part);
				copy.addOuterBuildingInstallation(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		if (isSetInteriorBuildingInstallation()) {
			for (IntBuildingInstallationProperty part : interiorBuildingInstallation) {
				IntBuildingInstallationProperty copyPart = (IntBuildingInstallationProperty)copyBuilder.copy(part);
				copy.addInteriorBuildingInstallation(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		
		
		if (isSetInteriorRoom()) {
			for (InteriorRoomProperty part : interiorRoom) {
				InteriorRoomProperty copyPart = (InteriorRoomProperty)copyBuilder.copy(part);
				copy.addInteriorRoom(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		if (isSetInteriorFurniture()) {
			for (InteriorFurnitureProperty part : interiorFurniture) {
				InteriorFurnitureProperty copyPart = (InteriorFurnitureProperty)copyBuilder.copy(part);
				copy.addInteriorFurniture(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
				
		return copy;
	}
	
	@Override
	public CityGMLClass getCityGMLClass() {
		
		return CityGMLClass.STOREY;
	}

	@Override
	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new Storey(), copyBuilder);
	}

	
	
	@Override	
	public void accept(GMLVisitor visitor) {
		visitor.visit(this);
	}
	
	@Override
	public <T> T accept(GMLFunctor<T> visitor) {
		return visitor.apply(this);
	}
	
	//unimplemented function for ADEComponent
	
	@Override
	public Element getContent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isSetContent() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setContent(Element content) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void unsetContent() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getLocalName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPrefix() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNamespaceURI() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void accept(FeatureVisitor visitor) {
		visitor.visit(this);
		
	}

	@Override
	public <T> T accept(FeatureFunctor<T> visitor) {
		return visitor.apply(this);
	}

	@Override
	public void visit(FeatureVisitor visitor) {
		visitor.visit(this);
		
	}

	@Override
	public <T> T apply(FeatureFunctor<T> visitor) {
		return visitor.apply(this);
	}

	

	
}
