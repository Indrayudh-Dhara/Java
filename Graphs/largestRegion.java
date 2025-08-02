package Graphs;


public class largestRegion {

    static int maxCount = 0; 

    public static void dfs(int[][] matrix , boolean[][] vis , int row , int col , int count){
        vis[row][col]=true;
        count++;
        maxCount = Math.max(maxCount, count);

        if(row>=0 && col>=0 && row<matrix.length && col<matrix[0].length){
            if(row+1<matrix.length && matrix[row+1][col]==1 && !vis[row+1][col]){
                dfs(matrix, vis, row+1, col, count);
            }
            if(row-1>=0 && matrix[row-1][col]==1 && !vis[row-1][col]){
                dfs(matrix, vis, row-1, col, count);
            }
            if(row+1<matrix.length &&  col+1<matrix[0].length && matrix[row+1][col+1]==1 && !vis[row+1][col+1]){
                dfs(matrix, vis, row+1, col+1, count);
            }
            if(row-1>=0 && col-1>=0 && matrix[row-1][col-1]==1 && !vis[row-1][col-1]){
                dfs(matrix, vis, row-1, col-1, count);
            }
            if(col+1<matrix[0].length && matrix[row][col+1]==1 && !vis[row][col+1]){
                dfs(matrix, vis, row, col+1, count);
            }
            if(col-1>=0 && matrix[row][col-1]==1 &&!vis[row][col-1]){
                dfs(matrix, vis, row, col-1, count);
            }
            if(row+1<matrix.length && col-1>=0 && matrix[row+1][col-1]==1 &&!vis[row+1][col-1]){
                dfs(matrix, vis, row+1, col-1, count);
            }
            if(col+1<matrix[0].length && row-1>=0 && matrix[row-1][col+1]==1 &&!vis[row-1][col+1]){
              dfs(matrix, vis, row-1, col+1, count);
            }
         
        }

        
    }

    public static void code(int matrix[][]){
        boolean[][] vis = new boolean[matrix.length][matrix[0].length];
        for(int i = 0 ; i<matrix.length ; i++){
            for(int j = 0 ; j<matrix[0].length ; j++){
                if(!vis[i][j] && matrix[i][j]==1 ){
                    int count= 0;
                    dfs(matrix ,vis , i , j , count);
                }
            }
        }
        System.out.println("Largest Region is  : " + maxCount);
    }
    public static void main(String[] args) {
        
        int matrix[][]={{1, 1, 0, 0, 0, 1, 0, 0},
 {0, 1, 1, 0, 1, 1, 0, 0},
 {0, 0, 1, 1, 0, 0, 1, 0},
 {1, 0, 0, 1, 1, 0, 1, 1},
 {0, 1, 1, 0, 1, 1, 0, 1},
 {0, 0, 0, 1, 0, 1, 1, 1},
 {1, 1, 0, 0, 1, 0, 0, 0}}
;
        code(matrix); //19
    }

}
