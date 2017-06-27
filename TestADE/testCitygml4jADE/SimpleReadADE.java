package testCitygml4jADE;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.citygml4j.CityGMLContext;
import org.citygml4j.builder.CityGMLBuilder;
import org.citygml4j.builder.jaxb.JAXBBuilder;
import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.building.Buildingx;
import org.citygml4j.model.citygml.building.BuildingInstallationProperty;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.citygml.core.CityModel;
import org.citygml4j.model.citygml.core.CityObjectMember;
import org.citygml4j.xml.io.CityGMLInputFactory;
import org.citygml4j.xml.io.reader.CityGMLReader;

public class SimpleReadADE {

	public static void main(String[] args) throws Exception {
		
		SimpleDateFormat df = new SimpleDateFormat("[HH:mm:ss] "); 
		
		System.out.println(df.format(new Date()) + "setting up citygml4j context and JAXB builder");
		CityGMLContext ctx = new CityGMLContext();
		CityGMLBuilder builder = ctx.createCityGMLBuilder();
		CityGMLInputFactory in = builder.createCityGMLInputFactory();
		System.out.println((new File("Test/Sample/storey_buildingInstallation_unextend.gml")).getAbsolutePath());
		//CityGMLReader reader = in.createCityGMLReader(new File("Test/Sample/Storey2_role_Test_underbuilding.gml"));
		CityGMLReader reader = in.createCityGMLReader(new File("Test/Sample/storey_buildingInstallation_unextend.gml"));
		
		
		int feature_count = 0;
		
		while (reader.hasNext()) {
			CityGML citygml = reader.nextFeature();
			feature_count++;
			System.out.println("Found " + citygml.getCityGMLClass() + 
					" version " + citygml.getCityGMLModule().getVersion());
			
			if (citygml.getCityGMLClass() == CityGMLClass.CITY_MODEL) {
				CityModel cityModel = (CityModel)citygml;
				System.out.println(df.format(new Date()) + "going through city model and counting building instances");
				int count = 0;
				//int storey_count = 0, stair_count = 0;
				
				for (CityObjectMember cityObjectMember : cityModel.getCityObjectMember()) {
					AbstractCityObject cityObject = cityObjectMember.getCityObject();
					if (cityObject.getCityGMLClass() == CityGMLClass.BUILDING) {
						for(BuildingInstallationProperty bi : ((Buildingx)cityObject).getOuterBuildingInstallation()) {
							System.out.println(bi.getCityGMLClass());
						}
						/*if(((Building)cityObject).isSetOuterBuildingInstallation()) {
							System.out.println("k");
							List<BuildingInstallationProperty> obi = ((Building)cityObject).getOuterBuildingInstallation();
							for(BuildingInstallationProperty bi:obi) {
								System.out.println(bi.getCityGMLClass());
							}
						}*/
						count++;
						
					}
					
				}

				System.out.println("The city model contains " + count + " building features");
				//System.out.println("The city model contains " + storey_count + " storey features");
				//System.out.println("The city model contains " + stair_count + " stair features");
			}
		}
		
		reader.close();
		System.out.println(feature_count+" features read");
		System.out.println(df.format(new Date()) + "sample citygml4j application successfully finished");
	}
}
