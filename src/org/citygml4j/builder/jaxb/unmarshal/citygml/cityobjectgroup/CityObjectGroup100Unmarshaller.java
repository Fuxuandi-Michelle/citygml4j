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
package org.citygml4j.builder.jaxb.unmarshal.citygml.cityobjectgroup;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.citygml4j.builder.jaxb.unmarshal.JAXBUnmarshaller;
import org.citygml4j.builder.jaxb.unmarshal.citygml.CityGMLUnmarshaller;
import net.opengis.citygml.cityobjectgroup._1.CityObjectGroupMemberType;
import net.opengis.citygml.cityobjectgroup._1.CityObjectGroupParentType;
import net.opengis.citygml.cityobjectgroup._1.CityObjectGroupType;
import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.cityobjectgroup.CityObjectGroup;
import org.citygml4j.model.citygml.cityobjectgroup.CityObjectGroupMember;
import org.citygml4j.model.citygml.cityobjectgroup.CityObjectGroupParent;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.gml.basicTypes.Code;
import org.citygml4j.model.gml.xlink.XLinkActuate;
import org.citygml4j.model.gml.xlink.XLinkShow;
import org.citygml4j.model.gml.xlink.XLinkType;
import org.citygml4j.model.module.citygml.CityObjectGroupModule;
import org.citygml4j.xml.io.reader.MissingADESchemaException;

public class CityObjectGroup100Unmarshaller {
	private final CityObjectGroupModule module = CityObjectGroupModule.v1_0_0;
	private final JAXBUnmarshaller jaxb;
	private final CityGMLUnmarshaller citygml;

	public CityObjectGroup100Unmarshaller(CityGMLUnmarshaller citygml) {
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

		if (src instanceof CityObjectGroupType)
			dest = unmarshalCityObjectGroup((CityObjectGroupType)src);
		else if (src instanceof CityObjectGroupMemberType)
			dest = unmarshalCityObjectGroupMember((CityObjectGroupMemberType)src);
		else if (src instanceof CityObjectGroupParentType)
			dest = unmarshalCityObjectGroupParent((CityObjectGroupParentType)src);

		return dest;
	}

	public void unmarshalCityObjectGroup(CityObjectGroupType src, CityObjectGroup dest) throws MissingADESchemaException {
		citygml.getCore100Unmarshaller().unmarshalAbstractCityObject(src, dest);

		if (src.isSetClazz())
			dest.setClazz(new Code(src.getClazz()));

		if (src.isSetFunction()) {
			for (String function : src.getFunction())
				dest.addFunction(new Code(function));
		}

		if (src.isSetUsage()) {
			for (String usage : src.getUsage())
				dest.addUsage(new Code(usage));
		}

		if (src.isSetGeometry())
			dest.setGeometry(jaxb.getGMLUnmarshaller().unmarshalGeometryProperty(src.getGeometry()));

		if (src.isSetGroupMember()) {
			for (CityObjectGroupMemberType cityObjectGroupMember : src.getGroupMember())
				dest.addGroupMember(unmarshalCityObjectGroupMember(cityObjectGroupMember));
		}

		if (src.isSetParent())
			dest.setGroupParent(unmarshalCityObjectGroupParent(src.getParent()));	
	}

	public CityObjectGroup unmarshalCityObjectGroup(CityObjectGroupType src) throws MissingADESchemaException {
		CityObjectGroup dest = new CityObjectGroup(module);
		unmarshalCityObjectGroup(src, dest);

		return dest;
	}

	public CityObjectGroupMember unmarshalCityObjectGroupMember(CityObjectGroupMemberType src) throws MissingADESchemaException {
		CityObjectGroupMember dest = new CityObjectGroupMember(module);

		if (src.isSet_CityObject()) {
			ModelObject object = jaxb.unmarshal(src.get_CityObject());
			if (object instanceof AbstractCityObject)
				dest.setObject((AbstractCityObject)object);
		}
		
		if (src.isSetGroupRole())
			dest.setGroupRole(src.getGroupRole());

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

	public CityObjectGroupParent unmarshalCityObjectGroupParent(CityObjectGroupParentType src) throws MissingADESchemaException {
		CityObjectGroupParent dest = new CityObjectGroupParent(module);

		if (src.isSet_CityObject()) {
			ModelObject object = jaxb.unmarshal(src.get_CityObject());
			if (object instanceof AbstractCityObject)
				dest.setObject((AbstractCityObject)object);
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
	
	public boolean assignGenericProperty(ADEComponent genericProperty, QName substitutionGroup, CityGML dest) {
		String name = substitutionGroup.getLocalPart();
		boolean success = true;
		
		if (dest instanceof CityObjectGroup && name.equals("_GenericApplicationPropertyOfCityObjectGroup"))
			((CityObjectGroup)dest).addGenericApplicationPropertyOfCityObjectGroup(genericProperty);
		else 
			success = false;
		
		return success;
	}

}
