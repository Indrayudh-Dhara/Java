package Heaps;

import java.util.PriorityQueue;

public class nRopes {


    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int ropes[]={2,3,3,4,6};
        for(int i = 0 ; i<ropes.length ; i++){
            //least number is the highest prio
            pq.add(ropes[i]);

        }
        int cost =0;
        while(!pq.isEmpty()){   
            int rope1 = pq.remove();
            int rope2 = pq.remove();
            cost += rope1+rope2;
            if(pq.size()==0){
                //breaks when all the cost are evaluated no need to add the sum further
                break;
            }
            pq.add(rope1+rope2);
        }
        //or you can use pq.size>1 and skip the break statement
        
        System.out.println(cost);
    }
}
