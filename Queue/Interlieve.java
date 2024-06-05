package Queue;
import java.util.*;
public class Interlieve {
    // TC: O(N) : SC: O(n)
     public static void interlieve(Queue<Integer>q){
      
        Queue<Integer>newq=new LinkedList<>();
        
        int n=q.size();
        // put half elements from q to new q
        for(int i=0;i<n/2;i++){
            newq.add(q.remove());
        }
        // keep adding elements at the back of q fromt both the queues 
        while(!newq.isEmpty()){
            q.add(newq.remove());
            q.add(q.remove());
        }
        
      
     }
    public static void main(String[] args) {
      
        Queue<Integer> q=new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);
        interlieve(q);
        while(!q.isEmpty()){
            System.out.print(q.remove()+" ");
        }
    }
    
}
