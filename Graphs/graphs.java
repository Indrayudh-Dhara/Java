package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


//adjacency list
public class graphs {

    static class Edge {
        int src;
        int dest;
        int weight;

        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // 0 -- 1 and 0 -- 2
        graph[0].add(new Edge(0, 1, 1));
        graph[1].add(new Edge(1, 0, 1));

        graph[0].add(new Edge(0, 2, 1));
        graph[2].add(new Edge(2, 0, 1));

        // 1 -- 3 and 1 -- 5
        graph[1].add(new Edge(1, 3, 1));
        graph[3].add(new Edge(3, 1, 1));

        // 2 -- 4
        graph[2].add(new Edge(2, 4, 1));
        graph[4].add(new Edge(4, 2, 1));

        // 3 -- 4 and 3 -- 5
        graph[3].add(new Edge(3, 4, 1));
        graph[4].add(new Edge(4, 3, 1));

        graph[3].add(new Edge(3, 5, 1));
        graph[5].add(new Edge(5, 3, 1));

        // 5 -- 6
        graph[5].add(new Edge(5, 6, 1));
        graph[6].add(new Edge(6, 5, 1));
    }

    //FOR MULTIPLE COMPONENTS , HERES HOW IT WORKS

   
    // It says:
    // “🐶 For every room (0 to 6):(assuming V=6)
    // If that room hasn’t been visited yet, go inside and explore everything from there.”
    // So:
    // First it starts at room 0 and explores 0 to 5(assuming they are connected) , boolean visited gets all 0-5 true in its first call (i=0)
    // Then it checks room 6, sees no one went there yet, and starts exploring it too (even if it’s disconnected)!

    public static void bfs(ArrayList<Edge>[] graph){
        boolean[] vis = new boolean[graph.length];

        for(int i= 0 ; i<graph.length ; i++){
            if(!vis[i]){
                bfsUtil(graph,i, vis);
            }
        }
    }
    public static void bfsUtil(ArrayList<Edge>[] graph , int i ,boolean[] visited){ //O(V/E) whoever is greater
        Queue<Integer> q = new LinkedList<>();
        q.add(i); //starting vertex
        while(!q.isEmpty()){       
            int vertex = q.remove();
            if(!visited[vertex]){
            System.out.print(vertex+ " ");
                visited[vertex]=true;
                for(int j = 0 ; j<graph[vertex].size() ; j++){
                    Edge e = graph[vertex].get(j);
                   
                    q.add(e.dest);
                }
            }
        }
    }

    public static void dfs(ArrayList<Edge>[] graph){
        boolean vis[] = new boolean[graph.length];
        //we are not doing visited check here as we are immediately returning if it is visited in dfsUtil
        for(int i = 0 ; i<graph.length ; i++){
            dfsUtil(graph, i, vis);
        }
    }

    //we can also write dfs in two different ways 
    //1. only doing recursion if not visited
    //2. using recursive calls only if (e.dest) isnt visited
    public static void dfsUtil(ArrayList<Edge>[] graph ,int curr , boolean[] visited){
        if(visited[curr]){
            return;
        }
        
            System.out.print(curr + " ");
            visited[curr] = true;
        
        for(int i=0 ; i<graph[curr].size() ; i++){
            Edge e = graph[curr].get(i); 
            dfsUtil(graph, e.dest, visited);
        }
    
    }

    public static boolean hasPath(ArrayList<Edge>[] graph , int src , int dest){ //USING BFS
        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[graph.length];
        
        q.add(src); //starting vertex
        while(!q.isEmpty()){
        
            int vertex = q.remove();
            if(!visited[vertex]){
            // System.out.print(vertex+ " ");
                visited[vertex]=true;
                for(int i = 0 ; i<graph[vertex].size() ; i++){
                    Edge e = graph[vertex].get(i);
                    if(e.dest==dest){
                        return true;
                    }
                    q.add(e.dest);
                }
            }
        }
        return false;
    }

    public static boolean hasPathDfs(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited) {
    if (src == dest) {
        return true;
    }

    visited[src] = true;

    for (Edge e : graph[src]) {
        if (!visited[e.dest]) {
            if (hasPathDfs(graph, e.dest, dest, visited)) {
                return true;
            }
        }
    }

    return false;
}


    public static void main(String[] args) {
        int v = 7; // total 7 vertices (0 to 6)
        ArrayList<Edge>[] graph = new ArrayList[v];
        createGraph(graph);
        
    //     0
    //    / \
    //   1   2
    //  /     \
    // 3------4
    // |
    // 5
    // |
    // 6
        // bfs(graph);
        boolean[] visited = new boolean[graph.length];
        for(int i  = 0 ; i<visited.length ; i++){
            visited[i]=false;
        }
        // dfs(graph, 0, visited);

        // System.out.println(hasPath(graph, 0, 5));
        System.out.println(hasPathDfs(graph, 0, 5, visited));
}
}
