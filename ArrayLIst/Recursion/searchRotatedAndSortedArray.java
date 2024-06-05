package Recursion;

public class searchRotatedAndSortedArray {
    public static int search(int[] arr,int key,int low,int high){
                  if(low>high){
                    return -1;
                  }
                  int mid=low+(high-low)/2;
                  if(key==arr[mid]){
                    return mid;
                  }
                 
                  // if on line 1
                  if(arr[mid]>=arr[low]){
                    if(key<=arr[mid]&&key>=arr[low]){
                        // case a: left of line 1
                        return  search(arr, key, low, mid-1);// mid-1 because mid is already returned
                     }
                     else{
                        // case b: right  of line 1 and line b (draw diagram)
                       return search(arr, key, mid+1, high);
                     }
                  }
                 
                  // if on line 2
                 else{
                  // case c: on the right of line 2 
                    if(key>=arr[mid]&&key<=arr[high]){
                        return search(arr, key, mid+1, high);
                    }
                    else{
                      // on the left of line 2 (including line 1 as well)
                      return search(arr, key, low, mid-1);
                    }
                 }
                
                
                 
    }
    public static void main(String[] args) {
        int arr[]= {4,5,6,7,0,1,2};
        System.out.println("Key is at Index: "+search(arr,1,0,arr.length-1));
    }
}
