package Strings;

public class largestString {
    public static void main(String[] args) {
        String fruits[]={"apple","banana","orange"};
        // str1.compareTo(str2): 0(strings are equal)  -ve(str1<str2)   +ve(str1>str2)
        String largest=fruits[0];
        for(int i=0;i<fruits.length;i++){
            if(largest.compareToIgnoreCase(fruits[i])<0){// if  largest  is smaller  than current string 
                largest=fruits[i];
            }
        }
        System.out.println(largest);
    }
    
}
