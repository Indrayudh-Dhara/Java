package BST;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class mergeBST {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void preorder(Node root){
        if (root == null){
            return ;
        }
        System.out.print(root.data +" ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void getInorder(Node root , ArrayList<Integer> inorder){
        if(root == null){
            return;
        }

        getInorder(root.left, inorder);
        inorder.add(root.data);
        getInorder(root.right, inorder);

    }

    //mid for every level 
    public static Node bstFromSortedArrList(ArrayList<Integer> inorder , int si , int ei){ //create new bst function
        if(si>ei){ //bst already formed
            return null;
        }
        int mid =  (si+ ei)/2;
        Node root = new Node(inorder.get(mid));
        root.left=bstFromSortedArrList(inorder, si, mid-1);
        root.right = bstFromSortedArrList(inorder, mid+1, ei);

        return root;//for correct updated propagation
    }

    public static void merge(Node root1 , Node root2){
        ArrayList<Integer> inorder = new ArrayList<>();
        getInorder(root1, inorder); //inorder gets all the nodes of root1 bst included in it in sorted
        getInorder(root2, inorder); //similarly
        
        //to reduce the TC do merge Sort seperately and take two storage for each indivitual BST's

        Collections.sort(inorder);//sorted everything for both the bsts;

        Node root = bstFromSortedArrList(inorder, 0, inorder.size()-1);
        preorder(root);

    }
    public static void main(String[] args) {
          //     2
        //      / \
        //     1   4
        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);
        //      9
        //     / \
        //    3   12
        Node root2 = new Node(9);
        root2.left = new Node(3);
        root2.right = new Node(12);


        //total sorted inorder for both is -> 1,2,3,4,9,12
        //         3
        //       /   \
        //      1     9
        //       \   / \
        //        2 4   12
                  
        merge(root1, root2);
        

    }
}
