package komp;

import java.util.ArrayList;
import javax.swing.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;
import org.json.*;
/**
 *
 * @author Simon Johansson
 * Last updated 2015-06-01
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
    
    /**
     * 
     * @param first_name takes user-input from txf_first_name 
     * @param last_name takes user-input from txf_last_name 
     * @param numb takes user-input from txf_phone
     * @param age takes user-input from txf_age
     * @param i Using radio-buttons in GUI, sends a int (i) 1 or 0 
     *          Then using Switch-case, sends the inputs to a subclass
     *          Which re-creates the inputs and then adds it into the array.
     */
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
    
    /**
     * 
     * @return Filename taken from the file that user selects using JFileChooser
     */
    public String getFile(){
        JFileChooser fc = new JFileChooser(System.getProperty("user.dir"));
	fc.showDialog(null, "Välj fil");
	filename = fc.getSelectedFile().getName();
        
        return filename;
    }
    
    /**
     * 
     * @param extension From GUI 4 letters, using Switch-case determinants what 
     *                  "read"-method to use.
     * @param filename  
     * @param txa_main  Used so the JTextArea can be manipulated from this file.
     */
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
    
    /**
     * Reads the "XML" file and converts it into a String.
     * Then sends the String to xmlToString.
     * @param filename
     * @return xml_full from xmlToString to readFile
     */
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
    
    /**
     * Reads the "JSON" file and converts it into a String.
     * Then sends the String to jsonToString
     * @param filename
     * @return json_full from jsonToString to readFile
     */
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
    
    /**
     * Manipulates the String using org.json and removes all JSON formating.
     * 
     * @param json String from readJSON
     * @return new String without the JSON formating.
     */
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
    
    /**
     * Manipulates the String using different methods to remove XML formating.
     * 
     * @param xml String from readXML
     * @return new String without the XML formating.
     */
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
    
    /**
     * Writes the array to the choosen file with XML formating.
     */
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
    /**
     * Writes the array to the choosen file with JSON formating.
     */
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
