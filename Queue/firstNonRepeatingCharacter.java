package Queue;
import java.util.Queue;
import java.util.LinkedList;
public class firstNonRepeatingCharacter {
    public static void first_non_repeating_character(String s){
        Queue<Character>q=new LinkedList<>();    
        int freqArr[]=new int[26];
        // steps to perform 
        // step1: take character  from s string
        // step2: increase its frequency by 1
        // push character in queue
        //check front in queue (if its frequency >1)remove it from queue(keep removing till element with <=1 frequency obtained)  
       for(int i=0;i<s.length();i++){
        char ch=s.charAt(i);
        q.add(ch);
        freqArr[ch-'a']++;
        while(!q.isEmpty()&&freqArr[q.peek()-'a']>1){// frequency of first element in queue is greater than 1 
            q.remove();// this is performed on queue so no need to do i++ as you did idiot 
        }
        // after exiting while loop 2 conditions will be there
        if(q.isEmpty()){// 1: q is empty
            System.out.print(-1+" ");
        }
        else{// 2: first element in queue has frequency 1
            System.out.print(q.peek()+" ");// print the element
        }
       }
       System.out.println();   
    }
    public static void main(String[] args) {
        String s="aabccxb";
       first_non_repeating_character(s);
    }
}
