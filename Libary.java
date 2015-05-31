/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFileChooser;
/**
 *
 * @author SAJMOON
 */
public class Libary {
    
    private String filename, firstname, lastname, telephonenumber;
    private int age;
    private ArrayList<Abstract> array;
    
    public Libary(){
        filename = null;
        array = new ArrayList<>();
    }
    
    public void add(String name, String numb, int age, int i){
        Abstract aC = null;
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
    
    public void readFile(String extension, String filename){
        array.clear();   
        
        switch (extension) {
            case "_xml":
                readXML(filename);
                break;
            case "json":
                readJSON(filename);
                break;
        }
    }
    
    public void readXML(String filename){
        try(BufferedReader br = new BufferedReader(new FileReader(filename))){
            String line = br.readLine();
            while(line != null){
                line = br.readLine();
            }
        } 
        catch (IOException e) {
            {e.printStackTrace();}
        }
    }
    
    public void readJSON(String filename){
        
    }
    
}
