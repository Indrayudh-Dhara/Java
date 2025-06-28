import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LCA {
    //lowest (deepest) common ancestor

    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

   //approach 1

   public static boolean getPath(Node root , int n , ArrayList<Node> path){
    //base case , reached null , no n there
        if(root == null){
            return false;
        }
        path.add(root);//add node and check at every recusive call
        if(root.data == n){
         return true;
        }

        boolean leftPath = getPath(root.left, n, path); //if not found check of lst
        boolean rightPath = getPath(root.right, n, path);//rst

        if(leftPath||rightPath){ //ie -> n found either at left or right 
            return true;
        }
        //found nowhere
        path.remove(path.size()-1);//remove the current  , backtracking step if not found
        return false;
    }


   public static Node lca(Node root , int n1 , int n2){
    ArrayList<Node> path1 = new ArrayList<>(); //to store the paths from root to n1
    ArrayList<Node> path2 = new ArrayList<>();//similarly to n2

    getPath(root ,n1 , path1); //to calculate path
    getPath(root,n2 , path2);

    int i = 0 ;
    for(;i<path1.size() && i<path2.size() ; i++){
        //the moment the path becomes unequal that means theres no more further ancestor deep down , so the current is the answer
        if(path1.get(i)!=path2.get(i)){
            break;
        }
    }
    Node lca = path1.get(i-1);//at i the paths become unequal
    return lca;

    
   }

   //approach 2 -> logic : the lca is the latest ancestor whose subtrees has both the n1 and n2 node : 

   public static Node lcaV2(Node root , int n1 , int n2){
    //base case
    if(root==null || root.data==n1 || root.data==n2){
        return root;
    }

    Node leftLca=lcaV2(root.left, n1, n2);
    Node rightLca=lcaV2(root.right, n1, n2);

    if(rightLca==null){
        return leftLca;
    }
    if(leftLca==null){
        return rightLca;
    }
    return root; //both not null thus root is the latest ancestor whose subtree has both n1 and n2 : root-> lca

    
   }



    
    public static void main(String[] args) {
    //       1
    //     /   \
    //    2     3
    //   / \   / \
    //  4   5  6  7
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.left = new Node(6);
    root.right.right = new Node(7);
    // System.out.println(lca(root, 4, 6).data); //1
    System.out.println(lcaV2(root, 4, 5).data); //2
    }
}
