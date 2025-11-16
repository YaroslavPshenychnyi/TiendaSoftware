package src.products;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.time.LocalDate;

public class DevOpsTool extends SoftwareProduct {
    private String categoria;
    private boolean cloudBased;

    public DevOpsTool(String productName, String developer, LocalDate launchDate, String licence, double sizeMB, String description, String categoria, boolean cloudBased) {
        super(productName, developer, launchDate, licence, sizeMB, description);
        this.categoria = categoria;
        this.cloudBased = cloudBased;
    }

    public DevOpsTool(Element node) throws ParserConfigurationException, IOException, SAXException {
        super((Element)node.getFirstChild());
        categoria = node.getChildNodes().item(1).getTextContent();
        cloudBased = Boolean.parseBoolean(node.getChildNodes().item(2).getTextContent());
    }

    @Override
    public Element serialize(Document document) {
        Element superElement = super.serialize(document);
        Element devopsElement = document.createElement("DevOpsTool");
        devopsElement.appendChild(superElement);

        Element categoriaElement = document.createElement("Category");
        categoriaElement.appendChild(document.createTextNode(this.categoria));
        devopsElement.appendChild(categoriaElement);

        Element cloudBasedElement = document.createElement("CloudBased");
        cloudBasedElement.appendChild(document.createTextNode(this.cloudBased ? "True" : "False"));
        devopsElement.appendChild(cloudBasedElement);
        return devopsElement;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public boolean isCloudBased() {
        return cloudBased;
    }

    public void setCloudBased(boolean cloudBased) {
        this.cloudBased = cloudBased;
    }

    @Override
    public String toString() {
        return "DevOpsTool{" +
                "categoria='" + categoria + '\'' +
                ", cloudBased=" + cloudBased +
                "} " + super.toString();
    }
}
