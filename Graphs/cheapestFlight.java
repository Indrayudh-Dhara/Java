package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class cheapestFlight {
    static class Edge{
        int src;
        int dest;
        int cost;
        public Edge(int src , int dest , int cost){
            this.src = src;
            this.dest=dest;
            this.cost=cost;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph , int[][] flights){
        for(int i  = 0 ; i<graph.length ; i++){
            graph[i]=new ArrayList<>();
        }

        for(int i = 0 ;i<flights.length ; i++){
            int src = flights[i][0];
            int dest = flights[i][1];
            int cost = flights[i][2];

            Edge e = new Edge(src, dest, cost);

            graph[src].add(e);
        }

    }

    static class Info{
        int vertex;
        int cost;
        int stops;

        public Info(int v , int c , int s){
            this.vertex = v;
            this.cost= c;
            this.stops =s;

        }
    }


    public static int cheapestFlightwithKStops(int[][] flights , int n , int src , int dst , int k){
       
        ArrayList<Edge>[] graph = new ArrayList[n];
        createGraph(graph, flights);
        //modified dijkstra

        //a array to store the cheapest cost which satisfies the  to reach that dest
        int[] costs = new int[graph.length];

        //initialize all cost to infinity
        for(int i = 0 ;i<n ; i++){
            if(i!=src){
                costs[i]=Integer.MAX_VALUE;
            }
        }

        //algo

        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src, 0, 0));//starting from src 

        while(!q.isEmpty()){
            Info curr =q.remove();
            if(curr.stops >k){
                break;
            }

            //take out their neightbours 
            for(int i  = 0 ; i<graph[curr.vertex].size() ; i++){
                Edge e = graph[curr.vertex].get(i);
                int u = e.src; //source of current
                int v = e.dest; //neighbout of current;
                int cost = e.cost;//cost of current
                //we cant do cost[u]+wt as if we do we will only be taking the least cost irregardless or the path , we cant do that as we have to take the cost of the path(curr) which satisfies the k condition
                //so we will be taking the cost of the current path (curr.cost or e.src.cost) - curr.cost is the cost required to go TO that path
                if(curr.cost + cost < costs[v] && curr.stops <=k){
                    costs[v]=curr.cost+cost;
                    q.add(new Info(v, costs[v], curr.stops+1));//adding the next stop
                }            
            }  
        } 

        if(costs[dst]==Integer.MAX_VALUE){ //no such path 
            return -1;
        }else{
            return costs[dst];
        }
    }

    public static void main(String[] args) {
        //flights - src , dest , cost
        int n = 4; //4 vertexes 1 , 2, 3, 4
        int[][] flights = {{0,1,100} , {1,2,100}, {2,0,100},{1,3,600},{2,3,200}};
        int src = 0  , dst = 3 , k=1;
        System.out.println(cheapestFlightwithKStops(flights,n, src, dst, k));
    }
}
