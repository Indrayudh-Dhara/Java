package BST;

public class maxSumBSTinBT {

    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data ){
            this.data = data ;
            this.left = null ;
            this.right = null;
        }
    }
static int maxSum = 0;
    public static boolean maxBSTsum(Node root){
        boolean isBST = true;
        if(root==null){
            return true;
        }
        if(root.left==null && root.right == null){
            return true;
        }

        boolean left=maxBSTsum(root.left);
        boolean right = maxBSTsum(root.right);

        
        if ((root.left != null && root.left.data > root.data) || 
            (root.right != null && root.right.data < root.data)) {
            isBST = false;
        }


        if(isBST){
            int sum = root.data + ( root.left!=null?root.left.data:0) +(root.right!=null ? root.right.data:0) ;
            root.data=sum;
            if(sum>maxSum){
                maxSum=sum;
            }
        }else{
            return false;
        }

        isBST=false;
        return left&&right;


    }
    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(9);
        root.left.left = new Node(6);
        root.left.left.left = new Node(8);
        root.left.left.right = new Node(7);
        root.right = new Node(2);
        root.right.right = new Node(3);
    //      5
    //     9 2
    //    6   3
    //   8 7 

    maxBSTsum(root);
    System.out.println(maxSum);
    }
}
