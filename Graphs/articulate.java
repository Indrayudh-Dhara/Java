package Graphs;

import java.util.ArrayList;

public class articulate{
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

    public static void dfs(ArrayList<Edge>[] graph , boolean[] vis , boolean[] ap , int[] dt , int[] low , int time , int par , int curr){
        vis[curr]=true;
        //init
        dt[curr]=low[curr]=++time;
        int children = 0 ; //calculates children for every vertex

        for(int i= 0 ; i<graph[curr].size() ; i++){
            Edge e = graph[curr].get(i);
            int neighbour = e.dest;

            //3 cases

            //1st case
            if(neighbour == par){
                continue;

            }
            else if(vis[neighbour]){ //not ap
                low[curr]=Math.min(low[curr], dt[neighbour]);

            }
            else{ //disconnected child
                dfs(graph, vis, ap, dt, low, time, curr, neighbour);
                low[curr]=Math.min(low[curr] , low[neighbour]);
                if(dt[curr]<=low[neighbour]){
                    ap[curr]=true;
                    children++;
                }
            }
            //for the case 1 where parent is -1 (ie starting node) : happens after all recusive calls are completed
            if(par==-1 && children>1){
                ap[curr]=true;
            }

        }
    }

    public static void articulatePoint(ArrayList<Edge>[] graph){
        int[] dt = new int[graph.length]; //time to reach
        int[] low = new int[graph.length];//lowest time amongs its neighbours that arent their parents
        boolean[] vis = new boolean[graph.length];
        boolean[] ap = new boolean[graph.length]; //to store the articulate points and print all in once so that we dont print them multiple times

        int time = 0 ;

        for(int i = 0 ;i<graph.length ; i++){
            if(!vis[i]){
                dfs(graph , vis , ap , dt , low , time , -1 , i);
            }
        }

        for(int i  = 0 ; i<ap.length ; i++){
            if(ap[i]){
                System.out.println(" AP --> " + i);
            }
        }


    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        articulatePoint(graph);
    }
}