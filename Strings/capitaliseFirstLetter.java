package Strings;

public class capitaliseFirstLetter {
    public static void main(String[] args) {
        String s="hello how are you aman";
        StringBuilder s1=new StringBuilder("");
        s1.append(Character.toUpperCase(s.charAt(0)));
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==' '&& i<s.length()-1){
               s1.append(s.charAt(i));
               i++;
               s1.append(Character.toUpperCase(s.charAt(i)));
            }
            else{
                s1.append(s.charAt(i));
            }
           
        }
        String s2=s1.toString();
        System.out.println(s2);
    }
}
