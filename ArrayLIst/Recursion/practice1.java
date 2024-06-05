package Recursion;

public class practice1 {

    public static boolean isSorted(int arr[],int i){
        // base case
        if(i>=arr.length-1)return true;
        // ek case solve kar do
        if(arr[i]>arr[i+1])return false;
        // baki recursion sambhal lega
        return isSorted(arr, i+1);
       }   

       public static int binarSerach(int arr[],int s,int e,int target){
             // base case
             if(s>e)return -1;
             // processing 
             int mid=s+(e-s)/2;
             if(target==arr[mid])return mid;
   
             // recursive function:
             if(target<arr[mid]){
                return  binarSerach(arr, s, mid-1, target);
             }
             else{
                return binarSerach(arr, mid+1, e, target);
             }
       }

       // inclusion exclusion:
       public static void printSubsequence(String str,StringBuilder output,int i){
        // base case
           if(i>=str.length()){
            System.out.println(output);
            return;
           }
           // processing : 
            // include string 
            output.append(str.charAt(i));
            printSubsequence(str, output, i+1);
           // exclude string first(same as previous)
           output.deleteCharAt(output.length()-1);
           printSubsequence(str, output, i+1);
           
          
           
       }


       // use for loop for each subproblem
          public static int coinChange(int arr[],int target){
            
            if(target==0)return 0;
            if(target<0)return Integer.MAX_VALUE;
            int mini=Integer.MAX_VALUE;
            for(int i=0;i<arr.length;i++){
                    int ans=coinChange(arr, target-arr[i]);
                    if(ans!=Integer.MAX_VALUE){
                       mini=Math.min(mini,ans+1);
                }
            }
            return mini;
           
            // java ki ma ki aankh ki wajah se likhana pad raha ye line no sense
          }
          public static int maximumSegment(int segLength,int x,int y,int z){
            if(segLength==0){
               return 0;
            }
            if(segLength<0){
               return Integer.MIN_VALUE;
            }
            int a=maximumSegment(segLength-x, x, y, z)+1;
            int b=maximumSegment(segLength-y, x, y, z)+1;
            int c=maximumSegment(segLength-z, x, y, z)+1;
            return Math.max(a,Math.max(b,c));
          }
          public static int maxNonContguousSum(int arr[],int sum,int i){
            if(i>=arr.length){
               return sum;
            }
            // include
            int ans1=maxNonContguousSum(arr, sum+arr[i], i+2);
            // exclude
            int ans2=maxNonContguousSum(arr, sum, i+1);
            return Math.max(ans1,ans2);

          }

         //  public static void lastOccurence(String s,char ch,int ans,int i){
         //    if(i>=s.length()){
         //       System.out.println(ans);
         //       return ;
         //    }
         //    if(s.charAt(i)==ch){
         //       lastOccurence(s, ch, i, i+1);
         //    }
         //    else{
         //       lastOccurence(s, ch, ans, i+1);
         //    }
         //  }


           public static void lastOccurence(String s,char ch,int i,int lastSeen[]){
            
            if(i>=s.length()){
               
               return ;
            }
            
            if(s.charAt(i)==ch){
               lastSeen[0]=i;
             // base case returns answer here 
            }
            lastOccurence(s, ch, i+1,lastSeen);
            
            
           
          }
        public static void main(String[] args) {
        int arr[]={1,2,3,4,5};
        System.out.println(isSorted(arr,0));
        System.out.println();
        System.out.println(binarSerach(arr, 0, arr.length-1, 5));
        System.out.println();
        String str="ab";
        StringBuilder output=new StringBuilder("");
        printSubsequence(str,output,0);
        int array[]={1,2};
        int target=3;
        System.out.println(coinChange(array,target));
        int ans=maximumSegment(7,3,8,5);
        if(ans<0)System.out.println(0);
        else{
         System.out.println(ans);
        }
        System.out.println();
        int arr1[]={2,1,6,5};
        int sum=0;
        System.out.println(maxNonContguousSum(arr1,sum,0));


        // to implement pass by reference in java we need to use integer or character array  as java has no pass by value concept
        String s="abcdada";
        char ch='a';
        int answer[]=new int [4];
        answer[0]=-1;
        int i=0;
      //   lastOccurence(s,ch,answer,i);
        lastOccurence(s,ch,i,answer);
        System.out.println(answer[0]);
        

    }

}
