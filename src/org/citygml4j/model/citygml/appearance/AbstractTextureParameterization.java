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
package org.citygml4j.model.citygml.appearance;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.gml.base.AbstractGML;
import org.citygml4j.model.module.citygml.AppearanceModule;

public abstract class AbstractTextureParameterization extends AbstractGML implements AppearanceModuleComponent {
	private List<ADEComponent> genericADEComponent;
	private List<ADEComponent> ade;
	private AppearanceModule module;
	
	public AbstractTextureParameterization() {
		
	}
	
	public AbstractTextureParameterization(AppearanceModule module) {
		this.module = module;
	}
	
	public void addGenericADEComponent(ADEComponent genericADEComponent) {
		if (this.genericADEComponent == null)
			this.genericADEComponent = new ChildList<ADEComponent>(this);
		
		this.genericADEComponent.add(genericADEComponent);
	}
	
	public void addGenericApplicationPropertyOfTextureParameterization(ADEComponent ade) {
		if (this.ade == null)
			this.ade = new ChildList<ADEComponent>(this);

		this.ade.add(ade);
	}

	public List<ADEComponent> getGenericADEComponent() {
		if (genericADEComponent == null)
			genericADEComponent = new ChildList<ADEComponent>(this);
		
		return genericADEComponent;
	}
	
	public List<ADEComponent> getGenericApplicationPropertyOfTextureParameterization() {
		if (ade == null)
			ade = new ChildList<ADEComponent>(this);

		return ade;
	}

	public boolean isSetGenericADEComponent() {
		return genericADEComponent != null && !genericADEComponent.isEmpty();
	}
	
	public boolean isSetGenericApplicationPropertyOfTextureParameterization() {
		return ade != null && !ade.isEmpty();
	}

	public void setGenericADEComponent(List<ADEComponent> genericADEComponent) {
		this.genericADEComponent = new ChildList<ADEComponent>(this, genericADEComponent);
	}
	
	public void setGenericApplicationPropertyOfTextureParameterization(List<ADEComponent> ade) {
		this.ade = new ChildList<ADEComponent>(this, ade);
	}

	public void unsetGenericADEComponent() {
		if (isSetGenericADEComponent())
			genericADEComponent.clear();
		
		genericADEComponent = null;
	}

	public boolean unsetGenericADEComponent(ADEComponent genericADEComponent) {
		return isSetGenericADEComponent() ? this.genericADEComponent.remove(genericADEComponent) : false;
	}
	
	public void unsetGenericApplicationPropertyOfTextureParameterization() {
		if (isSetGenericApplicationPropertyOfTextureParameterization())
				ade.clear();

		ade = null;
	}

	public boolean unsetGenericApplicationPropertyOfTextureParameterization(ADEComponent ade) {
		return isSetGenericApplicationPropertyOfTextureParameterization() ? this.ade.remove(ade) : false;
	}

	@Override
	public ModelType getModelType() {
		return ModelType.CITYGML;
	}
	
	public final AppearanceModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		if (target == null)
			throw new IllegalArgumentException("Target argument must not be null for abstract copyable classes.");

		AbstractTextureParameterization copy = (AbstractTextureParameterization)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetGenericApplicationPropertyOfTextureParameterization()) {
			for (ADEComponent part : ade) {
				ADEComponent copyPart = (ADEComponent)copyBuilder.copy(part);
				copy.addGenericApplicationPropertyOfTextureParameterization(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		return copy;
	}
}
