public class minDepth {
    static class Node{
        int data;
        Node left , right;
        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static int minDepthCode(Node root){
        if(root == null)return 0;
        if(root.left==null)return minDepthCode(root.right)+1;
        if(root.right == null)return minDepthCode(root.left)+1;

        return Math.min(minDepthCode(root.left), minDepthCode(root.right))+1;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(8);
        root.right = new Node(2);
        root.left.left = new Node(6);
        root.left.right = new Node(5);
        root.left.left.left = new Node(7);
        root.right.left =new Node(9);

        // Node root = new Node(1);
        // root.right = new Node(2);
        // root.right.right =new Node(3);

        System.out.println(minDepthCode(root));
    }

}
