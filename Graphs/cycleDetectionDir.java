package Graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public class cycleDetectionDir {
    static class Edge{
        int src ;
        int dest ;
        public Edge(int src , int dest){
            this.src=src;
            this.dest=dest;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph){
        for(int i= 0 ; i<graph.length ; i++){
            graph[i]=new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[2].add(new Edge(2, 3));
        graph[1].add(new Edge(1, 3));


    }

    public static boolean hasCycle(ArrayList<Edge>[] graph){
        boolean vis[]= new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];
       
        for(int i = 0 ; i<graph.length ; i++){
        
            if(!vis[i]){
                if(hasCycleUtil(graph , i , vis , stack)){
                    return true;
                };
            }
        }
        return false;
        HashSet<Integer> h = new HashSet<>();
        h.
    }

    public static boolean hasCycleUtil(ArrayList<Edge>[] graph , int curr , boolean[] vis , boolean[] stack){
        vis[curr] = true;
        stack[curr]=true; //to track the current elements for the current recursive calls

        for(int i = 0 ; i < graph[curr].size() ; i++){
            Edge e = graph[curr].get(i);
            if(stack[e.dest]){
                return true;
            }
            else if(!vis[e.dest]){
                if(hasCycleUtil(graph , e.dest , vis , stack)){
                    return true;
                }
            }
            
        }
        stack[curr]= false;
        return false;
    }

    public static void main(String[] args) {
        int v=5;
        ArrayList<Edge>[] graph = new ArrayList[v];
        createGraph(graph);
        System.out.println(hasCycle(graph));
    }
}
