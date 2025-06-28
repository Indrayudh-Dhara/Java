public class kthAncestor {
    
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

   public static int kthAncestorCode(Node root , int node , int k){
    
    if(root==null){
        return -1;
    }
    
    //check if root data is equal to node
    if(root.data==node){ 
        return 0; //distance from itself is 0 
    }

    //calculate distance for left subtree subroots 
    int leftDist = kthAncestorCode(root.left, node, k);
    //calculate distance for right subtree subroots distance
    int rightDist = kthAncestorCode(root.right, node, k);

    if(leftDist==-1 && rightDist ==-1){ //symbolised that in both the subtrees the node isnt present
        return -1;
    }
    //else one of them has it
    int max = Math.max(leftDist, rightDist); 
    //add the current distance to the previously cummilative distance done in max and if its equal to k then print the current level root (which is the kth ancestor)
    if(max+1==k){
        System.out.println(root.data);
    }
    return max+1; //if not equal return the distance for the previous level to calculate




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
    System.out.println(kthAncestorCode(root, 5 , 2));
}
}
