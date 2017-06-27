package org.citygml4j.model.citygml.buildingExtra;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.building.BuildingInstallation;
import org.citygml4j.model.common.visitor.FeatureFunctor;
import org.citygml4j.model.common.visitor.FeatureVisitor;
import org.citygml4j.model.common.visitor.GMLFunctor;
import org.citygml4j.model.common.visitor.GMLVisitor;
import org.citygml4j.model.module.citygml.BuildingExtraModule;
import org.citygml4j.model.module.citygml.BuildingModule;
import org.w3c.dom.Element;

public class Covering extends BuildingInstallation implements BuildingExtraModuleComponent {
	
	private BuildingExtraModule module;
	
	public Covering() {
		
	}
	
	public Covering(BuildingExtraModule module) {
		this.module = module;
	}
	
	
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.COVERING;
	}
	
	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new Covering(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		Covering copy = (target == null) ? new Covering() : (Covering)target;
		super.copyTo(copy, copyBuilder);
		return copy;
	}
		
	@Override
	public void visit(FeatureVisitor visitor) {
		System.out.println("-------visit beam-----------");
		visitor.visit(this);
		
	}

	@Override
	public <T> T apply(FeatureFunctor<T> visitor) {
		System.out.println("-------visit beam-----------");
		return visitor.apply(this);
	}


	public void accept(FeatureVisitor visitor) {
		System.out.println("-------visit beam-----------");
		visitor.visit(this);
	}
	
	public <T> T accept(FeatureFunctor<T> visitor) {
		return visitor.apply(this);
	}
	
	
	public final BuildingExtraModule getCityGMLModule() {
		return module;
	}

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


}
