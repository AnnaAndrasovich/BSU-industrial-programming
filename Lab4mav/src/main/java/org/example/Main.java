package org.example;

import org.example.dishwasher.Archiving;
import org.example.dishwasher.Dishwasher;
import org.example.dishwasher.Encrypt;
import org.example.dishwasher.Files;
import org.example.dishwasher.ListDW;
import org.example.dishwasher.XMLf;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Objects;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
//import org.json.JSONException;
//import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.Iterator;


public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Hello world!");
        Dishwasher machine = new Dishwasher("Machine", 2000, "black", 500);
        System.out.print(machine);
        Scanner in = new Scanner(System.in);

        System.out.println("Enter ' input ' : ");
        String InFName=in.next();
        System.out.println("Enter output filename:  ");
        String OutFName=in.next();
        System.out.println("What is format of your input file? ");
        String format = in.next();
        int count = 1;
//        System.out.println("Number of items: ");
//        int count; do {
//            count = in.nextInt();
//        }while(count<=0);

        Encrypt encr = new Encrypt();
        BufferedReader reader2 = new BufferedReader(new FileReader(InFName+".txt"));
        PrintStream fileOut5 = new PrintStream("encryption.txt");

        for(int i = 0; i < count; i++)
        {
            String str5 = reader2.readLine();
            String e = encr.encrypt(str5);
            fileOut5.println(e);
        }


        BufferedReader reader3 = new BufferedReader(new FileReader("encryption.txt"));
        PrintStream fileOut6 = new PrintStream("decryption.txt");

        for(int i = 0; i < count; i++)
        {
            String str5 = reader3.readLine();
            String e = encr.decrypt(str5);
            fileOut6.println(e);
        }


        Files file = new Files();
        XMLf file2 = new XMLf();
        Archiving a = new Archiving();
        a.archive(OutFName, InFName+".txt");
        a.read(OutFName);

        ListDW objects = new ListDW();


        if(Objects.equals(format,"txt"))
        {

            InFName = InFName+".txt";
            BufferedReader reader = new BufferedReader(new FileReader(InFName));
            PrintWriter out = new PrintWriter(new FileWriter("file.json"));
            for(int i = 0; i < count; i++)
            {
                file.Read(reader, InFName);
                String str = file.data;
                String[]parts = str.split(" ");
                Dishwasher model = new Dishwasher(parts[2], Integer.parseInt( parts[3]), parts[0], Integer.parseInt( parts[1]));
                objects.insert(model);


                JSONObject json = new JSONObject();
                //try {
                    json.put("name", model.GetName());
                    json.put("color", model.GetColor());
                    json.put("cost", model.GetCost());
                    json.put("volume", model.GetVolume());
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }

                try(out) {
                    out.write(json.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        if(Objects.equals(format,"xml"))
        {
            InFName = InFName+".xml";
            try {
                DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                Document document = documentBuilder.parse(InFName);
                Node root = document.getDocumentElement();
                System.out.println("nodelist ");
                System.out.println();
                NodeList nodes = root.getChildNodes();

                for (int i = 0; i < nodes.getLength(); i++) {
                    Dishwasher dishwasher = new Dishwasher();
                    Node node = nodes.item(i);
                    if (node.getNodeType() != Node.TEXT_NODE) {
                        NodeList nProps = node.getChildNodes();
                        for(int j = 0; j < nProps.getLength(); j++) {
                            Node nProp = nProps.item(j);
                            if (nProp.getNodeType() != Node.TEXT_NODE) {
                                if(Objects.equals("name", nProp.getNodeName()))
                                {
                                    dishwasher.SetName(nProp.getChildNodes().item(0).getTextContent());
                                }
                                if(Objects.equals("color", nProp.getNodeName()))
                                {
                                    dishwasher.SetColor(nProp.getChildNodes().item(0).getTextContent());
                                }
                                if(Objects.equals("cost", nProp.getNodeName()))
                                {
                                    dishwasher.SetCost(Integer.valueOf(nProp.getChildNodes().item(0).getTextContent()));
                                }
                                if(Objects.equals("volume", nProp.getNodeName()))
                                {
                                    dishwasher.SetVolume(Integer.valueOf(nProp.getChildNodes().item(0).getTextContent()));
                                }
                            }
                        }
                    }
                    objects.insert(dishwasher);
                }

            } catch (ParserConfigurationException ex) {
                ex.printStackTrace(System.out);
            } catch (SAXException ex) {
                ex.printStackTrace(System.out);
            } catch (IOException ex) {
                ex.printStackTrace(System.out);
            }
        }

        System.out.println("Sort by cost or volume? ");

        String sort=in.next();

        System.out.println("What is format of your output file? ");
        format = in.next();

        if(Objects.equals(sort,"cost"))
        {
            objects.sortByCost();
        }

        if(Objects.equals(sort,"volume"))
        {
            objects.sortByVolume();
        }

        if(Objects.equals(format, "xml"))
        {
            OutFName=OutFName+".xml";
            objects.Print(OutFName, file2);
        }

        if(Objects.equals(format,"txt"))
        {
            OutFName=OutFName+".txt";
            objects.Print(OutFName, file);
        }
    }
}