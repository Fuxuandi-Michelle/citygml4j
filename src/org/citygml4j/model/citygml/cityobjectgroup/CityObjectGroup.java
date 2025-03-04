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
package org.citygml4j.model.citygml.cityobjectgroup;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.core.AbstractCityObject;
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
import org.citygml4j.model.module.citygml.CityObjectGroupModule;

public class CityObjectGroup extends AbstractCityObject implements CityObjectGroupModuleComponent, StandardObjectClassifier {
	private Code clazz;
	private List<Code> function;
	private List<Code> usage;
	private List<CityObjectGroupMember> groupMember;
	private CityObjectGroupParent groupParent;
	private GeometryProperty<? extends AbstractGeometry> geometry;
	private List<ADEComponent> ade;
	private CityObjectGroupModule module;
	
	public CityObjectGroup() {
		
	}
	
	public CityObjectGroup(CityObjectGroupModule module) {
		this.module = module;
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

	public void addGenericApplicationPropertyOfCityObjectGroup(ADEComponent ade) {
		if (this.ade == null)
			this.ade = new ChildList<ADEComponent>(this);

		this.ade.add(ade);
	}

	public void addGroupMember(CityObjectGroupMember groupMember) {
		if (this.groupMember == null)
			this.groupMember = new ChildList<CityObjectGroupMember>(this);

		this.groupMember.add(groupMember);
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

	public List<ADEComponent> getGenericApplicationPropertyOfCityObjectGroup() {
		if (ade == null)
			ade = new ChildList<ADEComponent>(this);

		return ade;
	}

	public GeometryProperty<? extends AbstractGeometry> getGeometry() {
		return geometry;
	}

	public List<CityObjectGroupMember> getGroupMember() {
		if (groupMember == null)
			groupMember = new ChildList<CityObjectGroupMember>(this);

		return groupMember;
	}

	public CityObjectGroupParent getGroupParent() {
		return groupParent;
	}

	public boolean isSetClazz() {
		return clazz != null;
	}

	public boolean isSetFunction() {
		return function != null && !function.isEmpty();
	}
	
	public boolean isSetUsage() {
		return usage != null && !usage.isEmpty();
	}

	public boolean isSetGenericApplicationPropertyOfCityObjectGroup() {
		return ade != null && !ade.isEmpty();
	}

	public boolean isSetGeometry() {
		return geometry != null;
	}

	public boolean isSetGroupMember() {
		return groupMember != null && !groupMember.isEmpty();
	}

	public boolean isSetGroupParent() {
		return groupParent != null;
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

	public void setGenericApplicationPropertyOfCityObjectGroup(List<ADEComponent> ade) {
		this.ade = new ChildList<ADEComponent>(this, ade);
	}

	public void setGeometry(GeometryProperty<? extends AbstractGeometry> geometry) {
		if (geometry != null)
			geometry.setParent(this);
		
		this.geometry = geometry;
	}

	public void setGroupMember(List<CityObjectGroupMember> groupMember) {
		this.groupMember = new ChildList<CityObjectGroupMember>(this, groupMember);
	}

	public void setGroupParent(CityObjectGroupParent groupParent) {
		if (groupParent != null)
			groupParent.setParent(this);
		
		this.groupParent = groupParent;
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

	public void unsetGenericApplicationPropertyOfCityObjectGroup() {
		if (isSetGenericApplicationPropertyOfCityObjectGroup())
			ade.clear();

		ade = null;
	}

	public boolean unsetGenericApplicationPropertyOfCityObjectGroup(ADEComponent ade) {
		return isSetGenericApplicationPropertyOfCityObjectGroup() ? this.ade.remove(ade) : false;
	}

	public void unsetGeometry() {
		if (isSetGeometry())
			geometry.unsetParent();
		
		geometry = null;
	}

	public void unsetGroupMember() {
		if (isSetGroupMember())
			groupMember.clear();

		groupMember = null;
	}

	public boolean unsetGroupMember(CityObjectGroupMember groupMember) {
		return isSetGroupMember() ? this.groupMember.remove(groupMember) : false;
	}

	public void unsetGroupParent() {
		if (isSetGroupParent())
			groupParent.unsetParent();
		
		groupParent = null;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.CITY_OBJECT_GROUP;
	}

	public final CityObjectGroupModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}

	@Override
	public BoundingShape calcBoundedBy(boolean setBoundedBy) {
		BoundingShape boundedBy = new BoundingShape();
		
		if (isSetGeometry()) {
			if (geometry.isSetGeometry()) {
				calcBoundedBy(boundedBy, geometry.getGeometry());
			} else {
				// xlink
			}
		}
		
		if (isSetGroupMember()) {
			for (CityObjectGroupMember member : groupMember) {
				if (member.isSetObject()) {
					calcBoundedBy(boundedBy, member.getObject(), setBoundedBy);
				} else {
					// xlink
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
		
		if (isSetGeometry()) {
			for (int lod = 0; lod < 5; lod++)
				lodRepresentation.getLodGeometry(lod).add(geometry);
		}
		
		return lodRepresentation;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new CityObjectGroup(), copyBuilder);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		CityObjectGroup copy = (target == null) ? new CityObjectGroup() : (CityObjectGroup)target;
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
		
		if (isSetGroupMember()) {
			for (CityObjectGroupMember part : groupMember) {
				CityObjectGroupMember copyPart = (CityObjectGroupMember)copyBuilder.copy(part);
				copy.addGroupMember(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		if (isSetGroupParent()) {
			copy.setGroupParent((CityObjectGroupParent)copyBuilder.copy(groupParent));
			if (copy.getGroupParent() == groupParent)
				groupParent.setParent(this);
		}
		
		if (isSetGeometry()) {
			copy.setGeometry((GeometryProperty<? extends AbstractGeometry>)copyBuilder.copy(geometry));
			if (copy.getGeometry() == geometry)
				geometry.setParent(this);
		}
		
		if (isSetGenericApplicationPropertyOfCityObjectGroup()) {
			for (ADEComponent part : ade) {
				ADEComponent copyPart = (ADEComponent)copyBuilder.copy(part);
				copy.addGenericApplicationPropertyOfCityObjectGroup(copyPart);
				
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
