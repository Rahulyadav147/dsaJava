
package LinkedList1;
// see the implementation after you get time
public class circularLL {
    public class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static int size;

    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            newNode.next = head;
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            head = newNode;
        }
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head;
        }
    }

    public void printCircularLL() {
        if (head == null) {
            System.out.println("Circular Linked List is empty");
            return;
        }
        Node temp = head;
        do {
            System.out.print(temp.data + "->");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    public int removeFirst() {
        if (head == null) {
            System.out.println("Circular Linked List is empty");
            return Integer.MIN_VALUE;
        }
        int val = head.data;
        if (head.next == head) {
            head = null;
        } else {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = head.next;
            head = head.next;
        }
        size--;
        return val;
    }

    public int removeLast() {
        if (head == null) {
            System.out.println("Circular Linked List is empty");
            return Integer.MIN_VALUE;
        }
        int val;
        if (head.next == head) {
            val = head.data;
            head = null;
        } else {
            Node temp = head;
            while (temp.next.next != head) {
                temp = temp.next;
            }
            val = temp.next.data;
            temp.next = head;
        }
        size--;
        return val;
    }

    public static void main(String[] args) {
        circularLL cll = new circularLL();
        cll.addFirst(3);
        cll.addFirst(2);
        cll.addFirst(1);
        cll.printCircularLL();
        cll.removeFirst();
        cll.printCircularLL();
        System.out.println(size);
        cll.addLast(4);
        cll.printCircularLL();
        System.out.println(size);
        cll.removeLast();
        cll.printCircularLL();
        System.out.println(size);
    }
}