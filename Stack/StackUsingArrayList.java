package Stack;
import java.util.ArrayList;
public class StackUsingArrayList {
     public static class Stack{
        static ArrayList<Integer> list=new ArrayList<>();// so that list remains uniform throughout the code (single)
        public boolean isEmpty(){
                    // if(list.size()==0){
                    //     return true;
                    // }
                    // return false;
                    return  list.size()==0;
        }
        public void push(int data){// pushed on top O(1)
            list.add(data);
        }
        public int pop(){// removed from top O(1)
            int val=list.get(list.size()-1);
            list.remove(list.size()-1);
            return val;
        }
        public int peek(){
            
            return list.get(list.size()-1);
        }
        
     }
    public static void main(String[] args) {
        // StackUsingArrayList s=new StackUsingArrayList();//  we need to use outer class instance to invoke inner class
        // Stack st=s.new Stack();
        // NOTE:If the inner Stack class is not static then it can only be used using the above two lines as non-static inner classes are associated with instances of outer class and can have multiple instances 
        Stack st=new Stack();
        
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        while(!st.isEmpty()){
            System.out.println(st.peek());
            st.pop();
        }
        // stack.pop();
        //stack.peek();
        
    }
}
