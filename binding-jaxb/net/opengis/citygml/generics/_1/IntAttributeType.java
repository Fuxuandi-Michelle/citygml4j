//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2017.03.28 um 08:23:51 PM CEST 
//


package net.opengis.citygml.generics._1;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für IntAttributeType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="IntAttributeType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.opengis.net/citygml/generics/1.0}AbstractGenericAttributeType">
 *       &lt;sequence>
 *         &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IntAttributeType", propOrder = {
    "value"
})
public class IntAttributeType
    extends AbstractGenericAttributeType
{

    @XmlElement(required = true)
    protected BigInteger value;

    /**
     * Ruft den Wert der value-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getValue() {
        return value;
    }

    /**
     * Legt den Wert der value-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setValue(BigInteger value) {
        this.value = value;
    }

    public boolean isSetValue() {
        return (this.value!= null);
    }

}
