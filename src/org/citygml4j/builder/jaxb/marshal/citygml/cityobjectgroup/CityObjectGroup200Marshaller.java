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
package org.citygml4j.builder.jaxb.marshal.citygml.cityobjectgroup;

import javax.xml.bind.JAXBElement;

import net.opengis.citygml._2.AbstractCityObjectType;
import net.opengis.citygml.cityobjectgroup._2.CityObjectGroupMemberType;
import net.opengis.citygml.cityobjectgroup._2.CityObjectGroupParentType;
import net.opengis.citygml.cityobjectgroup._2.CityObjectGroupType;
import net.opengis.citygml.cityobjectgroup._2.ObjectFactory;

import org.citygml4j.builder.jaxb.marshal.JAXBMarshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.CityGMLMarshaller;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.cityobjectgroup.CityObjectGroup;
import org.citygml4j.model.citygml.cityobjectgroup.CityObjectGroupMember;
import org.citygml4j.model.citygml.cityobjectgroup.CityObjectGroupModuleComponent;
import org.citygml4j.model.citygml.cityobjectgroup.CityObjectGroupParent;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.gml.basicTypes.Code;
import org.w3._1999.xlink.ActuateType;
import org.w3._1999.xlink.ShowType;
import org.w3._1999.xlink.TypeType;

public class CityObjectGroup200Marshaller {
	private final ObjectFactory grp = new ObjectFactory();
	private final JAXBMarshaller jaxb;
	private final CityGMLMarshaller citygml;
	
	public CityObjectGroup200Marshaller(CityGMLMarshaller citygml) {
		this.citygml = citygml;
		jaxb = citygml.getJAXBMarshaller();
	}

	public JAXBElement<?> marshalJAXBElement(Object src) {
		JAXBElement<?> dest = null;
		
		if (src instanceof CityObjectGroupModuleComponent)
			src = marshal((CityObjectGroupModuleComponent)src);
		
		if (src instanceof CityObjectGroupType)
			dest = grp.createCityObjectGroup((CityObjectGroupType)src);
		
		return dest;
	}
	
	public Object marshal(ModelObject src) {
		Object dest = null;
		
		if (src instanceof CityObjectGroup)
			dest = marshalCityObjectGroup((CityObjectGroup)src);
		else if (src instanceof CityObjectGroupMember)
			dest = marshalCityObjectGroupMember((CityObjectGroupMember)src);
		else if (src instanceof CityObjectGroupParent)
			dest = marshalCityObjectGroupParent((CityObjectGroupParent)src);
		
		return dest;
	}
	
	public void marshalCityObjectGroup(CityObjectGroup src, CityObjectGroupType dest) {
		citygml.getCore200Marshaller().marshalAbstractCityObject(src, dest);

		if (src.isSetClazz())
			dest.setClazz(jaxb.getGMLMarshaller().marshalCode(src.getClazz()));

		if (src.isSetFunction()) {
			for (Code function : src.getFunction())
				dest.getFunction().add(jaxb.getGMLMarshaller().marshalCode(function));
		}

		if (src.isSetUsage()) {
			for (Code usage : src.getUsage())
				dest.getUsage().add(jaxb.getGMLMarshaller().marshalCode(usage));
		}

		if (src.isSetGeometry())
			dest.setGeometry(jaxb.getGMLMarshaller().marshalGeometryProperty(src.getGeometry()));

		if (src.isSetGroupMember()) {
			for (CityObjectGroupMember cityObjectGroupMember : src.getGroupMember())
				dest.getGroupMember().add(marshalCityObjectGroupMember(cityObjectGroupMember));
		}

		if (src.isSetGroupParent())
			dest.setParent(marshalCityObjectGroupParent(src.getGroupParent()));	
		
		if (src.isSetGenericApplicationPropertyOfCityObjectGroup()) {
			for (ADEComponent adeComponent :src.getGenericApplicationPropertyOfCityObjectGroup())
				if (adeComponent.isSetContent())
					dest.get_GenericApplicationPropertyOfCityObjectGroup().add(citygml.ade2jaxbElement(adeComponent));
		}
	}

	public CityObjectGroupType marshalCityObjectGroup(CityObjectGroup src) {
		CityObjectGroupType dest = grp.createCityObjectGroupType();
		marshalCityObjectGroup(src, dest);

		return dest;
	}
		
	@SuppressWarnings("unchecked")
	public CityObjectGroupMemberType marshalCityObjectGroupMember(CityObjectGroupMember src) {
		CityObjectGroupMemberType dest = grp.createCityObjectGroupMemberType();

		if (src.isSetCityObject()) {
			JAXBElement<?> elem = jaxb.marshalJAXBElement(src.getCityObject());
			if (elem != null && elem.getValue() instanceof AbstractCityObjectType)
				dest.set_CityObject((JAXBElement<? extends AbstractCityObjectType>)elem);
		}
		
		if (src.isSetGenericADEComponent() && src.getGenericADEComponent().isSetContent())
			dest.set_ADEComponent(src.getGenericADEComponent().getContent());
		
		if (src.isSetGroupRole())
			dest.setGroupRole(src.getGroupRole());
		
		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(TypeType.fromValue(src.getType().getValue()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(ShowType.fromValue(src.getShow().getValue()));

		if (src.isSetActuate())
			dest.setActuate(ActuateType.fromValue(src.getActuate().getValue()));

		return dest;
	}
	
	@SuppressWarnings("unchecked")
	public CityObjectGroupParentType marshalCityObjectGroupParent(CityObjectGroupParent src) {
		CityObjectGroupParentType dest = grp.createCityObjectGroupParentType();

		if (src.isSetCityObject()) {
			JAXBElement<?> elem = jaxb.marshalJAXBElement(src.getCityObject());
			if (elem != null && elem.getValue() instanceof AbstractCityObjectType)
				dest.set_CityObject((JAXBElement<? extends AbstractCityObjectType>)elem);
		}
		
		if (src.isSetGenericADEComponent() && src.getGenericADEComponent().isSetContent())
			dest.set_ADEComponent(src.getGenericADEComponent().getContent());

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(TypeType.fromValue(src.getType().getValue()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(ShowType.fromValue(src.getShow().getValue()));

		if (src.isSetActuate())
			dest.setActuate(ActuateType.fromValue(src.getActuate().getValue()));

		return dest;
	}
	
}
