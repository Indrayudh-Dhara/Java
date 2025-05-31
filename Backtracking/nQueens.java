package Backtracking;

public class nQueens {

    public static boolean nQueensCode(char board[][] , int row){
       
        //base case
        if(row==board.length){
            System.out.println("There is a solution!");
            printBoard(board);
            return true;
             
        }

        //nq in nrows for
        //now nq in nrows while checking condition which is if its safe or not 
        
        //looping in column
        
        for(int j= 0 ;j<board.length ; j++){
            
            if(isSafe(board,  row ,  j)){
                 board[row][j]='Q';
                if(nQueensCode(board, row+1)){
                    return true;
                };
                 board[row][j]='X';
                 
            
        }
        }
        return false;

    }

    public static void nQueensCodeAllWays(char board[][] , int row){
       
        //base case
        if(row==board.length){
            System.out.println("There is a solution!");
            printBoard(board);
            return ;
             
        }

        //nq in nrows for
        //now nq in nrows while checking condition which is if its safe or not 
        //looping in column
        
        for(int j= 0 ;j<board.length ; j++){ 
            if(isSafe(board,  row ,  j)){
                 board[row][j]='Q';
                nQueensCodeAllWays(board, row+1);
                 board[row][j]='X';           
        }
    }
    
}

       public static int nQueensCodeCountWays(char board[][] , int row){
       
        int count = 0;
        //base case
        if(row==board.length){
            return 1;
             
        }

        //nq in nrows for
        //now nq in nrows while checking condition which is if its safe or not 
        //looping in column
        
        for(int j= 0 ;j<board.length ; j++){ 
            if(isSafe(board,  row ,  j)){
                 board[row][j]='Q';
               count += nQueensCodeCountWays(board, row+1);
                 board[row][j]='X';           
        }
    }
    return count;
    
}

    public static boolean isSafe(char board[][], int row , int col){
        //vertically up
        for(int i= row-1 ; i>=0 ; i--){
            if(board[i][col]=='Q'){
                return false;
            }
        }
        //diagonally left up
        for(int i=row-1 , j =col-1; i>=0 && j>=0 ;i--,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }

        //diagonally right up
        for(int i=row-1 , j=col+1 ; i>=0 && j<board[0].length; i--,j++){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        return true;

    }

    public static void printBoard(char board[][]){
        System.out.println("-----chess board-----");
        for(int i = 0 ; i<board.length ; i++){
            for(int j = 0 ; j<board[0].length ; j++){
                System.out.print(board[i][j]+ " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int n=4;
        char board[][] = new char[n][n];
        //initialize board
        for(int i = 0  ; i<n ; i++){
            for(int j = 0 ; j<n ; j++){
                board[i][j]='X';
            }
        }
        
        nQueensCode(board, 0);
        
    }
}
