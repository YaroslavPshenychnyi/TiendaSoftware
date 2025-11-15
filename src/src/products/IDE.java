package src.products;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.time.LocalDate;

public class IDE extends SoftwareProduct {
    private String supportedLanguage;
    private boolean supportPlugins;

    public IDE(Element node) throws ParserConfigurationException, IOException, SAXException {
        super((Element)node.getFirstChild());
        NodeList nodeList = node.getChildNodes();
        supportedLanguage = nodeList.item(1).getTextContent();
        supportPlugins = Boolean.parseBoolean(nodeList.item(2).getTextContent());
    }

    public IDE(String productName, String developer, LocalDate launchDate, String licence, double sizeMB, String description, String supportedlanguage, boolean supportPlugins) {
        super(productName, developer, launchDate, licence, sizeMB, description);
        this.supportedLanguage = supportedlanguage;
        this.supportPlugins = supportPlugins;
    }

    @Override
    public Element serialize(Document document) {
        Element superElement = super.serialize(document);
        Element ideElement = document.createElement("IDE");
        ideElement.appendChild(superElement);
        
        Element supportedLanguage = document.createElement("SupportedLanguage");
        supportedLanguage.appendChild(document.createTextNode(this.supportedLanguage));
        ideElement.appendChild(supportedLanguage);

        Element supportPlugins = document.createElement("SupportPlugins");
        supportPlugins.appendChild(document.createTextNode(this.supportPlugins ? "True" : "False"));
        ideElement.appendChild(supportPlugins);
        
        return ideElement;
    }
}
