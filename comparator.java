import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;
// NOTE: If we return 1 it means swap and -1 means no swap: 
public class comparator {
    
//class Student implements Comparable<Student>
 static class Student
{
	int age;
	String name;
	
	public Student(int age, String name)
	{
		this.age=age;
		this.name=name;
	}
	
	public String toString() {
		return "Student [age=" + age + ", name=" +name +"]";
	}
	
//	public int CompareTo(Student that)
//	{
////		return 0;
//		if(this.age >that.age)
//			return 1;
//		else
//			return -1;
//	}
}
    public static void main(String[] args){   
    	
//    	Comparator<Integer> com=new Comparator<Integer>()
//    	{
//    		public int compare(Integer i,Integer j)// takes wrapper classes or classes only : i.e. objects no primitive dataTypes
//    		{
//    			if(i%10 >j%10)
//    				return 1;// if you want to sort it acc to condition return 1
//    			else
//    				return -1;
//    		}
//    	};	
    	
//    	List<Integer> nums= new ArrayList<>();
//    	nums.add(43);
//    	nums.add(31);
//    	nums.add(72);
//    	nums.add(29);
    	
//    	Comparator<Student> com=new Comparator<Student>()
//    	{
//    		public int compare(Student i,Student j)
//    		{
//    			if(i.age >j.age)
//    				return 1;
//    			else
//    				return -1;
//    		}
//    	};	
    	
    	Comparator<Student> com=(i,j) -> i.age > j.age?1:-1;
		// Note: returning 1 means the sort function places 1st(i) element after 2nd(j) element :-1 means 1st element comes before 2nd element 
     	// So if you want to sort in ascending order : 
		// i.age>j.age  : (i.e. i > j): the order should be j,i for ascending so return 1 because you want to  place i after j 
    	List<Student> studs= new ArrayList<>();
    	studs.add(new Student(21,"Navin"));
    	studs.add(new Student(12,"John"));
    	studs.add(new Student(18,"Parul"));
    	studs.add(new Student(20,"Kiran"));

//    	Collections.sort(nums);
//    	System.out.println(nums);
    	
    	for(Student s:studs)
    		System.out.println(s);
    	
    	Collections.sort(studs,com);
    	for(Student s: studs)
    		System.out.println(s);
    }
}




    


