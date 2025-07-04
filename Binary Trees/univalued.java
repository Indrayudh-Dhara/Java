public class univalued {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    // Function to check if the tree is univalued (all nodes have the same value as 'node')
    public static boolean checkUnivalued(Node root, Node node) {
        // Base case: an empty subtree is considered univalued
        if (root == null) {
            return true;
        }

        // If the current node's data doesn't match the reference value, return false
        if (root.data != node.data) {
            return false;
        }

        // Recursively check the left and right subtrees
        boolean lst = checkUnivalued(root.left, node);
        boolean rst = checkUnivalued(root.right, node);

        // Return true only if both left AND right subtrees are univalued
        return lst && rst;
    }

    public static void main(String[] args) {
        // Construct the binary tree:
        //        2
        //       / \
        //      2   2
        //     / \
        //    5   2

        Node root = new Node(2);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.left = new Node(5);   // <-- this node breaks univalued property
        root.left.right = new Node(2);

        // Call the function and print the result
        System.out.println(checkUnivalued(root, root));  // Expected output: false
    }
}
