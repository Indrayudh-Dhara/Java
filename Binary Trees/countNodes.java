

public class countNodes {
    
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

    public static int countNodes(Node root){
        //base case when height of the current is 0 , ie leaf reached
        if(root==null){
            return 0;

        }
        //basically for each nodes we counts its no of left nodes and right nodes recursively and go till the last leaf
    
        int leftCount = countNodes(root.left);
        int rightCount = countNodes(root.right);

        return leftCount+rightCount+1;    //+1 for the current node itself     
        
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
    System.out.println(countNodes(root));
    }
}


