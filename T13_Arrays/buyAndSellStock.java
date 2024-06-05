package T13_Arrays;

public class buyAndSellStock {
    public static int maxProfit(int arr[]){
        int mini=arr[0];
        int maxProfit=0;
        for(int i=0;i<arr.length;i++){
            int profit=arr[i]-mini;// current price - min till now 
            maxProfit=Math.max(profit,maxProfit);//max of  current profit  and maxprofit till now;
            mini=Math.min(arr[i],mini);// updating mini compared with current element
        }
        return maxProfit;
    }
    public static void main(String[] args){
     int arr[]={7,1,5,3,6,4};
     int ans=maxProfit(arr);
     System.out.println(ans);
    }
}
