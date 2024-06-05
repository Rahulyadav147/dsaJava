package LinkedList1;

public class LinkedList {

    // defining  the contents of a single node 
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }  
    
    // NOTE: head=null   means head's reference is null i.e. head does not exist
    // or any node=null means it does not exists
    public static Node head;
    public static Node tail;
    static int size;// by defalut  it has value as 0;

    // Add first : TC =O(1)

    public void AddFirst(int data){

        // step1: create new node with given data
        Node newNode=new Node(data);
        size++;
        // if head is null make new Node as head and tail 
        if(head==null){
            head=tail=newNode;
            return ;  // important or else infinite loop while printing
        }

        // step2: newNode next=head (newNode's next points to current head)

        newNode.next=head;//  head is directly accessible as it is in outer class 

        // step3: make newNode as head
        head =newNode;

    }

    // add last TC=O(1)

    public void AddLast(int data){
        // create newNode
          Node newNode=new Node(data);
          size++;
        // if head ==null
        if(head==null){
            head=tail=newNode;
            return ;
        }

        // point tail next to newNode

        tail.next=newNode;
        // make newNode as tail
        tail=newNode;


    }
    
    public void printList(){// no need to pass head as parameter as head is availabe everywhere inside outer class
        if(head==null){
            System.out.println("Linked List is empty");
            return ;
        }
       
            Node temp=head;
            while(temp!=null){  // temp==null means a node next to tail node which has no existence 
                System.out.print(temp.data+"->");
                temp=temp.next;
            } 
            System.out.println("null");
        

    }
    
    // add middle O(N)

    public void addMiddle(int index,int data){

        // create new node 
        Node newNode=new Node(data);
        // for index 0 we need to handle head as well 
        if(index==0){
            AddFirst(data);// used here because in Add First we are changing Head as well which is not done in any other case in AddMiddle function
            return ;
        }
        size++;
        if(head==null){
            head=tail=newNode;
            return ;
        }
        // start Index
        int i=0;
        Node temp=head;
        while(i<index-1){
            temp=temp.next;
            i++;
        }
        newNode.next=temp.next;
        temp.next=newNode;

    }

    // size of LL : Tc=O(n)
    public int sizeOfLL(){
       if(head==null){
        return 0;
       }
       Node temp=head;
       int i=1;
       while(temp.next!=null){// See why code is not working for temp!=null
        temp=temp.next;
        ++i;
       }
       return i;
    }
    
    // remove first
    public int removeFirst(){
        int val=head.data;
        if(size==0){
            System.out.println("linked is empty already");
            return Integer.MIN_VALUE;
        }
        else if(size==1){
         head=tail=null;
         size=0;
         return val;
        }
       
        head=head.next;// main operation
        size--;
        return val;
    }
    
    // remove last
    public int removeLast(){
        int val=head.data;
        if(size==0){
            System.out.println("linked is empty already");
            return Integer.MIN_VALUE;
        }
        else if(size==1){
         head=tail=null;
         size=0;
         return val;
        }
        
        Node temp=head;
        // for(int i=0;i<size-2;i++){
        //     temp=temp.next;
        // }
        // or
        while(temp.next.next!=null){
            temp=temp.next;
        }
        val=temp.next.data;
        temp.next=null;
        size--;
        tail=temp;
        return val;
    }


    // Iterative search

    public int iterativeSearch(int key){
        Node temp=head;
        int i=0;
        while(temp!=null){
            if(temp.data==key){
                return i;
            }
            temp=temp.next;// do not forget this step
            i++;
        }
        return -1;
    }


    // see this code again
    public int helper(Node head,int key){
        if(head==null){
            return -1;
        }
        else if(head.data==key){
            return 0;
        }
        int indx=helper(head.next,key);
        if(indx==-1){
            return -1;
        }
       
            return 1+indx;
        
    }
    public int recursiveSearch(int key){
        return helper(head,key);
       
    
    }

    public void reverseIterative(){
        // need curr and null initially
        Node curr=head;
        Node prev=null;
        while(curr!=null){
            Node front=curr.next;
            curr.next=prev;
            prev=curr;
            curr=front;
        }
        head=prev;
    }


    // this is not the actual approach to solve it see strivers code for the same
    public void reverseRecursive(Node prev,Node head,Node next){
        // if head reaches null reassign head to prev
        if(head==null){
            head=prev;
            return ;
        }
        // get the  front node
        Node front=head.next;   
        // update prev,head,next respectively
        reverseRecursive(head,front,prev);
    }

    public Node reverseRecursive(Node head){
        // for size 0 and 1 
        if(head==null|| head.next==null){
            return head;
        }
        // get newHead value from base case recursively()
        Node newHead= reverseRecursive(head.next);
        // kaam (these steps performed after coming from base case as it is written below recursive call)
        // head is at last second node after returning from base case
        Node front =head.next;
        // reversing the link of linked list
        front.next=head; // for the above 2 lines we can replace: head.next.next = head; head.next will point to node which is pointing to null backward which will next point to curr head backward
        head.next=null;// this will not effect last third node's head that will still point to next node in forward direction

        return newHead;
    }

    public void delete(int n){
        int x=size;
        int posFromFront=x-n;// taking starting index as 0
        Node temp=head;
       for(int i=0;i<posFromFront-1;i++){// i<posFromFront-1 because for 0 also inner loop runs ones
        temp=temp.next;
       }
       temp.next=temp.next.next;
    }
    // Find middle of linked list
    public Node middle(){
        Node fast=head;
        Node slow=head;
        while(fast != null &&fast.next != null){// fast will stop at last node for odd and at null for even 
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }

    public boolean checkPalindrome(){
        if (head == null || head.next == null) {
        return true; // A list with 0 or 1 element is always a palindrome
    }
        // // finding the middle node
        Node mid=middle();
        // reversing from middle and getting the newHead as last node
        Node newHead=reverseRecursive(mid);
        // checking for palindrome by comparing last and first node 
    
        while(newHead!=null){
            if(head.data!=newHead.data){
                return false;
            }
            head=head.next;
            newHead=newHead.next;
        }
        return true;

    }


    // detect cycle  Floyd's Cycle Finding Algorithm
    public boolean detectCycle(){
        Node slow=head;
        Node fast=head;
        // traverse through entire LL  for odd and even case both 
        while(fast!=null&& fast.next!=null){
              slow=slow.next;
              fast=fast.next.next;
              // after moving one step forward only we check as in starting both will be at head node 
              if(slow==fast){
                return true;
              }
        }
        return false;

    }

    void removeCycle(){
        //Step1: detect cycle
        Node slow =head;
        Node fast=head;
        while(fast!=null&& fast.next!=null){
            slow=slow.next;// +1
            fast=fast.next.next;//+2
             if(slow==fast){
                break;
             }
        }

       // Step2: point slow to head
       slow=head;
       // move slow and fast by +1 and track prev of fast
       Node prev=null;
       while(slow!=fast){
        slow=slow.next;//+1
        prev=fast;
        fast=fast.next;//+1
       }
       // point prev to null to remove cycle
       prev.next=null;

    }
   
    // merge for mergeSort
    public Node merge(Node left,Node right){
        Node mergedLL= new Node(-1);
        // using temp variable to traverse mergedLL
        Node temp=mergedLL;
        // merging both LL left and right
        while(left!=null&&right!=null){
            if(left.data<=right.data){
               temp.next=left;
               temp=temp.next;
               left=left.next;
            }
            else{
                temp.next=right;
                temp=temp.next;
                right=right.next;
            }
        }
        // if some nodes are still left
        while(left!=null){
            temp.next=left;
            temp=temp.next;
            left=left.next; 
        }
        while(right!=null){
            temp.next=right;
            temp=temp.next;
            right=right.next;
        }
        // making mergedLL.next as head;
        return mergedLL.next;


    }
    public Node getMid(Node head){
        Node slow=head;
        Node fast=head.next;// to handle the even case to get mid as last node of first half
        
        while(fast!=null&&fast.next!=null){
           fast= fast.next.next;
           slow=slow.next;
        }
      
        return slow;
    }
    public Node mergeSort(Node head){
        if(head!=null&&head.next==null){
            return head;
        }
        // call mergesort for half with mid in first half
        // find mid
        Node mid=getMid(head);
        
        
        // Now we need to divide linked list in two parts for mergeSort and then merge
        Node right=mid.next;
        // first half
        // create first half by making mid.next=null
        mid.next=null;

       Node newleft= mergeSort(head);
        // second half
    
        Node newright= mergeSort(right);
        // call merge function
        return  merge(newleft,newright);


        
    }

    public Node zigZag(Node head){
        // step1: get mid as last node of first half  1,2,3 : mid=2
        Node slow=head;
        Node fast=head.next;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }  
        Node mid=slow;
        // reverse the Linked list at mid (mid in fist half and mid.next in second half): 
        Node midNext=mid.next;// later half part to be reversed
        mid.next=null;// creating first half part

        // Step2:  reversing  second half and getting two LL with endNode as null
        Node curr=midNext;
        Node prev=null;
        while(curr!=null){
            // store front
            Node front=curr.next;
            // point currhead to prev
            curr.next=prev;
            // update prev and curr
            prev=curr;
            curr=front;
        }
        Node rightHead=prev;
        Node leftHead=head;

        // Step3 : creating LL in zigzag fashion
        
        // Storing in tempRight and left because we need to return leftHead in last
         Node tempRight=rightHead;
         Node tempLeft=leftHead;
         while(tempLeft!=null &&tempRight!=null){
            // joining first node to last and last to first.next 
            Node frontLeft=tempLeft.next;// storing next  for updation
            tempLeft.next=tempRight;
            Node frontRight=tempRight.next;// storing next  for updation
            tempRight.next=frontLeft;
            // updating tempLeft and tempRight
            tempLeft=frontLeft;
            tempRight=frontRight;
         }
         
        return leftHead;

    }
    public static void main(String args[]){
    // Note: In main function we can call static functions only directly unlike functions of LL which are called uisng LL object 
    LinkedList ll=new LinkedList();
    ll.printList();
    ll.AddFirst(1);
    ll.printList();
    ll.AddFirst(9);
    ll.printList();
    // ll.AddFirst(3);
    ll.printList();
    ll.AddFirst(4);
   
    ll.printList();
    ll.AddFirst(8);
    ll.printList();
    ll.AddFirst(5);
    ll.printList();
    
    // ll.AddLast(2);
    // ll.printList();

    // ll.addMiddle(2,7);
    // ll.printList();
    // System.out.println("size of LL is:"+size);
    // System.out.println("size of  LL is: "+ ll.sizeOfLL());
    // System.out.println();
    // int value=ll.removeFirst();
    // System.out.println("removed vlaue is:"+ value);
    // ll.printList();
    // int value1=ll.removeLast();
    // System.out.println("removed vlaue is:"+ value1);
    // ll.printList();
    
    // int keyIndex=ll.iterativeSearch(3);
    // System.out.println("Key is present at index:"+ keyIndex);
     
    // int keyIndex1=ll.recursiveSearch(3);
    // System.out.println("Key is present at index:"+ keyIndex1);
    // reverse a linked list
    // ll.reverseIterative();
    // ll.printList();
    
    // ll.reverseRecursive(null,head,head.next);
    
    // ll.printList( );
    // ll.reverseRecursive(head);
    
    // ll.printList( );
    // // find and remove nth node from end
    // ll.delete(2);
    // ll.printList();
    // if(ll.checkPalindrome()){
    //     System.out.println("LL is a palindrome");
    // }
    // else{
    //     System.out.println("LL is not palidnrome");
    // }
    // System.out.println();
    // head=new Node(1);
    // head.next=new Node(2);
    // Node temp=head.next;// pos stored so that we can point to it after last node
    // head.next.next=new Node(3);
    // head.next.next.next=new Node(4);
    // head.next.next.next.next=temp;
    // if(ll.detectCycle()){
    //     System.out.println("Cycle exists");
    // }
    // else{
    //     System.out.println("Cycle does not exists");
    // }
    // ll.removeCycle();
    // if(ll.detectCycle()){
    //     System.out.println("Cycle exists");
    // }
    // else{
    //     System.out.println("Cycle does not exists");
    // }

//    head=ll.mergeSort(head);
//     ll.printList();
 head=ll.zigZag(head);
 ll.printList();


    }
    
    
}
