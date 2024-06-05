package BinaryTree;

public class sumTree {
    public static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }}
              public static void printTree(Node root){
                if(root==null){
                    return ;
                }
                System.out.print(root.data+" ");
               
                printTree(root.left);
               
                printTree(root.right);
              }

              public static int  sum_Tree(Node root){
                if(root==null){
                    
                    return 0;
                }
                
                int leftSum=sum_Tree(root.left);
                int rightSum=sum_Tree(root.right);
                int data=root.data;
                int newLeft=root.left==null?0:root.left.data;// for base case when root.left==null: we cannnot access data as 0 so just return 0
                int newRight=root.right==null?0:root.right.data;
                root.data=leftSum+newLeft+rightSum+newRight;
                return data;
                
              }

        public static void main(String[] args) {
            Node root=new Node(1);
            root.left=new Node(2);
            root.right=new Node(3);
            root.left.left=new Node(4);
            root.left.right=new Node(5);
            root.right.left=new Node(6);
            root.right.right=new Node(7);
            sum_Tree(root);
            printTree(root);
        }
}
