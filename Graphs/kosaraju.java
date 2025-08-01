package Graphs;

import java.util.ArrayList;
import java.util.Stack;

public class kosaraju {

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

       graph[0].add(new Edge(0, 2));
       graph[0].add(new Edge(0, 3));
       graph[1].add(new Edge(1, 0));
       graph[2].add(new Edge(2, 1));
       graph[3].add(new Edge(3, 4));
    }

    public static void topSort(ArrayList<Edge>[] graph , boolean[] vis , Stack<Integer>  s, int curr){
        vis[curr]=true;
        for(int i = 0 ;i<graph[curr].size() ; i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                topSort(graph, vis, s, e.dest);

            }
        }
        
    }

    public static void dfs(ArrayList<Edge>[] transpose , boolean[] vis , int curr){
        vis[curr] =true ;
        System.out.print(curr + " ");
        for(int i = 0 ; i<transpose[curr].size() ; i++){
            Edge e = transpose[curr].get(i);
            if(!vis[e.dest]){
                dfs(transpose, vis, e.dest);
            }

        }
    }

    public static void kosarajuAlgo(ArrayList<Edge>[] graph){ //O(V+E)
        createGraph(graph);
        boolean[] vis = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();
        //Top sort
        for(int i = 0 ; i<graph.length ; i++){
            if(!vis[i]){
                topSort(graph, vis, s, i);
            }
        }

        //Tranpose
        ArrayList<Edge>[] transpose = new ArrayList[graph.length];
        for(int i = 0 ;i<transpose.length ; i++){
            transpose[i]=new ArrayList<>();
        }

        for(int i= 0 ;i<graph.length ; i++){
            vis[i]=false; // making visited array false for using it again in dfs 
            for(int j = 0 ; j<graph[i].size() ; j++){
                Edge e = graph[i].get(j);
                transpose[e.dest].add(new Edge(e.dest, e.src));
            }
        }

        //dfs on transpose
        for(int i = 0 ; i<transpose.length ; i++){
            if(!vis[i]){
                System.out.print("SCC -> ");
                dfs(transpose, vis, i);
                System.out.println();
            }
        }

    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V];
        kosarajuAlgo(graph);
    }
}
