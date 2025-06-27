public class identicalSubtree {

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

    public static boolean code(Node root , Node subRoot){
        //subroot doesnt with any node from main tree
        if(root==null){
            return false;
        }
        if(root.data==subRoot.data){
            if(isValid( root ,subRoot)){
                return true;
            }
        }

        return  code(root.left, subRoot)||code(root.right, subRoot);  //checking and returning for the left and right subtree to find similarity in subroot

    }

    public static boolean isValid(Node node ,Node subRoot){
        //check for not valid (easier)
        if(node == null && subRoot == null){
            return true;
        }
        else if(node==null || subRoot==null || node.data!=subRoot.data){
            return false;
        }
        //check NOT VALID for the entire subtree
        //LST
        if(!isValid(node.left, subRoot.left)){
            return false;
        };
        //RST
        if(!isValid(node.right, subRoot.right)){
            return false;
        };
        return true; //nothing satisfies this it is valid
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

    //    2    
    //   / \   
    //  4   5

    Node subRoot = new Node(2);
    subRoot.left = new Node(4);
    subRoot.right = new Node(5);
        System.out.println(code(root, subRoot));
    }
}
