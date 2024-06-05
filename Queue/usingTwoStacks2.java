package Queue;
import java.util.Stack;
// Add O(1)  : remove and peek O(n);
// approach: push at top of s1 for add and remove or peek from top of s2 (using O(N) operations because first we transfer elements front s1 to s2 then remove and peek)
public class usingTwoStacks2 {
    public static class Queue{
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        public boolean isEmpty(){
            return s1.isEmpty();
        }
        // TC: O(1)
        public void add(int data) {
            s1.push(data);
        }

        // TC: O(n) - Amortized constant time with frequent additions
        public int remove() {
            if(s1.isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            else{
                // add s1 data to s2 and pop top and add it back to s1
                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
                int val=s2.pop();
                // add back s2 data to s1  for further 
                while (!s2.isEmpty()) {
                    s1.push(s2.pop());
                }
                return val;

            }


            
        }

        // TC: O(n) - Amortized constant time with frequent additions
        public int peek() {
            if(s1.isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            else{
                // add s1 data to s2 and pop top and add it back to s1
                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
                int val=s2.peek();
                // add back s2 data to s1  for further 
                while (!s2.isEmpty()) {
                    s1.push(s2.pop());
                }
                return val;

            }
        
        }
    }
    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        while (!q.isEmpty()) {
            System.out.println(q.peek()); // O(n) call here
            q.remove();               // O(n) call here
        } 
    }
}
