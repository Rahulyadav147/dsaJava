import java.util.Scanner;

public class firstProgram{
    public static void main(String[] args){   
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter lines of text (type 'exit' to quit):");

    while(sc.hasNext()){
            String s = sc.nextLine();
            if(s.equals("exit")) {
                break;
            }
            System.out.println("You entered: " + s);
        }
        sc.close();
    
}
}