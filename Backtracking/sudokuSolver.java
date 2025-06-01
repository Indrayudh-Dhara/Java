package Backtracking;

public class sudokuSolver {

    // Check whether placing 'digit' at (row, col) is valid
    public static boolean isSafe(int sudoku[][], int row, int col, int digit) {
        // Check if the digit already exists in the current entire column
        for (int i = 0; i <= 8; i++) {
            if (sudoku[i][col] == digit) {
                return false;
            }
        }

        // Check if the digit already exists in the current entire row
        for (int i = 0; i <= 8; i++) {
            if (sudoku[row][i] == digit) {
                return false;
            }
        }

        // Check if the digit exists in the current 3x3 subgrid
        int si = (row / 3) * 3; // formula for starting row of subgrid
        int ei = (col / 3) * 3; // formula for starting col of subgrid

        //iterate through the subgrid to find digit exists or not
        for (int i = si; i < si + 3; i++) {
            for (int j = ei; j < ei + 3; j++) {
                if (sudoku[i][j] == digit) {
                    return false;
                }
            }
        }

        // digit is safe to place
        return true;
    }

    // Solves the Sudoku using backtracking
    public static boolean sudokuSolverCode(int sudoku[][], int row, int col) {
        // Base case: row has just went over the last one , meaning all solutions found
        if (row == 9) {
            printSudoku(sudoku);
            return true;
        }

        // using variables and conditions to automatically change next row and next column in recusive calls

        //row col - current
        //nextRow nextCol - for the next call
        
        int nextRow = row, nextCol = col + 1;
        if (nextCol == 9) {
            nextRow = row + 1;
            nextCol = 0;
        }

        // If current cell is already filled, move to the next one
        if (sudoku[row][col] != 0) {
            return sudokuSolverCode(sudoku, nextRow, nextCol);
        }

        // Try placing digits 1 to 9
        for (int digit = 1; digit <= 9; digit++) {
            // checking if it is safe
            if (isSafe(sudoku, row, col, digit)) {
                sudoku[row][col] = digit; // Place the digit

                // after placing digit the next recusive call for the next cell is done
                if (sudokuSolverCode(sudoku, nextRow, nextCol)) {
                    return true; // If solution is found, stop further calls(no need) , instead propagrate the answer upward 
                }
                
              //whenever the sudokusolver returns false(fails to place a digit) ,only then this step is executed when call stack is returning
              //and in this step we 'remove' the placed digit to 0 and for a clean new run 
              
                sudoku[row][col] = 0;
            }
        }

        // If no digit leads to a solution, return false
        return false;
    }

    // Prints the Sudoku board
    public static void printSudoku(int sudoku[][]) {
        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku[0].length; j++) {
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println(); // Newline after each row
        }
        System.out.println(); // Extra line after complete board
    }

    // Driver code to test the solver
    public static void main(String[] args) {
        int[][] sudoku = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9},
        };

        sudokuSolverCode(sudoku, 0, 0);
    }
}
