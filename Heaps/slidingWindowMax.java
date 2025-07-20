package Heaps;

import java.util.Comparator;
import java.util.PriorityQueue;



public class slidingWindowMax {

    static class Pair implements Comparable<Pair>{
        int data;
        int index;
        Pair(int data, int index){
            this.data=data;
            this.index=index;
        }
        @Override
        public int compareTo(Pair p){
            return this.data-p.data;
        }

    }


   
    public static void main(String[] args) {
        int window[] = {1,3,-1, -3,5,3,6,7};
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int k =3;
        int result[] = new int[window.length-k+1];
        //1st window hardcode
        for(int i = 0; i<k ; i++){
            pq.add(new Pair(window[i], i));
        }

        result[0]=pq.peek().data;
        for(int i=k ; i<window.length ;i++){
            while(pq.size()>0 && pq.peek().index<=(i-k)){
                pq.remove();
            }

            pq.add(new Pair(window[i], i));
            result[i-k+1]=pq.peek().data;
        }
        

        //print result
        for(int i = 0 ; i<result.length ;i++){
            System.out.print(result[i]+" ");
        }


        
        
    }
}
