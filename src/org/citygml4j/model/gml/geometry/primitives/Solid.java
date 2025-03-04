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
package org.citygml4j.model.gml.geometry.primitives;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.geometry.BoundingBox;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.common.visitor.GMLFunctor;
import org.citygml4j.model.common.visitor.GMLVisitor;
import org.citygml4j.model.common.visitor.GeometryFunctor;
import org.citygml4j.model.common.visitor.GeometryVisitor;
import org.citygml4j.model.gml.GMLClass;

public class Solid extends AbstractSolid {
	private SurfaceProperty exterior;
	private List<SurfaceProperty> interior;
	
	public void addInterior(SurfaceProperty interior) {
		if (this.interior == null)
			this.interior = new ChildList<SurfaceProperty>(this);
		
		this.interior.add(interior);
	}

	public SurfaceProperty getExterior() {
		return exterior;
	}

	public List<SurfaceProperty> getInterior() {
		if (interior == null)
			interior = new ChildList<SurfaceProperty>(this);
		
		return interior;
	}

	public boolean isSetExterior() {
		return exterior != null;
	}

	public boolean isSetInterior() {
		return interior != null && !interior.isEmpty();
	}

	public void setExterior(SurfaceProperty exterior) {
		if (exterior != null)
			exterior.setParent(this);
		
		this.exterior = exterior;
	}

	public void setInterior(List<SurfaceProperty> interior) {
		this.interior = new ChildList<SurfaceProperty>(this, interior);
	}

	public void unsetExterior() {
		if (exterior != null)
			exterior.unsetParent();
	}

	public void unsetInterior() {
		if (isSetInterior())
			interior.clear();
		
		interior = null;
	}

	public boolean unsetInterior(SurfaceProperty interior) {
		return (isSetInterior()) ? this.interior.remove(interior) : false;
	}

	public BoundingBox calcBoundingBox() {
		BoundingBox bbox = new BoundingBox();
		
		if (isSetExterior()) {
			SurfaceProperty exterior = getExterior();
			if (exterior.isSetSurface())
				bbox.update(exterior.getSurface().calcBoundingBox());
		}
		
		if (bbox.getLowerCorner().isEqual(Double.MAX_VALUE) && 
				bbox.getUpperCorner().isEqual(-Double.MAX_VALUE))
			return null;
		else
			return bbox;
	}

	public GMLClass getGMLClass() {
		return GMLClass.SOLID;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new Solid(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		Solid copy = (target == null) ? new Solid() : (Solid)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetExterior()) {
			copy.setExterior((SurfaceProperty)copyBuilder.copy(exterior));
			if (copy.getExterior() == exterior)
				exterior.setParent(this);
		}
		
		if (isSetInterior()) {
			for (SurfaceProperty part : interior) {
				SurfaceProperty copyPart = (SurfaceProperty)copyBuilder.copy(part);
				copy.addInterior(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		return copy;
	}
	
	public void accept(GeometryVisitor visitor) {
		visitor.visit(this);
	}

	public <T> T accept(GeometryFunctor<T> visitor) {
		return visitor.apply(this);
	}
	
	public void accept(GMLVisitor visitor) {
		visitor.visit(this);
	}
	
	public <T> T accept(GMLFunctor<T> visitor) {
		return visitor.apply(this);
	}

}
