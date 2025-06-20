
public class sumOfNodes {
    
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

    public static int sum(Node root){
        //base case when sum of the current is 0 , ie leaf reached
        if(root==null){
            return 0;

        }
        //basically for each nodes we counts its left sum and right sum recursively and go till the last leaf , and add the current data of the note it itself
    
        int leftSum = sum(root.left);
        int rightSum = sum(root.right);

        return leftSum+rightSum+root.data ;    //adding current data to its left and right sum for the previous calls 
        
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
    System.out.println(sum(root));;
    }
}



