package src;

import org.w3c.dom.Element;
import org.xml.sax.SAXException;
import src.products.SoftwareProduct;


import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public interface ObjectReadMethod {
    public SoftwareProduct deserialize(Element node) throws ParserConfigurationException, IOException, SAXException;
}
