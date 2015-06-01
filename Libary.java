package komp;

import java.util.ArrayList;
import javax.swing.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;
import org.json.*;
/**
 *
 * @author SAJMOON
 */
public class Libary {
    
    Abstract a;
    private String filename, xml, json, xml_full, json_full;
    private ArrayList<Abstract> array;
    private int i;
    
    
    public Libary(){
        filename = null;
        array = new ArrayList<>();
        xml = null;
        json = null;
        i = 0;
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
    try(BufferedReader br = new BufferedReader(new FileReader(filename))){
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while(line != null){
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            br.close();
            xml = sb.toString();
            xmlToString(xml);
        } 
        catch (IOException e) {
            {e.printStackTrace();}
        }
        return xml_full;
    }
    
    public String readJSON(String filename){
    try(BufferedReader br = new BufferedReader(new FileReader(filename))){
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while(line != null){
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            br.close();
            json = sb.toString();
            jsonToString(json);
        } 
        catch (IOException e) {
            {e.printStackTrace();}
        }
        return json_full;    
    }
    
    public String jsonToString(String json){
        try {
            final JSONObject jo = new JSONObject(json);
            final JSONArray persons = jo.getJSONArray("persons");
            final int n = persons.length();
            for (i = 0; i < n; ++i) {
                final JSONObject person = persons.getJSONObject(i);
                json_full += ( "\n" +
                        "First Name: " + (person.getString("firstName")) + "\n" +
                        "Last Name: " + (person.getString("lastName")) + "\n" +
                        "Telephone Number: " +  (person.getString("phoneNumber")) + "\n" +
                        "Age: " +  (person.getInt("age")) + "\n"
                ); 
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return json_full;
    }
    
    public String xmlToString(String xml) {
        try {
            File fXmlFile = new File(filename);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("person");
            for(i = 0; i < nList.getLength(); ++i){

                    Node nNode = nList.item(i);

                    if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                            Element eElement = (Element) nNode;

                            xml_full += ( "\n" +
                            "First Name: " + eElement.getElementsByTagName("first_name").item(0).getTextContent() + "\n" +
                            "Last Name: " + eElement.getElementsByTagName("last_name").item(0).getTextContent() + "\n" +
                            "Telephone Number: " + eElement.getElementsByTagName("telephone_number").item(0).getTextContent() + "\n" +
                            "Age: " + eElement.getElementsByTagName("age").item(0).getTextContent() + "\n"
                            );
                    }
            }
            } 
            catch (Exception e) {
                e.printStackTrace();
            }
        return xml_full;
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
                            pw.println(b.toString());
                        }
                            pw.close();
                        }
                
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    
    public void jsonToFile(){
        try{
                    FileWriter fw = new FileWriter(filename, true) ; 
                    BufferedWriter bw = new BufferedWriter(fw);
                     try (PrintWriter pw = new PrintWriter(bw)) {
                        for(Abstract b : array){
                            pw.println(b.toString());
                        }
                            pw.close();
                        }
                
            }catch (Exception e) {
                e.printStackTrace();
            }
    }
}
