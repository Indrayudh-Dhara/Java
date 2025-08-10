package DP;

public class zeroOneKnapsack {


    public static int code(int n , int W , int val[] , int wt[]){

        //base case
        if(n==0 || W==0){
            return 0;
        }
        //starting from last to first

        //if valid
        if(wt[n-1]<=W){
            //include

            int ans1 = val[n-1]+code(n-1 , W-=wt[n-1] , val , wt); //basically we added our current val to the profit as we added the item , and also called to add the rest of the valid profits

            //exclude
            int ans2 = code(n-1 , W , val , wt); //just like that as we are excluding here we do not add any profit and values but simply call for the next item

            return Math.max(ans1 , ans2); //both are the profit and we are returing whats max all the time when backtracking
        }else{
            //exclude ( not valid)

            return code(n-1 , W , val , wt);
        }       

    }
    public static void main(String[] args) {
        int val[] = { 15 , 14 , 10 , 45 , 30 };
        int wt[] = {2,5,1,3,4};
        int W = 7;
        System.out.println(code(val.length ,  W, val, wt));
    }
    
}


