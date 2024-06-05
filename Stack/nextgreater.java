package Stack;
import java.util.Stack;
public class nextgreater {
    public static void nextGreater(int arr[],int ans[]){
        Stack<Integer> st=new Stack< >();
        for(int i=arr.length-1;i>=0;i--){
            // step 1: till element at top smaller than arr element from last pop 
            while(!st.isEmpty()&&st.peek()<=arr[i]){
                st.pop();
            }
            // step 2: check what to insert in ans array
            if(st.isEmpty()){// if stack is empty : no next element is greater
                ans[i]=-1;
            }
            else{// top element in stack is next greater
                ans[i]=st.peek();
            }
            // step3:// push current element for previous elements to evaluate its next greater
            st.push(arr[i]);



        }
    }
    public static void main(String[] args) {
        int arr[]={6,8,0,1,3};
        int ans[]=new int[arr.length];
        nextGreater(arr,ans);
        for(int i=0;i<arr.length;i++){
            System.out.print(ans[i]+" ");
        }

        // Variations of the same question

        //1: next greater right: done 
        //2:next greater left: change: for(int i=0;i<arr.length;i++)
        //3: next Smaller Right: change:in same code =>while(!st.isEmpty()&&st.peek()>=arr[i])
        //4: next Smaller left: change: in second variatoin:=>while(!st.isEmpty()&&st.peek()>=arr[i])
    }
}
