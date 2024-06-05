package Queue;
// Deque: Double ended queue not dequeue(remove an element from queue)
import java.util.*;
public class deque {
    public static void main(String[] args) {
        Deque<Integer> dq=new LinkedList<>();
        dq.addFirst(1);//1
        dq.addFirst(2);//2,1
        dq.addLast(3);//2,1,3
        dq.addLast(4);//2,1,3,4
        dq.getFirst();//2
        dq.getLast();//4
        System.out.println(dq.removeFirst());// returns a value as well
        dq.removeLast();//
        System.out.println(dq);//1,3
        

    }
}
