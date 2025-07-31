package Graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class dijkastra {
     static class Edge  {
        int src;
        int dest;
        int wt;
        

        Edge(int src, int dest , int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

      public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0,1,2));
        graph[0].add(new Edge(0,2,4));

        graph[1].add(new Edge(1, 3,7));
        graph[1].add(new Edge(1, 2, 1));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));

      
    }

    static class Pair implements Comparable<Pair> {
        int n ;
        int path;
        public Pair(int n , int path){
            this.n = n;
            this.path = path;
        }

        @Override
        public int compareTo(Pair p){
           return this.path - p.path ; //ascending
        }
    }

    public static void dijkstra(ArrayList<Edge>[] graph , int src){ //O(nlogn)
        int[] dis = new int[graph.length] ; //to store distances of every index
        //initialize dist of all vertex from infinity except src
        for(int i = 0 ; i<graph.length ; i++){
            if (i!=src){
                dis[i]=Integer.MAX_VALUE;
            }
        }
        boolean[] vis = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>(); //pq to store paths in increasing order by deafult 
        pq.add(new Pair(src, 0)); //starting with src and its default 0 path

        while(!pq.isEmpty()){
            Pair curr = pq.remove();//
            if(!vis[curr.n]){
                vis[curr.n]=true;
                for(int i = 0 ; i<graph[curr.n].size(); i++){
                    Edge e = graph[curr.n].get(i);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;
                    //u-->v calculation
                    if(dis[u]+wt<dis[v]){
                        dis[v]=dis[u]+wt;
                        pq.add(new Pair(v, dis[v]));
                    }
                }
            }

        }

        for(int d : dis){
            System.out.println(d + " ");
        }
    }

    public static void main(String[] args) {
        ArrayList<Edge>[] graph = new ArrayList[6];
        createGraph(graph);
        dijkstra(graph, 0);

    }
}
