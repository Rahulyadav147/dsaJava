package Recursion;

public class recursion {
    public static void helloWorld(){
        System.out.println("hello world");
        helloWorld1();
    }
    public static void helloWorld1(){
        System.out.println("hello world");
        helloWorld2();
    }
    public static void helloWorld2(){
        System.out.println("hello world");
        helloWorld3();
    }
    public static void helloWorld3(){
        System.out.println("hello world");
    }
    
   public static void main(String[] args) {
    helloWorld();

   }
}
