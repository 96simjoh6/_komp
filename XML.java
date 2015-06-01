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
public class XML extends Abstract{
    private final String first_name, last_name, numb;
    private final int age;
    
    public XML(String first_name, String last_name, String numb, int age){
        this.first_name = first_name;
        this.last_name = last_name;
        this.numb = numb;
        this.age = age;
    }

    @Override
    public String toString() {
        return(
                "\r\n"+"<person>"+"\r\n"+
                "\t"+"<first_name>"+first_name+"</first_name>"+"\r\n"+
                "\t"+"<last_name>"+last_name+"</last_name>"+"\r\n"+
                "\t"+"<telephone_number>"+numb+"</telephone_number>"+"\r\n"+
                "\t"+"<age>"+age+"</age>"+"\r\n"+
                "</person>"+"\r\n"
        );
    }
}
