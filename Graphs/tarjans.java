package Graphs;

import java.util.ArrayList;

import Graphs.allPaths.Edge;

public class tarjans {
     static class Edge {
        int src;
        int dest;
      

        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
           
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

       graph[0].add(new Edge(0, 1));
       graph[1].add(new Edge(1, 0));

       graph[0].add(new Edge(0, 2));
       graph[2].add(new Edge(2, 0));

       graph[1].add(new Edge(1, 2));
       graph[2].add(new Edge(2, 1));
    
       graph[0].add(new Edge(0, 3));
       graph[3].add(new Edge(3, 0));

        graph[3].add(new Edge(3, 4));
        graph[4].add(new Edge(4, 3));


    }

    public static void dfs(ArrayList<Edge>[] graph , int curr , int par , int[] dt , int[] low , boolean[] vis , int time){
        vis[curr]=true;
        dt[curr]=low[curr]=++time;

        for(int i = 0 ; i<graph[curr].size() ; i++){
            Edge e = graph[curr].get(i);
            int neighbour = e.dest;
            //3 Cases

            // Case 1 
            if(neighbour == par){
                continue;
            }
            else if(!vis[neighbour]){ //case when neigh is unviisted
                dfs(graph, neighbour, curr, dt, low, vis, time);
                //Back track
                //updating low
                low[curr]=Math.min(low[curr], low[neighbour]);
                //checking bridge
                if(dt[curr]<low[neighbour]){
                    System.out.println("Bridge : " + curr + "-----" + neighbour);
                }
            }else{ //case when neighbour is visited
                low[curr]=Math.min(low[neighbour], low[curr]);
            }
        }
    }


    public static void tarjansAlgo(ArrayList<Edge>[] graph){ //O(V+E) // dfs based
        boolean[] vis = new boolean[graph.length];
        int[] dt = new int[graph.length];
        int[] low = new int[graph.length];
        int time = 0; 

        for(int i  = 0 ; i<graph.length ; i++){
            if(!vis[i]){
                dfs(graph ,i , -1, dt ,  low ,  vis , time); //parent is -1 as we call this for the first of each disconneected component so it never has any parent

                }
            }
        }

    
    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        tarjansAlgo(graph);
        
    }
}
