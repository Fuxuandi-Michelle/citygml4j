package testCitygml4jADE;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.citygml4j.CityGMLContext;
import org.citygml4j.builder.CityGMLBuilder;
import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.buildingExtra.Storey;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.citygml.core.CityModel;
import org.citygml4j.model.gml.feature.AbstractFeature;
import org.citygml4j.util.walker.FeatureWalker;
import org.citygml4j.xml.io.CityGMLInputFactory;
import org.citygml4j.xml.io.reader.CityGMLReader;

public class ReadStorey2 {
	
	public static void main(String[] args) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("[HH:mm:ss] "); 

		System.out.println(df.format(new Date()) + "setting up citygml4j context and JAXB builder");
		CityGMLContext ctx = new CityGMLContext();
		CityGMLBuilder builder = ctx.createCityGMLBuilder();

		//System.out.println(df.format(new Date()) + "reading CityGML 0.4.0 file LOD3_Building_v040.gml completely into main memory");
		CityGMLInputFactory in = builder.createCityGMLInputFactory();

		//System.out.println(df.format(new Date()) + "content is internally mapped onto CityGML 1.0.0 while reading");
		

		CityGMLReader reader = in.createCityGMLReader(new File("Test/Sample/storey_excludeBuildingExtra.gml"));
		//CityGMLReader reader = in.createCityGMLReader(new File("Test/Sample/storey_buildingInstallation_unextend.gml"));
		//CityModel cityModel = (CityModel)reader.nextFeature();
		//reader.close();
		

		while (reader.hasNext()) {
			
			CityModel cityModule = (CityModel)reader.nextFeature();
			
			FeatureWalker walker = new FeatureWalker() {
	
				@Override
				public void visit(AbstractFeature abstractFeature) {
					if (abstractFeature instanceof CityGML) {
						CityGML citygml = (CityGML)abstractFeature;
						System.out.println("Found: " + citygml.getCityGMLClass() + " version " 
								+ citygml.getCityGMLModule());
					}
					
					super.visit(abstractFeature);
				}
	
				
				/*@Override
				 * public void visit(AbstractCityObject abstractCityObject) {
					System.out.println("Foundg: " + abstractCityObject.getCityGMLClass() + " version " 
							+ abstractCityObject.getCityGMLModule().getVersion());

					super.visit(abstractCityObject);
				}*/
				
			};
	
			cityModule.accept(walker);
		}
		}
	
	}
