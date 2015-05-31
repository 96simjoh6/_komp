/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komp;

/**
 *
 * @author SAJMOON
 */
public class JSON extends Abstract{
    
    private String name, numb, type;
    private int age;
    
    public JSON(String name, String numb, int age){
        this.name = name;
        this.numb = numb;
        this.age = age;
        type = "XML";
    }
    @Override
    public String getAge() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int compareTo(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
