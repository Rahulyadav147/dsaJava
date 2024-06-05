package BitManipulation;

public class fastExponentiation {
    // fast exponentiation:
    public static int powerOf(int a,int b){
        int ans=1;
        while(b>0){// (3)011 -> becomes 001 -> 000 by b=b>>1;
       if((b&1)!=0)ans*=a;//if last bit is 1 
       a=a*a;// for 011 -> last 1 a=a: -> second last 1 a=a*a;
       b=b>>1;// 
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(powerOf(3,3));
    }
    
}
