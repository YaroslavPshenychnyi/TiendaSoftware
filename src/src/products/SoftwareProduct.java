package src.products;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.time.LocalDate;

public abstract class SoftwareProduct {
    private String productName;
    private String developer;
    private LocalDate launchDate;
    private String licence;
    private double sizeMB;
    private String description;

    public SoftwareProduct(String productName, String developer, LocalDate launchDate, String licence, double sizeMB, String description) {
        this.productName = productName;
        this.developer = developer;
        this.launchDate = launchDate;
        this.licence = licence;
        this.sizeMB = sizeMB;
        this.description = description;
    }

    public SoftwareProduct(Element node) throws ParserConfigurationException, IOException, SAXException {
        NodeList nodeList = node.getChildNodes();
        this.productName = nodeList.item(0).getTextContent();
        this.developer = nodeList.item(1).getTextContent();
        this.launchDate = LocalDate.parse(nodeList.item(2).getTextContent());
        this.licence = nodeList.item(3).getTextContent();
        this.sizeMB = Double.parseDouble(nodeList.item(4).getTextContent());
        this.description = nodeList.item(5).getTextContent();
    }

    public Element serialize(Document document) {
        Element mainElement = document.createElement("SoftwareProduct");

        Element productNameElement = document.createElement("productName");
        productNameElement.appendChild(document.createTextNode(productName));

        Element developerElement = document.createElement("developer");
        developerElement.appendChild(document.createTextNode(developer));

        Element launchDateElement = document.createElement("launchDate");
        launchDateElement.appendChild(document.createTextNode(launchDate.toString()));

        Element licenceElement = document.createElement("licence");
        licenceElement.appendChild(document.createTextNode(licence));

        Element sizeMBElement = document.createElement("sizeMB");
        sizeMBElement.appendChild(document.createTextNode(Double.toString(sizeMB)));

        Element descriptionElement = document.createElement("description");
        descriptionElement.appendChild(document.createTextNode(description));

        mainElement.appendChild(productNameElement);
        mainElement.appendChild(developerElement);
        mainElement.appendChild(launchDateElement);
        mainElement.appendChild(licenceElement);
        mainElement.appendChild(sizeMBElement);
        mainElement.appendChild(descriptionElement);
        return mainElement;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public LocalDate getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(LocalDate launchDate) {
        this.launchDate = launchDate;
    }

    public String getLicence() {
        return licence;
    }

    public void setLicence(String licence) {
        this.licence = licence;
    }

    public double getSizeMB() {
        return sizeMB;
    }

    public void setSizeMB(double sizeMB) {
        this.sizeMB = sizeMB;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "SoftwareProduct{" +
                "productName='" + productName + '\'' +
                ", developer='" + developer + '\'' +
                ", launchDate=" + launchDate +
                ", licence='" + licence + '\'' +
                ", sizeMB=" + sizeMB +
                ", description='" + description + '\'' +
                '}';
    }
}
