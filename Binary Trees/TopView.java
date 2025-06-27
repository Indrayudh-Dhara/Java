import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class TopView {

    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left=null;
            this.right=null;
        }
    }

    static class Info{
        int hd ; 
        Node node;
        Info(Node node , int hd){
            this.node = node;
            this.hd=hd;
        }
    }
    //top view (left -> right)
    public static void code(Node root){
        Queue<Info> q = new LinkedList<>(); //used to travel level order throught the BT
        HashMap<Integer , Node> map = new HashMap<>(); //to store the unique nodes based on their first appreance with a particular distance key(unique)->hd value->node
        int min= 0 ; int max= 0 ;//variables used later to print the top view in correct order
        q.add(new Info(root, 0));
        q.add(null);
        while(!q.isEmpty()){
            Info curr = q.remove();
            if(curr==null){
                if(q.isEmpty()){
                    break; //condition when all levels are traversed
                }else{
                    q.add(null);//gets added after the left and right of current are already added in previous iterations
                }
            }else{//if current not null
                if(!map.containsKey(curr.hd)){ //condition that checks if its the first time for the hd(key) or not
                    map.put(curr.hd, curr.node); //if first time , add curr and the hd to map
                }
                if(curr.node.left != null){ //check for its left node
                    //operation on q , adding left of curr for which will be the current for the next iteration
                    q.add(new Info(curr.node.left, curr.hd-1));//hd for left of a curr is always 1 less 
                    min = Math.min(min, curr.hd-1);
                }
                 if(curr.node.right != null){ //check for its left node
                    q.add(new Info(curr.node.right, curr.hd+1));//hd for right of a curr is always 1 more 
                    max = Math.max(min, curr.hd+1);
                }
            }
        }

        for(int i=  min ; i<=max ; i++){
            System.out.print(map.get(i).data);//key returns its value which is a node , thus we need node.data to print
        }
    
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
    code(root);
    }
}
