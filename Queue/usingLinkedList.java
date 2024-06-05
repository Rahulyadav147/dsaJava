package Queue;

public class usingLinkedList {
    public static class Node{
                int data;
                Node next;
                Node(int data){
                    this.data=data;
                    this.next=null;
                }
    }
    

    public static class Queue{
              public static Node head=null;
              public static Node tail=null;
              public  boolean isEmpty(){
                return head==null&&tail==null;
              }

              public  void add(int data){
                // this queue never gets full as it linked list so need to check for overflow
                Node newNode=new Node(data);
                if(isEmpty()){
                    head=tail=newNode;
                    return ;
                }
                else{
                    // we add from rear in queue : i.e. fronm tail
                    tail.next=newNode;
                    tail=newNode;// update tail to newNode
                }
              }

              public  int remove(){
                // if queue is empty
                if(isEmpty()){
                    System.out.println("Queue is empty");
                    return -1;
                }
                
                int front=head.data;
                 if(head==tail){// there is only one elment 
                    head=tail=null;
                    
                }
                else{// for more than 1 elements 
                    head=head.next;
                }
                return front;
              }

              public int peek(){
                if(isEmpty()){
                    System.out.println("Queue is empty");
                    return -1;
                }
                else{
                  return  head.data;
                }

              }
            }
              public static void main(String[] args) {
                Queue q=new Queue();
                q.add(1);
                q.add(2);
                q.add(3);
                System.out.println(q.remove());
                q.add(4);
                System.out.println(q.remove());
                q.add(5);
                while(!q.isEmpty()){
                    System.out.println(q.peek());
                    q.remove();
                }
              }

    }

