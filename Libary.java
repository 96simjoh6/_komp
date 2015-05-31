/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komp;

import javax.swing.JFileChooser;
import javax.swing.JTextArea;

/**
 *
 * @author SAJMOON
 */
public class Libary {
    
    private String filename;
    
    public Libary(){
        filename = null;
    }
    
    public String getFile(){
        JFileChooser fc = new JFileChooser(System.getProperty("user.dir"));
	fc.showDialog(null, "Välj fil");
	filename = fc.getSelectedFile().getName();
        
        return filename;
    }
    
    public void readFile(JTextArea txa_main){
        
    }
    
}
