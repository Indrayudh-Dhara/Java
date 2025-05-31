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

    public static int findPaths(int maze[][], int row, int col, int sol[][]) {
        // base conditions to check invalid moves or blocked cells
        if (row < 0 || col < 0 || row >= maze.length || col >= maze[0].length || maze[row][col] == 0 || sol[row][col] == 1) {
            return 0;
        }

        // destination reached
        if (row == maze.length - 1 && col == maze[0].length - 1) {
            sol[row][col] = 1;  // mark destination cell
            printSolution(sol);
            sol[row][col] = 0;  // unmark for backtracking
            return 1;
        }

        // mark current cell in solution path
        sol[row][col] = 1;

        int count = 0;

        // move down
        count += findPaths(maze, row + 1, col, sol);

        // move right
        count += findPaths(maze, row, col + 1, sol);

        // move up
        count += findPaths(maze, row - 1, col, sol);

        // move left
        count += findPaths(maze, row, col - 1, sol);

        // backtrack: unmark current cell before returning
        sol[row][col] = 0;

        return count;
    }
    

    public static void main(String[] args) {
        int maze[][] = {
            {1, 0, 0, 0},
            {1, 1, 0, 1},
            {0, 1, 0, 0},
            {1, 1, 1, 1}
        };

        int sol[][] = new int[maze.length][maze[0].length]; // solution matrix initialized with 0s

        int totalPaths = findPaths(maze, 0, 0, sol);

        System.out.println("Total paths found: " + totalPaths);
    }
}
