// package BinarySearchTree;


// //Most problems will be solved using recursion i.e. by dividing into subproblems & making recursive calls on subtrees.
// public class BasicsBst {
//     // build a  bst
//     public static class Node{
//         int data;
//         Node left;
//         Node right;
//         public Node(int data){
//             this.data=data;
//             this.left=null;
//             this.right=null;
//         }} 
//         public static Node  insert(Node root,int val){
//              if(root==null){
//                 root=new Node(val);
//                 return root;
//              }
//              if(val<root.data){
//                 // left subtree
//                 root.left=insert(root.left,val);
//                 //If you directly call insert(root.left, data) without assigning the return value, 
//                 //the newly created node is lost. It's not connected to the tree structure.
//                 // we need not to assign if insert does not return a value 
//              }
//              else{// right subtree
//                root.right=insert(root.right,val);
//              }
//         return root;
             
//         }
       
//         public static  void inorder(Node root){
//             if(root==null){
//                 return;
//             }
//             inorder(root.left);
//             System.out.print(root.data+" ");
//             inorder(root.right);
//         }

//         // TC: O(H)-> H : worst case is O(n) for skewed tree
//         public static boolean BinarySearch(Node root, int key) {
//             if (root == null) { 
//                 return false;
//             }
//             if (key == root.data) {
//                 return true;
//               } else if (key > root.data) {
//                 return BinarySearch(root.right, key);
//               } else {
//                return  BinarySearch(root.left, key);
//               }
//         }

//     // deleting a node
//     public static Node delete(Node root,int val){
//         // first search for the node
         

//     }
//     public static void main(String[] args) {
//         int values[]={8,5,3,1,4,6,10,11,14};
//         Node root=null;
//         for(int i=0;i<values.length;i++){
//            root= insert(root,values[i]);
//         }

//         inorder(root);
//         if(BinarySearch(root,9)){
//             System.out.println("key found");
//         }
//         else{
//             System.out.println("key not found");
//         }

//         delete()
//         inorder(root);

//     }
// }




  

