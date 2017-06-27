package testCitygml4jADE;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;

import org.citygml4j.CityGMLContext;
import org.citygml4j.builder.jaxb.JAXBBuilder;
import org.citygml4j.builder.jaxb.JAXBContextPath;
import org.citygml4j.builder.jaxb.marshal.JAXBMarshaller;
import org.citygml4j.builder.jaxb.unmarshal.JAXBUnmarshallerx;
import org.citygml4j.model.citygml.core.CityModel;
import org.citygml4j.xml.io.CityGMLInputFactory;
import org.citygml4j.xml.io.reader.CityGMLReader;

import ade.sub.jaxb.ObjectFactory;

public class UnmarshallADE {
	

	public static void main(String[] args) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("[HH:mm:ss] "); 

		System.out.println(df.format(new Date()) + "setting up citygml4j context and JAXB builder");
		CityGMLContext ctx = new CityGMLContext();
		JAXBBuilder builder = ctx.createJAXBBuilder();

		System.out.println(df.format(new Date()) + "reading ADE-enriched CityGML file LOD2_SubsurfaceStructureADE_v100.gml");
		System.out.println(df.format(new Date()) + "ADE schema file is read from xsi:schemaLocation attribute on root XML element");
		CityGMLInputFactory in = builder.createCityGMLInputFactory();
		
		CityGMLReader reader = in.createCityGMLReader(new File("samples/datasets/LOD2_SubsurfaceStructureADE_v100.gml"));
		CityModel cityModel = (CityModel)reader.nextFeature();
		reader.close();
		
		while (reader.hasNext()) {
			JAXBUnmarshallerx unmarshaller = builder.createJAXBUnmarshaller();
			unmarshaller.setReleaseJAXBElementsFromMemory(false);
			
			JAXBMarshaller marshaller = builder.createJAXBMarshaller();
			
			System.out.println(df.format(new Date()) + "creating JAXBContext from ADE JAXB classes");
			ObjectFactory jaxbFactory = new ObjectFactory();
			String contextPath = JAXBContextPath.getContextPath("org.citygml4j.model.citygml.buildingExtra");
			JAXBContext jaxbCtx = JAXBContext.newInstance(contextPath);
			Unmarshaller jaxbUmarshaller = jaxbCtx.createUnmarshaller();
			
			System.out.println(df.format(new Date()) + "unmarshalling ADE content using JAXB Unmarshaller");
			
			
			//JAXBElement<?> element = (JAXBElement<?>)jaxbUmarshaller.unmarshal(ade.getContent());
			//System.out.println("Unmarshalled JAXBElement: " + element.getName());
		
			//System.out.println(df.format(new Date()) + "processing ADE feature sub:Tunnel by using JAXBUnmarshaller and JAXBMarshaller to modify ADE content");
		}
	}
	
}
