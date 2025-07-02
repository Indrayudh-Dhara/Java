package BST;

public class largestValidBST {
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

    static class Info{
        boolean isBST;
        int max;
        int min;
        int size;
        public Info(boolean isBST , int max , int min , int size){
            this.isBST = isBST;
            this.max = max;
            this.min = min;
            this.size = size;
        }
    }

    public static int maxBST  = 0 ;
    public static Info largestBST(Node root){
        if(root == null){
            return new Info(true, Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
        }
        Info leftInfo = largestBST(root.left);
        Info rightInfo = largestBST(root.right);
        //after done calculating for left and right half , we calculate for the current node itself and also propagate that values to the previous levels recursively
        int max = Math.max(root.data, Math.max(leftInfo.max , rightInfo.max));
        int min = Math.min(root.data , Math.min(leftInfo.min, rightInfo.min));
        int size = leftInfo.size+rightInfo.size+1; //1 add for the current node

        if(root.data<=leftInfo.max || root.data>=rightInfo.min ){
            return new Info(false, max, min, size); //case of false propagation upwards
        }

        if(leftInfo.isBST && rightInfo.isBST){
            maxBST = Math.max(size, maxBST);
            return new Info(true, max, min, size);//case of true propagation upwards
        }
        return new Info(false, max, min, size);
    }
    public static void main(String[] args) {

            //         50
            //      /      \
            //     30       60
            //    /  \     /  \
            //   5   20   45   70
            //                /  \
            //               65   80
        Node root = new Node(50);
        root.left = new Node(30);
        root.left.left = new Node(5);
        root.left.right = new Node(20);
        root.right = new Node(60);
        root.right.left = new Node(45);
        root.right.right = new Node(70);
        root.right.right.left = new Node(65);
        root.right.right.right = new Node(80);


        //expected largest valid bst  (size - 5)
        //      60
        //     /  \
        //    45   70
        //        /  \
        //       65   80
        Info info = largestBST(root);
        System.out.println("Size of maximum BST is " + maxBST);

    }
}
