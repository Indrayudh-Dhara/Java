import java.util.LinkedList;
import java.util.Queue;

public class binaryTrees {

    //building binary trees using preorder sequence

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
     static class BinaryTree{
        static int idx=-1;
        public static Node build(int nodes[]){  //return type Node to return the Root
            idx++;
            if(nodes[idx]==-1){
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = build(nodes);
            newNode.right = build(nodes);

            return newNode;//will be the root at the end to get returned while building
        }

        //function of Binary Tree to traverse through it after building(preorder)
        public static void preorderTraversal(Node root){
            if(root == null ){ //we are trying to access children of leaves
                return ;
            }
            System.out.println(root.data);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }

        public static void inorderTraversal(Node root){
            if(root == null){
                return;
            }
            inorderTraversal(root.left);
            System.out.println(root.data);
            inorderTraversal(root.right);
        }

        public static void postorderTraversal(Node root){
            if(root == null){
                return;
            }
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            System.out.println(root.data);
        }

        public static void levelorderTraversal(Node root){
            Queue<Node> q = new LinkedList<>();
            //start with root and null as thats the first level always
            q.add(root); //add root
            q.add(null);//add null 
            

            while (!q.isEmpty()) {
                //remove front and store in a variable
                Node currNode = q.remove();
                //check if null or not
                if(currNode==null){
                    //null -> next line
                    System.out.println();
                    if(q.isEmpty()){ //all levels printed 
                        break;
                    }else{
                        //isnt empty that means theres left and right for the previous removed front , and we gotta add a null after those for tracking next line
                        q.add(null);
                    }
                }else{  //node is at a node not at a null , thus it has a left and right
                    System.out.print(currNode.data);
                    if(currNode.left!=null){ //check and add right and left for every node which isnt null
                        q.add(currNode.left);
                    }
                    if(currNode.right!=null){
                        q.add(currNode.right);
                    }
                }
                
            }
        }
    
    
    }

    public static void main(String[] args) {
        int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree = new BinaryTree(); //creating an object BinaryTree
        Node root = tree.build(nodes); //creating the actual tree and storing the root in a Node 
        // System.out.println(root.data);
        tree.levelorderTraversal(root);
        }
}
