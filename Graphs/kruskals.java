package Graphs;

import java.util.ArrayList;
import java.util.Collections;

public class kruskals {

    //KRUSKALS ALGO - SORT EDGES BASED ON WEIGHT , ADD ALL THE EDGES USING DISJOING SETS D.S IF THEY DOESNT FORM A CYCLE
    static class Edge implements Comparable<Edge> {
        int src;
        int dest;
        int wt;
        

        public Edge(int src, int dest , int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
        @Override
        public int compareTo(Edge e){
            return this.wt - e.wt;//ascending
        }
    }   

    public static void createGraph(ArrayList<Edge> edges){
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 15));
        edges.add(new Edge(0, 3, 30));
        edges.add(new Edge(1, 3, 40));
    }
    //implementing disjoint
    static int n =4;
    static int[] rank= new int[n];
    static int[] par = new int[n];

    public static void init(){
        for(int i = 0 ; i<par.length ; i++){
            par[i]=i;
        }
    }

    public static int find(int a){
        if(par[a]==a){
            return a;
        }
        return par[a]=find(par[a]);
    }

    public static void union(int a , int b){
        int parA = find(a);
        int parB = find(b);

        if(rank[parA]==rank[parB]){
            par[parB]=parA;
            rank[parA]++;
        }else if(rank[parA]>rank[parB]){
            par[parB]=parA;
        }else{
            par[parA]=parB;
        }
    }

    public static void kruskalsAlgo(ArrayList<Edge> edges){
      
        int mstCost=0;
        //sort edges
        Collections.sort(edges);//O(ElogE) //gets sorted in ascending due to the comparable that is implement on edges
        for(int i = 0 ; i<edges.size() ; i++){
            //add edges (ie union)
            Edge e = edges.get(i);
            int a = e.src;
            int b = e.dest;
            int cost = e.wt;
            //check cycle (cycle means parents of src and dest are the same and when we try to connect both , a cycle is formed)
            int parA = find(a);
            int parB = find(b);
            if(parA!=parB){
                union(a, b);
                mstCost+=cost;
            }
        }
        System.out.println(mstCost);
    }

    public static void main(String[] args) {
        init();
        ArrayList<Edge> edges = new ArrayList<>();
        createGraph(edges);
        kruskalsAlgo(edges);
    }
}
