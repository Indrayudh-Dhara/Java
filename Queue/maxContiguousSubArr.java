package Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Deque;

public class maxContiguousSubArr {

    //not optimized

    public static void maxContiguous(int arr[], int k){
        int size = arr.length;
        Queue<Integer> q = new LinkedList<>();
        int j=k;
        for(int i=0 ;i<size-k+1;i++){
            if(!q.isEmpty()){
                q.remove();
            }
            //use a loop to iterate K times instead of hardcoding insertion numbers
            q.add(arr[i]);
            q.add(arr[i+1]);
            q.add(arr[i+2]);

             int maxValue = 0;
            while (!q.isEmpty()) {
              
               if(q.peek()>=maxValue){
                 maxValue=q.peek();
               }
               q.remove();
            }
            System.out.println(maxValue);
        
        }

       
    }

     //optimized  - SLIDING WINDOW
        public static void optimized(int arr[] , int k){

            Deque<Integer> dq = new LinkedList<>(); // store indexes

            for(int i=0 ; i<arr.length ; i++){
            // remove elements from front if they are outside window
            if (!dq.isEmpty() && dq.getFirst() <= i - k) {
                dq.removeFirst();
            }

            // remove elements smaller than current from back
            while (!dq.isEmpty() && arr[dq.getLast()] < arr[i]) {
                dq.removeLast();
            }

            // add current index at the back
            dq.addLast(i);

            // print front value as max of window(ie only print when a complete window is formed not before that)
            if (i >= k - 1) {
                System.out.print(arr[dq.getFirst()] + " ");
            }
        }
    };

    public static void main(String[] args) {
        int arr[]= {1,2,3,1,4,5,2,3,6};
        maxContiguous(arr, 3);
    }
}
