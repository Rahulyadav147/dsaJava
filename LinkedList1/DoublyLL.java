package LinkedList1;

public class DoublyLL {
    public class Node{
        int data;
        Node next;
        Node prev;
        public Node(int data){
        this.data=data;
        this.next=null;
        this.prev=null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;
    // in addFirst tail is at last only as it is never moved front as head
    public void addFirst(int data){
        Node newNode=new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return ;
        }
        newNode.next=head;
        head.prev=newNode;
        head=newNode;
    }
    public void addLast(int data){
        Node  newNode=new Node(data);
        if(head==null){
            head=tail=newNode;
            return ;
        }
        // reach til last node 
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
       
        temp.next=newNode;
        newNode.prev=temp;
        tail=newNode;
        size++;
        
        
    }
  
    public void printDLL(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"<->");
            temp=temp.next;
        }
        System.out.println("null");
    }
    public int removeFirst(){
        // for 0 node
        if(head==null){
            System.out.println("DLL is empty");
            return Integer.MIN_VALUE;
        }
        // for 1 node : after moving head forward to null head.rev=null will give error as null has no prev 
        if(size==1){
            int val=head.data;
            head=tail=null;
            size--;
            return val;
        }
        // for >1 nodes
        int val=head.data;
        head=head.next;
        head.prev=null;
        size--;
        return val;
    }

    public int  removeLast(){
        if(head==null){
            System.out.println("DLL is empty");
            return Integer.MIN_VALUE;
        }
        // for 1 node
        if(size==1){
            int val=head.data;
            head=tail=null;
            size--;
            return val;

        }

        // >1 nodes

        // using tail
        // int val=tail.data;
        // tail=tail.prev;
        // tail.next=null;
        // return val;
        // size--;

        // using head;
        Node temp=head;
        while(temp.next.next!=null){// stop before second last node and free the last node
            temp=temp.next;
        }
        int val=temp.next.data;
        temp.next=null;
        size--;
        return val;

        
    }
    public void reverse(){
        Node curr=head;
        tail=head;// so that after reversing  tail becomes the head;
        Node prev=null;
        while(curr!=null){
            // store next first
            Node front=curr.next;
            curr.next=prev;
            curr.prev=front;// line added for DLL
            // updata curr and prev
            prev=curr;
            curr=front; 
            
        }
        head=prev;
    }
    public static void main(String[] args) {
        DoublyLL dll=new DoublyLL();
        dll.addFirst(3);
        dll.addFirst(2);
        dll.addFirst(1);
        dll.printDLL();
        // dll.removeFirst();
        // dll.printDLL();
        // System.out.println(size);
        // dll.addLast(4);
        // dll.printDLL();
        // System.out.println(size);
        // dll.removeLast();
        // dll.printDLL();
        // System.out.println(size);
        // System.out.println(tail.data);
        // System.out.println(head.data);
        // dll.reverse();
        // dll.printDLL();
        // System.out.println(tail.data);
        // System.out.println(head.data);

        

    }
}
