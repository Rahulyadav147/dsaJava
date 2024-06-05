package T14SortingAlgo;

public class Counting_sort {

    public static void counting_sort(int arr[]){
        // creating the count arr for the length of max element of arr
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }
        // creating the count arr for the length of max element of arr
        int count[]=new int[max+1];
        // putting element in count array with the elements of original array
        for(int i=0;i<arr.length;i++){
            count[arr[i]]++;// going to 
        }
        
        // filling the elements in origianl array from count array
        int j=0;
      for(int i=0;i<count.length;i++){
          // till count[i] has value greater then zero 
          // if count[i]==0 it will autmatically move to next iteration
          while(count[i]>0){
              // fill arr[j] or j,j+1,j+2 as count[i] till count[i]==0
            //   arr[j]=count[i];   wrong
                arr[j]=i;
              j++;
              count[i]--;
          }
      }
        
    }
    public static void main(String[] args) {
       int arr[]={2,3,6,1,7,3,8};
       counting_sort(arr);
       for(int i=0;i<arr.length;i++){
           System.out.print(arr[i]+" ");
       }
    }
}
