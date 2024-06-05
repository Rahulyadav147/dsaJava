package BinaryTree;

public class minDistanceBW2Nodes {
    public static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }}
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

        public static int dist(Node root,int val){
            if(root==null){
                return -1;
            }
           
            if(root.data==val){
                return 0;
            }
            
            int  leftfound =dist(root.left,val);
            int  rightfound=dist(root.right, val);
           
            if(leftfound==-1 && rightfound==-1){
                return -1;
            }
         
            else if(leftfound==-1){
                return rightfound+1;
            }
            else{
              return leftfound+1;
            }
            
        }

    public static int minDistance(Node root,int A,int B){
        Node lca=LCA1(root,A,B);
        int dist1=dist(lca,A);
        int dist2=dist(lca,B);
        return dist1+dist2;
        
       

    }
    public static void main(String[] args) {
        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right.left=new Node(6);
        root.right.right=new Node(7);
        int a=4,b=7;
       
        
        System.out.println("Min distance is " +minDistance(root, a,b));
    }
}
