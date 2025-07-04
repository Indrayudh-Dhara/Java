public class transformSum {

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

    public static int transform(Node root){
        if(root==null){
            return 0;

        }

        int leftSum= transform(root.left);
        int rightSum=transform(root.right);


        int data = root.data;
        int sum =leftSum+rightSum;
        root.data=sum;

        return sum+data;
        
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
    transform(root);
    //       27
    //     /    \
    //    9      13
    //   / \    /  \
    //  0   0  0    0
    preorderTraversal(root); //27-9-0-0-13-0-0
  

    }
}
