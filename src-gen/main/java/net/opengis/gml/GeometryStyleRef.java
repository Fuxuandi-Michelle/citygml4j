//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.01.28 um 10:00:07 PM CET 
//


package net.opengis.gml;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

public class GeometryStyleRef
    extends JAXBElement<GeometryStylePropertyType>
{

    protected final static QName NAME = new QName("http://www.opengis.net/gml", "geometryStyle");

    public GeometryStyleRef(GeometryStylePropertyType value) {
        super(NAME, ((Class) GeometryStylePropertyType.class), null, value);
    }

    public GeometryStyleRef() {
        super(NAME, ((Class) GeometryStylePropertyType.class), null, null);
    }

}
