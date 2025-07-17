package BST;

public class kthSmallestElement {
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
    static int count=0;

    public static void kthSmallest(Node root , int k){
       
        if(root==null){
            return;
        }

        kthSmallest(root.left, k);
        count++;
        if(count==k){
            System.out.println(root.data);
            return;
        }
        kthSmallest(root.right, k);
        
//         callstack
// |kthSmallest(8)
// ├── kthSmallest(5)
// │   ├── kthSmallest(3)
// │   │   ├── kthSmallest(null)   // left of 3
// │   │   └── count = 1 at 3 ✔️
// │   │   └── kthSmallest(null)   // right of 3
// │   └── count = 2 at 5 ✔️
// │   └── kthSmallest(6)
// │       ├── kthSmallest(null)
// │       └── count = 3 at 6 ✅ PRINT 6
// │       └── kthSmallest(null)
// ├── kthSmallest(11) → still called, but count already reached
// │   ├── kthSmallest(null)
// │   └── count = 4 at 11 ❌
// │   └── kthSmallest(20)
// │       ├── kthSmallest(null)
// │       └── count = 5 at 20 ❌
// │       └── kthSmallest(null)

        
        
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
    kthSmallest(root,3);
    }
}
