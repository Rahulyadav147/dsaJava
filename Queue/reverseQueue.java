package Queue;
import java.util.*;
public class reverseQueue {
    public static  void reverse(Queue<Integer>q1){
        Stack<Integer>s=new Stack<>();
        while(!q1.isEmpty()){
            s.push(q1.remove());
        }
        while(!s.isEmpty()){
            q1.add(s.pop());
        }
    }
    public static void main(String[] args) {
        Queue<Integer> q=new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        reverse(q);
        while(!q.isEmpty()){
            System.out.print(q.remove()+" ");
        }
    }
}
