package Graphs;

import java.util.ArrayList;


public class bellmanFord {
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

        graph[1].add(new Edge(1, 2,-4));

        graph[2].add(new Edge(2, 3, 2));

        graph[3].add(new Edge(3, 4, 4));

        graph[4].add(new Edge(4, 1, -1));

      
    }

    //i can make this compact if we just use ArrayList<Edge> as the graph as we just need all the edges and not necessarily need indexed based edging
    public static void bellmanFordAlgo(ArrayList<Edge>[] graph , int src){
        int[] dis = new int[graph.length];
        for(int i = 0 ;i<graph.length ; i++){
            if(i!=src){
                dis[i]=Integer.MAX_VALUE;
            }
        }

        //algo
        int V = graph.length;
        //total complexity O(V*E)
        for(int i = 0 ;i<V-1 ; i++){
            //O(E)
            for(int j = 0 ; j < graph.length ; j++){
                for(int k = 0 ;k<graph[j].size() ; k++){
                    Edge e = graph[j].get(k);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;
                    if(dis[u]!=Integer.MAX_VALUE && dis[u]+wt<dis[v]){
                        dis[v] = dis[u]+wt;
                    }
                }
            }
        }

        for(int i : dis){
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        bellmanFordAlgo(graph, 0);
    }
}
