//
// Generated with ade-xjc - XML Schema binding compiler for CityGML ADEs, version 2.4.3+1
// ade-xjc is part of the citygml4j project, see https://github.com/citygml4j
// Any modifications to this file will be lost upon recompilation of the source
// Generated: Thu Oct 12 16:10:47 CST 2017
//


package net.opengis.citygml.buildingExtra;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import net.opengis.citygml.building._2.BoundarySurfacePropertyType;
import net.opengis.citygml.building._2.BuildingInstallationPropertyType;
import net.opengis.citygml.building._2.IntBuildingInstallationPropertyType;
import net.opengis.citygml.building._2.InteriorFurniturePropertyType;
import net.opengis.citygml.building._2.InteriorRoomPropertyType;
import net.opengis.gml.CodeType;
import net.opengis.gml.LengthType;
import net.opengis.gml.MultiCurvePropertyType;
import net.opengis.gml.MultiSurfacePropertyType;
import net.opengis.gml.SolidPropertyType;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ade.sub.jaxb package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _FlowTerminal_QNAME = new QName("http://www.citygml.org/ade/buildingExtra", "FlowTerminal");
    private final static QName _Height_QNAME = new QName("http://www.citygml.org/ade/buildingExtra", "Height");
    private final static QName _BaseLevel_QNAME = new QName("http://www.citygml.org/ade/buildingExtra", "baseLevel");
    private final static QName _PodiumID_QNAME = new QName("http://www.citygml.org/ade/buildingExtra", "podiumID");
    private final static QName _RoofLevel_QNAME = new QName("http://www.citygml.org/ade/buildingExtra", "roofLevel");
    private final static QName _Slab_QNAME = new QName("http://www.citygml.org/ade/buildingExtra", "Slab");
    private final static QName _StairFlight_QNAME = new QName("http://www.citygml.org/ade/buildingExtra", "StairFlight");
    private final static QName _Railing_QNAME = new QName("http://www.citygml.org/ade/buildingExtra", "Railing");
    private final static QName _Column_QNAME = new QName("http://www.citygml.org/ade/buildingExtra", "Column");
    private final static QName _Beam_QNAME = new QName("http://www.citygml.org/ade/buildingExtra", "Beam");
    private final static QName _Stair_QNAME = new QName("http://www.citygml.org/ade/buildingExtra", "Stair");
    private final static QName _Podium_QNAME = new QName("http://www.citygml.org/ade/buildingExtra", "Podium");
    private final static QName _Covering_QNAME = new QName("http://www.citygml.org/ade/buildingExtra", "Covering");
    private final static QName _RampFlight_QNAME = new QName("http://www.citygml.org/ade/buildingExtra", "RampFlight");
    private final static QName _Width_QNAME = new QName("http://www.citygml.org/ade/buildingExtra", "Width");
    private final static QName _Ramp_QNAME = new QName("http://www.citygml.org/ade/buildingExtra", "Ramp");
    private final static QName _Storey_QNAME = new QName("http://www.citygml.org/ade/buildingExtra", "Storey");
    private final static QName _ContainStorey_QNAME = new QName("http://www.citygml.org/ade/buildingExtra", "containStorey");
    private final static QName _StoreyTypeLod4Solid_QNAME = new QName("http://www.citygml.org/ade/buildingExtra", "lod4Solid");
    private final static QName _StoreyTypeLod3Solid_QNAME = new QName("http://www.citygml.org/ade/buildingExtra", "lod3Solid");
    private final static QName _StoreyTypeUsage_QNAME = new QName("http://www.citygml.org/ade/buildingExtra", "usage");
    private final static QName _StoreyTypeOuterBuildingInstallation_QNAME = new QName("http://www.citygml.org/ade/buildingExtra", "outerBuildingInstallation");
    private final static QName _StoreyTypeBoundedBy_QNAME = new QName("http://www.citygml.org/ade/buildingExtra", "boundedBy");
    private final static QName _StoreyTypeClass_QNAME = new QName("http://www.citygml.org/ade/buildingExtra", "class");
    private final static QName _StoreyTypeLod3MultiSurface_QNAME = new QName("http://www.citygml.org/ade/buildingExtra", "lod3MultiSurface");
    private final static QName _StoreyTypeInteriorRoom_QNAME = new QName("http://www.citygml.org/ade/buildingExtra", "interiorRoom");
    private final static QName _StoreyTypeLod4MultiSurface_QNAME = new QName("http://www.citygml.org/ade/buildingExtra", "lod4MultiSurface");
    private final static QName _StoreyTypeMeasuredHeight_QNAME = new QName("http://www.citygml.org/ade/buildingExtra", "measuredHeight");
    private final static QName _StoreyTypeLod2MultiCurve_QNAME = new QName("http://www.citygml.org/ade/buildingExtra", "lod2MultiCurve");
    private final static QName _StoreyTypeLod4MultiCurve_QNAME = new QName("http://www.citygml.org/ade/buildingExtra", "lod4MultiCurve");
    private final static QName _StoreyTypeFunction_QNAME = new QName("http://www.citygml.org/ade/buildingExtra", "function");
    private final static QName _StoreyTypeInteriorBuildingInstallation_QNAME = new QName("http://www.citygml.org/ade/buildingExtra", "interiorBuildingInstallation");
    private final static QName _StoreyTypeInteriorFurniture_QNAME = new QName("http://www.citygml.org/ade/buildingExtra", "interiorFurniture");
    private final static QName _StoreyTypeLod3MultiCurve_QNAME = new QName("http://www.citygml.org/ade/buildingExtra", "lod3MultiCurve");
    private final static QName _StoreyTypeLod2Solid_QNAME = new QName("http://www.citygml.org/ade/buildingExtra", "lod2Solid");
    private final static QName _StoreyTypeLod2MultiSurface_QNAME = new QName("http://www.citygml.org/ade/buildingExtra", "lod2MultiSurface");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ade.sub.jaxb
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link StoreyType }
     * 
     */
    public StoreyType createStoreyType() {
        return new StoreyType();
    }

    /**
     * Create an instance of {@link StoreyPropertyType }
     * 
     */
    public StoreyPropertyType createStoreyPropertyType() {
        return new StoreyPropertyType();
    }

    /**
     * Create an instance of {@link FlowTerminalType }
     * 
     */
    public FlowTerminalType createFlowTerminalType() {
        return new FlowTerminalType();
    }

    /**
     * Create an instance of {@link RampFlightType }
     * 
     */
    public RampFlightType createRampFlightType() {
        return new RampFlightType();
    }

    /**
     * Create an instance of {@link CoveringType }
     * 
     */
    public CoveringType createCoveringType() {
        return new CoveringType();
    }

    /**
     * Create an instance of {@link StairFlightType }
     * 
     */
    public StairFlightType createStairFlightType() {
        return new StairFlightType();
    }

    /**
     * Create an instance of {@link StairType }
     * 
     */
    public StairType createStairType() {
        return new StairType();
    }

    /**
     * Create an instance of {@link RailingType }
     * 
     */
    public RailingType createRailingType() {
        return new RailingType();
    }

    /**
     * Create an instance of {@link BeamType }
     * 
     */
    public BeamType createBeamType() {
        return new BeamType();
    }

    /**
     * Create an instance of {@link PodiumType }
     * 
     */
    public PodiumType createPodiumType() {
        return new PodiumType();
    }

    /**
     * Create an instance of {@link RampType }
     * 
     */
    public RampType createRampType() {
        return new RampType();
    }

    /**
     * Create an instance of {@link ColumnType }
     * 
     */
    public ColumnType createColumnType() {
        return new ColumnType();
    }

    /**
     * Create an instance of {@link SlabType }
     * 
     */
    public SlabType createSlabType() {
        return new SlabType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FlowTerminalType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.citygml.org/ade/buildingExtra", name = "FlowTerminal", substitutionHeadNamespace = "http://www.opengis.net/citygml/building/2.0", substitutionHeadName = "BuildingInstallation")
    public JAXBElement<FlowTerminalType> createFlowTerminal(FlowTerminalType value) {
        return new JAXBElement<FlowTerminalType>(_FlowTerminal_QNAME, FlowTerminalType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LengthType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.citygml.org/ade/buildingExtra", name = "Height", substitutionHeadNamespace = "http://www.opengis.net/citygml/building/2.0", substitutionHeadName = "_GenericApplicationPropertyOfOpening")
    public JAXBElement<LengthType> createHeight(LengthType value) {
        return new JAXBElement<LengthType>(_Height_QNAME, LengthType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LengthType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.citygml.org/ade/buildingExtra", name = "baseLevel", substitutionHeadNamespace = "http://www.opengis.net/citygml/building/2.0", substitutionHeadName = "_GenericApplicationPropertyOfAbstractBuilding")
    public JAXBElement<LengthType> createBaseLevel(LengthType value) {
        return new JAXBElement<LengthType>(_BaseLevel_QNAME, LengthType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.citygml.org/ade/buildingExtra", name = "podiumID", substitutionHeadNamespace = "http://www.opengis.net/citygml/building/2.0", substitutionHeadName = "_GenericApplicationPropertyOfAbstractBuilding")
    public JAXBElement<String> createPodiumID(String value) {
        return new JAXBElement<String>(_PodiumID_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LengthType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.citygml.org/ade/buildingExtra", name = "roofLevel", substitutionHeadNamespace = "http://www.opengis.net/citygml/building/2.0", substitutionHeadName = "_GenericApplicationPropertyOfAbstractBuilding")
    public JAXBElement<LengthType> createRoofLevel(LengthType value) {
        return new JAXBElement<LengthType>(_RoofLevel_QNAME, LengthType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SlabType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.citygml.org/ade/buildingExtra", name = "Slab", substitutionHeadNamespace = "http://www.opengis.net/citygml/building/2.0", substitutionHeadName = "BuildingInstallation")
    public JAXBElement<SlabType> createSlab(SlabType value) {
        return new JAXBElement<SlabType>(_Slab_QNAME, SlabType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StairFlightType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.citygml.org/ade/buildingExtra", name = "StairFlight", substitutionHeadNamespace = "http://www.opengis.net/citygml/building/2.0", substitutionHeadName = "BuildingInstallation")
    public JAXBElement<StairFlightType> createStairFlight(StairFlightType value) {
        return new JAXBElement<StairFlightType>(_StairFlight_QNAME, StairFlightType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RailingType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.citygml.org/ade/buildingExtra", name = "Railing", substitutionHeadNamespace = "http://www.opengis.net/citygml/building/2.0", substitutionHeadName = "BuildingInstallation")
    public JAXBElement<RailingType> createRailing(RailingType value) {
        return new JAXBElement<RailingType>(_Railing_QNAME, RailingType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ColumnType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.citygml.org/ade/buildingExtra", name = "Column", substitutionHeadNamespace = "http://www.opengis.net/citygml/building/2.0", substitutionHeadName = "BuildingInstallation")
    public JAXBElement<ColumnType> createColumn(ColumnType value) {
        return new JAXBElement<ColumnType>(_Column_QNAME, ColumnType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BeamType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.citygml.org/ade/buildingExtra", name = "Beam", substitutionHeadNamespace = "http://www.opengis.net/citygml/building/2.0", substitutionHeadName = "BuildingInstallation")
    public JAXBElement<BeamType> createBeam(BeamType value) {
        return new JAXBElement<BeamType>(_Beam_QNAME, BeamType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StairType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.citygml.org/ade/buildingExtra", name = "Stair", substitutionHeadNamespace = "http://www.opengis.net/citygml/building/2.0", substitutionHeadName = "BuildingInstallation")
    public JAXBElement<StairType> createStair(StairType value) {
        return new JAXBElement<StairType>(_Stair_QNAME, StairType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PodiumType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.citygml.org/ade/buildingExtra", name = "Podium", substitutionHeadNamespace = "http://www.opengis.net/citygml/building/2.0", substitutionHeadName = "_AbstractBuilding")
    public JAXBElement<PodiumType> createPodium(PodiumType value) {
        return new JAXBElement<PodiumType>(_Podium_QNAME, PodiumType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CoveringType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.citygml.org/ade/buildingExtra", name = "Covering", substitutionHeadNamespace = "http://www.opengis.net/citygml/building/2.0", substitutionHeadName = "BuildingInstallation")
    public JAXBElement<CoveringType> createCovering(CoveringType value) {
        return new JAXBElement<CoveringType>(_Covering_QNAME, CoveringType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RampFlightType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.citygml.org/ade/buildingExtra", name = "RampFlight", substitutionHeadNamespace = "http://www.opengis.net/citygml/building/2.0", substitutionHeadName = "BuildingInstallation")
    public JAXBElement<RampFlightType> createRampFlight(RampFlightType value) {
        return new JAXBElement<RampFlightType>(_RampFlight_QNAME, RampFlightType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LengthType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.citygml.org/ade/buildingExtra", name = "Width", substitutionHeadNamespace = "http://www.opengis.net/citygml/building/2.0", substitutionHeadName = "_GenericApplicationPropertyOfOpening")
    public JAXBElement<LengthType> createWidth(LengthType value) {
        return new JAXBElement<LengthType>(_Width_QNAME, LengthType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RampType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.citygml.org/ade/buildingExtra", name = "Ramp", substitutionHeadNamespace = "http://www.opengis.net/citygml/building/2.0", substitutionHeadName = "BuildingInstallation")
    public JAXBElement<RampType> createRamp(RampType value) {
        return new JAXBElement<RampType>(_Ramp_QNAME, RampType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StoreyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.citygml.org/ade/buildingExtra", name = "Storey", substitutionHeadNamespace = "http://www.opengis.net/citygml/2.0", substitutionHeadName = "_Site")
    public JAXBElement<StoreyType> createStorey(StoreyType value) {
        return new JAXBElement<StoreyType>(_Storey_QNAME, StoreyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StoreyPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.citygml.org/ade/buildingExtra", name = "containStorey", substitutionHeadNamespace = "http://www.opengis.net/citygml/building/2.0", substitutionHeadName = "_GenericApplicationPropertyOfAbstractBuilding")
    public JAXBElement<StoreyPropertyType> createContainStorey(StoreyPropertyType value) {
        return new JAXBElement<StoreyPropertyType>(_ContainStorey_QNAME, StoreyPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SolidPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.citygml.org/ade/buildingExtra", name = "lod4Solid", scope = StoreyType.class)
    public JAXBElement<SolidPropertyType> createStoreyTypeLod4Solid(SolidPropertyType value) {
        return new JAXBElement<SolidPropertyType>(_StoreyTypeLod4Solid_QNAME, SolidPropertyType.class, StoreyType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SolidPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.citygml.org/ade/buildingExtra", name = "lod3Solid", scope = StoreyType.class)
    public JAXBElement<SolidPropertyType> createStoreyTypeLod3Solid(SolidPropertyType value) {
        return new JAXBElement<SolidPropertyType>(_StoreyTypeLod3Solid_QNAME, SolidPropertyType.class, StoreyType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CodeType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.citygml.org/ade/buildingExtra", name = "usage", scope = StoreyType.class)
    public JAXBElement<CodeType> createStoreyTypeUsage(CodeType value) {
        return new JAXBElement<CodeType>(_StoreyTypeUsage_QNAME, CodeType.class, StoreyType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuildingInstallationPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.citygml.org/ade/buildingExtra", name = "outerBuildingInstallation", scope = StoreyType.class)
    public JAXBElement<BuildingInstallationPropertyType> createStoreyTypeOuterBuildingInstallation(BuildingInstallationPropertyType value) {
        return new JAXBElement<BuildingInstallationPropertyType>(_StoreyTypeOuterBuildingInstallation_QNAME, BuildingInstallationPropertyType.class, StoreyType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BoundarySurfacePropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.citygml.org/ade/buildingExtra", name = "boundedBy", scope = StoreyType.class)
    public JAXBElement<BoundarySurfacePropertyType> createStoreyTypeBoundedBy(BoundarySurfacePropertyType value) {
        return new JAXBElement<BoundarySurfacePropertyType>(_StoreyTypeBoundedBy_QNAME, BoundarySurfacePropertyType.class, StoreyType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CodeType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.citygml.org/ade/buildingExtra", name = "class", scope = StoreyType.class)
    public JAXBElement<CodeType> createStoreyTypeClass(CodeType value) {
        return new JAXBElement<CodeType>(_StoreyTypeClass_QNAME, CodeType.class, StoreyType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MultiSurfacePropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.citygml.org/ade/buildingExtra", name = "lod3MultiSurface", scope = StoreyType.class)
    public JAXBElement<MultiSurfacePropertyType> createStoreyTypeLod3MultiSurface(MultiSurfacePropertyType value) {
        return new JAXBElement<MultiSurfacePropertyType>(_StoreyTypeLod3MultiSurface_QNAME, MultiSurfacePropertyType.class, StoreyType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InteriorRoomPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.citygml.org/ade/buildingExtra", name = "interiorRoom", scope = StoreyType.class)
    public JAXBElement<InteriorRoomPropertyType> createStoreyTypeInteriorRoom(InteriorRoomPropertyType value) {
        return new JAXBElement<InteriorRoomPropertyType>(_StoreyTypeInteriorRoom_QNAME, InteriorRoomPropertyType.class, StoreyType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MultiSurfacePropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.citygml.org/ade/buildingExtra", name = "lod4MultiSurface", scope = StoreyType.class)
    public JAXBElement<MultiSurfacePropertyType> createStoreyTypeLod4MultiSurface(MultiSurfacePropertyType value) {
        return new JAXBElement<MultiSurfacePropertyType>(_StoreyTypeLod4MultiSurface_QNAME, MultiSurfacePropertyType.class, StoreyType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LengthType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.citygml.org/ade/buildingExtra", name = "measuredHeight", scope = StoreyType.class)
    public JAXBElement<LengthType> createStoreyTypeMeasuredHeight(LengthType value) {
        return new JAXBElement<LengthType>(_StoreyTypeMeasuredHeight_QNAME, LengthType.class, StoreyType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MultiCurvePropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.citygml.org/ade/buildingExtra", name = "lod2MultiCurve", scope = StoreyType.class)
    public JAXBElement<MultiCurvePropertyType> createStoreyTypeLod2MultiCurve(MultiCurvePropertyType value) {
        return new JAXBElement<MultiCurvePropertyType>(_StoreyTypeLod2MultiCurve_QNAME, MultiCurvePropertyType.class, StoreyType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MultiCurvePropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.citygml.org/ade/buildingExtra", name = "lod4MultiCurve", scope = StoreyType.class)
    public JAXBElement<MultiCurvePropertyType> createStoreyTypeLod4MultiCurve(MultiCurvePropertyType value) {
        return new JAXBElement<MultiCurvePropertyType>(_StoreyTypeLod4MultiCurve_QNAME, MultiCurvePropertyType.class, StoreyType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CodeType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.citygml.org/ade/buildingExtra", name = "function", scope = StoreyType.class)
    public JAXBElement<CodeType> createStoreyTypeFunction(CodeType value) {
        return new JAXBElement<CodeType>(_StoreyTypeFunction_QNAME, CodeType.class, StoreyType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IntBuildingInstallationPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.citygml.org/ade/buildingExtra", name = "interiorBuildingInstallation", scope = StoreyType.class)
    public JAXBElement<IntBuildingInstallationPropertyType> createStoreyTypeInteriorBuildingInstallation(IntBuildingInstallationPropertyType value) {
        return new JAXBElement<IntBuildingInstallationPropertyType>(_StoreyTypeInteriorBuildingInstallation_QNAME, IntBuildingInstallationPropertyType.class, StoreyType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InteriorFurniturePropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.citygml.org/ade/buildingExtra", name = "interiorFurniture", scope = StoreyType.class)
    public JAXBElement<InteriorFurniturePropertyType> createStoreyTypeInteriorFurniture(InteriorFurniturePropertyType value) {
        return new JAXBElement<InteriorFurniturePropertyType>(_StoreyTypeInteriorFurniture_QNAME, InteriorFurniturePropertyType.class, StoreyType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MultiCurvePropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.citygml.org/ade/buildingExtra", name = "lod3MultiCurve", scope = StoreyType.class)
    public JAXBElement<MultiCurvePropertyType> createStoreyTypeLod3MultiCurve(MultiCurvePropertyType value) {
        return new JAXBElement<MultiCurvePropertyType>(_StoreyTypeLod3MultiCurve_QNAME, MultiCurvePropertyType.class, StoreyType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SolidPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.citygml.org/ade/buildingExtra", name = "lod2Solid", scope = StoreyType.class)
    public JAXBElement<SolidPropertyType> createStoreyTypeLod2Solid(SolidPropertyType value) {
        return new JAXBElement<SolidPropertyType>(_StoreyTypeLod2Solid_QNAME, SolidPropertyType.class, StoreyType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MultiSurfacePropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.citygml.org/ade/buildingExtra", name = "lod2MultiSurface", scope = StoreyType.class)
    public JAXBElement<MultiSurfacePropertyType> createStoreyTypeLod2MultiSurface(MultiSurfacePropertyType value) {
        return new JAXBElement<MultiSurfacePropertyType>(_StoreyTypeLod2MultiSurface_QNAME, MultiSurfacePropertyType.class, StoreyType.class, value);
    }

}
