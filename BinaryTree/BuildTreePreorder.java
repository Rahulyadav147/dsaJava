package BinaryTree;
import java.util.*;
public class BuildTreePreorder {
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
    static class BinaryTree{// TC: O(n)
        public static Integer index=-1;;
        public static Node builtPreorder(int nodes[]){
                    // update index for next eleemnt access
                    index++;
                    // if root node is -1 make it as null node(or leaf node)
                    if(nodes[index]==-1){
                        return null;
                    }
                    else{
                        // create a node and call for left and right tree
                        Node newNode =new Node(nodes[index]);// root node
                        System.out.print(newNode.data+" ");// dry run for output
                        newNode.left= builtPreorder(nodes);// call  for left of root(newNode)// the value null returned in last is not used anywhere (as we are not  printing just inserting in tree so we move forward to right of root node)
                        newNode.right= builtPreorder(nodes);// call for right of root(newNode)
                        return newNode ;// we have to return root node 
                    }
        }
        // now root points to an actual tree root node(implement in form of linked list)
        public static void preOrderTraversal(Node root){
            // base case
            if(root==null){
                
                return;
            }
            // pirnt root data
            System.out.print(root.data+" ");
            // go to left of root
            preOrderTraversal(root.left);
            // go to right of root
            preOrderTraversal(root.right);
        }


        public static void postOrderTraversal(Node root){
            // base case
            if(root==null){
                
                return;
            }
           
            // go to left of root
            postOrderTraversal(root.left);
            // go to right of root
            postOrderTraversal(root.right);
             // pirnt root data
             System.out.print(root.data+" ");
        }
        
        public static void inOrderTraversal(Node root){
            // base case
            if(root==null){
              
                return;
            }
            
            // go to left of root
            inOrderTraversal(root.left);
             // pirnt root data 
             System.out.print(root.data+" ");
            // go to right of root
            inOrderTraversal(root.right);     
        }

        // levelOrderTraversal (Iterative approach)
        //TC: O(n) -> we are adding and removing nodes in queue(n+n=2n->O(n))
        public static void levelOrderTraversal(Node root){
               
               // base case
               if(root==null){// if tree is empty 
                return ;
               }
               Queue<Node> q= new LinkedList<>();
               q.add(root);
               q.add(null);
               while(!q.isEmpty()){
                    Node curr=q.remove();
                    if(curr!=null){// if curr node is null:print and add non null left and right nodes to queue
                        
                        System.out.print(curr.data+" ");
                        if(curr.left!=null){
                            q.add(curr.left);
                        }
                        if(curr.right!=null){
                            q.add(curr.right);
                        }
                    }
                    else{// 
                        System.out.println();// after null we go to next level so print space
                        if(q.isEmpty()){// after removing q is empty means means there are no nodes left to print
                            break;
                        }
                        q.add(null);//add null to divide different levels
                    }
               }
               // keep removing nodes from queue and adding there left and right nodes in queue until next null arrives 
              
               

        }

        public static int height(Node root){
            if(root==null){// for last null node height is 0
               return 0;
            }
            int leftHight=height(root.left);// if left of curr is null:height of curr is 0+1 =1(for last node)
            int rightHight=height(root.right);
            return Math.max(leftHight,rightHight)+1;
        }
    } 
    public static void main(String[] args) {
        int nodes[]={1,2,4,-1,-1,5,-1,9,-1,7,-1,-1,3,-1,6,-1,-1 }; 
       
        Node root= BinaryTree.builtPreorder(nodes);// as inner class is static we need to access it directly through inner class (not necessary we can use ob of inner class as well)
        System.out.println(root.data);
        System.out.println("preOrder");
        BinaryTree.preOrderTraversal(root);
        System.out.println();
        System.out.println("PostOrder");
        BinaryTree.postOrderTraversal(root);
        System.out.println();
        System.out.println("inOrder");
        BinaryTree.inOrderTraversal(root);
        // System.out.println("levelOrdertraversal");
        // BinaryTree.levelOrderTraversal(root);
        // System.out.println("Height of binary tree is: ");
        // System.out.println(BinaryTree.height(root));
        

        
    }
}
