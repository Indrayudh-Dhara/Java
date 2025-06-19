package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class IndianCoins {

    public static void code(int coins[] , int V){
        int capacity = V;
        int minReq = 0;
        ArrayList<Integer> change = new ArrayList<>();
       for(int i= coins.length-1 ; i>=0 ; i--){
        if(coins[i]<=capacity){
            while(coins[i]<=capacity){
            change.add(coins[i]);
            capacity-=coins[i];
            minReq++;
            }
            
        }
       }
       System.out.println(change);
       System.out.println(minReq);
    }
    public static void main(String[] args) {
        int coins[] ={1,2,5,10,20,50,100,500,2000};
        code(coins, 590);
    }
}
