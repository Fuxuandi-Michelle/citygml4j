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
package org.citygml4j.builder.jaxb.unmarshal.citygml.waterbody;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import net.opengis.citygml.waterbody._2.AbstractWaterBoundarySurfaceType;
import net.opengis.citygml.waterbody._2.AbstractWaterObjectType;
import net.opengis.citygml.waterbody._2.BoundedByWaterSurfacePropertyType;
import net.opengis.citygml.waterbody._2.WaterBodyType;
import net.opengis.citygml.waterbody._2.WaterClosureSurfaceType;
import net.opengis.citygml.waterbody._2.WaterGroundSurfaceType;
import net.opengis.citygml.waterbody._2.WaterSurfaceType;
import net.opengis.gml.CodeType;

import org.citygml4j.builder.jaxb.unmarshal.JAXBUnmarshaller;
import org.citygml4j.builder.jaxb.unmarshal.citygml.CityGMLUnmarshaller;
import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.waterbody.AbstractWaterBoundarySurface;
import org.citygml4j.model.citygml.waterbody.AbstractWaterObject;
import org.citygml4j.model.citygml.waterbody.BoundedByWaterSurfaceProperty;
import org.citygml4j.model.citygml.waterbody.WaterBody;
import org.citygml4j.model.citygml.waterbody.WaterClosureSurface;
import org.citygml4j.model.citygml.waterbody.WaterGroundSurface;
import org.citygml4j.model.citygml.waterbody.WaterSurface;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.gml.xlink.XLinkActuate;
import org.citygml4j.model.gml.xlink.XLinkShow;
import org.citygml4j.model.gml.xlink.XLinkType;
import org.citygml4j.model.module.citygml.WaterBodyModule;
import org.citygml4j.xml.io.reader.MissingADESchemaException;

public class WaterBody200Unmarshaller {
	private final WaterBodyModule module = WaterBodyModule.v2_0_0;
	private final JAXBUnmarshaller jaxb;
	private final CityGMLUnmarshaller citygml;

	public WaterBody200Unmarshaller(CityGMLUnmarshaller citygml) {
		this.citygml = citygml;
		jaxb = citygml.getJAXBUnmarshaller();
	}

	public CityGML unmarshal(JAXBElement<?> src) throws MissingADESchemaException {
		return unmarshal(src.getValue());
	}
	
	public CityGML unmarshal(Object src) throws MissingADESchemaException {
		if (src instanceof JAXBElement<?>)
			return unmarshal((JAXBElement<?>)src);

		CityGML dest = null;
				
		if (src instanceof BoundedByWaterSurfacePropertyType)
			dest = unmarshalBoundedByWaterSurfaceProperty((BoundedByWaterSurfacePropertyType)src);
		else if (src instanceof WaterBodyType)
			dest = unmarshalWaterBody((WaterBodyType)src);
		else if (src instanceof WaterClosureSurfaceType)
			dest = unmarshalWaterClosureSurface((WaterClosureSurfaceType)src);
		else if (src instanceof WaterGroundSurfaceType)
			dest = unmarshalWaterGroundSurface((WaterGroundSurfaceType)src);
		else if (src instanceof WaterSurfaceType)
			dest = unmarshalWaterSurface((WaterSurfaceType)src);
		
		return dest;
	}
	
	public void unmarshalAbstractWaterObject(AbstractWaterObjectType src, AbstractWaterObject dest) throws MissingADESchemaException {
		citygml.getCore200Unmarshaller().unmarshalAbstractCityObject(src, dest);
	}
	
	public void unmarshalAbstractWaterBoundarySurface(AbstractWaterBoundarySurfaceType src, AbstractWaterBoundarySurface dest) throws MissingADESchemaException {
		citygml.getCore200Unmarshaller().unmarshalAbstractCityObject(src, dest);
		
		if (src.isSetLod2Surface())
			dest.setLod2Surface(jaxb.getGMLUnmarshaller().unmarshalSurfaceProperty(src.getLod2Surface()));
		
		if (src.isSetLod3Surface())
			dest.setLod3Surface(jaxb.getGMLUnmarshaller().unmarshalSurfaceProperty(src.getLod3Surface()));
		
		if (src.isSetLod4Surface())
			dest.setLod4Surface(jaxb.getGMLUnmarshaller().unmarshalSurfaceProperty(src.getLod4Surface()));
	}

	public BoundedByWaterSurfaceProperty unmarshalBoundedByWaterSurfaceProperty(BoundedByWaterSurfacePropertyType src) throws MissingADESchemaException {
		BoundedByWaterSurfaceProperty dest = new BoundedByWaterSurfaceProperty(module);

		if (src.isSet_WaterBoundarySurface()) {
			ModelObject object = jaxb.unmarshal(src.get_WaterBoundarySurface());
			if (object instanceof AbstractWaterBoundarySurface)
				dest.setObject((AbstractWaterBoundarySurface)object);
		}
		
		if (src.isSet_ADEComponent())
			dest.setGenericADEComponent(jaxb.getADEUnmarshaller().unmarshal(src.get_ADEComponent()));

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(XLinkType.fromValue(src.getType().value()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(XLinkShow.fromValue(src.getShow().value()));

		if (src.isSetActuate())
			dest.setActuate(XLinkActuate.fromValue(src.getActuate().value()));

		return dest;
	}
	
	public void unmarshalWaterBody(WaterBodyType src, WaterBody dest) throws MissingADESchemaException {
		unmarshalAbstractWaterObject(src, dest);
		
		if (src.isSetClazz())
			dest.setClazz(jaxb.getGMLUnmarshaller().unmarshalCode(src.getClazz()));

		if (src.isSetFunction()) {
			for (CodeType function : src.getFunction())
				dest.addFunction(jaxb.getGMLUnmarshaller().unmarshalCode(function));
		}

		if (src.isSetUsage()) {
			for (CodeType usage : src.getUsage())
				dest.addUsage(jaxb.getGMLUnmarshaller().unmarshalCode(usage));
		}
		
		if (src.isSetLod0MultiSurface())
			dest.setLod0MultiSurface(jaxb.getGMLUnmarshaller().unmarshalMultiSurfaceProperty(src.getLod0MultiSurface()));
		
		if (src.isSetLod1MultiSurface())
			dest.setLod1MultiSurface(jaxb.getGMLUnmarshaller().unmarshalMultiSurfaceProperty(src.getLod1MultiSurface()));
		
		if (src.isSetLod0MultiCurve())
			dest.setLod0MultiCurve(jaxb.getGMLUnmarshaller().unmarshalMultiCurveProperty(src.getLod0MultiCurve()));
		
		if (src.isSetLod1MultiCurve())
			dest.setLod1MultiCurve(jaxb.getGMLUnmarshaller().unmarshalMultiCurveProperty(src.getLod1MultiCurve()));
		
		if (src.isSetLod1Solid())
			dest.setLod1Solid(jaxb.getGMLUnmarshaller().unmarshalSolidProperty(src.getLod1Solid()));
		
		if (src.isSetLod2Solid())
			dest.setLod2Solid(jaxb.getGMLUnmarshaller().unmarshalSolidProperty(src.getLod2Solid()));
		
		if (src.isSetLod3Solid())
			dest.setLod3Solid(jaxb.getGMLUnmarshaller().unmarshalSolidProperty(src.getLod3Solid()));
		
		if (src.isSetLod4Solid())
			dest.setLod4Solid(jaxb.getGMLUnmarshaller().unmarshalSolidProperty(src.getLod4Solid()));
		
		if (src.isSetBoundedBySurface()) {
			for (BoundedByWaterSurfacePropertyType boundedByWaterSurfaceProperty : src.getBoundedBySurface())
				dest.addBoundedBySurface(unmarshalBoundedByWaterSurfaceProperty(boundedByWaterSurfaceProperty));
		}
	}
	
	public WaterBody unmarshalWaterBody(WaterBodyType src) throws MissingADESchemaException {
		WaterBody dest = new WaterBody(module);
		unmarshalWaterBody(src, dest);

		return dest;
	}
	
	public void unmarshalWaterClosureSurface(WaterClosureSurfaceType src, WaterClosureSurface dest) throws MissingADESchemaException {
		unmarshalAbstractWaterBoundarySurface(src, dest);
	}
	
	public WaterClosureSurface unmarshalWaterClosureSurface(WaterClosureSurfaceType src) throws MissingADESchemaException {
		WaterClosureSurface dest = new WaterClosureSurface(module);
		unmarshalWaterClosureSurface(src, dest);

		return dest;
	}
	
	public void unmarshalWaterGroundSurface(WaterGroundSurfaceType src, WaterGroundSurface dest) throws MissingADESchemaException {
		unmarshalAbstractWaterBoundarySurface(src, dest);
	}
	
	public WaterGroundSurface unmarshalWaterGroundSurface(WaterGroundSurfaceType src) throws MissingADESchemaException {
		WaterGroundSurface dest = new WaterGroundSurface(module);
		unmarshalWaterGroundSurface(src, dest);

		return dest;
	}
	
	public void unmarshalWaterSurface(WaterSurfaceType src, WaterSurface dest) throws MissingADESchemaException {
		unmarshalAbstractWaterBoundarySurface(src, dest);
		
		if (src.isSetWaterLevel())
			dest.setWaterLevel(jaxb.getGMLUnmarshaller().unmarshalCode(src.getWaterLevel()));
	}
	
	public WaterSurface unmarshalWaterSurface(WaterSurfaceType src) throws MissingADESchemaException {
		WaterSurface dest = new WaterSurface(module);
		unmarshalWaterSurface(src, dest);

		return dest;
	}
	
	public boolean assignGenericProperty(ADEComponent genericProperty, QName substitutionGroup, CityGML dest) {
		String name = substitutionGroup.getLocalPart();
		boolean success = true;
		
		if (dest instanceof AbstractWaterObject && name.equals("_GenericApplicationPropertyOfWaterObject"))
			((AbstractWaterObject)dest).addGenericApplicationPropertyOfWaterObject(genericProperty);		
		else if (dest instanceof AbstractWaterBoundarySurface && name.equals("_GenericApplicationPropertyOfWaterBoundarySurface"))
			((AbstractWaterBoundarySurface)dest).addGenericApplicationPropertyOfWaterBoundarySurface(genericProperty);		
		else if (dest instanceof WaterBody && name.equals("_GenericApplicationPropertyOfWaterBody"))
			((WaterBody)dest).addGenericApplicationPropertyOfWaterBody(genericProperty);		
		else if (dest instanceof WaterClosureSurface && name.equals("_GenericApplicationPropertyOfWaterClosureSurface"))
			((WaterClosureSurface)dest).addGenericApplicationPropertyOfWaterClosureSurface(genericProperty);		
		else if (dest instanceof WaterGroundSurface && name.equals("_GenericApplicationPropertyOfWaterGroundSurface"))
			((WaterGroundSurface)dest).addGenericApplicationPropertyOfWaterGroundSurface(genericProperty);		
		else if (dest instanceof WaterSurface && name.equals("_GenericApplicationPropertyOfWaterSurface"))
			((WaterSurface)dest).addGenericApplicationPropertyOfWaterSurface(genericProperty);		
		else
			success = false;
		
		return success;
	}
	
}
