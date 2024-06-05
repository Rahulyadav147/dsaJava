package backTracking;
public class printPermutation2 {

    public static void print_permutation(String s,String ans){
        if(s.length()==0){
            System.out.println(ans);
            return ;
        }

        for(int i=0;i<s.length();i++){
           // pick the currentcharacter
           char ch=s.charAt(i);
           // delete ch  from original string
           String str=s.substring(0,i)+s.substring(i+1,s.length());
           print_permutation(str, ans+ch);// NOTE: after coming to this call from base case it will go for next ith value of the same string length s for same level
        }
       
    }
    public static void main(String[] args) {
        String s="abc";
        String ans="";
     
        print_permutation(s,ans);
    }
}
