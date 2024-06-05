package Queue;
import java.util.Queue;
import java.util.LinkedList;
// import java.util.ArrayDeque;



public class usingJCF {
    public static void main(String[] args) {
        
    // NOTE: Queue is an interface so we cannot make objects of interface rather we make objects of class that exteds (implements) Queue
    Queue<Integer>q=new LinkedList<>();
    // Queue<Integer>q1=new ArrayDeque<>();
    q.add(1);
    q.add(2);
    q.add(3);
    while(!q.isEmpty()){
        System.out.println(q.peek());
        q.remove();
    }
    }
}
