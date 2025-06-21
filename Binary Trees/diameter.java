
public class diameter {

    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right =null;
        }
    }
    //helper for diameter
      public static int heightCalculation(Node root){
        //base case when height of the current is 0 , ie leaf reached
        if(root==null){
            return 0;

        }
    
        int leftHeight = heightCalculation(root.left);
        int rightHeight = heightCalculation(root.right);

        return Math.max(leftHeight, rightHeight) + 1; //+1 for current node  , and for each node we take the maximum of its left height and right height
        //basically we recursively find the height of the left and right sub tree for the current node , stop when leaf reached and +1 for its own node
        
        
    }

    public static int diameterCalculation(Node root){  //O(n^2)  - for height calculation of each node O(n) and we calculate height for every n thus O(n^2)
        if(root==null){
            return 0;
        }

        //for each level we need its left dia , right dia, left height , right height
        int leftDia = diameterCalculation(root.left);
        int leftHeight = heightCalculation(root.left);
        int rightDia = diameterCalculation(root.right);
        int rightHeight = heightCalculation(root.right);

        int selfDiameter = leftHeight+rightHeight+1; //diameter that passes through the current level and not left in its subtree(left or right dia)

        return Math.max(selfDiameter , Math.max(rightDia, leftDia)); //3 choices - diameter passes through current node , left in left subtree (thus left dia ) , left in right subtree thus(right dia)
        
    }
    

    //optimized approach O(n)

    static class Info{
        int diam ;
        int ht ;
        public Info(int diam , int ht){
            this.diam = diam;
            this.ht = ht;
        }
    }
    //return type Info for optimized recursion and both diam & ht calculation in a single recursive call
    public static Info optimizedDiam(Node root){
        //base case
        if(root==null){
            return new Info(0, 0);
        }

        Info leftInfo = optimizedDiam(root.left); //recursively solve the left diameter and left max height for every cell , with Info as its value
        Info rightInfo = optimizedDiam(root.right);//similarly

        int diam =Math.max(leftInfo.ht +rightInfo.ht+1, Math.max(leftInfo.diam, rightInfo.diam));//for current level , diam has to be the maximum out of 3 choices , its left sub diam , its right sub diam and or the diameter which includes itself thus (its left max height , its right max height and itself) 
        
        int ht = Math.max(leftInfo.ht, rightInfo.ht)+1; //if you dont increase it by one it will never change and always be 0 from the initial call , as you are never including the current cell its calculating height for and when it start returning back to the previous nodes their child isnt getting included 
        return new Info(diam, ht);
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
    System.out.println(optimizedDiam(root).diam);
    }
}
