package org.citygml4j.model.citygml.buildingExtra;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;

import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.common.visitor.FeatureFunctor;
import org.citygml4j.model.common.visitor.FeatureVisitor;
import org.citygml4j.model.common.visitor.GMLFunctor;
import org.citygml4j.model.common.visitor.GMLVisitor;
import org.citygml4j.model.gml.feature.FeatureProperty;
import org.citygml4j.model.module.citygml.BuildingExtraModule;
import org.w3c.dom.Element;


public class StoreyProperty extends FeatureProperty<Storey> implements BuildingExtraModuleComponent{
	private BuildingExtraModule module;
	
	public StoreyProperty() {
		
	}
	
	public StoreyProperty(Storey storey) {
		super(storey);
	}
	
	
	public StoreyProperty(String href) {
		super(href);
	}
	
	public StoreyProperty(BuildingExtraModule module) {
		this.module = module;
	}
	
	public Storey getStorey() {
		return super.getObject();
	}

	public boolean isSetStorey() {
		return super.isSetObject();
	}

	public void setStorey(Storey storey) {
		super.setObject(storey);
	}

	public void unsetStorey() {
		super.unsetObject();
	}

	@Override
	public ModelType getModelType() {
		return ModelType.CITYGML;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.STOREY_PROPERTY;
		//return CityGMLClass.BUILDING_PART_PROPERTY;
	}

	public final BuildingExtraModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}

	@Override
	public Class<Storey> getAssociableClass() {
		return Storey.class;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new StoreyProperty(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		StoreyProperty copy = (target == null) ? new StoreyProperty() : (StoreyProperty)target;
		return super.copyTo(copy, copyBuilder);
	}
	
	// unimplemented function for ADEComponent
	
	@Override
	public Element getContent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isSetContent() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setContent(Element content) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void unsetContent() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getLocalName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPrefix() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNamespaceURI() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void visit(FeatureVisitor visitor) {
		visitor.visit(this);
		
	}

	@Override
	public <T> T apply(FeatureFunctor<T> visitor) {
		return visitor.apply(this);
	}



}
