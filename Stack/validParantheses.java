package Stack;
import java.util.Stack;
public class validParantheses {
    public static boolean valid_parantheses1(String str){
        Stack<Character> s=new Stack<>();
        
        int i=0;
        while(i<str.length()) {
            char ch = str.charAt(i);
            // for opening  brackets
            if(ch == '(' || ch == '{' || ch == '[') {
                s.push(ch);
            } else {
                // if no opening bracket first(i.e closing bracket is there first) then stack is empty (as no element is pushed)
                if(s.isEmpty()) {
                    return false;
                }
                // check for matched parantheses if opening came first 
                char top = s.peek();
                if((top == '(' && ch == ')') 
                    || (top == '{' && ch == '}')
                    || (top == '[' && ch == ']')) {
                        s.pop();
                } else {
                    // if umatched paranthesis
                    return false;
                }
            }

            i++;
        }
        if(!s.isEmpty()) {
            return false;
        }
        return true;
    }

    public static boolean valid_parantheses(String s){
        Stack<Character> st=new Stack<>();
        
        for(int i=0;i<s.length();i++){
            // for opening brackets
            if(s.charAt(i)=='('||s.charAt(i)=='{'||s.charAt(i)=='['){
                st.push(s.charAt(i));
               
            }
            // for matched closing brackets : check pairs
            else if((s.charAt(i)==')'&& st.peek()=='(')||(s.charAt(i)=='}'&& st.peek()=='{')||(s.charAt(i)==']'&& st.peek()=='[')){
                st.pop();
               
            }
            // for unmatched closing parantheses or 1:stack is empty as it has not found any opening parantheses 2: if opening parantheses found closing match is not found
            else{
                return false;
            }
        }
        
        if(!st.isEmpty()){
            return false;
        }
        return true;
    }

    
    
    public static void main(String[] args) {
        String s="(()[]{}){({})}";
        if(valid_parantheses(s)){
            System.out.println("It is valid parantheses");
        }
        else{
            System.out.println("It is not a valid parantheses");
        }

        if(valid_parantheses1(s)){
            System.out.println("It is valid parantheses");
        }
        else{
            System.out.println("It is not a valid parantheses");
        }
    }
}
