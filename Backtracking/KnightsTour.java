package Backtracking;

public class knightsTour {
    //not optimized using Warnsdorff’s Heuristic
    public static void printBoard(int board[][]){
        System.out.println("-----board-----");
        for(int i = 0 ; i<board.length ; i++){
            for(int j = 0 ; j<board[0].length ; j++){
                System.out.println(board[i][j]+ " ");
            }
            System.out.println();
        }
    }

    static int dx[] = {-2 , -2 , -1 , -1 , +2 , +2 , +1 , +1 };  //all the moves for x dimension (row of board)
    static int dy[] = {+1 , -1 , -2 ,  2 , -1 , +1 , -2 , +2};  //all the moves for y dimension (col of board)
    static int n = 6; //board size

    public static boolean solve(int board[][] , int moveCount , int x , int y ){
        //base case -> all cells traversed thus its a valid solution
        if(moveCount == n * n){
            
            return true;
        }

        for(int i = 0 ; i < 8 ; i++){
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if(isSafe(board, nextX, nextY)){
                board[nextX][nextY] = moveCount;

                if(solve(board, moveCount + 1, nextX, nextY)){
                    return true;
                }

                // backtrack
                board[nextX][nextY] = -1;
            }
        }
        return false;
    }

    public static boolean isSafe(int board[][] , int x , int y){
        return x >= 0 && x < n && y >= 0 && y < n && board[x][y] == -1;
    }

    public static void main(String[] args) {
        int board[][] = new int[n][n];

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                board[i][j] = -1;
            }
        }

        board[0][0] = 0;

        if(solve(board, 1 , 0 , 0)){
            printBoard(board);
        } else {
            System.out.println("No solution exists");
        }
    }
}

