package Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class reverseFirstKelements {

    //using one queue and one stack
    public static void reverse(Queue<Integer> q ,int k){
        Queue<Integer> helperQ = new LinkedList<>(); //to store elements that wont be reversed
        Stack<Integer> helperS = new Stack<>(); // to store elements that will be reversed
       
      
        int count= 0 ; 
        while(count!=k){
            helperS.push(q.remove());
            count++;
           
        }
        //all the K elements to be reversed are now in the stack 
        while(!q.isEmpty()){
            helperQ.add(q.remove());
           
        }
        //all the other elements not to be revesed are now in the queue
        //original q is empty
        
        while(!helperS.isEmpty()){
            q.add(helperS.pop());
            
        }
        while(!helperQ.isEmpty()){
            q.add(helperQ.remove());
        }
        System.out.println(q);

    
    }

    //not using any other queue instead we add from stack in the same queue and then we remove(first) from the same queue and add to the same queue thus those just gets shifted after the reversed ones from stack
    public static void spaceOptimizedReverse(Queue<Integer> q, int k){
        if (q == null || k <= 0 || k > q.size()) return;

    Stack<Integer> stack = new Stack<>();
    
    // Step 1: Push first k elements into the stack
    for (int i = 0; i < k; i++) {
        stack.push(q.remove());
    }

    // Step 2: Enqueue back the reversed elements
    while (!stack.isEmpty()) {
        q.add(stack.pop());
    }

    // Step 3: Move the remaining elements to the back of the queue
    int size = q.size();
    for (int i = 0; i < size - k; i++) {
        q.add(q.remove());
    }

    System.out.println(q);
    }
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(10);
         q.add(20);
          q.add(30);
           q.add(40);
            q.add(50);
             q.add(60);
              q.add(70);
               q.add(80);
                q.add(90);
                 q.add(100);

        reverse(q, 5);
    }
}
