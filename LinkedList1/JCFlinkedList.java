package LinkedList1;
import java.util.LinkedList;
public class JCFlinkedList {
    public static void main(String[] args) {
        LinkedList<Integer>ll=new LinkedList<>();
        ll.addFirst(0);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.add(1,1);
        System.out.println(ll);
        ll.removeFirst();
        ll.removeLast();
        ll.remove(2);
        System.out.println(ll);
    }
}
