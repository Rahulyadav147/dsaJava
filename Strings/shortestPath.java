package Strings;
public class shortestPath {
    public static float shortest_path(String s){
              int x=0,y=0;
              for(int i=0;i<s.length();i++){
                if(s.charAt(i)=='S')y--;
                else if(s.charAt(i)=='N')y++;
                else if(s.charAt(i)=='W')x--;
                else x++;
              }
              int  X=x*x;
              int  Y=y*y;
              return (float)Math.sqrt(X+Y);
              
    }
    public static void main(String[] args) {
        String s="SNN";
        System.out.println(shortest_path(s));
    }
    
}
