public class minDistance2Nodes {

    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left= null;
            this.right=null;
        }
    }

       public static Node lcaV2(Node root , int n1 , int n2){
    //base case
    if(root==null || root.data==n1 || root.data==n2){
        return root;
    }

    Node leftLca=lcaV2(root.left, n1, n2);
    Node rightLca=lcaV2(root.right, n1, n2);

    if(rightLca==null){
        return leftLca;
    }
    if(leftLca==null){
        return rightLca;
    }
    return root; //both not null thus root is the latest ancestor whose subtree has both n1 and n2 : root-> lca

    
   }
   
   public static int lcaDist(Node lca , int n){
    if(lca==null){ //lca null thus no valid node that equals n 
        return -1;
    }
    if(lca.data==n){
        return 0 ; //distance from itself is 0
    }
    int lst=lcaDist(lca.left, n);
    int rst=lcaDist(lca.right, n);

    if(lst==-1 && rst==-1){ //no valid node that equals n in that subroot
        return -1; 
    }else if(lst==-1){ //means rst has a valid value , thus return value+1 for the parent to add its path
        return rst+1;
    }else{
        return lst+1; //means lst has a valid value
    }

   }

   public static int minDistance(Node root, int n1 , int n2 ){
    Node lca = lcaV2(root, n1, n2); //now we got the lca , we calculate the distance lca->n1 and lca->n2 and add them for their minimum dist calcn

    int dist1 = lcaDist(lca , n1); 
    int dist2 = lcaDist(lca,n2);

    return dist1+dist2;

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
   System.out.println(minDistance(root, 4,5)); //2
    }
}
