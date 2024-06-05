package ArrayLIst;
import java.util.ArrayList;
public class pairSum1 {

    public static String pairSum(ArrayList<Integer>list,int targetSum){
            // two pointer approach
            int s=0,e=list.size()-1;
            while(s<e){
                if(list.get(s)+list.get(e)==targetSum){
                    return "Yes";
                }
                if(list.get(s)+list.get(e)<targetSum){
                   s++;
                }
                else{
                   e--;
                }

            }

            return "No";
    }
    public static void main(String[] args) {
          ArrayList<Integer>list=new ArrayList<>();
         list.add(1);
         list.add(2);
         list.add(3);
         list.add(4);
         list.add(5);
         list.add(6);
         list.add(7);
         int sum=10;
         System.out.println("sum "+sum+" is possible or not: "+ pairSum(list,sum));
    }
}
