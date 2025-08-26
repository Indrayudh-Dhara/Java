package DP;



public class zeroOneKnapsack {


    //MEMOIZATION
    public static int code(int n , int W , int val[] , int wt[] , int dp[][]){

        //base case
        if(n==0 || W==0){
            return 0;
        }
        
        if(dp[n][W]!=-1){
            return dp[n][W];
        }
        //starting from last to first

        //if valid
        if(wt[n-1]<=W){
            //include
            int ans1 = val[n-1]+code(n-1 , W-=wt[n-1] , val , wt , dp); //basically we added our current val to the profit as we added the item , and also called to add the rest of the valid profits
            //exclude
            int ans2 = code(n-1 , W , val , wt, dp); //just like that as we are excluding here we do not add any profit and values but simply call for the next item

            return dp[n][W] = Math.max(ans1 , ans2); //both are the profit and we are returing whats max all the time at every level   when backtracking
        }else{
            //exclude ( not valid)

            return dp[n][W]=code(n-1 , W , val , wt , dp);
        }       

    }

    //TABULATION

    public static int codeTab(int W ,int n ,  int dp[][] , int wt[] , int val[]){
        //initialize (assigning rows / cols with n / W == 0 as it if either of them is zero , nothing can be taken thus maxProfit / profit in any way is zero
        for(int j = 0 ; j<dp[0].length ; j++){
            dp[0][j]=0;
        }
         for(int i = 0 ; i<dp.length ; i++){
            dp[i][0]=0;
        }
        //actual logic (each index holds the max profit for its corresponding ith and jth logic mentioned below)
        for(int i = 1; i<n+1 ;i++){ //i holds "the 0-ith item that can be considered" logic
            for(int j = 1 ; j<W+1 ; j++){ //j holds the "the maximum weight that can be allowed" logic 
                //now finding the value  and the weight of the current(ith) item
                int v  = val[i-1];
                int w = wt[i-1];
                //valid
                if(wt[i-1]<=j){
                    //include
                    int incProfit = v + dp[i-1][j-w];//dp[i-1][j-w]-->the profit which was stored whose weight satisfies the current weight that adds up to the total possible weight given (the col)
                    //exclude(||rly)
                    int excProfit = dp[i-1][j];
                    dp[i][j]=Math.max(incProfit , excProfit);
                }else{
                    //exclude (taking the profit except the current ith item (ie . taking taking the profit for the same W(weight / col ) but for the previous row))
                    int excProfit = dp[i-1][j];
                    dp[i][j]=excProfit;
                }
            }
        }
        return dp[n][W];//the last index (where all ns are considered and the entire Weight is taken);
    }
    public static void main(String[] args) {
        int val[] = { 15 , 14 , 10 , 45 , 30 };
        int wt[] = {2,5,1,3,4};
          int W = 7;
        int dp[][] = new int[val.length+1][W+1];

        for(int i = 0 ; i<dp.length ; i++){
            for(int j = 0 ; j<dp[0].length ; j++){
                dp[i][j]=-1;
            }
        }
      
        System.out.println(code(val.length ,  W, val, wt , dp));
        System.out.println(codeTab(W, val.length, dp, wt, val));
    }
    
}


