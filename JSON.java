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
    
    private String first_name, last_name, numb, type;
    private int age;
    
    public JSON(String first_name,String last_name, String numb, int age){
        this.first_name = first_name;
        this.last_name = last_name;
        this.numb = numb;
        this.age = age;
    }

    @Override
    public String toString() {
        return(
                "\r\n"+"\t"+"{"+"\r\n"+
                "\t\t"+"\"firstName\": \""+first_name+"\","+"\r\n"+
                "\t\t"+"\"lastName\": \""+last_name+"\","+"\r\n"+
                "\t\t"+"\"phoneNumber\": \""+numb+"\","+"\r\n"+
                "\t\t"+"\"age\": \""+age+"\","+"\r\n"+
                "\t"+"},"+"\r\n"
        );
    }
    
}
