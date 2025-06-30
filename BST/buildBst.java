package BST;

import java.util.Stack;

public class buildBst {

    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
        }
    }

    public static Node insert(Node root , int val){ //returns root

        if(root==null){ //this is where the nodes gets attached everytime in every recursion
            root = new Node(val);
            return root;
        }

        if(root.data<val){
            root.right = insert(root.right, val);

        }
        else{
            root.left=insert(root.left, val);
        }

        return root; //in case of deep level recursion , this ensures the proper propagation back to upper levels until call stack is completed

// this happens bottom-up while adding 2:
// root.left = code(root.left, val); // 3's left becomes 2
// return root;                      // returns updated 3

// root.right = code(root.right, val); // 1's right becomes updated 3
// return root;                        // returns updated 1

// root.left = code(root.left, val);   // 5's left becomes updated 1
// return root;                        // returns updated 5

    }

    public static void search(Node root , int key){ //TC -> O(H)
        if(root==null){
            System.out.println("Key is not present");
            return;
        }
        if(root.data==key){
            System.out.println("found");
            return;
        }

        if(key>root.data){
            search(root.right, key);
        }else{
            search(root.left, key);
        }
    }

    
        public static void inorderTraversal(Node root){
            if(root == null){
                return;
            }
            inorderTraversal(root.left);
            System.out.print(root.data + " ");
            inorderTraversal(root.right);
        }

        public static void printInRange(Node root , int k1 , int k2){
            if(root==null){
                return; //propagation back 
            }
            //only go left is root data is greater than lowest boundary
            if(root.data>k1){ //goes to the lowest possible node which equal to or the closest larger than the lower boundary(k2)
                printInRange(root.left, k1, k2);
            }
            //now checks and prints if its in range
            if(root.data>=k1 && root.data<=k2){ 
                System.out.print(root.data + " ");
            }
            //only go right if root data is smaller than upper boundary
            if(root.data<k2){ //similary 
                printInRange(root.right, k1, k2);
            }
            

            //goes to 5 the prints 5
            //goes to 6 then tries to access left of it , returns back to 6 as null and prints 6 , tries to access right of 6 returns back to 6 as null , 6 complete -> popped from call stack
            //now on 5 , 5 completed stack , thus popped 
            //now on 8 for the right part , similarly
        }
      
        public static void rootToleaf(Node root, Stack<Integer> s){

            if(root==null){
                return;
            }
            s.push(root.data);
            if(root.left == null && root.right==null){
                System.out.println(s);
                
            }
            
            
            rootToleaf(root.left , s);
            rootToleaf(root.right ,s);
            
            s.pop();

            //mistakenly tried to print stack when A PARTICULAR root is null ,
            // thats wrong as it just means that when the recursion happened for the parent's that can be one of the child which doesnt exist 
            // there still can be another child which is THE LEAF (where we want to print)
            
        }
    public static void main(String[] args) {
        int values[] = {8,5,3,1,4,6,10,11,14};
//         8
//        / \
//       5   10
//      / \     \
//     3   6     11
//    / \           \
//   1   4           14

        Node root = null;
       for(int i =0 ; i<values.length ; i++){
        root=insert(root, values[i]);
       }


       Stack<Integer> s = new Stack<>();
       
       
    //    inorderTraversal(root);
    // printInRange(root , 5, 12);
    rootToleaf(root, s );
    }
}
