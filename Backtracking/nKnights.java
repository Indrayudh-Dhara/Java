package Backtracking;

public class nKnights {
    public static void printBoard(int board[][]){
        System.out.println("------board-----");
        for(int i = 0 ; i<board.length ; i++){
            for(int j = 0 ; j<board[0].length ;j++){
               System.out.print(board[i][j] + " ");
            }
            System.out.println();
          
        }
    }
    
    // public static boolean isSafe(int board[][] , int row , int col ){
    //     if(row-2>=0 && row-1>=0 && col-1>=0 && col-2>=0 && col+1<board[0].length && col+2<board[0].length &&row+2<board.length && row+1<board.length){
       
    //     //vertically up left row = -2 , col = -1
    //     if(board[row-2][col-1]!=0){
    //         return false;
    //     }
    //     //vertically up right row = -2 , col = +1
        
    //     if(board[row-2][col+1]==0){
    //         return false;
    //     }
    //     //horizontally left up
    //     if(board[row-1][col-2]==0){
    //         return false;
    //     }
    //     //horizontally right up

    //    if(board[row-1][col+2]==0){
    //     return false;
    //    }
    //     }

    // return true;
        
    // }
  

static boolean found = false;

public static void nKnightsCode(int board[][] , int row, int col ,int count){
    if (found) return;

    if(row<0 || col<0 || row>=board.length || col>=board[0].length || board[row][col]!=-1 )
        return;

    board[row][col] = count;

    if (count == 63) {
        printBoard(board);
        found = true;
        return;
    }

    nKnightsCode(board, row-2, col-1 , count+1);
    nKnightsCode(board, row-1, col-2,count+1);
    nKnightsCode(board, row-2, col+1,count+1);
    nKnightsCode(board, row-1, col+2,count+1);
    nKnightsCode(board, row+2, col-1,count+1);
    nKnightsCode(board, row+2, col+1,count+1);
    nKnightsCode(board, row+1, col-2,count+1);
    nKnightsCode(board, row+1, col+2,count+1);

    board[row][col] = -1;
}

    public static void main(String[] args) {
        int n = 8;
        int board[][] = new int[n][n];
        //initialize the board
        for(int i = 0 ; i<n ; i++){
            for(int j = 0 ; j<n ;j++){
                board[i][j]=-1;
                
            }
        // printBoard(board);
        
    }

    
}
};
