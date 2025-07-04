public class deleteX {
      static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    public static Node deleteXLeaf(Node root , int x){
        if(root==null){
            return null;
        }

        // we recusively call and store it in the root.left or right accordinly , in that way we either keep that node (returns root) or delete (returns null)
        root.left = deleteXLeaf(root.left, x);
        root.right = deleteXLeaf(root.right, x);


        if(root.data ==x && root.left ==null && root.right==null){
            return null; //delete that node
        }

        return root ; //else keep that node
        
        
        
    }
        public static void preorderTraversal(Node root){
            if(root == null ){ //we are trying to access children of leaves
                return ;
            }
            System.out.println(root.data);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
    public static void main(String[] args) {
         // Construct the binary tree:
        //        1
        //       / \
        //      3   3
        //     / \
        //    3   2

        Node root = new Node(1);
        root.left = new Node(3);
        root.right = new Node(3);
        root.left.left = new Node(3);
        root.left.right = new Node(2);
        deleteXLeaf(root, 3);

        preorderTraversal(root);
    }
}
