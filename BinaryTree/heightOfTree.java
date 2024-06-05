package BinaryTree;
public class heightOfTree {
    public static  class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        } 
    }
    public static int height(Node root){
        if(root==null){// for last null node height is 0
           return 0;
        }
        int leftHight=height(root.left);// if left of curr is null:height of curr is 0+1 =1(for last node)
        int rightHight=height(root.right);
        return Math.max(leftHight,rightHight)+1;
    }
    public static int countNodes(Node root){
        if(root==null){// for last null node count is 0
            return 0;
         }
         int leftCount=countNodes(root.left);// left tree count
         int rightCount=countNodes(root.right);// rght tree count
        return leftCount+rightCount+1;// left + right + root count
    }

    public static int sumOfNodes(Node root){
        if(root==null){// for last null node count is 0
            return 0;
         }
         int leftSum=sumOfNodes(root.left);// left tree count
         int rightSum=sumOfNodes(root.right);// rght tree count
        return root.data+ leftSum+rightSum;// left + right + root count
          
    }
    

    //  TC: O(n^2): diameter of each node O(n) and for each node height=O(n) so O(n^2)
    public static int diameterOfTree1(Node root){
        if(root==null){// diameter of null node is 0
            return 0;
        }
        // diameter is : max of leftSubtree,rightSubtree diameter and  treediameter(i.e. rightHeight,leftHeight+1)

       
        int leftDiameter=diameterOfTree1(root.left);
        int rightDiameter=diameterOfTree1(root.right);
        int leftHeight=height(root.left);
        int rightHeight=height(root.right);
        int selfDiameter=leftHeight+rightHeight+1;// this is first calulated for left most child (go recursively)
        int treeDiameter=Math.max(selfDiameter,Math.max(leftDiameter,rightDiameter));
        return treeDiameter ;
    }

    // TC:O(n)
    public static class Info{
         int height;
         int diameter;
        Info(int h,int d){
            this.height=h;
            this.diameter=d;
        }

    }
    public static Info diameterOfTree2(Node root) {
          
        if (root == null) {
            return new Info(0, 0); // Height and diameter of null node are 0
        }
    
        // Get diameter and height information for left and right subtrees
        Info leftInfo = diameterOfTree2(root.left);
        Info rightInfo = diameterOfTree2(root.right);
    
        // Calculate self diameter based on left and right subtree heights
        int selfDiameter = leftInfo.height + rightInfo.height + 1;
    
        // Find the maximum diameter (tree diameter)
        int treeDiameter = Math.max(Math.max(leftInfo.diameter, rightInfo.diameter), selfDiameter);
    
        // Height of the tree is the maximum of left and right subtree heights plus 1
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
    
        // Return information about the current subtree
        return new Info(height, treeDiameter);

       
    }
    
    public static boolean isIdentical(Node node,Node subRoot){
       if(node==null&&subRoot==null){// if both are null they are identical
        return true;
       }
       else if(node ==null||subRoot==null || node.data!=subRoot.data){// any one is null or data is not same 
           return false;
       }
       if(!isIdentical(node.left, subRoot.left)){// left is not identical 
        return false;
       }
       if(!isIdentical(node.right, subRoot.right)){// right is not indentical
        return false;
       }
       return true;// both are not null and identical
    }
    public static boolean subTreeOrNot(Node treeRoot,Node subTreeRoot){
        if(treeRoot==null){// if tree is null it will have no subtree
            return false;
        }
        // treeTraversal (preorder): check for root value
        if(treeRoot.data==subTreeRoot.data){
            if(isIdentical(treeRoot,subTreeRoot)){
                  return true;
            }
        }
       
        // left of root
         boolean leftAns=subTreeOrNot(treeRoot.left, subTreeRoot);
         // right of root
         boolean rightAns=subTreeOrNot(treeRoot.right, subTreeRoot);
         return leftAns||rightAns;// if  any of the right or left of tree is identical we  return treu;  
    }
    
    public static void main(String[] args) {
        /*
                  1
                /  \
               2     3
              / \   / \
             4   5 6   7
                  \
                   8
                    \
                     9
                      \
                       10
         */
          Node root=new Node(1);
          root.left=new Node(2);
          root.left.left=new Node(4);
          root.left.right=new Node(5);
        //   root.left.right.right=new Node(8);
        //   root.left.right.right.right=new Node(9);
        //   root.left.right.right.right.right=new Node(10);
          root.right=new Node(3);
          root.right.left=new Node(6);
          root.right.right=new Node(7);

          Node root1=new Node(2);
          root1.left=new Node(4);
        //   root1.right=new Node(5);
        //   root1.right=new Node(7);
         System.out.println("Height of binary tree is: ");
        System.out.println(height(root));
        System.out.println("No of Nodes in BT are: ");
        System.out.println(countNodes(root));

        System.out.println("Sum of Nodes in BT are: ");
        System.out.println(sumOfNodes(root));
        System.out.println("diameter of Tree in BT are: ");
        System.out.println(diameterOfTree1(root));
        System.out.println();
        System.out.println("diameter of Tree in BT are: ");
        
        System.out.println(diameterOfTree2(root).diameter);

        System.out.println("is subtree ");
        System.out.println(subTreeOrNot(root, root1));
    }
}
