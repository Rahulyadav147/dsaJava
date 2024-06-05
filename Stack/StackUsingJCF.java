package Stack;
import java.util.*;
public class StackUsingJCF {
    public static void main(String[] args) {
        Stack<Integer> st=new Stack<>();
        if(st.isEmpty()){
            System.out.println("Stack is empty");
        }
        st.push(1);
        st.add(2);// in  stack we have add operation also that return true always : it also adds element in stack similar to push
        st.push(3);
        st.push(4);
        st.push(5);
        st.pop();
        st.pop();
        st.pop();
        System.out.println(st.push(7));//output:7      push acutally returns the value added
        System.out.println(st.add(7));// output:true      always returns true


        
    }
}
