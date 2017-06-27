package org.citygml4j.model.citygml.buildingExtra;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;

import org.citygml4j.model.citygml.building.AbstractBuilding;

import org.citygml4j.model.common.visitor.FeatureFunctor;
import org.citygml4j.model.common.visitor.FeatureVisitor;
import org.citygml4j.model.common.visitor.GMLFunctor;
import org.citygml4j.model.common.visitor.GMLVisitor;
import org.citygml4j.model.module.citygml.BuildingExtraModule;
import org.citygml4j.model.module.citygml.BuildingModule;
import org.w3c.dom.Element;


public class Podium extends AbstractBuilding implements BuildingExtraModuleComponent {
	
	//private List<String> connectedBuildingID;
	private BuildingExtraModule module;
	
	public Podium() {
		
	}
	
	public Podium(BuildingExtraModule module) {
		this.module = module;
	}
	
	
	
	@Override
	public CityGMLClass getCityGMLClass() {
		
		return CityGMLClass.PODIUM;
	}

	@Override
	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new Podium(), copyBuilder);
	}

	public void accept(FeatureVisitor visitor) {
		visitor.visit(this);
	}
	
	public <T> T accept(FeatureFunctor<T> visitor) {
		return visitor.apply(this);
	}
	
	public void accept(GMLVisitor visitor) {
		visitor.visit(this);
	}
	
	public <T> T accept(GMLFunctor<T> visitor) {
		return visitor.apply(this);
	}
	
	//unimplemented function for ADEComponent
	
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public <T> T apply(FeatureFunctor<T> visitor) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public final BuildingExtraModule getCityGMLModule() {
		return module;
	}
	
}
