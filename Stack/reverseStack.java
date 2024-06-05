package Stack;
import java.util.Stack;
public class reverseStack {
    // using extra space O(n)   and TC : O(n)
    public static Stack<Integer> reverse1(Stack<Integer>st){
        Stack<Integer> s=new Stack<>();
        while(!st.empty()){
            s.push(st.pop());
        }
        return s;

    }


    // without using extra memory but TC: O(n^2)
    public  static void pushBottom(Stack <Integer>s,int data){
        // when stack is empty push the given data 
                 if(s.isEmpty()){
                    s.push(data);
                    return ;
                 }
                 // while going down the recursion tree store val so that we can push back while recursion backtracks 
                 int val=s.pop();
                
                 pushBottom(s,data);
                 s.push(val);
    }
    public  static void reverse2(Stack<Integer>st){
        if(st.isEmpty()){
            return ;
        }
        // storing values while going down recursion tree
        int val=st.pop();
        // revursive call:
        reverse2(st);
        // pusing at bottom while coming back 
        pushBottom(st,val);
    


    }
    public static void main(String[] args) {
        Stack<Integer> st=new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        // can use new stack and return that but that uses extra memory 
        // Stack<Integer> reversedStack=reverse1( st); 

        // while(!reversedStack.empty()){
        //     System.out.println(reversedStack.peek());
        //     reversedStack.pop();
        // }

        // Better approach
        reverse2(st);
         while(!st.empty()){
            System.out.println(st.peek());
            st.pop();
        }
        
        

    }
}
