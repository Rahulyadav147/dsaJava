package Stack;
import java.util.Stack;
public class reverseString {
    public static String reverse(String s){
               Stack<Character> st=new Stack<>();
               int indx=0;
               while(indx<s.length()){
                st.push(s.charAt(indx));
                indx++;
               }
            StringBuilder sb=new StringBuilder("");
               while(!st.isEmpty()){
                  sb.append(st.pop());
               }

               // we need to convert StringBuilder to string while returning 

               return sb.toString();

    }
    public static void main(String[] args) {
        String st="rahul";
       
        st= reverse(st);
      System.out.println(st);

    }
}
