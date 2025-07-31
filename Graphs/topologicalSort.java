package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class topologicalSort {
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

        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3,1));
        graph[4].add(new Edge(4,0));
        graph[4].add(new Edge(4,1));
        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5,2));


      
    }

    public static void topSort(ArrayList<Edge>[] graph){
        boolean vis[] = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();
        for(int i = 0 ; i<graph.length ; i++){
            if(!vis[i]){
                topSortUtil(graph , i , vis , s);
            }
        }

        while(!s.isEmpty()){
            System.out.print(s.pop() + " ");
        }
    }

    public static void topSortUtil(ArrayList<Edge>[] graph , int curr , boolean[] vis , Stack<Integer> s){
        vis[curr]=true;
        for(int i = 0 ; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                topSortUtil(graph, e.dest, vis, s);
            }
        }
        s.push(curr);//recusively push at the end , this will push the top elements at the end during the end of recursion 

    }

    //topological sort using Kahn's algo (BFS INDEGREE)

    public static void indegree(ArrayList<Edge>[] graph , int[] indegree){
        for(int i = 0 ; i<graph.length ; i++){
            for(int j = 0 ; j <graph[i].size(); j++){
                Edge e = graph[i].get(j);
                indegree[e.dest]++;
            }
        }
    }
    
    public static void topSortKahn(ArrayList<Edge>[] graph){
        int[] indegree = new int[graph.length];
        indegree(graph , indegree);

        Queue<Integer> q = new LinkedList<>();//only contains the indegree 0 els and the curr els to be added in top sort order

        //add the starting points (indegree 0)
        for(int i = 0 ; i<indegree.length ; i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }

        //bfs

        while(!q.isEmpty()){
            int curr = q.remove();
            System.out.print(curr + " ");
            for(int i = 0 ; i< graph[curr].size() ; i++){
                Edge e = graph[curr].get(i);
                indegree[e.dest]--;
                if(indegree[e.dest]==0){
                    q.add(e.dest);
                }
            }
            
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int v = 6;
        ArrayList<Edge>[] graph = new ArrayList[v];
        createGraph(graph);
        // topSort(graph);
        topSortKahn(graph);

    }

}
