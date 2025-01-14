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
package org.citygml4j.builder.jaxb.marshal;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.citygml4j.builder.jaxb.JAXBBuilder;
import org.citygml4j.builder.jaxb.marshal.citygml.CityGMLMarshaller;
import org.citygml4j.builder.jaxb.marshal.gml.GMLMarshaller;
import org.citygml4j.builder.jaxb.marshal.xal.XALMarshaller;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.module.ModuleContext;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class JAXBMarshaller {
	private final CityGMLMarshaller citygml;
	private final GMLMarshaller gml;
	private final XALMarshaller xal;
	private final JAXBBuilder jaxbBuilder;

	private ModuleContext moduleContext;	
	private Document document;

	public JAXBMarshaller(JAXBBuilder jaxbBuilder, ModuleContext moduleContext) {
		this.jaxbBuilder = jaxbBuilder;
		this.moduleContext = moduleContext;

		citygml = new CityGMLMarshaller(this);
		gml = new GMLMarshaller(this);
		xal = new XALMarshaller();
	}

	public JAXBElement<?> marshalJAXBElement(Object src) {
		JAXBElement<?> dest = citygml.marshalJAXBElement(src);		
		if (dest == null)
			dest = gml.marshalJAXBElement(src);
		if (dest == null)
			dest = xal.marshalJAXBElement(src);

		return dest;
	}

	public Element marshalDOMElement(Object src) {
		Element dest = null;

		try {
			if (document == null) {			
				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				DocumentBuilder docBuilder = factory.newDocumentBuilder();
				document = docBuilder.newDocument();
			}
			
			dest = marshalDOMElement(src, document);
		} catch (ParserConfigurationException e) {
			// 
		}

		return dest;		
	}
	
	public Element marshalDOMElement(Object src, Document document) {
		Element dest = null;

		try {
			Marshaller marshaller = jaxbBuilder.getJAXBContext().createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);

			Element foo = document.createElement("foo");
			JAXBElement<?> jaxbElement = (src instanceof JAXBElement<?>) ? (JAXBElement<?>)src : marshalJAXBElement(src);
			if (jaxbElement != null)
				marshaller.marshal(jaxbElement, foo);

			Node child = foo.getFirstChild();
			if (child instanceof Element)
				dest = (Element)child;			
		} catch (JAXBException e) {
			//
		}

		return dest;
	}
	
	public Element marshalDOMElement(JAXBElement<?> src, JAXBContext ctx) {
		Element dest = null;

		try {
			if (document == null) {			
				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				DocumentBuilder docBuilder = factory.newDocumentBuilder();
				document = docBuilder.newDocument();
			}
			
			Marshaller marshaller = ctx.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);

			Element foo = document.createElement("foo");
			marshaller.marshal(src, foo);

			Node child = foo.getFirstChild();
			if (child instanceof Element)
				dest = (Element)child;			
		} catch (JAXBException e) {
			//
		} catch (ParserConfigurationException e) {
			// 
		}

		return dest;
	}
	
	public Object marshal(ModelObject src) {
		Object dest = citygml.marshal(src);		
		if (dest == null)
			dest = gml.marshal(src);
		if (dest == null)
			dest = xal.marshal(src);

		return dest;
	}

	public ModuleContext getModuleContext() {
		return moduleContext;
	}

	public void setModuleContext(ModuleContext moduleContext) {
		if (moduleContext == null)
			throw new IllegalArgumentException("module context URI may not be null.");

		this.moduleContext = moduleContext;
	}

	public CityGMLMarshaller getCityGMLMarshaller() {
		return citygml;
	}

	public GMLMarshaller getGMLMarshaller() {
		return gml;
	}

	public XALMarshaller getXALMarshaller() {
		return xal;
	}

}
