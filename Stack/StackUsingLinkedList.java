package Stack;

public class StackUsingLinkedList {
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static class Stack{

        public static Node head;
        public static int size;
    
        public  boolean isEmpty(){
            return head==null;
        }
        // add data at head position and move head to newData 
        public void push(int data){
            Node newNode=new Node(data);
            if(head==null){
                head=newNode;
                return ;
            }
            // >=1 nodes
            newNode.next=head;
            head=newNode;
            size++;
    
        }
        // remove data from head and move head forward 
        public int pop(){
            if(head==null){
                System.out.println("Stack is empty");
                return -1;
            }
            // >=1
            int val=head.data;
            head=head.next;
            size--;
            return val;
        }
    
        public int peek(){
            if(head==null){
                System.out.println("Stack is empty");
                return -1;
            }
            // >=1 nodes
            return head.data;
        }
    }
    public static void main(String[] args) {
        Stack st=new Stack();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        while(!st.isEmpty()){
            System.out.println(st.peek());
            st.pop();
        }
    }
}
