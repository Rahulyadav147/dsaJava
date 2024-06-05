package Stack;

import java.util.Stack;

public class maxAreaHistogram {
   // Note we need to push indexes in stack instead of arr elements because in ansArray we need indexes(leftsmaller and rightsmaller ) to calulate the width
    public static int maxArea(int [] arr){
        int maxArea=0;
        int nsr[]=new int[arr.length];
        int nsl[]=new int[arr.length];
        // next Smaller right
        Stack<Integer> st=new Stack< >();
        for(int i=arr.length-1;i>=0;i--){
           
            while(!st.isEmpty()&&arr[st.peek()]>=arr[i]){
                st.pop();
            }
            
            if(st.isEmpty()){
                // if stack empty : next smaller not there 
                nsr[i]=arr.length;
            }
            else{
                nsr[i]=st.peek();
            }
            st.push(i);



        }

        st=new Stack< >();// make stack empty

        // next smaller left
        for(int i=0;i<arr.length;i++){
           
            while(!st.isEmpty()&&arr[st.peek()]>=arr[i]){
                st.pop();
            }
           
            if(st.isEmpty()){
                nsl[i]=arr.length;
            }
            else{
                nsl[i]=st.peek();
            }
           
            st.push(i);



        }
        
        
        
        
        for(int i=0;i<arr.length;i++){
            int height=arr[i];
            int width=nsr[i]-nsl[i]-1;
            int currArea=height*width;
            maxArea=Math.max(maxArea,currArea);
        }
        return maxArea;


    }
    public static void main(String[] args) {
        int arr[]={2,1,5,6,2,3};
        System.out.println(maxArea(arr));
    }
}
