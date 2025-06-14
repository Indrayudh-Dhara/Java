package Backtracking;
public class KnightsTour {

    private int N;
    private int[][] board;
    private int[] xMove = {2, 1, -1, -2, -2, -1, 1, 2};
    private int[] yMove = {1, 2, 2, 1, -1, -2, -2, -1};

    public KnightsTour(int N) {
        this.N = N;
        this.board = new int[N][N];
        // Initialize board with -1 to indicate unvisited cells
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = -1;
            }
        }
    }

    public void solve() {
        // Start from the top-left corner (0, 0)
        board[0][0] = 0; // First move
        if (!solveKTUtil(0, 0, 1)) {
            System.out.println("Solution does not exist");
        } else {
            printSolution();
        }
    }

    private boolean solveKTUtil(int x, int y, int moveCount) {
        if (moveCount == N * N) {
            return true; // All squares visited
        }

        for (int i = 0; i < 8; i++) {
            int nextX = x + xMove[i];
            int nextY = y + yMove[i];

            if (isSafe(nextX, nextY)) {
                board[nextX][nextY] = moveCount;
                if (solveKTUtil(nextX, nextY, moveCount + 1)) {
                    return true;
                } else {
                    // Backtrack: If placing the knight here doesn't lead to a solution,
                    // reset the cell and try a different move.
                    board[nextX][nextY] = -1;
                }
            }
        }

        return false; // No valid move found from this position
    }

    private boolean isSafe(int x, int y) {
        return (x >= 0 && x < N && y >= 0 && y < N && board[x][y] == -1);
    }

    private void printSolution() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int N = 8; // Example board size
        KnightsTour kt = new KnightsTour(N);
        kt.solve();
    }
}