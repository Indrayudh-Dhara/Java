package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import Queue.interleave2halves;

public class detectcycle {
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
        graph[3].add(new Edge(3, 4, 1));
        graph[4].add(new Edge(4, 3, 1));

        graph[3].add(new Edge(3, 5, 1));
        graph[5].add(new Edge(5, 3, 1));

        // 5 -- 6
        graph[5].add(new Edge(5, 6, 1));
        graph[6].add(new Edge(6, 5, 1));
    }

    static class Info{
        int curr;
        int par;
        public Info(int c , int p){
            this.curr = c;
            this.par = p;
        }
    }

    public static boolean cycleBfs(ArrayList<Edge>[] graph){
        boolean[] vis= new boolean[graph.length];

      
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(0, 0));
        while(!q.isEmpty()){
            Info info = q.remove();
            if(!vis[info.curr]){
                vis[info.curr]=true;
                for(int i = 0 ; i<graph[info.curr].size() ; i++){
                    Edge e = graph[info.curr].get(i);
                    if(!vis[e.dest]){
                        q.add(new Info(e.dest, info.curr)); 
                    }else if(e.dest!=info.par){
                        return true;
                    }

                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
    //     0
    //    / \
    //   1   2
    //  /     \
    // 3------4
    // |
    // 5
    // |
    // 6
    ArrayList<Edge>[] graph = new ArrayList[7];
    createGraph(graph);
    System.out.println(cycleBfs(graph));

    }
}
