package variables_And_Data_Structres;
import java.util.Scanner;

public class L02_input_in_Java {
    public static void main(String[] args) {
                Scanner sc = new Scanner(System.in) ;
                String value = sc.next(); // next for one word and nextLine for entire line
                System.out.println(value); 
                
                sc.close();
                
}
}