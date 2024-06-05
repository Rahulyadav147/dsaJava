package BinaryTree;
public class printKthLevelOfBT {
    public static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }}

        //TC:O(n)
        public static void printKthLevel(Node root,int k,int level ){
            if(root==null){
                return;
            }

            // preOrder Traversal
            // 1:root 
            if(k==level){// this is actually the level of root of tree
                System.out.print(root.data+" ");
                return ;
            }
            //2: left child
            printKthLevel(root.left,k,level+1);
            //3: right Child
            printKthLevel(root.right,k,level+1);
                
        }
        public static void main(String[] args) {
            Node root=new Node(1);
            root.left=new Node(2);
            root.right=new Node(3);
            root.left.left=new Node(4);
            root.left.right=new Node(5);
            root.right.left=new Node(6);
            root.right.right=new Node(7);
            int k=3;
            printKthLevel(root,k,1);
            System.out.println();
        }
} 
