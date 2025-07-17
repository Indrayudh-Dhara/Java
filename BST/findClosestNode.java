package BST;

public class findClosestNode {
    static class Node{
        Node left;
        Node right;
        int data;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }

    }
    static int minDiff = Integer.MAX_VALUE; 
    static Node closestNode = null;
    public static void closest(Node root , int k){
        if(root == null){
            return;
        }
        int minAbsDiff = Math.abs(k-root.data);
        if(minAbsDiff<minDiff){
            minDiff=minAbsDiff;
            closestNode=root;
        }
        if(root.data>=k){
            closest(root.left,k);
        }else{
            closest(root.right,k);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(5);
        root.right = new Node(11);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.right.right = new Node(20);
    //      8
    //    5  11
    //   3 6   20

    closest(root, 12);
    System.out.println(closestNode.data);
    }
}
