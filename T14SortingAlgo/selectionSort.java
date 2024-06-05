package T14SortingAlgo;

public class selectionSort {
    public static void SelectionSort(int arr[]){
        for(int i=0;i<arr.length;i++){
            int minPos=i;
            for(int j=i+1;j<arr.length;j++){
                 //for making it reverse sort just change the below inequlaties
                // < , >
                if(arr[j]<arr[minPos])minPos=j;// note:arr[j] compared with arr[minPos] not arr[i]
            }
            int temp=arr[i];
            arr[i]=arr[minPos];
            arr[minPos]=temp;
            }

        }

        public static void main(String[] args){
        int arr[]={4,1,6,3,8,2};
        SelectionSort(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        }
    }
    

