package T13_Arrays;

public class trappingRainWater {

    public static int maxWater(int arr[]){
        int n=arr.length;
        int leftMax[]=new int[n];// to store the max left bar from the current index
        int rightMax[]=new int[n];//to store the max left bar from the current index
        int max=0;
        for(int i=0;i<n;i++){
            if(arr[i]>max){
                max=arr[i];
            }
            leftMax[i]=max; 
        }
        int max2=0;
        for(int i=n-1;i>=0;i--){
            if(arr[i]>max2)max2=arr[i];
            rightMax[i]=max2;
        }
          int trappedWater=0;
        for(int i=0;i<n;i++){
            int waterHeight=Math.min(leftMax[i],rightMax[i])-arr[i];// current water height at that index
            trappedWater+=waterHeight;// total water stored 
        }
      return trappedWater;
    }
    public static void main (String[] args){
int arr[]={5,1,8,2,6};
int ans=maxWater(arr);
System.out.println(ans);
    }
}
