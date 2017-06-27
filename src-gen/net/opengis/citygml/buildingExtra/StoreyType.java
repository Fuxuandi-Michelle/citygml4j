//
// Generated with ade-xjc - XML Schema binding compiler for CityGML ADEs, version 2.4.3+1
// ade-xjc is part of the citygml4j project, see https://github.com/citygml4j
// Any modifications to this file will be lost upon recompilation of the source
// Generated: Tue Sep 05 18:08:52 PDT 2017
//


package net.opengis.citygml.buildingExtra;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlType;
import net.opengis.citygml._2.AbstractSiteType;
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
 * <p>Java class for StoreyType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StoreyType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.opengis.net/citygml/2.0}AbstractSiteType">
 *       &lt;sequence>
 *         &lt;element name="class" type="{http://www.opengis.net/gml}CodeType" minOccurs="0"/>
 *         &lt;element name="function" type="{http://www.opengis.net/gml}CodeType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="usage" type="{http://www.opengis.net/gml}CodeType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="measuredHeight" type="{http://www.opengis.net/gml}LengthType" minOccurs="0"/>
 *         &lt;element name="lod2Solid" type="{http://www.opengis.net/gml}SolidPropertyType" minOccurs="0"/>
 *         &lt;element name="lod2MultiSurface" type="{http://www.opengis.net/gml}MultiSurfacePropertyType" minOccurs="0"/>
 *         &lt;element name="lod2MultiCurve" type="{http://www.opengis.net/gml}MultiCurvePropertyType" minOccurs="0"/>
 *         &lt;element name="outerBuildingInstallation" type="{http://www.opengis.net/citygml/building/2.0}BuildingInstallationPropertyType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="interiorBuildingInstallation" type="{http://www.opengis.net/citygml/building/2.0}IntBuildingInstallationPropertyType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="lod3Solid" type="{http://www.opengis.net/gml}SolidPropertyType" minOccurs="0"/>
 *         &lt;element name="lod3MultiSurface" type="{http://www.opengis.net/gml}MultiSurfacePropertyType" minOccurs="0"/>
 *         &lt;element name="lod3MultiCurve" type="{http://www.opengis.net/gml}MultiCurvePropertyType" minOccurs="0"/>
 *         &lt;element name="lod4Solid" type="{http://www.opengis.net/gml}SolidPropertyType" minOccurs="0"/>
 *         &lt;element name="lod4MultiSurface" type="{http://www.opengis.net/gml}MultiSurfacePropertyType" minOccurs="0"/>
 *         &lt;element name="lod4MultiCurve" type="{http://www.opengis.net/gml}MultiCurvePropertyType" minOccurs="0"/>
 *         &lt;element name="interiorRoom" type="{http://www.opengis.net/citygml/building/2.0}InteriorRoomPropertyType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="interiorFurniture" type="{http://www.opengis.net/citygml/building/2.0}InteriorFurniturePropertyType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="boundedBy" type="{http://www.opengis.net/citygml/building/2.0}BoundarySurfacePropertyType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StoreyType", propOrder = {
	    "clazz",
	    "function",
	    "usage",	   
	    "measuredHeight",
	    "lod2Solid",
	    "lod2MultiSurface",
	    "lod2MultiCurve",
	    
	    "outerBuildingInstallation",
	    "interiorBuildingInstallation",
	    "boundedBySurface",
	    "lod3Solid",
	    "lod3MultiSurface",
	    "lod3MultiCurve",
	   
	    "lod4Solid",
	    "lod4MultiSurface",
	    "lod4MultiCurve",
	  
	    "interiorRoom",
	    "interiorFurniture"
})
public class StoreyType
    extends AbstractSiteType
{

	  	@XmlElement(name = "class")
	    protected CodeType clazz;
	    protected List<CodeType> function;
	    protected List<CodeType> usage;
	   

	    protected LengthType measuredHeight;
	   
	   
	    protected SolidPropertyType lod2Solid;
	    protected MultiSurfacePropertyType lod2MultiSurface;
	    protected MultiCurvePropertyType lod2MultiCurve;
	   
	    protected List<BuildingInstallationPropertyType> outerBuildingInstallation;
	    protected List<IntBuildingInstallationPropertyType> interiorBuildingInstallation;
	    @XmlElement(name = "boundedBy")
	    protected List<BoundarySurfacePropertyType> boundedBySurface;
	    protected SolidPropertyType lod3Solid;
	    protected MultiSurfacePropertyType lod3MultiSurface;
	    protected MultiCurvePropertyType lod3MultiCurve;
	   
	    protected SolidPropertyType lod4Solid;
	    protected MultiSurfacePropertyType lod4MultiSurface;
	    protected MultiCurvePropertyType lod4MultiCurve;
	    
	    protected List<InteriorRoomPropertyType> interiorRoom;
	    protected List<InteriorFurniturePropertyType> interiorFurniture;
	    /**
	     * Ruft den Wert der clazz-Eigenschaft ab.
	     * 
	     * @return
	     *     possible object is
	     *     {@link CodeType }
	     *     
	     */
	    public CodeType getClazz() {
	        return clazz;
	    }

	    /**
	     * Legt den Wert der clazz-Eigenschaft fest.
	     * 
	     * @param value
	     *     allowed object is
	     *     {@link CodeType }
	     *     
	     */
	    public void setClazz(CodeType value) {
	        this.clazz = value;
	    }

	    public boolean isSetClazz() {
	        return (this.clazz!= null);
	    }

	    /**
	     * Gets the value of the function property.
	     * 
	     * <p>
	     * This accessor method returns a reference to the live list,
	     * not a snapshot. Therefore any modification you make to the
	     * returned list will be present inside the JAXB object.
	     * This is why there is not a <CODE>set</CODE> method for the function property.
	     * 
	     * <p>
	     * For example, to add a new item, do as follows:
	     * <pre>
	     *    getFunction().add(newItem);
	     * </pre>
	     * 
	     * 
	     * <p>
	     * Objects of the following type(s) are allowed in the list
	     * {@link CodeType }
	     * 
	     * 
	     */
	    public List<CodeType> getFunction() {
	        if (function == null) {
	            function = new ArrayList<CodeType>();
	        }
	        return this.function;
	    }

	    public boolean isSetFunction() {
	        return ((this.function!= null)&&(!this.function.isEmpty()));
	    }

	    public void unsetFunction() {
	        this.function = null;
	    }

	    /**
	     * Gets the value of the usage property.
	     * 
	     * <p>
	     * This accessor method returns a reference to the live list,
	     * not a snapshot. Therefore any modification you make to the
	     * returned list will be present inside the JAXB object.
	     * This is why there is not a <CODE>set</CODE> method for the usage property.
	     * 
	     * <p>
	     * For example, to add a new item, do as follows:
	     * <pre>
	     *    getUsage().add(newItem);
	     * </pre>
	     * 
	     * 
	     * <p>
	     * Objects of the following type(s) are allowed in the list
	     * {@link CodeType }
	     * 
	     * 
	     */
	    public List<CodeType> getUsage() {
	        if (usage == null) {
	            usage = new ArrayList<CodeType>();
	        }
	        return this.usage;
	    }

	    public boolean isSetUsage() {
	        return ((this.usage!= null)&&(!this.usage.isEmpty()));
	    }

	    public void unsetUsage() {
	        this.usage = null;
	    }

	   
	   

	    /**
	     * Ruft den Wert der measuredHeight-Eigenschaft ab.
	     * 
	     * @return
	     *     possible object is
	     *     {@link LengthType }
	     *     
	     */
	    public LengthType getMeasuredHeight() {
	        return measuredHeight;
	    }

	    /**
	     * Legt den Wert der measuredHeight-Eigenschaft fest.
	     * 
	     * @param value
	     *     allowed object is
	     *     {@link LengthType }
	     *     
	     */
	    public void setMeasuredHeight(LengthType value) {
	        this.measuredHeight = value;
	    }

	    public boolean isSetMeasuredHeight() {
	        return (this.measuredHeight!= null);
	    }

	   
	   

	    /**
	     * Ruft den Wert der lod2Solid-Eigenschaft ab.
	     * 
	     * @return
	     *     possible object is
	     *     {@link SolidPropertyType }
	     *     
	     */
	    public SolidPropertyType getLod2Solid() {
	        return lod2Solid;
	    }

	    /**
	     * Legt den Wert der lod2Solid-Eigenschaft fest.
	     * 
	     * @param value
	     *     allowed object is
	     *     {@link SolidPropertyType }
	     *     
	     */
	    public void setLod2Solid(SolidPropertyType value) {
	        this.lod2Solid = value;
	    }

	    public boolean isSetLod2Solid() {
	        return (this.lod2Solid!= null);
	    }

	    /**
	     * Ruft den Wert der lod2MultiSurface-Eigenschaft ab.
	     * 
	     * @return
	     *     possible object is
	     *     {@link MultiSurfacePropertyType }
	     *     
	     */
	    public MultiSurfacePropertyType getLod2MultiSurface() {
	        return lod2MultiSurface;
	    }

	    /**
	     * Legt den Wert der lod2MultiSurface-Eigenschaft fest.
	     * 
	     * @param value
	     *     allowed object is
	     *     {@link MultiSurfacePropertyType }
	     *     
	     */
	    public void setLod2MultiSurface(MultiSurfacePropertyType value) {
	        this.lod2MultiSurface = value;
	    }

	    public boolean isSetLod2MultiSurface() {
	        return (this.lod2MultiSurface!= null);
	    }

	    /**
	     * Ruft den Wert der lod2MultiCurve-Eigenschaft ab.
	     * 
	     * @return
	     *     possible object is
	     *     {@link MultiCurvePropertyType }
	     *     
	     */
	    public MultiCurvePropertyType getLod2MultiCurve() {
	        return lod2MultiCurve;
	    }

	    /**
	     * Legt den Wert der lod2MultiCurve-Eigenschaft fest.
	     * 
	     * @param value
	     *     allowed object is
	     *     {@link MultiCurvePropertyType }
	     *     
	     */
	    public void setLod2MultiCurve(MultiCurvePropertyType value) {
	        this.lod2MultiCurve = value;
	    }

	    public boolean isSetLod2MultiCurve() {
	        return (this.lod2MultiCurve!= null);
	    }

	    /**
	     * Gets the value of the outerBuildingInstallation property.
	     * 
	     * <p>
	     * This accessor method returns a reference to the live list,
	     * not a snapshot. Therefore any modification you make to the
	     * returned list will be present inside the JAXB object.
	     * This is why there is not a <CODE>set</CODE> method for the outerBuildingInstallation property.
	     * 
	     * <p>
	     * For example, to add a new item, do as follows:
	     * <pre>
	     *    getOuterBuildingInstallation().add(newItem);
	     * </pre>
	     * 
	     * 
	     * <p>
	     * Objects of the following type(s) are allowed in the list
	     * {@link BuildingInstallationPropertyType }
	     * 
	     * 
	     */
	    public List<BuildingInstallationPropertyType> getOuterBuildingInstallation() {
	        if (outerBuildingInstallation == null) {
	            outerBuildingInstallation = new ArrayList<BuildingInstallationPropertyType>();
	        }
	        return this.outerBuildingInstallation;
	    }

	    public boolean isSetOuterBuildingInstallation() {
	        return ((this.outerBuildingInstallation!= null)&&(!this.outerBuildingInstallation.isEmpty()));
	    }

	    public void unsetOuterBuildingInstallation() {
	        this.outerBuildingInstallation = null;
	    }

	    /**
	     * Gets the value of the interiorBuildingInstallation property.
	     * 
	     * <p>
	     * This accessor method returns a reference to the live list,
	     * not a snapshot. Therefore any modification you make to the
	     * returned list will be present inside the JAXB object.
	     * This is why there is not a <CODE>set</CODE> method for the interiorBuildingInstallation property.
	     * 
	     * <p>
	     * For example, to add a new item, do as follows:
	     * <pre>
	     *    getInteriorBuildingInstallation().add(newItem);
	     * </pre>
	     * 
	     * 
	     * <p>
	     * Objects of the following type(s) are allowed in the list
	     * {@link IntBuildingInstallationPropertyType }
	     * 
	     * 
	     */
	    public List<IntBuildingInstallationPropertyType> getInteriorBuildingInstallation() {
	        if (interiorBuildingInstallation == null) {
	            interiorBuildingInstallation = new ArrayList<IntBuildingInstallationPropertyType>();
	        }
	        return this.interiorBuildingInstallation;
	    }

	    public boolean isSetInteriorBuildingInstallation() {
	        return ((this.interiorBuildingInstallation!= null)&&(!this.interiorBuildingInstallation.isEmpty()));
	    }

	    public void unsetInteriorBuildingInstallation() {
	        this.interiorBuildingInstallation = null;
	    }

	    /**
	     * Gets the value of the boundedBySurface property.
	     * 
	     * <p>
	     * This accessor method returns a reference to the live list,
	     * not a snapshot. Therefore any modification you make to the
	     * returned list will be present inside the JAXB object.
	     * This is why there is not a <CODE>set</CODE> method for the boundedBySurface property.
	     * 
	     * <p>
	     * For example, to add a new item, do as follows:
	     * <pre>
	     *    getBoundedBySurface().add(newItem);
	     * </pre>
	     * 
	     * 
	     * <p>
	     * Objects of the following type(s) are allowed in the list
	     * {@link BoundarySurfacePropertyType }
	     * 
	     * 
	     */
	    public List<BoundarySurfacePropertyType> getBoundedBySurface() {
	        if (boundedBySurface == null) {
	            boundedBySurface = new ArrayList<BoundarySurfacePropertyType>();
	        }
	        return this.boundedBySurface;
	    }

	    public boolean isSetBoundedBySurface() {
	        return ((this.boundedBySurface!= null)&&(!this.boundedBySurface.isEmpty()));
	    }

	    public void unsetBoundedBySurface() {
	        this.boundedBySurface = null;
	    }

	    /**
	     * Ruft den Wert der lod3Solid-Eigenschaft ab.
	     * 
	     * @return
	     *     possible object is
	     *     {@link SolidPropertyType }
	     *     
	     */
	    public SolidPropertyType getLod3Solid() {
	        return lod3Solid;
	    }

	    /**
	     * Legt den Wert der lod3Solid-Eigenschaft fest.
	     * 
	     * @param value
	     *     allowed object is
	     *     {@link SolidPropertyType }
	     *     
	     */
	    public void setLod3Solid(SolidPropertyType value) {
	        this.lod3Solid = value;
	    }

	    public boolean isSetLod3Solid() {
	        return (this.lod3Solid!= null);
	    }

	    /**
	     * Ruft den Wert der lod3MultiSurface-Eigenschaft ab.
	     * 
	     * @return
	     *     possible object is
	     *     {@link MultiSurfacePropertyType }
	     *     
	     */
	    public MultiSurfacePropertyType getLod3MultiSurface() {
	        return lod3MultiSurface;
	    }

	    /**
	     * Legt den Wert der lod3MultiSurface-Eigenschaft fest.
	     * 
	     * @param value
	     *     allowed object is
	     *     {@link MultiSurfacePropertyType }
	     *     
	     */
	    public void setLod3MultiSurface(MultiSurfacePropertyType value) {
	        this.lod3MultiSurface = value;
	    }

	    public boolean isSetLod3MultiSurface() {
	        return (this.lod3MultiSurface!= null);
	    }

	    /**
	     * Ruft den Wert der lod3MultiCurve-Eigenschaft ab.
	     * 
	     * @return
	     *     possible object is
	     *     {@link MultiCurvePropertyType }
	     *     
	     */
	    public MultiCurvePropertyType getLod3MultiCurve() {
	        return lod3MultiCurve;
	    }

	    /**
	     * Legt den Wert der lod3MultiCurve-Eigenschaft fest.
	     * 
	     * @param value
	     *     allowed object is
	     *     {@link MultiCurvePropertyType }
	     *     
	     */
	    public void setLod3MultiCurve(MultiCurvePropertyType value) {
	        this.lod3MultiCurve = value;
	    }

	    public boolean isSetLod3MultiCurve() {
	        return (this.lod3MultiCurve!= null);
	    }

	   

	    /**
	     * Ruft den Wert der lod4Solid-Eigenschaft ab.
	     * 
	     * @return
	     *     possible object is
	     *     {@link SolidPropertyType }
	     *     
	     */
	    public SolidPropertyType getLod4Solid() {
	        return lod4Solid;
	    }

	    /**
	     * Legt den Wert der lod4Solid-Eigenschaft fest.
	     * 
	     * @param value
	     *     allowed object is
	     *     {@link SolidPropertyType }
	     *     
	     */
	    public void setLod4Solid(SolidPropertyType value) {
	        this.lod4Solid = value;
	    }

	    public boolean isSetLod4Solid() {
	        return (this.lod4Solid!= null);
	    }

	    /**
	     * Ruft den Wert der lod4MultiSurface-Eigenschaft ab.
	     * 
	     * @return
	     *     possible object is
	     *     {@link MultiSurfacePropertyType }
	     *     
	     */
	    public MultiSurfacePropertyType getLod4MultiSurface() {
	        return lod4MultiSurface;
	    }

	    /**
	     * Legt den Wert der lod4MultiSurface-Eigenschaft fest.
	     * 
	     * @param value
	     *     allowed object is
	     *     {@link MultiSurfacePropertyType }
	     *     
	     */
	    public void setLod4MultiSurface(MultiSurfacePropertyType value) {
	        this.lod4MultiSurface = value;
	    }

	    public boolean isSetLod4MultiSurface() {
	        return (this.lod4MultiSurface!= null);
	    }

	    /**
	     * Ruft den Wert der lod4MultiCurve-Eigenschaft ab.
	     * 
	     * @return
	     *     possible object is
	     *     {@link MultiCurvePropertyType }
	     *     
	     */
	    public MultiCurvePropertyType getLod4MultiCurve() {
	        return lod4MultiCurve;
	    }

	    /**
	     * Legt den Wert der lod4MultiCurve-Eigenschaft fest.
	     * 
	     * @param value
	     *     allowed object is
	     *     {@link MultiCurvePropertyType }
	     *     
	     */
	    public void setLod4MultiCurve(MultiCurvePropertyType value) {
	        this.lod4MultiCurve = value;
	    }

	    public boolean isSetLod4MultiCurve() {
	        return (this.lod4MultiCurve!= null);
	    }

	    /**
	     * Gets the value of the interiorRoom property.
	     * 
	     * <p>
	     * This accessor method returns a reference to the live list,
	     * not a snapshot. Therefore any modification you make to the
	     * returned list will be present inside the JAXB object.
	     * This is why there is not a <CODE>set</CODE> method for the interiorRoom property.
	     * 
	     * <p>
	     * For example, to add a new item, do as follows:
	     * <pre>
	     *    getInteriorRoom().add(newItem);
	     * </pre>
	     * 
	     * 
	     * <p>
	     * Objects of the following type(s) are allowed in the list
	     * {@link InteriorRoomPropertyType }
	     * 
	     * 
	     */
	    public List<InteriorRoomPropertyType> getInteriorRoom() {
	        if (interiorRoom == null) {
	            interiorRoom = new ArrayList<InteriorRoomPropertyType>();
	        }
	        return this.interiorRoom;
	    }

	    public boolean isSetInteriorRoom() {
	        return ((this.interiorRoom!= null)&&(!this.interiorRoom.isEmpty()));
	    }

	    public void unsetInteriorRoom() {
	        this.interiorRoom = null;
	    }

	    //=============interior furniture==========================================================//
		   
	    /**
	     * Gets the value of the interiorFurniture property.
	     * 
	     * <p>
	     * This accessor method returns a reference to the live list,
	     * not a snapshot. Therefore any modification you make to the
	     * returned list will be present inside the JAXB object.
	     * This is why there is not a <CODE>set</CODE> method for the interiorFurniture property.
	     * 
	     * <p>
	     * For example, to add a new item, do as follows:
	     * <pre>
	     *    getInteriorFurniture().add(newItem);
	     * </pre>
	     * 
	     * 
	     * <p>
	     * Objects of the following type(s) are allowed in the list
	     * {@link InteriorFurniturePropertyType }
	     * 
	     * 
	     */
	    public List<InteriorFurniturePropertyType> getInteriorFurniture() {
	        if (interiorFurniture == null) {
	            interiorFurniture = new ArrayList<InteriorFurniturePropertyType>();
	        }
	        return this.interiorFurniture;
	    }

	    public boolean isSetInteriorFurniture() {
	        return ((this.interiorFurniture!= null)&&(!this.interiorFurniture.isEmpty()));
	    }

	    public void unsetInteriorFurniture() {
	        this.interiorFurniture = null;
	    }

	    /**
	     * Gets the value of the genericApplicationPropertyOfAbstractBuilding property.
	     * 
	     * <p>
	     * This accessor method returns a reference to the live list,
	     * not a snapshot. Therefore any modification you make to the
	     * returned list will be present inside the JAXB object.
	     * This is why there is not a <CODE>set</CODE> method for the genericApplicationPropertyOfAbstractBuilding property.
	     * 
	     * <p>
	     * For example, to add a new item, do as follows:
	     * <pre>
	     *    get_GenericApplicationPropertyOfAbstractBuilding().add(newItem);
	     * </pre>
	     * 
	     * 
	     * <p>
	     * Objects of the following type(s) are allowed in the list
	     * {@link JAXBElement }{@code <}{@link Object }{@code >}
	     * {@link JAXBElement }{@code <}{@link Object }{@code >}
	     * 
	     * 
	     */
	   
	    public void setFunction(List<CodeType> value) {
	        this.function = value;
	    }

	    public void setUsage(List<CodeType> value) {
	        this.usage = value;
	    }

	    public void setOuterBuildingInstallation(List<BuildingInstallationPropertyType> value) {
	        this.outerBuildingInstallation = value;
	    }

	    public void setInteriorBuildingInstallation(List<IntBuildingInstallationPropertyType> value) {
	        this.interiorBuildingInstallation = value;
	    }

	    public void setBoundedBySurface(List<BoundarySurfacePropertyType> value) {
	        this.boundedBySurface = value;
	    }

	    public void setInteriorRoom(List<InteriorRoomPropertyType> value) {
	        this.interiorRoom = value;
	    }
	    
	    public void setInteriorFurniture(List<InteriorFurniturePropertyType> value) {
	        this.interiorFurniture = value;
	    }
	  
	   
	}
