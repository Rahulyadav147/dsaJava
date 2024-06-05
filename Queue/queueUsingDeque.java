package Queue;

import java.util.*;

public class queueUsingDeque {
     public static class Queue{    // always try to make the class static : to make it standAlone and not clash with other stack classes in different packagees
        Deque<Integer>dq=new LinkedList<>();
        // add  // addlast in dq
        public void add(int data){
            dq.addLast(data);
        }

         // remove  // removelast in dq
         public int  remove(){
             return dq.removeFirst();
        }

         // add  // addlast in dq
         public int peek(){
            return dq.getFirst();
        }
    }
    public static void main(String[] args) {
        Queue q=new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println(q.peek());
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
        
    }
}
