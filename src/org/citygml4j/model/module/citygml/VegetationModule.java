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
package org.citygml4j.model.module.citygml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.vegetation.PlantCover;
import org.citygml4j.model.citygml.vegetation.SolitaryVegetationObject;
import org.citygml4j.model.module.Module;

public class VegetationModule extends AbstractCityGMLModule {
	private static final List<VegetationModule> instances = new ArrayList<VegetationModule>();

	public static final VegetationModule v2_0_0;
	public static final VegetationModule v1_0_0;

	private VegetationModule (
			CityGMLModuleType type, 
			CityGMLModuleVersion version,
			String namespaceURI, 
			String namespacePrefix, 
			String schemaLocation,
			Module... dependencies) {
		super(type, version, namespaceURI, namespacePrefix, schemaLocation, dependencies);		
		instances.add(this);
	}

	static {
		v2_0_0 = new VegetationModule (
				CityGMLModuleType.VEGETATION,
				CityGMLModuleVersion.v2_0_0,
				"http://www.opengis.net/citygml/vegetation/2.0",
				"veg",
				"http://schemas.opengis.net/citygml/vegetation/2.0/vegetation.xsd",			
				CoreModule.v2_0_0);
		
		v1_0_0 = new VegetationModule (
				CityGMLModuleType.VEGETATION,
				CityGMLModuleVersion.v1_0_0,
				"http://www.opengis.net/citygml/vegetation/1.0",
				"veg",
				"http://schemas.opengis.net/citygml/vegetation/1.0/vegetation.xsd",			
				CoreModule.v1_0_0);

		v2_0_0.elementMap = new HashMap<String, Class<? extends CityGML>>();
		v2_0_0.elementMap.put("SolitaryVegetationObject", SolitaryVegetationObject.class);
		v2_0_0.elementMap.put("PlantCover", PlantCover.class);
		v1_0_0.elementMap = v2_0_0.elementMap;
	}

	public static List<VegetationModule> getInstances() {
		return instances;
	}
	
	public static VegetationModule getInstance(CityGMLModuleVersion version) {
		switch (version) {
		case v2_0_0:
			return v2_0_0;
		case v1_0_0:
			return v1_0_0;
		default:
			return null;
		}
	}

}
