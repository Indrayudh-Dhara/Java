package BST;

import java.util.ArrayList;
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

    public static boolean validBST(Node root ,Node min , Node max ){ //returns boolean
       
        if(root==null){
            return true;
        }
        if(max!=null && root.data >=  max.data){ //checking for the maximum (ie lst)
            return false;
        }
        else if(min!=null && min.data>=root.data){
            return false;
        }

       return validBST(root.left, min, root) && validBST(root.right, root, max); 
    }

    public static Node mirrorBST(Node root){
        if(root==null){
            return root; 
        }

        //if we wouldve called directly inside the root.right or left , swapping wouldnt have been possible;
        Node leftMirror = mirrorBST(root.left);
        Node rightMirror = mirrorBST(root.right);
        

        root.right=leftMirror;
        root.left=rightMirror;


        return root; //correct updated root propagation backwards the call stack after sub calls and calls are done 
    }

    public static Node balancedBSTfromSortedArray(int arr[] , int si , int ei){
        if(si>ei){ //invalid case ,  BST already created
            return null;
        }
        
        int mid = (si+ei)/2; //for every level calculating mid , so that we can attach a lst and rst for every node not just root and make it symmetric 
        Node root = new Node(arr[mid]); 
        root.right = balancedBSTfromSortedArray(arr, mid+1, ei);
        root.left = balancedBSTfromSortedArray(arr, si, mid-1);
        return root; //yk what
    }

    public static void preorder(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+ " ");
        preorder(root.left);
        preorder(root.right);
    }



    //convert a normal bst to balanced bst (Util function)
    public static ArrayList<Integer> getInorder(Node root , ArrayList<Integer> a){
        if(root==null){
            return a;
        }

        getInorder(root.left , a);
        a.add(root.data);
        getInorder(root.right, a);
        return a;

    }
    //Util function
    public static Node balancedBSTfromSortedArrayList(ArrayList<Integer> inorder , int si , int ei){
        if(si>ei){
            return null;
        }
        int mid = (si+ei)/2;
        Node root = new Node(inorder.get(mid));
        root.left = balancedBSTfromSortedArrayList(inorder, si, mid-1);
        root.right = balancedBSTfromSortedArrayList(inorder, mid+1, ei);
        return root;
    }
    public static void toBalancedBST(Node root){

        ArrayList<Integer> inorder = new ArrayList<>(); //helper arraylist to store the returned inorder AL for the unbalanced BST
        inorder = getInorder(root, new ArrayList<>());//stores
        root = balancedBSTfromSortedArrayList(inorder, 0, inorder.size()-1); //changes and balances in the original BST using the inorder AL
        preorder(root); //printed the preorder of the balanced BST
    }
    public static void main(String[] args) {
        int values[] = {8,5,3,1,10,11,14};
//         8
//        / \
//       5   10
//      /      \
//     3        11
//    /           \
//   1             14

        Node root = null;
       for(int i =0 ; i<values.length ; i++){
        root=insert(root, values[i]);
       }

       toBalancedBST(root);
       //expected bst
//           8
//        /    \
//       3      11
//      / \    /  \
//     1   5  10   14






//        Stack<Integer> s = new Stack<>(); //for root to leaf path
        
//        int arr[]  = {3,5,6,8,9,10,11};

//     //    inorderTraversal(root);
//     // printInRange(root , 5, 12);
//     // rootToleaf(root, s );
//     // System.out.println(validBST(root, null, null));
//     // mirrorBST(root);
//     // inorderTraversal(root);
//     Node root = balancedBSTfromSortedArray(arr, 0, arr.length-1);
// //          8
// //        /   \
// //       5     10
// //      / \   /  \
// //     3   6 9    11
// //            
//     preorder(root);
    }
}
