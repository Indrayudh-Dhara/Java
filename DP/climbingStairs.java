package DP;

public class climbingStairs {

    //O(n)
    public static int countWaysMem(int a, int n , int[] dp ){
        
        if(a==n){
           
            return 1;
        }
        if(a>n){
            return 0;
        }

        if(dp[a]!=0){
            return dp[a];
        }
        
          return dp[a]=countWaysMem(a+1, n ,dp)+countWaysMem(a+2, n ,dp) +countWaysMem(a+3, n, dp);

    }

    //O(n)
    public static int countWaysTab(int n){
        int[] dp = new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i =2 ; i<=n ; i++){
            dp[i]  =  dp[i-1]+dp[i-2];
        }

        return dp[n]; //count for nth stairs stored in nth index
    }

    // we can also approach this problem as climbing down the stairs 
    // Then its similar as Fibonacci

    public static void main(String[] args) {
        int n = 5;
        int[] dp = new int[n+1];
        System.out.println(countWaysTab(n));
    }
}
