package Greedy;

import java.util.Arrays;

public class minAbsDiffPairs {

    //minimum absolute difference pairs

    public static void pairs(int A[] , int B[]){
        Arrays.sort(A);
        Arrays.sort(B);
        //i basically MADE a pair to make it more obvious and reasonable , this step is usually skippable
        int pairs[][] = new int[A.length][2];
        for(int i = 0 ; i<pairs.length ; i++){
            pairs[i][0]=A[i];
            pairs[i][1]=B[i];
        
        }
       int sum = 0 ;

       for(int i= 0 ; i<pairs.length ; i++){
        int diff = pairs[i][0]-pairs[i][1];
        sum+=Math.abs(diff);
       }
       System.out.println(sum);

    }
    public static void main(String[] args) {
        int A[]={1,2,3};
        int B[]={2,1,3};
        pairs(A, B);
    }
}
