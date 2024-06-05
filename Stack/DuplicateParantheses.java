package Stack;
import java.util.Stack;
public class DuplicateParantheses {
    // using for loop
    public static boolean duplicate_parantheses(String str){
        Stack <Character> s = new Stack<>();

        //we are given a valid string 
        for(int i = 0; i<str.length(); i++){
            char ch = str.charAt(i);
            // for opening  brackets and + and a,b,c,d
            if(ch == '(' || ch == '{' || ch == '['|| ch == '+'|| ch == 'a'|| ch == 'b'|| ch == 'c'|| ch == 'd') {
                s.push(ch);
            
            } else {
                // when a closing bracket is reached
                // keep  poping '+','a,b,c,d'
                char top = s.peek();
                int count=0;
                // traverse till we get a opening paranthese and count no of  elements inside
                while(top!='('&&top!='{'&&top!='['){// NOTE: condition is && not || : i.e. if any opening bracket found break the loop
                        // pop the element
                        s.pop();
                        // update top
                        top=s.peek();
                        count++;
                        
                   
                }
                if(count<1){// if there are no elements in between brackets : it is a duplicate parantheses
                    return true;
                }
                else{
                    // to check for other parantheses ((a+b)+(c+d))=> after cheking (c+d) as not duplicate pop '(' and check for ((a+b)+)
                    s.pop();// pop the opening pair at last 
                }
               
               
            }
        }
        return false;
    }
    // NOTE: We already know that parantheses is valid , we jsut need to check for duplicate
    // public static boolean duplicate_parantheses(String str){
    //     Stack<Character> s=new Stack<>();
        
    //     int i=0;
    //     while(i<str.length()) {
    //         char ch = str.charAt(i);
    //         // for opening  brackets and + and a,b,c,d
    //         if(ch == '(' || ch == '{' || ch == '['|| ch == '+'|| ch == 'a'|| ch == 'b'|| ch == 'c'|| ch == 'd') {
    //             s.push(ch);
    //             i++;
    //         } else {
    //             // when a closing bracket is reached
    //             // keep  poping '+','a,b,c,d'
    //             char top = s.peek();
    //             int count=0;
    //             // traverse till we get a opening paranthese and count no of  elements inside
    //             while(top!='('&&top!='{'&&top!='['){// NOTE: condition is && not || : i.e. if any opening bracket found break the loop
    //                     // pop the element
    //                     s.pop();
    //                     // update top
    //                     top=s.peek();
    //                     count++;
                        
                   
    //             }
    //             if(count<1){// if there are no elements in between brackets : it is a duplicate parantheses
    //                 return true;
    //             }
    //             s.pop();// pop the opening pair at last
    //             i++;// because we have traversed stack for a closing bracket so we need to move forward in string
    //         }
    //     }
    //     return false;
    // }

    public static void main(String[] args) {
        String s="(((a+b))+(c+d))";
        if(duplicate_parantheses(s)){
            System.out.println("It is duplicate parantheses");
        }
        else{
            System.out.println("It is not duplicate parantheses");
        }

       
    }
}
