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
import org.citygml4j.model.citygml.transportation.AuxiliaryTrafficArea;
import org.citygml4j.model.citygml.transportation.Railway;
import org.citygml4j.model.citygml.transportation.Road;
import org.citygml4j.model.citygml.transportation.Square;
import org.citygml4j.model.citygml.transportation.Track;
import org.citygml4j.model.citygml.transportation.TrafficArea;
import org.citygml4j.model.citygml.transportation.TransportationComplex;
import org.citygml4j.model.module.Module;

public class TransportationModule extends AbstractCityGMLModule {
	private static final List<TransportationModule> instances = new ArrayList<TransportationModule>();

	public static final TransportationModule v2_0_0;
	public static final TransportationModule v1_0_0;

	private TransportationModule (
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
		v2_0_0 = new TransportationModule (
				CityGMLModuleType.TRANSPORTATION,
				CityGMLModuleVersion.v2_0_0,
				"http://www.opengis.net/citygml/transportation/2.0",
				"tran",
				"http://schemas.opengis.net/citygml/transportation/2.0/transportation.xsd",			
				CoreModule.v2_0_0);
		
		v1_0_0 = new TransportationModule (
				CityGMLModuleType.TRANSPORTATION,
				CityGMLModuleVersion.v1_0_0,
				"http://www.opengis.net/citygml/transportation/1.0",
				"tran",
				"http://schemas.opengis.net/citygml/transportation/1.0/transportation.xsd",			
				CoreModule.v1_0_0);

		v2_0_0.elementMap = new HashMap<String, Class<? extends CityGML>>();
		v2_0_0.elementMap.put("TransportationComplex", TransportationComplex.class);
		v2_0_0.elementMap.put("AuxiliaryTrafficArea", AuxiliaryTrafficArea.class);
		v2_0_0.elementMap.put("TrafficArea", TrafficArea.class);
		v2_0_0.elementMap.put("Square", Square.class);
		v2_0_0.elementMap.put("Track", Track.class);
		v2_0_0.elementMap.put("Railway", Railway.class);
		v2_0_0.elementMap.put("Road", Road.class);
		v1_0_0.elementMap = v2_0_0.elementMap;
		
		v2_0_0.propertySet = new HashSet<String>();
		v2_0_0.propertySet.add("trafficArea");
		v2_0_0.propertySet.add("auxiliaryTrafficArea");
		v1_0_0.propertySet = v2_0_0.propertySet;
	}

	public static List<TransportationModule> getInstances() {
		return instances;
	}
	
	public static TransportationModule getInstance(CityGMLModuleVersion version) {
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
