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
package org.citygml4j.model.citygml.relief;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.core.LodRepresentation;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.common.visitor.FeatureFunctor;
import org.citygml4j.model.common.visitor.FeatureVisitor;
import org.citygml4j.model.common.visitor.GMLFunctor;
import org.citygml4j.model.common.visitor.GMLVisitor;
import org.citygml4j.model.gml.feature.BoundingShape;
import org.citygml4j.model.gml.geometry.AbstractGeometry;
import org.citygml4j.model.gml.geometry.GeometryProperty;
import org.citygml4j.model.module.citygml.ReliefModule;

public class RasterRelief extends AbstractReliefComponent {
	private GridProperty grid;
	private List<ADEComponent> ade;

	public RasterRelief() {

	}

	public RasterRelief(ReliefModule module) {
		super(module);
	}

	public void addGenericApplicationPropertyOfRasterRelief(ADEComponent ade) {
		if (this.ade == null)
			this.ade = new ChildList<ADEComponent>(this);

		this.ade.add(ade);
	}

	public List<ADEComponent> getGenericApplicationPropertyOfRasterRelief() {
		if (ade == null)
			ade = new ChildList<ADEComponent>(this);

		return ade;
	}

	public GridProperty getGrid() {
		return grid;
	}

	public boolean isSetGenericApplicationPropertyOfRasterRelief() {
		return ade != null && !ade.isEmpty();
	}

	public boolean isSetGrid() {
		return grid != null;
	}

	public void setGenericApplicationPropertyOfRasterRelief(List<ADEComponent> ade) {
		this.ade = new ChildList<ADEComponent>(this, ade);
	}

	public void setGrid(GridProperty grid) {
		if (grid != null)
			grid.setParent(this);

		this.grid = grid;
	}

	public void unsetGenericApplicationPropertyOfRasterRelief() {
		if (isSetGenericApplicationPropertyOfRasterRelief())
			ade.clear();

		ade = null;
	}

	public boolean unsetGenericApplicationPropertyOfRasterRelief(ADEComponent ade) {
		return isSetGenericApplicationPropertyOfRasterRelief() ? this.ade.remove(ade) : false;
	}

	public void unsetGrid() {
		if (isSetGrid())
			grid.unsetParent();

		grid = null;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.RASTER_RELIEF;
	}

	@Override
	public BoundingShape calcBoundedBy(boolean setBoundedBy) {
		BoundingShape boundedBy = super.calcBoundedBy(false);
		if (boundedBy == null)
			boundedBy = new BoundingShape();

		if (isSetGrid()) {
			if (grid.isSetObject()) {
				calcBoundedBy(boundedBy, grid.getObject(), setBoundedBy);
			} else {
				// xlink
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

		if (isSetGrid() && grid.isSetObject() && grid.getObject().isSetRectifiedGridDomain()) {
			List<GeometryProperty<? extends AbstractGeometry>> propertyList = lodRepresentation.getLodGeometry(getLod());
			if (propertyList != null) 
				propertyList.add(grid.getObject().getRectifiedGridDomain());
		}

		return lodRepresentation;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new RasterRelief(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		RasterRelief copy = (target == null) ? new RasterRelief() : (RasterRelief)target;
		super.copyTo(copy, copyBuilder);

		if (isSetGrid()) {
			copy.setGrid((GridProperty)copyBuilder.copy(grid));
			if (copy.getGrid() == grid)
				grid.setParent(this);
		}

		if (isSetGenericApplicationPropertyOfRasterRelief()) {
			for (ADEComponent part : ade) {
				ADEComponent copyPart = (ADEComponent)copyBuilder.copy(part);
				copy.addGenericApplicationPropertyOfRasterRelief(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}

		return copy;
	}

	public void accept(FeatureVisitor visitor) {
		visitor.visit(this);
	}

	public <T> T accept(FeatureFunctor<T> visitor) {
		return visitor.apply(this);
	}

	public void accept(GMLVisitor visitor) {
		visitor.visit(this);
	}

	public <T> T accept(GMLFunctor<T> visitor) {
		return visitor.apply(this);
	}

}
