package Stack;
import java.util.ArrayList;
import java.util.Stack;
public class StockSpan {
    // // using ArrayList or array  TC:O(n^2)  SC: O(n)

    // public static ArrayList<Integer> stockSpan1(ArrayList<Integer> l){//  Note:  return type is ArrayList<Integer> not ArrayList 
    //     ArrayList<Integer> newL=new ArrayList<>();
    //     // traverse to any element 
    //     for(int i=0;i<l.size();i++){
    //         int cnt=0;
    //         int j=i;
    //         // including element traverse till first element and break at higher stock
    //         for(j=i;j>=0;j--){
    //            if(l.get(j)>l.get(i)){
    //             break;
    //            }
    //            cnt++;
    //         }
    //      newL.add(cnt);

    //     }
    //     return newL;
    // }


    // using arraylist and stack: TC:O(n)   
    // keep index of prev element that is higher than the curr : if lesser pop it : insert the curr index

    public static ArrayList<Integer> stockSpan2(ArrayList<Integer> l){
        Stack<Integer> st=new Stack<>();
        ArrayList<Integer> newL=new ArrayList<>();
        st.push(0);// index of first element by default
        for(int i=0;i<l.size();i++){   
            int currElement=l.get(i);
            while(!st.isEmpty()&& currElement>=l.get(st.peek())){// till curr element is greater >= element at top of stack : pop
                st.pop();
            }
            if(st.isEmpty()){
                newL.add(i,i+1);
                if(i==0)st.push(0);// only for 1st element as when popped it nee
            }
            else{
                newL.add(i,i-st.peek());
            }
            st.push(i);

        }
        return newL;
    }
  
    // using array and stack TC: O(n)
    public static void stockSpan(int stocks[]) {
        Stack<Integer> s = new Stack<>();
        int span[] = new int[stocks.length];
        span[0] = 1;
        s.push(0);
        
        for(int i=1; i<stocks.length; i++) {
            int curr = stocks[i];
            while(!s.isEmpty() && curr >= stocks[s.peek()]) {
                s.pop();
            }
            if(s.isEmpty()) {
                span[i] = i+1;
            } else {
                int prevHigh = s.peek();
                span[i] = i - prevHigh;
            }
             
            s.push(i);
        }

        for(int i=0; i<span.length; i++) {
            System.out.print(span[i]+" ");
        }
    }
     public static void main(String[] args) {
        ArrayList<Integer>l=new ArrayList<>();
        l.add(100);
        l.add(80);
        l.add(60);
        l.add(70);
        l.add(60);
        l.add(85);
        l.add(100);
        // ArrayList<Integer>l1=stockSpan1(l);
        // System.out.println(l1);
        

        
       // using stack
        ArrayList<Integer>l2=stockSpan2(l);
        System.out.println(l2);

        int stocks[] = {100, 80, 60, 70, 60, 85, 100};
        stockSpan(stocks);

    }
}
