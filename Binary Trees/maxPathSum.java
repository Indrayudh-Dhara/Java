public class maxPathSum {
        static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.right=null;
            this.left=null;
        }
    }
    static int maxSum = Integer.MIN_VALUE ; 
    public static int maxSum(Node root){
        if(root == null){
            return 0;
        }

        int leftSum = maxSum(root.left);
        int rightsum = maxSum(root.right);
        
        int totalSum = root.data+leftSum+rightsum;
        maxSum=Math.max(maxSum, totalSum);
        //we are calculating max sum for a path not nodes , so we gotta return paths (for this case , we gotta return path which is giving us the maximum Sum)
        return Math.max(leftSum, rightsum)+root.data;

        //call stack
// ├── maxSum(9)
// │   ├── maxSum(null) → 0
// │   ├── maxSum(null) → 0
// │   └── total = 0 + 0 + 9 = 9
// │       return: 0 + 9 = 9   ← maxSum = 9
// │
// ├── maxSum(20)
// │   ├── maxSum(15)
// │   │   ├── maxSum(null) → 0
// │   │   ├── maxSum(null) → 0
// │   │   └── total = 0 + 0 + 15 = 15
// │   │       return: 15     ← maxSum = 15
// │   │
// │   ├── maxSum(7)
// │   │   ├── maxSum(null) → 0
// │   │   ├── maxSum(null) → 0
// │   │   └── total = 0 + 0 + 7 = 7
// │   │       return: 7      ← maxSum still 15
// │   │
// │   └── total = 15 + 7 + 20 = 42
// │       return: max(15,7)+20 = 35 ← maxSum = 42
// │
// └── total = 9 + 35 + (-10) = 34
//     return: max(9,35)+(-10) = 25  ← maxSum still 42


    }
    public static void main(String[] args) {
        Node root = new Node(-10);
        root.left = new Node(9);
        root.right= new Node(20 );
        root.right.left = new Node(15);
        root.right.right = new Node(7);

                // -10
                // 9  20
                //   15 7
            
        maxSum(root);
        System.out.println(maxSum);

        
    }
}
