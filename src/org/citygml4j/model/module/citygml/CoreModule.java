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
import java.util.HashSet;
import java.util.List;

import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.core.Address;
import org.citygml4j.model.citygml.core.CityModel;
import org.citygml4j.model.module.Module;
import org.citygml4j.model.module.gml.GMLCoreModule;
import org.citygml4j.model.module.xal.XALCoreModule;

public class CoreModule extends AbstractCityGMLModule {
	private static final List<CoreModule> instances = new ArrayList<CoreModule>();

	public static final CoreModule v2_0_0;
	public static final CoreModule v1_0_0;

	private CoreModule (
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
		v2_0_0 = new CoreModule (
				CityGMLModuleType.CORE,
				CityGMLModuleVersion.v2_0_0,
				"http://www.opengis.net/citygml/2.0",
				"core",
				"http://schemas.opengis.net/citygml/2.0/cityGMLBase.xsd", 
				GMLCoreModule.v3_1_1, XALCoreModule.v2_0);	
		
		v1_0_0 = new CoreModule (
				CityGMLModuleType.CORE,
				CityGMLModuleVersion.v1_0_0,
				"http://www.opengis.net/citygml/1.0",
				"core",
				"http://schemas.opengis.net/citygml/1.0/cityGMLBase.xsd", 
				GMLCoreModule.v3_1_1, XALCoreModule.v2_0);			

		v2_0_0.elementMap = new HashMap<String, Class<? extends CityGML>>();
		v2_0_0.elementMap.put("CityModel", CityModel.class);
		v2_0_0.elementMap.put("Address", Address.class);
		v1_0_0.elementMap = v2_0_0.elementMap;
		
		v2_0_0.propertySet = new HashSet<String>();
		v2_0_0.propertySet.add("cityObjectMember");
		v2_0_0.propertySet.add("generalizesTo");
		v1_0_0.propertySet = v2_0_0.propertySet;
	}

	public static List<CoreModule> getInstances() {
		return instances;
	}
	
	public static CoreModule getInstance(CityGMLModuleVersion version) {
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
