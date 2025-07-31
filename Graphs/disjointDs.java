package Graphs;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class disjointDs {

    static int n = 7;
    static int[] par = new int[n];
    static int[] rank = new int[n]; //starts with all 0 default

    public static void init( ){
        for(int i = 0 ; i<par.length ; i++){
            par[i]=i;
        }
    }

    public static int find(int a){
        if(par[a]==a){
            return a ;
        }
        //normally return find(par[a])
        return par[a]= find(par[a]);//path compression optimization
        //basically for the first time we find someone (its leader) while finding we update it entirely to its leader instead of its parent as we dont really need parent in this DS
    }

    public static void union(int a , int b){
        int parA = find(a);
        int parB = find(b);

        if(rank[parA] == rank[parB]){
            par[parB]=parA;
            rank[parA]++;
        }
        else if(rank[parA]>rank[parB]){
            par[parB]=parA;
        }else{
            par[parA]=parB;
        }

    }

    //TC
    //UNION - O (1)
    //FIND - O(1)
    public static void main(String[] args) {
        init();
        LinkedHashSet<Integer> ls = new LinkedHashSet<>();
        
    }
}
