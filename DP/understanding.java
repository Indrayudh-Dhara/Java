package DP;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class understanding {
    //here we just start with whats DP

    //normal fibonacci code
    public static int fibonacciBasic(int n){
        if(n==1 || n==0){
            return n;
        }

        return fibonacciBasic(n-1) + fibonacciBasic(n-2);
    }
    //fibonacci code using DP (Memoization)
    public static int fibonacciDynamicM(int n , int[] dp){
        if(n==0 || n==1){
            return n;
        }
        // we store the already calculated fibonacci of a number in an array to avoid calling it multiple times in recursions
        if(dp[n]!=0){
            return dp[n];
        }
        dp[n]=fibonacciDynamicM(n-1, dp) +fibonacciDynamicM(n-2, dp);
        return dp[n];
    }

    //fibonacci code using DP (Tabulation)

    public static int fibonacciDynamicT(int n , int[] dp){
        dp[0]=0;
        dp[1]=1;

        for(int i = 2 ; i<dp.length ; i++){
            dp[i]=dp[i-1]+dp[i-2];
        }

        //nth dp is stored in dp[n];
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 5;
        int[] dp = new int[n+1]; //n+1 as 0 1 1 2 3 5 (0th based)
        int[] dp2 = new int[n+1];
        System.out.println(fibonacciBasic(n)); //5
        System.out.println(fibonacciDynamicM(n, dp));//5
        System.out.println(fibonacciDynamicT(n, dp2));//5
        String word = "Nigga";
      StringBuilder words = new StringBuilder()
      words.set;
      words.replace(0, 0, "a");
        System.out.println(word);
        List<String> wordList = new ArrayList<>();
        for(String words : wordList){

        }
        HashSet<Integer> hs = new HashSet<>();
        
        word.replace(word.charAt(0) , (char)('a'+0 ));
    }
}
