// Add:O(n)  , remove and peek: O(1)
// 
package Queue;
import java.util.Stack;
//since the Stack objects s1 and s2 are declared as static, they are shared across all instances of the Queue class. If you were to make them non-static, each instance of Queue would have its own separate stacks for s1 and s2.
public class usingTwoStacks1 {
    static class Queue{
        static Stack<Integer> s1=new Stack<>();
        static Stack<Integer> s2=new Stack<>();
        public boolean isEmpty(){
            return s1.isEmpty();
        }
        // TC:O(n)
        public void add(int data){
            if(isEmpty()){// if queue is empty we can directly add data to queue 
                s1.push(data); // add data to queue
                return ;
            }
            else{
                // Step1:empty s1 into s2
                 while(!s1.isEmpty()){
                    s2.push(s1.pop());
                 }
                //Step2: push data in s1
                s1.push(data);
                // step3: empty s2 into s1
                while(!s2.isEmpty()){
                    s1.push(s2.pop());
                }

            }
        }
        // TC: O(1)
        public int remove(){
            // if queue is empty
            if(s1.isEmpty()){
                System.out.println("queue is empty");
                return -1;
            }
            else{
                int front=s1.pop();
                return front;
            }
        }
        // TC: O(1)
        public int peek(){
             // if queue is empty
             if(s1.isEmpty()){
                System.out.println("queue is empty");
                return -1;
            }
            else{
                int front=s1.peek();
                return front;
            }
        }

    }
    public static void main(String[] args) {
        Queue q= new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
    }
    
}
