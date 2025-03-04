/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 * 
 * Copyright 2013-2017 Claus Nagel <claus.nagel@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 *     
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.citygml4j.model.citygml.building;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.citygml.core.ImplicitRepresentationProperty;
import org.citygml4j.model.citygml.core.LodRepresentation;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.gml.feature.BoundingShape;
import org.citygml4j.model.gml.geometry.AbstractGeometry;
import org.citygml4j.model.gml.geometry.GeometryProperty;
import org.citygml4j.model.gml.geometry.aggregates.MultiSurfaceProperty;
import org.citygml4j.model.module.citygml.BuildingModule;

public abstract class AbstractOpening extends AbstractCityObject implements BuildingModuleComponent {	
	private MultiSurfaceProperty lod3MultiSurface;
	private MultiSurfaceProperty lod4MultiSurface;
	private ImplicitRepresentationProperty lod3ImplicitRepresentation;
	private ImplicitRepresentationProperty lod4ImplicitRepresentation;
	private List<ADEComponent> ade;
	private BuildingModule module;

	public AbstractOpening() {
		
	}
	
	public AbstractOpening(BuildingModule module) {
		this.module = module;
	}

	public ImplicitRepresentationProperty getLod3ImplicitRepresentation() {
		return lod3ImplicitRepresentation;
	}
	
	public ImplicitRepresentationProperty getLod4ImplicitRepresentation() {
		return lod4ImplicitRepresentation;
	}
	
	public boolean isSetLod3ImplicitRepresentation() {
		return lod3ImplicitRepresentation != null;
	}
	
	public boolean isSetLod4ImplicitRepresentation() {
		return lod4ImplicitRepresentation != null;
	}
	
	public void setLod3ImplicitRepresentation(ImplicitRepresentationProperty lod3ImplicitRepresentation) {
		if (lod3ImplicitRepresentation != null)
			lod3ImplicitRepresentation.setParent(this);

		this.lod3ImplicitRepresentation = lod3ImplicitRepresentation;
	}

	public void setLod4ImplicitRepresentation(ImplicitRepresentationProperty lod4ImplicitRepresentation) {
		if (lod4ImplicitRepresentation != null)
			lod4ImplicitRepresentation.setParent(this);

		this.lod4ImplicitRepresentation = lod4ImplicitRepresentation;
	}
	
	public void unsetLod3ImplicitRepresentation() {
		if (isSetLod3ImplicitRepresentation())
			lod3ImplicitRepresentation.unsetParent();

		lod3ImplicitRepresentation = null;
	}
	
	public void unsetLod4ImplicitRepresentation() {
		if (isSetLod4ImplicitRepresentation())
			lod4ImplicitRepresentation.unsetParent();

		lod4ImplicitRepresentation = null;
	}
	
	public void addGenericApplicationPropertyOfOpening(ADEComponent ade) {
		if (this.ade == null)
			this.ade = new ChildList<ADEComponent>(this);

		this.ade.add(ade);
	}

	public List<ADEComponent> getGenericApplicationPropertyOfOpening() {
		if (ade == null)
			ade = new ChildList<ADEComponent>(this);

		return ade;
	}

	public MultiSurfaceProperty getLod3MultiSurface() {
		return lod3MultiSurface;
	}

	public MultiSurfaceProperty getLod4MultiSurface() {
		return lod4MultiSurface;
	}

	public boolean isSetGenericApplicationPropertyOfOpening() {
		return ade != null && !ade.isEmpty();
	}

	public boolean isSetLod3MultiSurface() {
		return lod3MultiSurface != null;
	}

	public boolean isSetLod4MultiSurface() {
		return lod4MultiSurface != null;
	}

	public void setGenericApplicationPropertyOfOpening(List<ADEComponent> ade) {
		this.ade = new ChildList<ADEComponent>(this, ade);
	}

	public void setLod3MultiSurface(MultiSurfaceProperty lod3MultiSurface) {
		if (lod3MultiSurface != null)
			lod3MultiSurface.setParent(this);

		this.lod3MultiSurface = lod3MultiSurface;
	}

	public void setLod4MultiSurface(MultiSurfaceProperty lod4MultiSurface) {
		if (lod4MultiSurface != null)
			lod4MultiSurface.setParent(this);

		this.lod4MultiSurface = lod4MultiSurface;
	}

	public void unsetGenericApplicationPropertyOfOpening() {
		if (isSetGenericApplicationPropertyOfOpening())
			ade.clear();

		ade = null;
	}

	public boolean unsetGenericApplicationPropertyOfOpening(ADEComponent ade) {
		return isSetGenericApplicationPropertyOfOpening() ? this.ade.remove(ade) : false;
	}

	public void unsetLod3MultiSurface() {
		if (isSetLod3MultiSurface())
			lod3MultiSurface.unsetParent();

		lod3MultiSurface = null;
	}

	public void unsetLod4MultiSurface() {
		if (isSetLod4MultiSurface())
			lod4MultiSurface.unsetParent();

		lod4MultiSurface = null;
	}
	
	public final BuildingModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}

	@Override
	public BoundingShape calcBoundedBy(boolean setBoundedBy) {
		BoundingShape boundedBy = new BoundingShape();
		GeometryProperty<? extends AbstractGeometry> geometryProperty = null;
		
		for (int lod = 3; lod < 5; lod++) {
			switch (lod) {
			case 3:
				geometryProperty = lod3MultiSurface;
				break;
			case 4:
				geometryProperty = lod4MultiSurface;
				break;
			}

			if (geometryProperty != null) {
				if (geometryProperty.isSetGeometry()) {
					calcBoundedBy(boundedBy, geometryProperty.getGeometry());
				} else {
					// xlink
				}
			}
		}
		
		ImplicitRepresentationProperty implicitRepresentation = null;
		for (int lod = 3; lod < 5; lod++) {
			switch (lod) {
			case 3:
				implicitRepresentation = lod3ImplicitRepresentation;
				break;
			case 4:
				implicitRepresentation = lod4ImplicitRepresentation;
				break;
			}

			if (implicitRepresentation != null && 
					implicitRepresentation.isSetImplicitGeometry() &&
					implicitRepresentation.getImplicitGeometry().isSetRelativeGMLGeometry()) {
				geometryProperty = implicitRepresentation.getImplicitGeometry().getRelativeGMLGeometry();

				if (geometryProperty != null) {
					if (geometryProperty.isSetGeometry()) {
						calcBoundedBy(boundedBy, geometryProperty.getGeometry());
					} else {
						// xlink
					}
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
		
		GeometryProperty<? extends AbstractGeometry> property = null;		
		for (int lod = 3; lod < 5; lod++) {
			switch (lod) {
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
		
		ImplicitRepresentationProperty implicitRepresentation = null;
		for (int lod = 3; lod < 5; lod++) {
			switch (lod) {
			case 3:
				implicitRepresentation = lod3ImplicitRepresentation;
				break;
			case 4:
				implicitRepresentation = lod4ImplicitRepresentation;
				break;
			}

			if (implicitRepresentation != null && 
					implicitRepresentation.isSetImplicitGeometry() &&
					implicitRepresentation.getImplicitGeometry().isSetRelativeGMLGeometry()) {
				property = implicitRepresentation.getImplicitGeometry().getRelativeGMLGeometry();
				lodRepresentation.getLodGeometry(lod).add(property);
			}
		}
		
		return lodRepresentation;
	}
	
	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		if (target == null)
			throw new IllegalArgumentException("Target argument must not be null for abstract copyable classes.");

		AbstractOpening copy = (AbstractOpening)target;		
		super.copyTo(copy, copyBuilder);
		
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
		
		if (isSetLod3ImplicitRepresentation()) {
			copy.setLod3ImplicitRepresentation((ImplicitRepresentationProperty)copyBuilder.copy(lod3ImplicitRepresentation));
			if (copy.getLod3ImplicitRepresentation() == lod3ImplicitRepresentation)
				lod3ImplicitRepresentation.setParent(this);
		}

		if (isSetLod4ImplicitRepresentation()) {
			copy.setLod4ImplicitRepresentation((ImplicitRepresentationProperty)copyBuilder.copy(lod4ImplicitRepresentation));
			if (copy.getLod4ImplicitRepresentation() == lod4ImplicitRepresentation)
				lod4ImplicitRepresentation.setParent(this);
		}

		if (isSetGenericApplicationPropertyOfOpening()) {
			for (ADEComponent part : ade) {
				ADEComponent copyPart = (ADEComponent)copyBuilder.copy(part);
				copy.addGenericApplicationPropertyOfOpening(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}

		return copy;
	}	
	
}
