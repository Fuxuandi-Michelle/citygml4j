package org.citygml4j.model.module.citygml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.buildingExtra.Beam;
import org.citygml4j.model.citygml.buildingExtra.Column;
import org.citygml4j.model.citygml.buildingExtra.Covering;
import org.citygml4j.model.citygml.buildingExtra.FlowTerminal;
import org.citygml4j.model.citygml.buildingExtra.Podium;
import org.citygml4j.model.citygml.buildingExtra.Railing;
import org.citygml4j.model.citygml.buildingExtra.Ramp;
import org.citygml4j.model.citygml.buildingExtra.RampFlight;
import org.citygml4j.model.citygml.buildingExtra.Slab;
import org.citygml4j.model.citygml.buildingExtra.Stair;
import org.citygml4j.model.citygml.buildingExtra.StairFlight;
import org.citygml4j.model.citygml.buildingExtra.Storey;
import org.citygml4j.model.module.Module;

public class BuildingExtraModule extends AbstractCityGMLModule {
	private static final List<BuildingExtraModule> instances = new ArrayList<BuildingExtraModule>();
	
	public static final BuildingExtraModule v2_0_0;
	
	private BuildingExtraModule (
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
		v2_0_0 = new BuildingExtraModule (
				CityGMLModuleType.BUILDING,
				CityGMLModuleVersion.v2_0_0,
				"http://www.citygml.org/ade/buildingExtra",
				"pfx0",
				"ADESchema/bldgEx_Formal_Podium_AbsBldg_bldgex.xsd",			
				CoreModule.v2_0_0);
		
		
		v2_0_0.elementMap = new HashMap<String, Class<? extends CityGML>>();
		v2_0_0.elementMap.put("Storey", Storey.class);
		v2_0_0.elementMap.put("Podium", Podium.class);
		v2_0_0.elementMap.put("Beam",Beam.class);
		v2_0_0.elementMap.put("Stair",Stair.class);
		v2_0_0.elementMap.put("StairFlight",StairFlight.class);
		v2_0_0.elementMap.put("Column",Column.class);
		v2_0_0.elementMap.put("Railing",Railing.class);
		v2_0_0.elementMap.put("FlowTerminal",FlowTerminal.class);
		v2_0_0.elementMap.put("Slab",Slab.class);
		v2_0_0.elementMap.put("Covering",Covering.class);
		v2_0_0.elementMap.put("Ramp",Ramp.class);
		v2_0_0.elementMap.put("RampFlight",RampFlight.class);
	}
	
	public static List<BuildingExtraModule> getInstances() {
		return instances;
	}
	
	public static BuildingExtraModule getInstance(CityGMLModuleVersion version) {
		switch (version) {
		case v2_0_0:
			return v2_0_0;
		default:
			return null;
		}
	}
}
