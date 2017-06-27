package org.citygml4j.builder.jaxb.unmarshal.citygml.buildingExtra;

import javax.xml.bind.JAXBElement;

import org.citygml4j.builder.jaxb.unmarshal.JAXBUnmarshallerx;
import org.citygml4j.builder.jaxb.unmarshal.citygml.CityGMLUnmarshaller;
import org.citygml4j.builder.jaxb.unmarshal.citygml.building.Building200Unmarshaller;
import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.building.AbstractBoundarySurface;
import org.citygml4j.model.citygml.building.BuildingInstallationProperty;
import org.citygml4j.model.citygml.buildingExtra.Beam;


import org.citygml4j.model.citygml.buildingExtra.Column;
import org.citygml4j.model.citygml.buildingExtra.Covering;
import org.citygml4j.model.citygml.buildingExtra.FlowTerminal;

import org.citygml4j.model.citygml.buildingExtra.Podium;
import org.citygml4j.model.citygml.buildingExtra.Railing;
import org.citygml4j.model.citygml.buildingExtra.Ramp;
import org.citygml4j.model.citygml.buildingExtra.RampFlight;
import org.citygml4j.model.citygml.buildingExtra.Slab;
import org.citygml4j.model.citygml.buildingExtra.Stair;
import org.citygml4j.model.citygml.buildingExtra.StairFlight;
import org.citygml4j.model.citygml.buildingExtra.Storey;
import org.citygml4j.model.citygml.buildingExtra.StoreyProperty;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.gml.xlink.XLinkActuate;
import org.citygml4j.model.gml.xlink.XLinkShow;
import org.citygml4j.model.gml.xlink.XLinkType;
import org.citygml4j.model.module.citygml.BuildingExtraModule;
import org.citygml4j.xml.io.reader.MissingADESchemaException;
import org.w3c.dom.Element;

import net.opengis.citygml.building._2.BoundarySurfacePropertyType;
import net.opengis.citygml.building._2.BuildingFurnitureType;
import net.opengis.citygml.building._2.BuildingInstallationPropertyType;
import net.opengis.citygml.building._2.BuildingInstallationType;
import net.opengis.citygml.building._2.IntBuildingInstallationPropertyType;
import net.opengis.citygml.building._2.IntBuildingInstallationType;
import net.opengis.citygml.building._2.InteriorFurniturePropertyType;
import net.opengis.citygml.building._2.InteriorRoomPropertyType;
import net.opengis.citygml.building._2.RoomType;
import net.opengis.citygml.buildingExtra.BeamType;

import net.opengis.citygml.buildingExtra.ColumnType;
import net.opengis.citygml.buildingExtra.CoveringType;
import net.opengis.citygml.buildingExtra.FlowTerminalType;
import net.opengis.citygml.buildingExtra.PodiumType;
import net.opengis.citygml.buildingExtra.RailingType;
import net.opengis.citygml.buildingExtra.RampFlightType;
import net.opengis.citygml.buildingExtra.RampType;
import net.opengis.citygml.buildingExtra.SlabType;
import net.opengis.citygml.buildingExtra.StairFlightType;
import net.opengis.citygml.buildingExtra.StairType;
import net.opengis.citygml.buildingExtra.StoreyPropertyType;
import net.opengis.citygml.buildingExtra.StoreyType;
import net.opengis.gml.CodeType;

public class BuildingExtra200Unmarshaller {
	
	private final BuildingExtraModule module = BuildingExtraModule.v2_0_0;
	
	private final JAXBUnmarshallerx jaxb;
	private final CityGMLUnmarshaller citygml;
	private final Building200Unmarshaller bldg200;
	
	public BuildingExtra200Unmarshaller(CityGMLUnmarshaller citygml) {
		this.citygml = citygml;
		jaxb = citygml.getJAXBUnmarshaller();
		bldg200 = citygml.getBuilding200Unmarshaller();
	}

	public CityGML unmarshal(JAXBElement<?> src) throws MissingADESchemaException {
		System.out.println("unmarshal building extra: "+src.getValue());
		return unmarshal(src.getValue());
	}
	
	public CityGML unmarshal(Object src) throws MissingADESchemaException {
		
		if (src instanceof JAXBElement<?>)
			return unmarshal((JAXBElement<?>)src);
		
		CityGML dest = null;
		

		if (src instanceof StoreyType)
			dest = unmarshalStorey((StoreyType)src);
		else if (src instanceof StoreyPropertyType)
			dest = unmarshalStoreyProperty((StoreyPropertyType)src);
		else if (src instanceof PodiumType)
			dest = unmarshalPodium((PodiumType)src);
		else if(src instanceof BeamType) {	
			dest = unmarshalBeam((BeamType)src);
		}else if (src instanceof StairType) {	
			dest = unmarshalStair((StairType)src);
		}else if (src instanceof StairFlightType)
			dest = unmarshalStairFlight((StairFlightType)src);
		else if (src instanceof ColumnType)
			dest = unmarshalColumn((ColumnType)src);
		else if (src instanceof RailingType)
			dest = unmarshalRailing((RailingType)src);
		else if (src instanceof FlowTerminalType)
			dest = unmarshalFlowTerminal((FlowTerminalType)src);
		else if (src instanceof SlabType)
			dest = unmarshalSlab((SlabType)src);
		else if (src instanceof CoveringType)
			dest = unmarshalCovering((CoveringType)src);
		else if (src instanceof RampType)
			dest = unmarshalRamp((RampType)src);
		else if (src instanceof RampFlightType)
			dest = unmarshalRampFlight((RampFlightType)src);
		
		else if (src instanceof BuildingInstallationPropertyType)
			dest = bldg200.unmarshalBuildingInstallationProperty((BuildingInstallationPropertyType)src);
		else if (src instanceof IntBuildingInstallationPropertyType)
			dest = bldg200.unmarshalIntBuildingInstallationProperty((IntBuildingInstallationPropertyType)src);
		else if (src instanceof InteriorFurniturePropertyType)
			dest = bldg200.unmarshalInteriorFurnitureProperty((InteriorFurniturePropertyType)src);
		else if (src instanceof InteriorRoomPropertyType)
			dest = bldg200.unmarshalInteriorRoomProperty((InteriorRoomPropertyType)src);
		
		else if (src instanceof BuildingFurnitureType)
			dest = bldg200.unmarshalBuildingFurniture((BuildingFurnitureType)src);
		else if (src instanceof BuildingInstallationType)
			dest = bldg200.unmarshalBuildingInstallation((BuildingInstallationType)src);
		else if (src instanceof IntBuildingInstallationType)
			dest = bldg200.unmarshalIntBuildingInstallation((IntBuildingInstallationType)src);
		else if (src instanceof RoomType)
			dest = bldg200.unmarshalRoom((RoomType)src);
		
		
		return dest;
		
	}
	

	public void unmarshalStorey(StoreyType src, Storey dest) throws MissingADESchemaException {
		citygml.getCore200Unmarshaller().unmarshalAbstractSite(src, dest);

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
			
		if (src.isSetMeasuredHeight())
			dest.setMeasuredHeight(jaxb.getGMLUnmarshaller().unmarshalLength(src.getMeasuredHeight()));
		

		if (src.isSetLod2Solid())
			dest.setLod2Solid(jaxb.getGMLUnmarshaller().unmarshalSolidProperty(src.getLod2Solid()));
		
		if (src.isSetLod3Solid())
			dest.setLod3Solid(jaxb.getGMLUnmarshaller().unmarshalSolidProperty(src.getLod3Solid()));
		
		if (src.isSetLod4Solid())
			dest.setLod4Solid(jaxb.getGMLUnmarshaller().unmarshalSolidProperty(src.getLod4Solid()));	
				
		if (src.isSetLod2MultiSurface())
			dest.setLod2MultiSurface(jaxb.getGMLUnmarshaller().unmarshalMultiSurfaceProperty(src.getLod2MultiSurface()));
		
		if (src.isSetLod3MultiSurface())
			dest.setLod3MultiSurface(jaxb.getGMLUnmarshaller().unmarshalMultiSurfaceProperty(src.getLod3MultiSurface()));
		
		if (src.isSetLod4MultiSurface())
			dest.setLod4MultiSurface(jaxb.getGMLUnmarshaller().unmarshalMultiSurfaceProperty(src.getLod4MultiSurface()));
		
		
		if (src.isSetLod2MultiCurve())
			dest.setLod2MultiCurve(jaxb.getGMLUnmarshaller().unmarshalMultiCurveProperty(src.getLod2MultiCurve()));
		
		if (src.isSetLod3MultiCurve())
			dest.setLod3MultiCurve(jaxb.getGMLUnmarshaller().unmarshalMultiCurveProperty(src.getLod3MultiCurve()));
		
		if (src.isSetLod4MultiCurve())
			dest.setLod4MultiCurve(jaxb.getGMLUnmarshaller().unmarshalMultiCurveProperty(src.getLod4MultiCurve()));	
				
		
		if (src.isSetOuterBuildingInstallation()) {
			for (BuildingInstallationPropertyType buildingInstallationProperty : src.getOuterBuildingInstallation()) {
				System.out.println(buildingInstallationProperty.getClass());
				dest.addOuterBuildingInstallation(bldg200.unmarshalBuildingInstallationProperty(buildingInstallationProperty));
				
			}
		}
		
		if (src.isSetInteriorBuildingInstallation()) {
			for (IntBuildingInstallationPropertyType intBuildingInstallationProperty : src.getInteriorBuildingInstallation())
				dest.addInteriorBuildingInstallation(bldg200.unmarshalIntBuildingInstallationProperty(intBuildingInstallationProperty));
		}
		
		if (src.isSetBoundedBySurface()) {
			for (BoundarySurfacePropertyType boundarySurfaceProperty : src.getBoundedBySurface())
				dest.addBoundedBySurface(bldg200.unmarshalBoundarySurfaceProperty(boundarySurfaceProperty));
		}

		if (src.isSetInteriorRoom()) {
			for (InteriorRoomPropertyType interiorRoomProperty : src.getInteriorRoom())
				dest.addInteriorRoom(bldg200.unmarshalInteriorRoomProperty(interiorRoomProperty));
		}
		
		if (src.isSetInteriorFurniture()) {
			for (InteriorFurniturePropertyType interiorFurnitureProperty : src.getInteriorFurniture())
				dest.addInteriorFurniture(bldg200.unmarshalInteriorFurnitureProperty(interiorFurnitureProperty));
		}
		
		
	}
	
	public Storey unmarshalStorey(StoreyType src) throws MissingADESchemaException {
		Storey dest = new Storey(module);
		unmarshalStorey(src, dest);
		System.out.println("unmarshal Storey: " + dest.getCityGMLClass());
		if(dest.isSetOuterBuildingInstallation()) {
			for (BuildingInstallationProperty bip:dest.getOuterBuildingInstallation()) {
				System.out.println(bip.getCityGMLClass());
			}
		}
		return dest;
	}
	
	//=============StoreyProperty==========//
	
	public StoreyProperty unmarshalStoreyProperty(StoreyPropertyType src) throws MissingADESchemaException {
		StoreyProperty dest = new StoreyProperty(module);

		if (src.isSetStorey()) {
			dest.setStorey(unmarshalStorey(src.getStorey()));
			System.out.println("storey instance: "+ src.getStorey().getClass());
		}

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
	
	//==============Podium============//
	
	public void unmarshalPodium(PodiumType src, Podium dest) throws MissingADESchemaException {
		bldg200.unmarshalAbstractBuilding(src, dest);
	}
	
	public Podium unmarshalPodium(PodiumType src) throws MissingADESchemaException {
		Podium dest = new Podium(module);
		unmarshalPodium(src, dest);

		return dest;
	}

	
	//==============Beam============//
	
	public void unmarshalBeam(BeamType src, Beam dest) throws MissingADESchemaException {
		bldg200.unmarshalBuildingInstallation(src, dest);
	}
	
	public Beam unmarshalBeam(BeamType src) throws MissingADESchemaException {
		Beam dest = new Beam(module);
		unmarshalBeam(src, dest);

		return dest;
	}
	
	//1======================================================//
	
	public void unmarshalStair(StairType src, Stair dest) throws MissingADESchemaException {
		bldg200.unmarshalBuildingInstallation(src, dest);

	}

	public Stair unmarshalStair(StairType src) throws MissingADESchemaException {
		Stair dest = new Stair(module);
		unmarshalStair(src, dest);

		return dest;
	}
	
	//=2=====================================================//
	public void unmarshalStairFlight(StairFlightType src, StairFlight dest) throws MissingADESchemaException {
		bldg200.unmarshalBuildingInstallation(src, dest);

	}

	public StairFlight unmarshalStairFlight(StairFlightType src) throws MissingADESchemaException {
		StairFlight dest = new StairFlight(module);
		unmarshalStairFlight(src, dest);

		return dest;
	}
	
	//==3====================================================//
	public void unmarshalColumn(ColumnType src, Column dest) throws MissingADESchemaException {
		bldg200.unmarshalBuildingInstallation(src, dest);

	}

	public Column unmarshalColumn(ColumnType src) throws MissingADESchemaException {
		Column dest = new Column(module);
		unmarshalColumn(src, dest);

		return dest;
	}
	
	//==4====================================================//

	public void unmarshalRailing(RailingType src, Railing dest) throws MissingADESchemaException {
		bldg200.unmarshalBuildingInstallation(src, dest);

	}

	public Railing unmarshalRailing(RailingType src) throws MissingADESchemaException {
		Railing dest = new Railing(module);
		unmarshalRailing(src, dest);
		
		return dest;
	}
	
	//==5====================================================//

	public void unmarshalFlowTerminal(FlowTerminalType src, FlowTerminal dest) throws MissingADESchemaException {
		bldg200.unmarshalBuildingInstallation(src, dest);

	}

	public FlowTerminal unmarshalFlowTerminal(FlowTerminalType src) throws MissingADESchemaException {
		FlowTerminal dest = new FlowTerminal(module);
		unmarshalFlowTerminal(src, dest);

		return dest;
	}	
	
	//==6====================================================//

	public void unmarshalSlab(SlabType src, Slab dest) throws MissingADESchemaException {
		bldg200.unmarshalBuildingInstallation(src, dest);

	}

	public Slab unmarshalSlab(SlabType src) throws MissingADESchemaException {
		Slab dest = new Slab(module);
		unmarshalSlab(src, dest);

		return dest;
	}
	
	//===7===================================================//

	public void unmarshalCovering(CoveringType src, Covering dest) throws MissingADESchemaException {
		bldg200.unmarshalBuildingInstallation(src, dest);

	}

	public Covering unmarshalCovering(CoveringType src) throws MissingADESchemaException {
		Covering dest = new Covering(module);
		unmarshalCovering(src, dest);

		return dest;
	}
	
	//===8===================================================//

	public void unmarshalRampFlight(RampFlightType src, RampFlight dest) throws MissingADESchemaException {
		bldg200.unmarshalBuildingInstallation(src, dest);

	}

	public RampFlight unmarshalRampFlight(RampFlightType src) throws MissingADESchemaException {
		RampFlight dest = new RampFlight(module);
		unmarshalRampFlight(src, dest);

		return dest;
	}
	
	//===9===================================================//

	public void unmarshalRamp(RampType src, Ramp dest) throws MissingADESchemaException {
		bldg200.unmarshalBuildingInstallation(src, dest);

	}

	public Ramp unmarshalRamp(RampType src) throws MissingADESchemaException {
		Ramp dest = new Ramp(module);
		unmarshalRamp(src, dest);

		return dest;
	}
	/*
	public BuildingInstallationProperty unmarshalBuildingInstallationProperty(BuildingInstallationPropertyType src) throws MissingADESchemaException {
		BuildingInstallationProperty dest = new BuildingInstallationProperty(module);

		if (src.isSetBuildingInstallation())
			dest.setBuildingInstallation(bldg200.unmarshalBuildingInstallation(src.getBuildingInstallation()));
		
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
	
	
	public IntBuildingInstallationProperty unmarshalIntBuildingInstallationProperty(IntBuildingInstallationPropertyType src) throws MissingADESchemaException {
		IntBuildingInstallationProperty dest = new IntBuildingInstallationProperty(module);

		if (src.isSetIntBuildingInstallation())
			dest.setIntBuildingInstallation(bldg200.unmarshalIntBuildingInstallation(src.getIntBuildingInstallation()));
		
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

	public InteriorFurnitureProperty unmarshalInteriorFurnitureProperty(InteriorFurniturePropertyType src) throws MissingADESchemaException {
		InteriorFurnitureProperty dest = new InteriorFurnitureProperty(module);

		if (src.isSetBuildingFurniture())
			dest.setBuildingFurniture(bldg200.unmarshalBuildingFurniture(src.getBuildingFurniture()));
		
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

	public InteriorRoomProperty unmarshalInteriorRoomProperty(InteriorRoomPropertyType src) throws MissingADESchemaException {
		InteriorRoomProperty dest = new InteriorRoomProperty(module);

		if (src.isSetRoom())
			dest.setRoom(bldg200.unmarshalRoom(src.getRoom()));
		
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

	public BoundarySurfaceProperty unmarshalBoundarySurfaceProperty(BoundarySurfacePropertyType src) throws MissingADESchemaException {
		BoundarySurfaceProperty dest = new BoundarySurfaceProperty(module);

		if (src.isSet_BoundarySurface()) {
			ModelObject object = jaxb.unmarshal(src.get_BoundarySurface());
			if (object instanceof AbstractBoundarySurface)
				dest.setObject((AbstractBoundarySurface)object);
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
	
	*/

	
	
	
}
