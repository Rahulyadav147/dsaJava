package Queue;
import java.util.*;
public class stackUsingDeque {
    public static class Stack{    // always try to make the class static : to make it standAlone and not clash with other stack classes in different packagees
        Deque<Integer>dq=new LinkedList<>();
        // push  // addlast in dq
        public void push(int data){
            dq.addLast(data);
        }

         // pop  // removelast in dq
         public int  pop(){
             return dq.removeLast();
        }

         // push  // addlast in dq
         public int peek(){
            return dq.getLast();
        }
    }
    public static void main(String[] args) {
        Stack s=new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println(s.peek());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        
    }
}
