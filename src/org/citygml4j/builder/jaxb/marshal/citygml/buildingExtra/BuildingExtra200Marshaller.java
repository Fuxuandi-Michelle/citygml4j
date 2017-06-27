package org.citygml4j.builder.jaxb.marshal.citygml.buildingExtra;

import javax.xml.bind.JAXBElement;

import org.citygml4j.builder.jaxb.marshal.JAXBMarshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.CityGMLMarshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.building.Building200Marshaller;
import org.citygml4j.model.citygml.building.BoundarySurfaceProperty;
import org.citygml4j.model.citygml.building.BuildingFurniture;
import org.citygml4j.model.citygml.building.BuildingInstallation;
import org.citygml4j.model.citygml.building.BuildingInstallationProperty;
import org.citygml4j.model.citygml.building.BuildingModuleComponent;
import org.citygml4j.model.citygml.building.IntBuildingInstallation;
import org.citygml4j.model.citygml.building.IntBuildingInstallationProperty;
import org.citygml4j.model.citygml.building.InteriorFurnitureProperty;
import org.citygml4j.model.citygml.building.InteriorRoomProperty;
import org.citygml4j.model.citygml.building.Room;
import org.citygml4j.model.citygml.buildingExtra.Beam;

import org.citygml4j.model.citygml.buildingExtra.BuildingExtraModuleComponent;
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
import org.citygml4j.model.gml.basicTypes.Code;
import org.w3._1999.xlink.ActuateType;
import org.w3._1999.xlink.ShowType;
import org.w3._1999.xlink.TypeType;

import net.opengis.citygml.building._2.BuildingFurnitureType;
import net.opengis.citygml.building._2.BuildingInstallationType;
import net.opengis.citygml.building._2.IntBuildingInstallationType;
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

public class BuildingExtra200Marshaller {
	private final net.opengis.citygml.buildingExtra.ObjectFactory bldgEx = new net.opengis.citygml.buildingExtra.ObjectFactory();
	private final net.opengis.citygml.building._2.ObjectFactory bldg = new net.opengis.citygml.building._2.ObjectFactory();
	private final JAXBMarshaller jaxb;
	private final CityGMLMarshaller citygml;
	private final Building200Marshaller bldg200;
	
	public BuildingExtra200Marshaller(CityGMLMarshaller citygml) {
		this.citygml = citygml;
		jaxb = citygml.getJAXBMarshaller();
		bldg200 = citygml.getBuilding200Marshaller();
	}
	
	public JAXBElement<?> marshalJAXBElement(Object src) {
		JAXBElement<?> dest = null;
		
		/*------ consider BuildingModuleComponent ----*/
		
		if (src instanceof BuildingExtraModuleComponent)
			src = marshal((BuildingExtraModuleComponent)src);
		
		if (src instanceof StoreyType)
			dest = bldgEx.createStorey((StoreyType)src);
		else if (src instanceof PodiumType)
			dest = bldgEx.createPodium((PodiumType)src);
		else if (src instanceof BeamType)
			dest = bldgEx.createBeam((BeamType)src);
		
		else if (src instanceof StairType)
			dest = bldgEx.createStair((StairType)src);
		else if (src instanceof StairFlightType)
			dest = bldgEx.createStairFlight((StairFlightType)src);
		else if (src instanceof ColumnType)
			dest = bldgEx.createColumn((ColumnType)src);
		else if (src instanceof RailingType)
			dest = bldgEx.createRailing((RailingType)src);
		else if (src instanceof FlowTerminalType)
			dest = bldgEx.createFlowTerminal((FlowTerminalType)src);
		else if (src instanceof SlabType)
			dest = bldgEx.createSlab((SlabType)src);
		else if (src instanceof CoveringType)
			dest = bldgEx.createCovering((CoveringType)src);
		else if (src instanceof RampType)
			dest = bldgEx.createRamp((RampType)src);
		else if (src instanceof RampFlightType)
			dest = bldgEx.createRampFlight((RampFlightType)src);
		
		else if (src instanceof BuildingFurnitureType)
			dest = bldg.createBuildingFurniture((BuildingFurnitureType)src);
		else if (src instanceof BuildingInstallationType)
			dest = bldg.createBuildingInstallation((BuildingInstallationType)src);
		else if (src instanceof IntBuildingInstallationType)
			dest = bldg.createIntBuildingInstallation((IntBuildingInstallationType)src);
		else if (src instanceof RoomType)
			dest = bldg.createRoom((RoomType)src);
		
		return dest;
		
	}
	
	public Object marshal(ModelObject src) {
		Object dest = null;
		
		if (src instanceof Storey)
			dest = marshalStorey((Storey)src);
		else if (src instanceof StoreyProperty)
			dest = marshalStoreyProperty((StoreyProperty)src);
		else if (src instanceof Podium)
			dest = marshalPodium((Podium)src);
		else if (src instanceof Beam)
			dest = marshalBeam((Beam)src);
		else if (src instanceof Stair)
			dest = marshalStair((Stair)src);
		else if (src instanceof StairFlight)
			dest = marshalStairFlight((StairFlight)src);
		else if (src instanceof Column)
			dest = marshalColumn((Column)src);
		else if (src instanceof Railing)
			dest = marshalRailing((Railing)src);
		else if (src instanceof FlowTerminal)
			dest = marshalFlowTerminal((FlowTerminal)src);
		else if (src instanceof Slab)
			dest = marshalSlab((Slab)src);
		else if (src instanceof Covering)
			dest = marshalCovering((Covering)src);
		else if (src instanceof Ramp)
			dest = marshalRamp((Ramp)src);
		else if (src instanceof RampFlight)
			dest = marshalRampFlight((RampFlight)src);
		
		else if (src instanceof BuildingInstallationProperty)
			dest = bldg200.marshalBuildingInstallationProperty((BuildingInstallationProperty)src);
		else if (src instanceof IntBuildingInstallationProperty)
			dest = bldg200.marshalIntBuildingInstallationProperty((IntBuildingInstallationProperty)src);
		else if (src instanceof InteriorFurnitureProperty)
			dest = bldg200.marshalInteriorFurnitureProperty((InteriorFurnitureProperty)src);
		else if (src instanceof InteriorRoomProperty)
			dest = bldg200.marshalInteriorRoomProperty((InteriorRoomProperty)src);
		else if (src instanceof BoundarySurfaceProperty)
			dest = bldg200.marshalBoundarySurfaceProperty((BoundarySurfaceProperty)src);
		
		else if (src instanceof BuildingFurniture)
			dest = bldg200.marshalBuildingFurniture((BuildingFurniture)src);
		else if (src instanceof BuildingInstallation)
			dest = bldg200.marshalBuildingInstallation((BuildingInstallation)src);
		else if (src instanceof IntBuildingInstallation)
			dest = bldg200.marshalIntBuildingInstallation((IntBuildingInstallation)src);
		else if (src instanceof Room)
			dest = bldg200.marshalRoom((Room)src);
		
		return dest;
		
		
	}
	
	public void marshalStorey(Storey src, StoreyType dest) {
		citygml.getCore200Marshaller().marshalAbstractSite(src, dest);

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

		if (src.isSetMeasuredHeight())
			dest.setMeasuredHeight(jaxb.getGMLMarshaller().marshalLength(src.getMeasuredHeight()));	
		
		if (src.isSetLod2Solid())
			dest.setLod2Solid(jaxb.getGMLMarshaller().marshalSolidProperty(src.getLod2Solid()));

		if (src.isSetLod3Solid())
			dest.setLod3Solid(jaxb.getGMLMarshaller().marshalSolidProperty(src.getLod3Solid()));

		if (src.isSetLod4Solid())
			dest.setLod4Solid(jaxb.getGMLMarshaller().marshalSolidProperty(src.getLod4Solid()));

		
		if (src.isSetLod2MultiSurface())
			dest.setLod2MultiSurface(jaxb.getGMLMarshaller().marshalMultiSurfaceProperty(src.getLod2MultiSurface()));

		if (src.isSetLod3MultiSurface())
			dest.setLod3MultiSurface(jaxb.getGMLMarshaller().marshalMultiSurfaceProperty(src.getLod3MultiSurface()));

		if (src.isSetLod4MultiSurface())
			dest.setLod4MultiSurface(jaxb.getGMLMarshaller().marshalMultiSurfaceProperty(src.getLod4MultiSurface()));
	
		
		if (src.isSetLod2MultiCurve())
			dest.setLod2MultiCurve(jaxb.getGMLMarshaller().marshalMultiCurveProperty(src.getLod2MultiCurve()));

		if (src.isSetLod3MultiCurve())
			dest.setLod3MultiCurve(jaxb.getGMLMarshaller().marshalMultiCurveProperty(src.getLod3MultiCurve()));

		if (src.isSetLod4MultiCurve())
			dest.setLod4MultiCurve(jaxb.getGMLMarshaller().marshalMultiCurveProperty(src.getLod4MultiCurve()));	

		if (src.isSetOuterBuildingInstallation()) {
			for (BuildingInstallationProperty buildingInstallationProperty : src.getOuterBuildingInstallation())
				dest.getOuterBuildingInstallation().add(bldg200.marshalBuildingInstallationProperty(buildingInstallationProperty));
		}

		if (src.isSetInteriorBuildingInstallation()) {
			for (IntBuildingInstallationProperty intBuildingInstallationProperty : src.getInteriorBuildingInstallation())
				dest.getInteriorBuildingInstallation().add(bldg200.marshalIntBuildingInstallationProperty(intBuildingInstallationProperty));
		}

		if (src.isSetBoundedBySurface()) {
			for (BoundarySurfaceProperty boundarySurfaceProperty : src.getBoundedBySurface())
				dest.getBoundedBySurface().add(bldg200.marshalBoundarySurfaceProperty(boundarySurfaceProperty));
		}

		if (src.isSetInteriorRoom()) {
			for (InteriorRoomProperty interiorRoomProperty : src.getInteriorRoom())
				dest.getInteriorRoom().add(bldg200.marshalInteriorRoomProperty(interiorRoomProperty));
		}
		
		if (src.isSetInteriorFurniture()) {
			for (InteriorFurnitureProperty interiorFurnitureProperty : src.getInteriorFurniture())
				dest.getInteriorFurniture().add(bldg200.marshalInteriorFurnitureProperty(interiorFurnitureProperty));
		}
		
	}
	
	public StoreyType marshalStorey(Storey src) {
		StoreyType dest = bldgEx.createStoreyType();
		marshalStorey(src, dest);

		return dest;
	}
	
	//============Storey Property==============//
	

	public StoreyPropertyType marshalStoreyProperty(StoreyProperty src) {
		StoreyPropertyType dest = bldgEx.createStoreyPropertyType();

		if (src.isSetStorey())
			dest.setStorey(marshalStorey(src.getStorey()));

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

	
	//===========podium================//
	
	public void marshalPodium(Podium src, PodiumType dest) {
		bldg200.marshalAbstractBuilding(src, dest);

	}

	public PodiumType marshalPodium(Podium src) {
		PodiumType dest = bldgEx.createPodiumType();
		marshalPodium(src, dest);

		return dest;
	}
	
	//============BuildingExtra===============//
	//================installations e.g.Beam===================//
	
	public void marshalBeam(Beam src, BeamType dest) {
		bldg200.marshalBuildingInstallation(src, dest);

	}

	public BeamType marshalBeam(Beam src) {
		BeamType dest = bldgEx.createBeamType();
		marshalBeam(src, dest);

		return dest;
	}
	
	//1======================================================//
	
	public void marshalStair(Stair src, StairType dest) {
		bldg200.marshalBuildingInstallation(src, dest);

	}

	public StairType marshalStair(Stair src) {
		StairType dest = bldgEx.createStairType();
		marshalStair(src, dest);

		return dest;
	}
	
	//=2=====================================================//
	public void marshalStairFlight(StairFlight src, StairFlightType dest) {
		bldg200.marshalBuildingInstallation(src, dest);

	}

	public StairFlightType marshalStairFlight(StairFlight src) {
		StairFlightType dest = bldgEx.createStairFlightType();
		marshalStairFlight(src, dest);

		return dest;
	}
	
	//==3====================================================//
	public void marshalColumn(Column src, ColumnType dest) {
		bldg200.marshalBuildingInstallation(src, dest);

	}

	public ColumnType marshalColumn(Column src) {
		ColumnType dest = bldgEx.createColumnType();
		marshalColumn(src, dest);

		return dest;
	}
	
	//==4====================================================//

	public void marshalRailing(Railing src, RailingType dest) {
		bldg200.marshalBuildingInstallation(src, dest);

	}

	public RailingType marshalRailing(Railing src) {
		RailingType dest = bldgEx.createRailingType();
		marshalRailing(src, dest);

		return dest;
	}
	
	//==5====================================================//

	public void marshalFlowTerminal(FlowTerminal src, FlowTerminalType dest) {
		bldg200.marshalBuildingInstallation(src, dest);

	}

	public FlowTerminalType marshalFlowTerminal(FlowTerminal src) {
		FlowTerminalType dest = bldgEx.createFlowTerminalType();
		marshalFlowTerminal(src, dest);

		return dest;
	}	
	
	//==6====================================================//

	public void marshalSlab(Slab src, SlabType dest) {
		bldg200.marshalBuildingInstallation(src, dest);

	}

	public SlabType marshalSlab(Slab src) {
		SlabType dest = bldgEx.createSlabType();
		marshalSlab(src, dest);

		return dest;
	}
	
	//===7===================================================//

	public void marshalCovering(Covering src, CoveringType dest) {
		bldg200.marshalBuildingInstallation(src, dest);

	}

	public CoveringType marshalCovering(Covering src) {
		CoveringType dest = bldgEx.createCoveringType();
		marshalCovering(src, dest);

		return dest;
	}
	
	//===8===================================================//

	public void marshalRampFlight(RampFlight src, RampFlightType dest) {
		bldg200.marshalBuildingInstallation(src, dest);

	}

	public RampFlightType marshalRampFlight(RampFlight src) {
		RampFlightType dest = bldgEx.createRampFlightType();
		marshalRampFlight(src, dest);

		return dest;
	}
	
	//===9===================================================//

	public void marshalRamp(Ramp src, RampType dest) {
		bldg200.marshalBuildingInstallation(src, dest);

	}

	public RampType marshalRamp(Ramp src) {
		RampType dest = bldgEx.createRampType();
		marshalRamp(src, dest);

		return dest;
	}
	
	/*
	public BuildingInstallationPropertyType marshalBuildingInstallationProperty(BuildingInstallationProperty src) {
		BuildingInstallationPropertyType dest = bldg.createBuildingInstallationPropertyType();

		if (src.isSetBuildingInstallation())
			dest.setBuildingInstallation(bldg200.marshalBuildingInstallation(src.getBuildingInstallation()));
		
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
	
	public IntBuildingInstallationPropertyType marshalIntBuildingInstallationProperty(IntBuildingInstallationProperty src) {
		IntBuildingInstallationPropertyType dest = bldg.createIntBuildingInstallationPropertyType();

		if (src.isSetIntBuildingInstallation())
			dest.setIntBuildingInstallation(bldg200.marshalIntBuildingInstallation(src.getIntBuildingInstallation()));
		
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

	public InteriorFurniturePropertyType marshalInteriorFurnitureProperty(InteriorFurnitureProperty src) {
		InteriorFurniturePropertyType dest = bldg.createInteriorFurniturePropertyType();

		if (src.isSetBuildingFurniture())
			dest.setBuildingFurniture(bldg200.marshalBuildingFurniture(src.getBuildingFurniture()));
		
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

	public InteriorRoomPropertyType marshalInteriorRoomProperty(InteriorRoomProperty src) {
		InteriorRoomPropertyType dest = bldg.createInteriorRoomPropertyType();

		if (src.isSetRoom())
			dest.setRoom(bldg200.marshalRoom(src.getRoom()));
		
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
	
	@SuppressWarnings("unchecked")
	public BoundarySurfacePropertyType marshalBoundarySurfaceProperty(BoundarySurfaceProperty src) {
		BoundarySurfacePropertyType dest = bldg.createBoundarySurfacePropertyType();

		if (src.isSetBoundarySurface()) {
			JAXBElement<?> elem = jaxb.marshalJAXBElement(src.getBoundarySurface());
			if (elem != null && elem.getValue() instanceof AbstractBoundarySurfaceType)
				dest.set_BoundarySurface((JAXBElement<? extends AbstractBoundarySurfaceType>)elem);
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
	*/
	
}
