package Queue;

public class usingArray {
   
    public static class Queue{
       static int arr[];
       static int size;
       static int rear;// front is always fixed to index 0 so need to initialize
       Queue(int n){
           arr=new int[n];// for static fields we need not write this.arr,this.size
           size=n;
           rear=-1;
       }
       public  boolean isEmpty(){
              return rear==-1;
       }                                                       
       public  void add(int data){
        if(rear==size-1){
             System.out.println("Queue is full");
             return ;
        }
        else{
            rear=rear+1;
            arr[rear]=data;

        }
       }
       // this is only function with TCO(n)
       public  int remove(){
        if(rear==-1){
            System.out.println("Queue is empty");
            return -1;
        }
        else{
            int front=arr[0];// remove fron front
            // move all values to 1 index before original to fill front 
            for(int i=0;i<arr.length-1;i++){// <arr.length is wrong// because arr[length-1]=arr[length-1+1]:index out of bound 
                arr[i]=arr[i+1];
            }
            // move rear 1 index back 
            rear=rear-1;
            return front;

        }
       }

    public int peek(){
        if(rear==-1){
            System.out.println("Queue is empty");
            return -1;
        }
        else{
            return arr[0];// peeking means getting element that was inserted first i.e. element at index  0
        }
    }
}

    public static void main(String[] args) {
        Queue q=new Queue(5);// queue of size 5
        q.add(1);// for static method use class name directly to access functions
        q.add(2);
        q.add(3);
        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }

    }
    
}
