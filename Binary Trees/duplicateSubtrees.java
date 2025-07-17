import java.util.ArrayList;

public class duplicateSubtrees {
    
    // Binary Tree Node class
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    /**
     * This method serializes each subtree and checks if it's a duplicate.
     * 
     * @param root       The current node we're processing.
     * @param subtrees   List of all serialized subtrees we've seen so far.
     * @param duplicates List of serials we've already confirmed as duplicates (to avoid repeating them).
     * @param result     List of actual Node roots of detected duplicate subtrees (final output).
     * @return The serialized string of the current subtree.
     */
    public static String findDuplicates(Node root, ArrayList<String> subtrees, ArrayList<String> duplicates, ArrayList<Node> result) {
        // Base case: null node is represented by '#'
        if (root == null) return "#";

        // Recursively serialize left and right subtrees
        String left = findDuplicates(root.left, subtrees, duplicates, result);
        String right = findDuplicates(root.right, subtrees, duplicates, result);

        // Construct a unique string representing this subtree
        // It captures structure + values: (left)(right)(root)
        String serial = "(" + left + ")(" + right + ")(" + root.data + ")";

        // Check if this serial has been seen before
        boolean foundInSubtrees = false;
        for (int i = 0; i < subtrees.size(); i++) {
            if (subtrees.get(i).equals(serial)) {
                foundInSubtrees = true;
                break;
            }
        }

        // If it's already been seen once, it may be a duplicate
        if (foundInSubtrees) {
            // But check: have we already stored this duplicate before?
            boolean alreadyInDuplicates = false;
            for (int i = 0; i < duplicates.size(); i++) {
                if (duplicates.get(i).equals(serial)) {
                    alreadyInDuplicates = true;
                    break;
                }
            }

            // If this duplicate has not been stored yet, we record it now
            if (!alreadyInDuplicates) {
                result.add(root);         // Save this node as a duplicate subtree root
                duplicates.add(serial);   // Mark this serial as already handled
            }

        } else {
            // If this is the first time we're seeing this structure,
            // we just add it to subtrees
            subtrees.add(serial);
        }

        // Return the serialization for further recursive use
        return serial;
    }

    public static void main(String[] args) {
        // Constructing the example tree
        Node root = new Node(1);
        root.left = new Node(4);
        root.right = new Node(3);
        root.left.left = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(3);
        root.right.left.left = new Node(3);

        // Tree structure:
        //         1
        //       /   \
        //      4     3
        //     /     / \
        //    3     4   3
        //         /
        //        3

        // Lists to track unique subtrees, found duplicates, and final results
        ArrayList<String> subtrees = new ArrayList<>();
        ArrayList<String> duplicates = new ArrayList<>();
        ArrayList<Node> result = new ArrayList<>();

        // Start the detection
        findDuplicates(root, subtrees, duplicates, result);

        // Print the roots of duplicate subtrees
        System.out.println("Duplicate Subtree Roots:");
        for (int i = 0; i < result.size(); i++) {
            System.out.println("Node with value: " + result.get(i).data);
        }
    }
}
