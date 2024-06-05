package Strings;

public class intern {
    public static void main(String[] args) {
        String s1 = "hello";
String s2 = new String("hello");
String s3 = s1.intern(); // Returns the reference to "hello" from the pool
System.out.println(s1 == s2); // false
System.out.println(s1== s3); // true

String name1 = "Tony";
String name2 = "Tony";

if(name1.equals(name2)) {
    System.out.println("They are the same string");
} else {
    System.out.println("They are different strings");
}

//DO NOT USE == to check for string equality
//Gives correct answer here
if(name1 == name2) {
    System.out.println("They are the same string");
} else {
    System.out.println("They are different strings");
}

//Gives incorrect answer here
if(new String("Tony") == new String("Tony")) {
    System.out.println("They are the same string");
} else {
    System.out.println("They are different strings");
}


// equals(): This method compares the actual content of the strings. If the content is identical, it returns true; otherwise, it returns false.
// ==: This operator compares the references, not the content. It checks whether two references point to the exact same object in memory, not whether the contents of the strings are the same.
    }
}
