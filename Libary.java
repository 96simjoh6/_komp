/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komp;

import java.util.ArrayList;
import javax.swing.*;
import javax.xml.parsers.*;
import org.xml.sax.InputSource;
import org.w3c.dom.*;
import java.io.*;
/**
 *
 * @author SAJMOON
 */
public class Libary {
    
    Abstract aC = null;
    private String filename, xml_full;
    private ArrayList<Abstract> array;
    
    
    public Libary(){
        filename = null;
        array = new ArrayList<>();
        xml_full = null;
    }
    
    public void add(String name, String numb, int age, int i){
        switch(i){
            case 0:
                aC = new XML(name,numb,age);
                
            break;
            case 1:
                aC = new JSON(name,numb,age);
            break;
        }
        array.add(aC);
    }
    
    public String getFile(){
        JFileChooser fc = new JFileChooser(System.getProperty("user.dir"));
	fc.showDialog(null, "Välj fil");
	filename = fc.getSelectedFile().getName();
        
        return filename;
    }
    
    public void readFile(String extension, String filename, JTextArea txa_main){
        array.clear();   
        
        switch (extension) {
            case "xml_":
                readXML(filename);
                txa_main.append(xml_full);
                break;
            case "json":
                readJSON(filename);
                break;
        }
    }
    
    public String readXML(String filename){ 
    String file = getClass().getResource(filename).getPath();
    try(BufferedReader br = new BufferedReader(new FileReader(file))){
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while(line != null){
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            br.close();
            String xml = sb.toString();
            xmlToString(xml);
        } 
        catch (IOException e) {
            {e.printStackTrace();}
        }
        return(xml_full);
    }
    
    public void readJSON(String filename){
        
    }
    
    public String getData(Element e){
        Node child = e.getFirstChild();
        if(!(child instanceof CharacterData)){
        }else{
            CharacterData cd = (CharacterData) child;
            return cd.getData();
        }
        return "?";
    }
    
    public String xmlToString(String xml){
        StringBuilder sb = new StringBuilder();
        try {DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        InputSource is = new InputSource();
        is.setCharacterStream(new StringReader(xml));
        Document d = db.parse(is);
        NodeList antal = d.getElementsByTagName("person");
        for (int i = 0; i < antal.getLength(); i++) {
           Element prop;
            prop = (Element) antal.item(i);

           NodeList first_name = prop.getElementsByTagName("first_name");
           Element e = (Element) first_name.item(0);
           sb.append("First name: ").append(getData(e)).append("\n");

           NodeList last_name = prop.getElementsByTagName("last_name");
           e = (Element) last_name.item(0);
           sb.append("Last name: ").append(getData(e)).append("\n");

           NodeList telephone_number = prop.getElementsByTagName("telephone_number");
           e = (Element) telephone_number.item(0);
           sb.append("Telephone number: ").append(getData(e)).append("\n");

           NodeList age = prop.getElementsByTagName("age");
           e = (Element) age.item(0);
           sb.append("Age: ").append(getData(e)).append("\n");
           }
        xml_full = sb.toString();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
        return(xml_full);
    }
    
}
