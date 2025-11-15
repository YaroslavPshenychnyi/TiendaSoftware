package src.products;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.time.LocalDate;

public class Framework extends SoftwareProduct {
    private String supportLanguage;
    private String currentVersion;

    public Framework(String productName, String developer, LocalDate launchDate, String licence, double sizeMB, String description, String supportLanguage, String currentVersion) {
        super(productName, developer, launchDate, licence, sizeMB, description);
        this.supportLanguage = supportLanguage;
        this.currentVersion = currentVersion;
    }

    public Framework(Element node) throws ParserConfigurationException, IOException, SAXException {
        super((Element)node.getFirstChild());
        supportLanguage = node.getChildNodes().item(1).getTextContent();
        currentVersion = node.getChildNodes().item(2).getTextContent();
    }

    @Override
    public Element serialize(Document document) {
        Element superElement = super.serialize(document);
        Element frameworkElement = document.createElement("Framework");
        frameworkElement.appendChild(superElement);

        Element supportLanguageElement = document.createElement("SupportLanguage");
        supportLanguageElement.appendChild(document.createTextNode(this.supportLanguage));
        frameworkElement.appendChild(supportLanguageElement);

        Element currentVersionElement = document.createElement("CurrentVersion");
        currentVersionElement.appendChild(document.createTextNode(this.currentVersion));
        frameworkElement.appendChild(currentVersionElement);

        return frameworkElement;
    }
}
