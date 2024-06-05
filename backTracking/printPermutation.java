package backTracking;

public class printPermutation {
    public static void print_permutation(StringBuilder str, int idx) {
        if (idx == str.length() - 1) {
            System.out.print(str + " ");
            System.out.println();
        }
        for (int i = idx; i < str.length(); i++) {
            swap(str, idx, i);
            print_permutation(str, idx + 1);
            swap(str, idx, i);
        }
    }

    public static void swap(StringBuilder str, int idx, int idx2) {
        char temp = str.charAt(idx);
        str.setCharAt(idx, str.charAt(idx2));
        str.setCharAt(idx2, temp);
    }
    
 public static void main(String[] args) {
    StringBuilder str=new StringBuilder("abc");
    print_permutation(str,0);
 }
    
}
