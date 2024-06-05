package BinaryTree;
import java.util.*;

//  do dry run to  understand how hd(horizontal distance) and min ,max are updated in tree
public class TopViewOfTree {
    public static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }    
    static  class Info{
          Node node;
          int hd;// horizontal distance
          public Info(Node node,int hd){
            this.node=node;
            this.hd=hd;
          }
    }
    public static void printTopView(Node root){
                Queue<Info> q=new LinkedList<>();// it is done to track val from node and hd from hd of Info class 
                HashMap<Integer,Node> map=new HashMap<>();
                int min=0,max=0;// to track min and max to print nodes at last
                if(root==null){
                    return ;// we do not have any node to print
                }
                // level order traversal
                q.add(new Info(root,0));
                q.add(null);
                while(!q.isEmpty()){
                    Info curr=q.remove();
                    if(curr != null){
                        // first put key and value in map this will help to compare hd to min and max and update them as it common for both right and left child 
                        if(!map.containsKey(curr.hd)){
                            map.put(curr.hd,curr.node);
                        }
                        // put left and right child in queue if they are not null
                        if(curr.node.left!=null){
                        
                            q.add(new Info(curr.node.left,curr.hd-1));
                            min=Math.min(min,curr.hd-1);
                        }
                        if(curr.node.right!=null){
                            
                            q.add(new Info(curr.node.right,curr.hd+1));
                            max=Math.max(max,curr.hd+1);
                        }

                    }
                    else{
                        
                        if(q.isEmpty()){
                            break;// as we have no nodes left
                        }
                        q.add(null);
                    }
                }

                for(int i=min;i<=max;i++){
                    System.out.print(map.get(i).data+" ");
                       }
    }           
        public static void main(String[] args) {
            Node root=new Node(1);
            root.left=new Node(2);
            root.right=new Node(3);
            root.left.right=new Node(4);
            root.left.right.right=new Node(5);
            root.left.right.right.right=new Node(6);
            printTopView(root);
        }
    
}
