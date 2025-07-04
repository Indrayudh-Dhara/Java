package Heaps;

import java.util.PriorityQueue;

public class nearbyNcars {
    static class Cars implements Comparable<Cars>{
        int x;
        int y;
        String name;
        int dist;
        public Cars(int x , int y , String name){
            this.name = name;
            this.x = x;
            this.y=y;
            this.dist= x*x +y*y;
        }

        @Override
        public int compareTo(Cars C){
            return this.dist-C.dist;   
        }
    }

     static class CarsV2 implements Comparable<CarsV2>{
        int x;
        int y;
        String name;
        int dist;
        public CarsV2(int x , int y , String name){
            this.name = name;
            this.x = x;
            this.y=y;
            this.dist= x*x +y*y;
        }

        @Override
        public int compareTo(CarsV2 C){
            return this.dist-C.dist;   
        }
    }
    

    public static void nearestKcars(PriorityQueue<Cars> pq , int k){
        for(int i =  1; i<=k ; i++){
            System.out.print(pq.remove().name + " ");
        }
    }

    public static void nearestKcarsV2(PriorityQueue<CarsV2> pq , int k){
         for(int i =  1; i<=k ; i++){
            System.out.print(pq.remove().name + " ");
        }
    }

    public static void main(String[] args) {
        // PriorityQueue<Cars> pq = new PriorityQueue<>();
        // pq.add(new Cars(3,3,"C0"));
        // pq.add(new Cars(5, -1, "C1"));
        // pq.add(new Cars(-2, 4, "C2"));

        // nearestKcars(pq, 2);


        //variant -> points comes in 2d array

        int points[][] = {{3,3},{5,-1},{-2,4}};
        PriorityQueue<CarsV2> pq2 = new PriorityQueue<>();
        for(int i = 0 ; i<points.length; i++){ //nlogn (each add in pq (min heap) takes logn and we do this for n times n-> points.length)
            pq2.add(new CarsV2(points[i][0],points[i][1], "C"+i));
        }
        nearestKcarsV2(pq2 , 2); 
    }
}
