package src;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import src.products.SoftwareProduct;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class ObjectSerializer {
    private static HashMap<String, ObjectReadMethod> registratedCreatorsFunc = new HashMap<String, ObjectReadMethod>();

    public static void registerCreator(String creatorName, ObjectReadMethod creator) {
        registratedCreatorsFunc.put(creatorName, creator);
    }

    public static ArrayList<SoftwareProduct> readProductsFromFile(File file) {
        ArrayList<SoftwareProduct> products = null;
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document documento = builder.parse(file);
            NodeList nodeList = documento.getElementsByTagName("*");
            products = new ArrayList<SoftwareProduct>();
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element element = (Element) nodeList.item(i);

                for (String creatorName : registratedCreatorsFunc.keySet()) {
                    if (creatorName.equals(element.getTagName())) {
                        ObjectReadMethod creator = registratedCreatorsFunc.get(creatorName);
                        products.add(creator.deserialize(element));
                        break;
                    }
                }
            }
        } catch (SAXException | IOException | ParserConfigurationException e) {
            e.printStackTrace();
        }
        return products;
    }

    public static void writeProductsToFile(ArrayList<SoftwareProduct> products, File file) {

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = null;
            builder = factory.newDocumentBuilder();
            //implementacion DOM -> web
            DOMImplementation dom = builder.getDOMImplementation();
            Document documento = dom.createDocument(null,"xml",null);

            //añado el nodo raiz (primera etiqueta)
            Element raiz = documento.createElement("Products");
            documento.getDocumentElement().appendChild(raiz);
            for (SoftwareProduct product : products) {
                Element serialized = product.serialize(documento);
                raiz.appendChild(serialized);
            }
            //guardo los datos en fichero
            Source source = new DOMSource(documento);
            Result result = new StreamResult(file);

            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source,result);

        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }

    }

}
