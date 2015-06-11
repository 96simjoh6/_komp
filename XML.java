package komp;

/**
 *
 * @author Simon Johansson
 * Last update 2015-06-01
 */
public class XML extends Abstract{
    private final String first_name, last_name, numb;
    private final int age;
    
    /**
    * This is only used when writing to a file.
    * @param first_name, input from Libary. Taken from txf_first_name
    * @param last_name, input from Libary. Taken from txf_last_name
    * @param numb, input from Libary. Taken from txf_phone
    * @param age, input from Libary. Taken from txf_age
    */
    public XML(String first_name, String last_name, String numb, int age){
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
                "\r\n"+"<person>"+"\r\n"+
                "\t"+"<first_name>"+first_name+"</first_name>"+"\r\n"+
                "\t"+"<last_name>"+last_name+"</last_name>"+"\r\n"+
                "\t"+"<telephone_number>"+numb+"</telephone_number>"+"\r\n"+
                "\t"+"<age>"+age+"</age>"+"\r\n"+
                "</person>"+"\r\n"
        );
    }
}
