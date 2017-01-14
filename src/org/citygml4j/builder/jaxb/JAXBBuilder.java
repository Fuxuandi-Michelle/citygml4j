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
package org.citygml4j.builder.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import org.citygml4j.builder.CityGMLBuilder;
import org.citygml4j.builder.jaxb.marshal.JAXBMarshaller;
import org.citygml4j.builder.jaxb.unmarshal.JAXBUnmarshaller;
import org.citygml4j.builder.jaxb.xml.io.reader.JAXBInputFactory;
import org.citygml4j.builder.jaxb.xml.io.writer.JAXBOutputFactory;
import org.citygml4j.builder.jaxb.xml.validation.JAXBValidator;
import org.citygml4j.model.module.ModuleContext;
import org.citygml4j.model.module.citygml.CityGMLVersion;
import org.citygml4j.xml.io.CityGMLInputFactory;
import org.citygml4j.xml.io.CityGMLOutputFactory;
import org.citygml4j.xml.io.reader.CityGMLReadException;
import org.citygml4j.xml.io.writer.CityGMLWriteException;
import org.citygml4j.xml.schema.SchemaHandler;
import org.citygml4j.xml.validation.CityGMLValidateException;
import org.citygml4j.xml.validation.Validator;
import org.xml.sax.SAXException;

public class JAXBBuilder implements CityGMLBuilder {
	private final JAXBContext context;
	
	public JAXBBuilder() throws JAXBException {
		this(Thread.currentThread().getContextClassLoader());
	}
	
	public JAXBBuilder(ClassLoader classLoader) throws JAXBException {
		context = JAXBContext.newInstance(JAXBContextPath.getContextPath(), classLoader);
	}
	
	public JAXBBuilder(String... packageNames) throws JAXBException {
		this(Thread.currentThread().getContextClassLoader(), JAXBContextPath.getContextPath(packageNames));
	}
	
	public JAXBBuilder(ClassLoader classLoader, String... packageNames) throws JAXBException {
		context = JAXBContext.newInstance(JAXBContextPath.getContextPath(packageNames), classLoader);
	}

	public JAXBContext getJAXBContext() {
		return context;
	}
	
	public JAXBUnmarshaller createJAXBUnmarshaller(SchemaHandler schemaHandler) {
		return new JAXBUnmarshaller(this, schemaHandler);
	}
	
	public JAXBUnmarshaller createJAXBUnmarshaller() throws SAXException {
		return createJAXBUnmarshaller(SchemaHandler.newInstance());
	}
	
	public JAXBMarshaller createJAXBMarshaller(ModuleContext moduleContext) {
		return new JAXBMarshaller(this, moduleContext);
	}
	
	public JAXBMarshaller createJAXBMarshaller(CityGMLVersion version) {
		return new JAXBMarshaller(this, new ModuleContext(version));
	}
	
	public JAXBMarshaller createJAXBMarshaller() {
		return createJAXBMarshaller(new ModuleContext(CityGMLVersion.DEFAULT));
	}
	
	public CityGMLInputFactory createCityGMLInputFactory() throws CityGMLReadException {
		return new JAXBInputFactory(this);
	}
	
	public CityGMLInputFactory createCityGMLInputFactory(SchemaHandler schemaHandler) {
		return new JAXBInputFactory(this, schemaHandler);
	}
	
	public CityGMLOutputFactory createCityGMLOutputFactory() throws CityGMLWriteException {
		return new JAXBOutputFactory(this);
	}
	
	public CityGMLOutputFactory createCityGMLOutputFactory(ModuleContext moduleContext) throws CityGMLWriteException {
		return new JAXBOutputFactory(this, moduleContext);
	}
	
	public CityGMLOutputFactory createCityGMLOutputFactory(ModuleContext moduleContext, SchemaHandler schemaHandler) {
		return new JAXBOutputFactory(this, moduleContext, schemaHandler);
	}
	
	public CityGMLOutputFactory createCityGMLOutputFactory(CityGMLVersion version) throws CityGMLWriteException {
		return new JAXBOutputFactory(this, new ModuleContext(version));
	}
	
	public CityGMLOutputFactory createCityGMLOutputFactory(CityGMLVersion version, SchemaHandler schemaHandler) {
		return new JAXBOutputFactory(this, new ModuleContext(version), schemaHandler);
	}
	
	public CityGMLOutputFactory createCityGMLOutputFactory(SchemaHandler schemaHandler) {
		return new JAXBOutputFactory(this, schemaHandler);
	}
	
	public Validator createValidator() throws CityGMLValidateException {
		return new JAXBValidator(this);
	}
	
	public Validator createValidator(SchemaHandler schemaHandler) {
		return new JAXBValidator(this, schemaHandler);
	}
	
}
