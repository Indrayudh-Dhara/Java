package Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class queueReversal {

    public static void reverse(Queue<Integer> q){
        Stack<Integer> s = new Stack<>();
        while(!q.isEmpty()){
            s.push(q.remove());
        }
        // now has has 5,4,3,2,1 - where 5 is the top

        while(!s.isEmpty()){
            q.add(s.pop());
        }
        // now q has 5,4,3,2,1 - where 5 is the front
        System.out.println(q);
    }
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        reverse(q);
    }
}
