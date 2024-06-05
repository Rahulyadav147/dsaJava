package Queue;

public class circularQueueUsingArray {
   // NOTE: updation of rear and  front is done as: (rear+1)%size ,(front+1)%size to go to 0 after last index: this works for non last element as well
    public static class Queue{
       static int arr[];
       static int size;
       static int rear;
       static int front; // need to initialize front as it moves
       Queue(int n){
           arr=new int[n];// for static fields we need not write this.arr,this.size
           size=n;
           rear=-1;
           front=-1;// front is also  kept -1 in start
       }
       public  boolean isEmpty(){   
            return rear==-1 && front==-1;          
       }    
       public  boolean isFull(){
        return (rear+1)%size==front;// if next to rear front is there
       }                                                   
       public  void add(int data){
        if(isFull()){
             System.out.println("Queue is full");
             return ;
        }
        else{
            // while adding 1st element in queue : we need to update front and rear both 
            // vary IMPORTANT
            if(front==-1){
                front=0;
                rear=0;
                arr[rear]=data;
            }
            else{
            // for other cases we just need to update rear
                rear=(rear+1)%size;
                arr[rear]=data;
            }
           

        }
       }
      
       public  int remove(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }
        else{
            int result=arr[front];// remove fron front
            // if we are removing last element make front and rear point to -1 making queue empty
            if(rear==front){
                rear=front=-1;
            }
            else{
                // if queue has more than one element  update just front 
                front=(front+1)%size;
            }
            
           

            return result;

        }
       }

    public   int peek(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }
        else{
            return arr[front];// peeking means getting element that was inserted first i.e. element at index  0
        }
    }
}

    public static void main(String[] args) {
        Queue q=new Queue(3);// queue of size 5
        q.add(1);// for static method use class name directly to access functions
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
