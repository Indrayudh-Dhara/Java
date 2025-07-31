package Graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class connectingCities {
    static class Edge{
        int src;
        int dest;
        int cost;
        public Edge(int src , int dest , int cost){
            this.src = src;
            this.dest=dest;
            this.cost=cost;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph , int[][] cities){
        for(int i = 0 ; i<graph.length ; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0 ; i<cities.length ; i++){
            for(int j = 0 ; j<cities[0].length ; j++){
                int cost = cities[i][j];
                //graph is only supposed to be made when cost is not zero and no self loops (i==j)
                if (i != j && cost != 0) {
                    graph[i].add(new Edge(i, j, cost));
                    graph[j].add(new Edge(j, i, cost)); // Because it's undirected
        }
            }
        }
    }

    static class Pair implements Comparable<Pair>{
        int v ;
        int cost;

        public Pair(int v , int cost){
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Pair p){
            return this.cost - p.cost; //increasing order
        }

    }
    public static int minimumCost(int[][] cities ){
        ArrayList<Edge>[] graph = new ArrayList[cities.length];
        createGraph(graph, cities);

        boolean[] vis = new boolean[graph.length];

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0));
        int finalCost= 0;
        while(!pq.isEmpty()){
            Pair p = pq.remove();
            if(!vis[p.v]){
                vis[p.v]=true;
                finalCost+=p.cost;
                //adding its neighbours as Pairs in PQ
                for(int i= 0 ;i<graph[p.v].size() ; i++){
                    Edge e = graph[p.v].get(i);
                    int v = e.dest;
                    int cost = e.cost;
                    pq.add(new Pair(v, cost));
                }
            }
        }
        return finalCost;
    }

    public static void main(String[] args) {
        //In cities[i][j] : i-src , j-dest , cities[i][j]==cost from i-->j
        //no of cities == 5 : 1 , 2 , 3, 4, 5 (cities.length)
        int[][] cities = {{0,1,2,3,4},{1,0,5,0,7} , {2,5,0,6,0} , {3,0,6,0,0} , {4,7,0,0,0}};
        System.out.println(minimumCost(cities));
    }
}
