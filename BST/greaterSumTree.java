package BST;

public class greaterSumTree {
     static class Node{
        Node left;
        Node right;
        int data;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }

    }

    static int sum=0;

    public static void greaterSum(Node root){
        
        if(root==null){
            return;
        }
        //reverse inorder 
        greaterSum(root.right);
        //taking out the root data
        int original = root.data;
        //assignning root data to the previous sum 
        root.data=sum;
        //updating sum
        sum+=original;

        greaterSum(root.left);
        
    }

    public static void inorder(Node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(5);
        root.right = new Node(11);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.right.right = new Node(20);
    //      8
    //    5  11
    //   3 6   20
        greaterSum(root);
             
        inorder(root);

    
    }
}
