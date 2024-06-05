package backTracking;
// time complexity O(n*2^n): no of subsets 2^n and each subset takes n time to complete
// space complexity O(n): stack  need to have max of n size at a time
public class printSubsets {
    public static void print_subsets(String s,String ans,int Index){
        if(Index>=s.length()){
            if(ans.length()==0){
                System.out.println("null");
            }
            else{
                System.out.println(ans+" ");
            }
           
            return ;
        }
      
        // including character at index 
        print_subsets(s, ans+s.charAt(Index), Index+1);
        // excluding character at index
        print_subsets(s, ans, Index+1);
        
    }
    public static void main(String[] args) {
        String s="abc";
        String ans="";
        int startIndex=0;
        print_subsets(s,ans,startIndex);
    }
}
