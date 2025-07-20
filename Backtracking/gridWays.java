package Backtracking;

import java.util.HashMap;

public class gridWays {


    public static int gridWaysCode(int grid[][], int row , int col){
        int count=0;
        //base case
        if(row==grid.length-1 && col==grid[0].length-1){
            return 1;
        }
        //recursion
        if(row<grid.length-1){
        count+=gridWaysCode(grid,row+1,col);
        }
        if(col<grid[0].length-1){
           count+= gridWaysCode(grid, row, col+1);
        }
        return count;


    }

    public static int gridWaysOptimized(int grid[][]){
        //linear time O(n)
        int n=grid.length;
        int m=grid[0].length;

        return factorial(m+n-2)/(factorial(n-1)*factorial(m-1));

   
    }

    public static int factorial(int n){
        int result =1;
        for(int i=2 ; i<=n ; i++){
            result*=i;
        }
        return result;
    }

    public static void main(String[] args) {
        int grid[][]=new int[4][5];
        System.out.println(gridWaysOptimized(grid));

    }
}
