package Strings;

import java.util.Scanner;

public class basicsOfString {
    public static void main(String[] args) {
        char abc[]={'a','b','c'};// for characters;
        String s="abc";
        // or 
        String str=new String("abc");
        // strings are immutable: can give only give new string upon any operation ,no change  in original string 
        Scanner sc=new Scanner(System.in);
        String name=sc.next();// takes input till next space
        String name1=sc.nextLine();
        System.out.println(abc);
        System.out.println(s);
        System.out.println(str);
        System.out.println(name);
        System.out.println(name1);
       
         sc.close();
    }
}
