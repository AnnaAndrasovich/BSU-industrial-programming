package org.example.dishwasher;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;


public class XMLf{
    private String data;
    public XMLf()
    {
        data=null;
    }
    public void Read(BufferedReader reader, String fName) {
        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse("input.xml");
            Node root = document.getDocumentElement();
            System.out.println("List of dishwashers:");
            System.out.println();

            NodeList nlist = root.getChildNodes();

            for (int i = 0; i < nlist.getLength(); i++) {
                Node n = nlist.item(i);
                if (n.getNodeType() != Node.TEXT_NODE) {
                    NodeList nProps = n.getChildNodes();
                    for(int j = 0; j < nProps.getLength(); j++) {
                        Node nProp = nProps.item(j);
                        if (nProp.getNodeType() != Node.TEXT_NODE) {
                            System.out.println(nProp.getNodeName() + ":" + nProp.getChildNodes().item(0).getTextContent());
                        }
                    }
                    System.out.println("--------------");
                }
            }

        } catch (ParserConfigurationException ex) {
            ex.printStackTrace(System.out);
        } catch (SAXException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public void Write(PrintStream fileOut, ListDW model, String fName) {
        try {

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("superdw");
            doc.appendChild(rootElement);
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(fName);
            for(int i = 0; i < model.Size(); i++)
            {
                Dishwasher dw = model.get(i);
                Element superdw = doc.createElement("superdw");
                rootElement.appendChild(superdw);

                Element name = doc.createElement("name");
                name.appendChild(doc.createTextNode(dw.name));
                superdw.appendChild(name);

                Element color = doc.createElement("color");
                color.appendChild(doc.createTextNode(dw.color));
                superdw.appendChild(color);


                Element cost = doc.createElement("cost");
                cost.appendChild(doc.createTextNode(Integer.toString(dw.cost)));
                superdw.appendChild(cost);

                Element volume = doc.createElement("volume");
                volume.appendChild(doc.createTextNode(Integer.toString(dw.volume)));
                superdw.appendChild(volume);

                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = null;
                try {
                    transformer = transformerFactory.newTransformer();
                } catch (TransformerConfigurationException e) {
                    e.printStackTrace();
                }
                transformer.transform(source, result);
            }
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
    }
}