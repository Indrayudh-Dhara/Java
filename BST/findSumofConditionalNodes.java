package BST;

public class findSumofConditionalNodes {
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

    static int sum=0;

    public static void findSumV2(Node root , int l , int r){
       
        if(root == null){
            return;
        }

        if(root.data>=l && root.data<=r){
            sum+=root.data;
            findSumV2(root.left, l, r);
            findSumV2(root.right, l, r);
        }
        //using binary search tree properties
        else if(root.data>r){
            findSumV2(root.left, l, r); //skip right
        }else if(root.data<l){
            findSumV2(root.right, l, r);//skip left
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

    findSumV2(root, 6, 20);
    System.out.println(sum);


    }


}
