package Backtracking;

public class ratInAMaze {

    public static void printSolution(int sol[][]) {
        for (int i = 0; i < sol.length; i++) {
            for (int j = 0; j < sol[0].length; j++) {
                System.out.print(sol[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

   public static int findPaths(int maze[][], int row , int col , int sol[][]){
    int count = 0 ;
    //edge case

    if(row<0 || col<0  || row>=maze.length || col>=maze[0].length || maze[row][col]==0 || sol[row][col]==1 ){
        return 0 ; 
    }

    //base case  ( solution reached)
    if(row==maze.length-1 && col==maze[0].length-1){
        sol[row][col]=1; //mark visited to the last cell , as it wont get a chance to mark itself as it has reached the base case
        printSolution(sol);
        sol[row][col]=0;///unmark to print valid multiple solutions
        return 1;
    };

    //mark visited( the current cell )
    sol[row][col]=1;


    //recusion
    count+=findPaths(maze, row-1, col , sol); //up
    count+=findPaths(maze, row+1, col, sol);//down
    count+=findPaths(maze, row, col-1,sol);//left
    count+=findPaths(maze, row, col+1,sol);//right

    //unmark while backtracking
    sol[row][col]=0;

    return count ; 

   }
    

    public static void main(String[] args) {
        int maze[][] = {
            {1, 1,1},
            {1, 1, 1},
            {1, 1,1},
            {1, 1, 1}
        };

        int sol[][] = new int[maze.length][maze[0].length]; // solution matrix initialized with 0s

        int totalPaths = findPaths(maze, 0, 0, sol);

        System.out.println("Total paths found: " + totalPaths);
    }
}

