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

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.gml.feature.FeatureProperty;
import org.citygml4j.model.module.citygml.BuildingModule;

public class BuildingPartProperty extends FeatureProperty<BuildingPart> implements BuildingModuleComponent {
	private BuildingModule module;
	
	public BuildingPartProperty() {
		
	}
	
	public BuildingPartProperty(BuildingPart buildingPart) {
		super(buildingPart);
	}
	
	public BuildingPartProperty(String href) {
		super(href);
	}
	
	public BuildingPartProperty(BuildingModule module) {
		this.module = module;
	}
	
	public BuildingPart getBuildingPart() {
		return super.getObject();
	}

	public boolean isSetBuildingPart() {
		return super.isSetObject();
	}

	public void setBuildingPart(BuildingPart buildingPart) {
		super.setObject(buildingPart);
	}

	public void unsetBuildingPart() {
		super.unsetObject();
	}

	@Override
	public ModelType getModelType() {
		return ModelType.CITYGML;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.BUILDING_PART_PROPERTY;
	}

	public final BuildingModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}

	@Override
	public Class<BuildingPart> getAssociableClass() {
		return BuildingPart.class;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new BuildingPartProperty(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		BuildingPartProperty copy = (target == null) ? new BuildingPartProperty() : (BuildingPartProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
