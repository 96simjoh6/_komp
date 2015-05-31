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
    
    Abstract a;
    private String filename, xml_full, json_full;
    private ArrayList<Abstract> array;
    
    
    public Libary(){
        filename = null;
        array = new ArrayList<>();
        xml_full = null;
        json_full = null;
    }
    
    public void saveToFile(String first_name, String last_name, String numb, int age, int i){
        switch(i){
            case 1:
                a = new XML(first_name,last_name,numb,age);
                array.add(a);
                xmlToFile();
            break;
            case 0:
                a = new JSON(first_name,last_name,numb,age);
                array.add(a);
                jsonToFile();
            break;
        }
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
                txa_main.append(json_full);
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
           Element elm = (Element) first_name.item(0);
           sb.append("First name: ").append(getData(elm)).append("\n");

           NodeList last_name = prop.getElementsByTagName("last_name");
           elm = (Element) last_name.item(0);
           sb.append("Last name: ").append(getData(elm)).append("\n");

           NodeList telephone_number = prop.getElementsByTagName("telephone_number");
           elm = (Element) telephone_number.item(0);
           sb.append("Telephone number: ").append(getData(elm)).append("\n");

           NodeList age = prop.getElementsByTagName("age");
           elm = (Element) age.item(0);
           sb.append("Age: ").append(getData(elm)).append("\n");
           }
        xml_full = sb.toString();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
        return(xml_full);
    }
    
    public String getData(Element e){
        Node child = e.getFirstChild();
        if(!(child instanceof CharacterData)){
        }else{
            CharacterData cd = (CharacterData) child;
            return cd.getData();
        }
        return null;
    }
    
    public void xmlToFile(){
          try{
                    FileWriter fw = new FileWriter(filename, true) ; 
                    BufferedWriter bw = new BufferedWriter(fw);
                     try (PrintWriter pw = new PrintWriter(bw)) {
                        for(Abstract b : array){
                        pw.append(b.toString());
                        }
                        pw.close();
                        }
                
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    
    public String jsonToFile(){
        
        
        return null;
    }
}
