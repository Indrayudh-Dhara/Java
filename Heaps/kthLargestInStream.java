package Heaps;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

public class kthLargestInStream {

    public static void myFirstApproach(){
        int stream[] = { 10 , 20 , 11 , 70 , 50 , 40 , 100 , 5};
        int k = 3;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        Stack<Integer> s = new Stack<>();
        int result[] = new int[stream.length];
        for(int i = 0 ; i<k-1 ; i++){
            pq.add(stream[i]);
            result[i]=-1;
        }
        for(int i = k-1 ; i< stream.length ; i++){
            //add current
            pq.add(stream[i]);

            //add first 3 in stack
            s.push(pq.remove());
            s.push(pq.remove());
            s.push(pq.remove());

            result[i]=s.peek();

            pq.add(s.pop());
            pq.add(s.pop());
            pq.add(s.pop());

            
        }

        for(int i : result){
            System.out.print(i + " ");
        }
    }

    public static void optimalApproach(){
        int stream[] = { 10 , 20 , 11 , 70 , 50 , 40 , 100 , 5};
        int k = 3;
        PriorityQueue<Integer> pq = new PriorityQueue<>(); //min heap and we need to manually maintain the size of min heap to be k always
        int result[] = new int[stream.length];
        for(int i = 0 ; i<stream.length ; i++){
            pq.add(stream[i]);
            
            if(pq.size()<k){
                // for the cases where theres no k elements to compare to
                result[i]=-1;
            }else if(pq.size()>k){
                while(pq.size()!=3){
                    pq.poll();
                }
                result[i]=pq.peek();
            }else{
                result[i]=pq.peek();
            }
            
        }
         for(int i : result){
            System.out.print(i + " ");
        }

    }
    public static void main(String args[]){
       optimalApproach();
    }
}
