package komp;

/**
 *
 * @author Simon Johansson
 * Last update 2015-06-01
 */
public class JSON extends Abstract{
    
    private String first_name, last_name, numb;
    private int age;
    
    /**
    * This is only used when writing to a file.
    * @param first_name, input from Libary. Taken from txf_first_name
    * @param last_name, input from Libary. Taken from txf_last_name
    * @param numb, input from Libary. Taken from txf_phone
    * @param age, input from Libary. Taken from txf_age
    */
    public JSON(String first_name,String last_name, String numb, int age){
        this.first_name = first_name;
        this.last_name = last_name;
        this.numb = numb;
        this.age = age;
    }

    /**
    * Re-Creates the Inputs with a JSON formating
    * 
    * @return The String new created String.
    */
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
