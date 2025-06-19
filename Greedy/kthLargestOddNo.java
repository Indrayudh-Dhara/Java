package Greedy;

import java.util.ArrayList;

import java.util.Collections;

public class kthLargestOddNo {

    public static void code(int L , int R , int K){
    
        ArrayList<Integer> odds = new ArrayList<>();
        //adding only the odds starting from L to R inclusive [L,R]
        for( int i=L ; i<=R ; i++){
            if(i%2!=0){
                odds.add(i);
            }
            

        }
        Collections.sort(odds , Collections.reverseOrder()); //sorts odds in descending

        //odds are in descending order

        if(K>odds.size()){
            System.out.println("Odd doesnt exist");
        }else{
        System.out.println("Kth Largest Odd number is "+ odds.get(K-1));
        }
    }
    public static void main(String[] args) {
        code(-3, 3, 1);
        
    }
}
