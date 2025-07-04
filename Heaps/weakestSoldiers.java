package Heaps;

import java.util.PriorityQueue;



public class weakestSoldiers {
    static class soldierRows implements Comparable<soldierRows>{
        int soldiers;
        String name;
        int index;
        public soldierRows(int row[] , int index , String name){
            for(int i= 0 ; i<row.length ; i++){
                this.soldiers+=row[i];
            }
            this.index=index;
            this.name = name;
        }

        @Override
        public int compareTo(soldierRows s){
            if(this.soldiers!=s.soldiers){
                return this.soldiers-s.soldiers;
            }else{
                return this.index-s.index;
            }
        }
    }


    public static void main(String[] args) {
        PriorityQueue<soldierRows> pq = new PriorityQueue<>();
        int army[][]={
            {1,0,0,0},
            {1,1,1,1},
            {1,0,0,0},
            {1,0,0,0},
        };

        for(int i = 0 ; i<army.length ; i++){
            pq.add(new soldierRows(army[i], i , "R"+i));
        }

        for(int i = 1 ; i<=2 ; i++ ){
            System.out.println(pq.remove().name);
        }
    }
}
