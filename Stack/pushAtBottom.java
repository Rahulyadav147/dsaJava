package Stack;
import java.util.Stack;
public class pushAtBottom {
    public  static void pushBottom(Stack <Integer>s,int data){
        // when stack is empty push the given data 
                 if(s.isEmpty()){
                    s.push(data);
                    return ;
                 }
                 // while going down the recursion tree store val so that we can push back while recursion backtracks 
                 int val=s.pop();
                
                 pushBottom(s,data);
                 s.push(val);
    }
    public static void main(String[] args) {
        Stack<Integer> s=new Stack<>();
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        pushBottom(s,1);
        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }
        
                

    }
}
