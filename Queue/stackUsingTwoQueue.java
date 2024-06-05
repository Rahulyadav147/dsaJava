package Queue;
import java.util.LinkedList;
import java.util.Queue;
public class stackUsingTwoQueue {
    public static class Stack{
        Queue<Integer> q1=new LinkedList<>();
        Queue<Integer>q2=new LinkedList<>();
        public boolean isEmpty(){
            return q1.isEmpty();
        }
        
        // add O(1) because we are adding in last of queue as in stack
        public void push(int data){
           q1.add(data); 
        }
        // POP O(n) because we remove from last of queue ( takes n operation  to reach last element as we add q1 into q2 to reach last element and then remove that fromt q2 and put it back in q1 )
        public int pop(){
            if(q1.isEmpty()){
                System.out.println("Stack is empty");
                return -1;
            }
            else {
                // Move all elements except the last one from q1 to q2
                while (q1.size() > 1) {
                    q2.add(q1.remove());
                }
                // Store and remove the last element in q1
                int val = q1.remove();
                // Swap q1 and q2, so q2 is empty and q1 has all elements except the popped one
                // Queue<Integer> temp = q1;
                // q1 = q2;
                // q2 = temp;
                // or just put the elements of q2 back in q1
                while(!q2.isEmpty()){
                    q1.add(q2.remove());
                }
                return val;
            }
        }
        
        public int peek(){
            if(q1.isEmpty()){
                System.out.println("Stack is empty");
                return -1;
            }
            else {
                // Move all elements except the last one from q1 to q2
                while (q1.size() > 1) {
                    q2.add(q1.remove());
                }
                // Store the last element in q1
                int val = q1.peek();
                // Move the last element from q1 to q2
                q2.add(q1.remove());
                // Swap q1 and q2, so q2 has the last element and q1 has all elements except the peeked one
                Queue<Integer> temp = q1;
                q1 = q2;
                q2 = temp;
                return val;
            }
        }
    }
    public static void main(String[] args) {
        Stack s=new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }

    }
}

 // Another implementation where last(top of stack) element after putting q1 elements to q2 is taken and popped : then queue is not  swapped as q1 and q2 are same : so same operations are performed on the queue which is not empty
/*
 * import java.util.*;

public class Stack_using_Queues {

    static class Stack {
        static Queue<Integer> q1 = new LinkedList<>();
        static Queue<Integer> q2 = new LinkedList<>();

        // empty
        public static boolean isEmpty() {
            return q1.isEmpty() && q2.isEmpty();
        }

        // add
        public static void push(int data) {
            if (!q1.isEmpty()) {
                q1.add(data);
            } else {
                q2.add(data);
            }
        }

        // remove - O(n)
        public static int pop() { 
            if (isEmpty()) {
                System.out.println("Stack is empty");
                return -1;
            }

            // here there will be two cases as the elements can be in q2 or in q1
            int top = -1;
            if (!q1.isEmpty()) { // case 1
                while (!q1.isEmpty()) {
                    top = q1.remove();
                    if (q1.isEmpty()) {// if last element is removed do not add it to q2 as we want to pop that element permanently
                        break;
                    }
                    q2.add(top);
                }

            } else {// case 2
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    if (q1.isEmpty()) {
                        break;
                    }
                    q1.add(top);
                }

            }
            return top;
        }

        public static int peek() {
            int top = -1;
            if (!q1.isEmpty()) { // case 1
                while (!q1.isEmpty()) {
                    top = q1.remove();// no if condition  because we are adding every element in q2 as no popping is done only peek 
                    q2.add(top);
                }

            } else {// case 2
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    q1.add(top);
                }

            }
            return top;
        }
    }

    public static void main(String args[]) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);

        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }

}
 */
