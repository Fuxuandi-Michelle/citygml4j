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
package org.citygml4j.model.gml.base;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.common.association.Associable;
import org.citygml4j.model.common.association.Association;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.gml.GML;
import org.citygml4j.model.gml.GMLClass;

public abstract class ArrayAssociation<T extends Associable & Child> implements GML, Association<T>, Child, Copyable {
	private List<T> object;
	private HashMap<String, Object> localProperties;
	private ModelObject parent;

	public ArrayAssociation() {

	}
	
	public ArrayAssociation(T object) {
		addObject(object);
	}

	public ArrayAssociation(List<T> object) {
		setObject(object);
	}

	public ArrayAssociation(T[] object) {
		this(Arrays.asList(object));
	}
	
	public void addObject(T object) {
		if (this.object == null)
			this.object = new ChildList<T>(this);

		this.object.add(object);
	}

	public List<T> getObject() {
		if (object == null)
			object = new ChildList<T>(this);

		return object;
	}

	public boolean isSetObject() {
		return object != null && !object.isEmpty();
	}

	public void setObject(List<T> object) {
		this.object = new ChildList<T>(this, object);
	}

	public void unsetObject() {
		if (isSetObject())
			object.clear();

		object = null;
	}

	public boolean unsetObject(T object) {
		return isSetObject() ? this.object.remove(object) : false;
	}

	public ModelType getModelType() {
		return ModelType.GML;
	}

	public GMLClass getGMLClass() {
		return GMLClass.ARRAY_ASSOCIATION;
	}

	public Object getLocalProperty(String name) {
		if (localProperties != null)
			return localProperties.get(name);

		return null;
	}

	public void setLocalProperty(String name, Object value) {
		if (localProperties == null)
			localProperties = new HashMap<String, Object>();

		localProperties.put(name, value);
	}

	public boolean hasLocalProperty(String name) {
		return localProperties != null && localProperties.containsKey(name);
	}

	public Object unsetLocalProperty(String name) {
		if (localProperties != null)
			return localProperties.remove(name);

		return null;
	}

	public ModelObject getParent() {
		return parent;
	}

	public void setParent(ModelObject parent) {
		this.parent = parent;
	}

	public boolean isSetParent() {
		return parent != null;
	}

	public void unsetParent() {
		parent = null;
	}

	@SuppressWarnings("unchecked")
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		if (target == null)
			throw new IllegalArgumentException("Target argument must not be null for abstract copyable classes.");

		ArrayAssociation<T> copy = (ArrayAssociation<T>)target;

		if (isSetObject()) {
			for (T part : object) {
				T copyPart = (T)copyBuilder.copy(part);
				copy.addObject(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}

		copy.unsetParent();

		return copy;
	}

}
