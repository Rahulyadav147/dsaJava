package BinaryTree;
import java.util.*;
public class LowestCommonAncestor {
    public static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }}
        public static void getPath(Node root,int val,ArrayList<Node> ll){
            if(root==null){
                return ;
            }
            // preOrder 
            // root 
            ll.add(root);
            // left
            getPath(root.left,val,ll);
            // while coming back from left node: do not remove first check right as well
            
            //right
            getPath(root.right,val,ll);
            // // while coming back from right node 
            if(val!=ll.get(ll.size()-1).data){// get last element in list ( it is node so we extract data to compare with val)
                ll.remove(ll.size()-1);
               }       
        }

       // TC:O(n) pathA + pathB + for loop =3n =n   SC:O(n+n)->O(n)
    public static int LCA(Node root,int A,int B){
        ArrayList<Node> pathA=new ArrayList<Node>();
        ArrayList<Node> pathB=new ArrayList<Node>();
        getPath(root,A,pathA);
        getPath(root,B,pathB);
        // match for last common element and print it
        int lastCommon=-1;
        int min=Math.min(pathA.size(),pathB.size());
        for(int i=0;i<min;i++){
              if(pathA.get(i).data==pathB.get(i).data){
                     lastCommon=pathB.get(i).data;// pathA or pathB both work
              }
        }
        
        {// uncomment to see the magic paths
        // System.out.println("PathA");
        // for(int i =0;i<pathA.size();i++){
        //     System.out.print(pathA.get(i).data+" ");
        // }
        // System.out.println();
        // System.out.println("PathB");
        // for(int i =0;i<pathB.size();i++){
        //     System.out.print(pathB.get(i).data+" ");
        // }
        // System.out.println();
        }
        return lastCommon;
    }
// TC : O(n)  SC: O(n) -> recursion stack 
    public static Node LCA1(Node root,int A,int B){
        if(root==null){
            return null;
        }
        // preOrder
        // root:
        if(root.data==A||root.data==B){
            return root;
        }
        // if the answer comes from left or right or both 
        Node leftfound =LCA1(root.left, A, B);
        Node  rightfound=LCA1(root.right, A, B);
        // if comes from  both(i.e. one from left and another right) (curr root is the answer)
        if(leftfound!=null && rightfound!=null){
            return root;
        }
        // if from left (both lies on leftSide)
        else if(leftfound!=null){
            return leftfound;// root cannot be part of answer so return leftFound
        }
        else{// right!=null
          return rightfound;
        }
        // 4th if both are null : but we assume values (A,B) already in tree
       

    }
    public static void main(String[] args) {
        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(8);
        root.left.left.right=new Node(4);
        root.left.right=new Node(5);
        root.right.left=new Node(6);
        root.right.right=new Node(7);
        int a=4,b=5;
       
        System.out.println("LCA Node is " +LCA(root, a,b));
        System.out.println("LCA Node is " +LCA1(root, a,b).data);
    }
}
