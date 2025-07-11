import java.util.LinkedList;
import java.util.Queue;

public class KthLevel {

    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data= data;
            this.left = null;
            this.right=null;
        }
    }

    public static void code(Node root ,int k){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        int count = 1 ; //1st level 
        while(!q.isEmpty()){
            Node curr = q.remove();
            if(curr==null){
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                    count++;
                }
            }else{
                if(count==k){
                    System.out.print(curr.data + " "); //as we pop current out to check for conditions , we need to print it seperately as its not in the queue
                    while(q.peek()!=null){
                        System.out.print(q.remove().data+ " ");
                    }
                }else{
                     if(curr.left!=null){
                q.add(curr.left);
               }
               if(curr.right!=null){
                q.add(curr.right);
               }
                }
              
            }
        }
    }

    //recursive way

    public static void codeV2(Node root , int level , int k){
        if(root == null){
            return ;
        }
        if(level == k ){
            System.out.print(root.data + " ");
        }
        codeV2(root.left, level+1, k);
        codeV2(root.right, level+1, k);
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
        code(root,3);
        codeV2(root, 1, 3);

        
    }
}
