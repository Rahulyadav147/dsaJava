package T13_Arrays;
// using Prefix Sum
public class maxSubarraySum {
    public static void prefixSum(int num[]) {

        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;

        // here PREFIX ARRAY means cummulative added array

        int prefix[] = new int[num.length];

        // creating prefix array

        prefix[0] = num[0];

        for (int i = 1; i < prefix.length; i++) {

            prefix[i] = prefix[i - 1] + num[i];

        }

        for (int i = 0; i < num.length; i++) {

            int start = i;
            currSum = 0;
            for (int j = i; j < num.length; j++) {

                int end = j;

                // Ternary operator is used below

                currSum = start == 0 ? prefix[end] : prefix[end] - prefix[start - 1];
                System.out.print(currSum);

                if (currSum > maxSum) {
                    maxSum = currSum;
                }
                System.out.println();

            }
            System.out.println();

        }
        System.out.println("Max sum of a sub Array is : " + maxSum);

    }

    // kadane's algo to find and print maxsum subarray:
    public static void kadanes( int num []){

        int currSum = 0;
        int maxSum  = Integer.MIN_VALUE;

        for (int i = 0; i < num.length; i++) {

            currSum = currSum + num[i];
            if (currSum < 0){
                currSum = 0;
            }
            maxSum = Math.max(currSum , maxSum);
            System.out.println(maxSum);
        }
        System.out.println("Max sum is : " + maxSum);
    }
    public static void main(String[] args){
    int arr[]={8,-5,6,-8,15};
    prefixSum(arr);
    kadanes(arr);
    }
}
