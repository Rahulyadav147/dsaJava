package ArrayLIst;
import java.util.ArrayList;
import java.util.Collections;
public class BasicOperations {

    public static void swap(ArrayList<Integer>list,int index1,int index2){
         int temp=list.get(index1);
         list.set(index1,list.get(index2));
         list.set(index2,temp);
    }
    public static void main(String[] args) {
        
    // ArrayList<Integer>list=new ArrayList<>();
    // Integer->String,Boolean,Character,Byte,Short,Long,Double,Float etc;

    ArrayList<Integer>list=new ArrayList<>();
    // ArrayList<String>list1=new ArrayList<>();
    // ArrayList<Boolean>list2=new ArrayList<>();
    // ArrayList<Character>list3=new ArrayList<>();
    // ArrayList<Byte>list4=new ArrayList<>();
    // ArrayList<Short>list5=new ArrayList<>();
    // ArrayList<Long>list6=new ArrayList<>();
    // ArrayList<Double>list7=new ArrayList<>();
    // ArrayList<Float>list8=new ArrayList<>();

    // Add operation: adds element in last 
    list.add(1);  
    list.add(2);
    System.out.println(list);

    list.add(1,3);// adds element at index and shifts curr element to index+1
    System.out.println(list);

    list.add(4);
    System.out.println(list);
    // Remove operation: removes element from index
    list.remove(3);
    System.out.println(list);
    // Get element at index 
    System.out.println(list.get(2));
    System.out.println(list);
    
    // Set element at index by replacing the element at index
    list.set(2,5);
    System.out.println(list);

    // size of list
    System.out.println(list.size());

    // using for loop to iterate
    for(int i=0;i<list.size();i++){
        System.out.print(list.get(i)+" ");
    }
     System.out.println();
    // printReverse
    for(int i=list.size()-1;i>=0;i--){
        System.out.print(list.get(i)+" ");
    }
     System.out.println();
    
     // find max
     int max=Integer.MIN_VALUE;
    for(int i=list.size()-1;i>=0;i--){
        max=Math.max(max,list.get(i));
    }
     System.out.println(max);
     

     // swap two numbers
     int index1=0;
     int index2=2;
     System.out.println("Before swapping"+list);
     swap(list,index1,index2);
    System.out.println("After swapping"+list);

    // sorting 
    Collections.sort(list);
    // Collections.sort(list,Comparator);  : comparator define the functino logic : ex: we can use to sort strings lexicographic order wise
    Collections.sort(list,Collections.reverseOrder());



    
    }
}
