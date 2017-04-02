//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2017.03.28 um 08:23:51 PM CEST 
//


package net.opengis.gml;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * This type supports embedding an array of topological primitives in a TopoComplex
 * 
 * <p>Java-Klasse für TopoPrimitiveArrayAssociationType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="TopoPrimitiveArrayAssociationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice maxOccurs="unbounded" minOccurs="0">
 *           &lt;element ref="{http://www.opengis.net/gml}_TopoPrimitive"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TopoPrimitiveArrayAssociationType", propOrder = {
    "_TopoPrimitive"
})
public class TopoPrimitiveArrayAssociationType {

    @XmlElementRef(name = "_TopoPrimitive", namespace = "http://www.opengis.net/gml", type = JAXBElement.class, required = false)
    protected List<JAXBElement<? extends AbstractTopoPrimitiveType>> _TopoPrimitive;

    /**
     * Gets the value of the topoPrimitive property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the topoPrimitive property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    get_TopoPrimitive().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link EdgeType }{@code >}
     * {@link JAXBElement }{@code <}{@link FaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractTopoPrimitiveType }{@code >}
     * {@link JAXBElement }{@code <}{@link NodeType }{@code >}
     * {@link JAXBElement }{@code <}{@link TopoSolidType }{@code >}
     * 
     * 
     */
    public List<JAXBElement<? extends AbstractTopoPrimitiveType>> get_TopoPrimitive() {
        if (_TopoPrimitive == null) {
            _TopoPrimitive = new ArrayList<JAXBElement<? extends AbstractTopoPrimitiveType>>();
        }
        return this._TopoPrimitive;
    }

    public boolean isSet_TopoPrimitive() {
        return ((this._TopoPrimitive!= null)&&(!this._TopoPrimitive.isEmpty()));
    }

    public void unset_TopoPrimitive() {
        this._TopoPrimitive = null;
    }

    public void set_TopoPrimitive(List<JAXBElement<? extends AbstractTopoPrimitiveType>> value) {
        this._TopoPrimitive = value;
    }

}
