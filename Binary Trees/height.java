

public class height {
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

    public static int heightCalculation(Node root){
        //base case when height of the current is 0 , ie leaf reached
        if(root==null){
            return 0;

        }
    
        int leftHeight = heightCalculation(root.left);
        int rightHeight = heightCalculation(root.right);

        return Math.max(leftHeight, rightHeight) + 1; //+1 for current node  , and for each node we take the maximum of its left height and right height
        //basically we recursively find the height of the left and right sub tree for the current node , stop when leaf reached and +1 for its own node
        
        
    }
    public static void main(String[] args) {
    //       1
    //     /   \
    //    2     3
    //   / \   / \
    //  4   5  6  7
    // /
    //8             height = 4;
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.left.left = new Node(8);
    root.left.right = new Node(5);
    root.right.left = new Node(6);
    root.right.right = new Node(7);
    //manually created a binary tree
    System.out.println(heightCalculation(root));
    }
}
