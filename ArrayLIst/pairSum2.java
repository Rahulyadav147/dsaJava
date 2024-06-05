package ArrayLIst;
import java.util.ArrayList;
public class pairSum2 {

    public static String pairSum(ArrayList<Integer>list,int targetSum){
            // two pointer approach
            int n=list.size();
            if(list.size()<=1){
                return "No";
            }
            // finding the breakpoint
            int breakPoint=-1;
            for(int i=0;i<list.size()-1;i++){
                if(list.get(i)>list.get(i+1)){
                    breakPoint=i;
                }
            }
            int s=breakPoint+1,e=breakPoint;
            while(s!=e){
                if(list.get(s)+list.get(e)==targetSum){
                    System.out.println("index "+s+" and "+e);
                    return "Yes";
                }
                if(list.get(s)+list.get(e)<targetSum){
                    // if(s==list.size()-1){
                    //     s=0;
                    // }
                    // else{
                    //     s++;
                    // }
                    s=(s+1)%n;
                   
                }
                else{
                    // if(e==0){
                    //     e=list.size()-1;
                    // }
                    // else{
                    //     e--;
                    // }
                    e=(n+e-1)%n;
                  
                }

            }

            return "No";
    }
    public static void main(String[] args) {
          ArrayList<Integer>list=new ArrayList<>();
        
          list.add(11);
          list.add(15);
          list.add(6);
          list.add(8);
          list.add(9);
          list.add(10);
  
          int target = 16;
  
          System.out.println(pairSum(list, target));
    }
}
