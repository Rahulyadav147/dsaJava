package T13_Arrays;

public class binarySearch {
    public static boolean binary_Search(int arr[],int key){
        int s=0,e=arr.length-1;
        while(s<=e){
            int mid=s+(e-s)/2;
            if(key==arr[mid])return true;
            else if(key<arr[mid])e=mid-1;
            else s=mid+1;
        }
        return false;
    }
    public static void main(String[] args) {
        int arr[]={2,3,4,5,6,8};
        int key=6;
        if(binary_Search(arr,key)){
            System.out.print("Key is present");
        }
        else{
            System.out.print("key is not present");
        }
    }
}


