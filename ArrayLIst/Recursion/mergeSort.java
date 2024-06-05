package Recursion;

public class mergeSort {
    public static void merge(int arr[],int low,int mid,int high){
        int temp[]=new int[arr.length];
        int  left=low;
        int right=mid+1;
        // traverse each subarray till end of any one
        int i=0;
        while(left<=mid&&right<=high){
                if(arr[left]<=arr[right]){
                    temp[i]=arr[left];
                    i++;
                    left++;
                }
                else{
                    temp[i]=arr[right];
                    i++;
                    right++;
                }
        }
        // check if left still has reached mid or not
        while(left<=mid){
            temp[i]=arr[left];
            i++;
            left++;
        }
        // check if right still has reached hight or  not 
        while(right<=high){
            temp[i]=arr[right];
            i++;
            right++;
        }
            
           // copy tempt to arr    this is the only area where i made error (be careful)
           // This is because the elements in the temporary array are shifted by 'low' positions compared to the original array.
         
           for(int j=low;j<=high;j++){
            arr[j]=temp[j-low];// temp[low-low],temp[low+1-low]....-> temp[0],temp[1]....
           }

        //    do not use like this becuase arr.length is 9 but we may try to merge only samller parts down the order 
        // for(int i=0;i<arr.length;i++){
        //     arr[i]=temp[i];
        // }

    }
 
    public static void mergesort(int arr[],int low,int high){
        if(low>=high){
            return;
        }
        int mid=(low+high)/2;
        mergesort(arr,low,mid);
        mergesort(arr, mid+1, high);
        merge(arr,low,mid,high);
    }
    public static void main(String[] args) {
        int arr[]={3,5,2,8,1};
        mergesort(arr,0,arr.length-1);
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
