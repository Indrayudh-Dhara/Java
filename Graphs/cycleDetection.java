package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


//adjacency list
public class cycleDetection {

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

        // 1 -- 3 
        graph[1].add(new Edge(1, 3, 1));
        graph[3].add(new Edge(3, 1, 1));

        // 2 -- 4
        graph[2].add(new Edge(2, 4, 1));
        graph[4].add(new Edge(4, 2, 1));

        // 3 -- 4 and 3 -- 5
        // graph[3].add(new Edge(3, 4, 1));
        // graph[4].add(new Edge(4, 3, 1));

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


    public static boolean hasCycle(ArrayList<Edge>[] graph){
        boolean vis[] = new boolean[graph.length];
        //we are not doing visited check here as we are immediately returning if it is visited in dfsUtil
        for(int i = 0 ; i<graph.length ; i++){
            if(!vis[i]){
                if(hasCycleUtil(graph, i,-1, vis)){
                return true;
            };
            }
            
        }
        return false;
    }

    
    public static boolean hasCycleUtil(ArrayList<Edge>[] graph ,int curr ,int parent , boolean[] visited){
        visited[curr]=true;
        for(int i = 0 ; i<graph[curr].size() ; i++){
            Edge e = graph[curr].get(i);
            //case 3
            if(!visited[e.dest]){
                if(hasCycleUtil(graph, e.dest,curr, visited)){
                    return true;
                }
                //case 1
            }else if(visited[e.dest] && e.dest!=parent){ //e.dest is not the parent for the current node then its a cycle 
                return true;
            }
            //case 2 (do nothing)
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
        System.out.println(hasCycle(graph));
    
}
}
