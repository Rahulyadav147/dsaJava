package ArrayLIst;
import java.util.*;
import java.util.ArrayList;

public class containerWithMostWater {

    public static int maxWater(ArrayList<Integer>list){
        // brute force : O(n^2)
        // int max=Integer.MIN_VALUE;
        // for(int i=0;i<list.size();i++){
        //     for(int j=i+1;j<list.size();j++){
        //         int hight=Math.min(list.get(i),list.get(j));
        //         int width=j-1;
        //         int water=hight*width;
        //         max=Math.max(max,water);
        //     }
        // }
        // return max;


        // optimised : O(n) 2 pointer
         int maxwater=Integer.MIN_VALUE;
         int s=0,e=list.size()-1;
         while(s<e){
            int hight=Math.min(list.get(s),list.get(e));
            int width=e-s;
            int water=hight*width;
            maxwater=Math.max(maxwater,water);
             if(list.get(s)<list.get(e)){
                s++;
             }
             else{
                e--;
             }

         }
         return maxwater;
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        ArrayList<Integer>list=new ArrayList<>();
        for(int i=0;i<9;i++){
            list.add(sc.nextInt());
        }
        System.out.println(maxWater(list));
        sc.close();
    }
}
