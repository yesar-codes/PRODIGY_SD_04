public class SudokuSolver {
    private static final int SIZE = 9;
    private static final String NO_SOLUTION_ERROR = "No solution exists.";
    public static void main(String[] args) {
        int[][] sudokuGrid = {
                {8, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 3, 6, 0, 0, 0, 0, 0},
                {0, 7, 0, 0, 9, 0, 2, 0, 0},
                {0, 5, 0, 0, 0, 7, 0, 0, 0},
                {0, 0, 0, 0, 4, 5, 7, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 3, 0},
                {0, 0, 1, 0, 0, 0, 0, 6, 8},
                {0, 0, 8, 5, 0, 0, 0, 1, 0},
                {0, 9, 0, 0, 0, 0, 4, 0, 0}
        };

        SudokuSolver sudokuSolver = new SudokuSolver();

        if (sudokuSolver.solveSudoku(sudokuGrid)) {
            sudokuSolver.printSudokuGrid(sudokuGrid);
        } else {
            System.out.println(NO_SOLUTION_ERROR);
        }
    }

    private boolean solveSudoku(int[][] grid) {
        return solve(grid);
    }

    private boolean solve(int[][] grid) {
        int[] emptyCell = findEmptyCell(grid);

        if (emptyCell == null) {
            return true; // Sudoku is solved
        }

        int row = emptyCell[0];
        int col = emptyCell[1];

        for (int num = 1; num <= SIZE; num++) {
            if (tryNumber(grid, row, col, num)) {
                if (solve(grid)) {
                    return true; // Found a solution
                }
                undoMove(grid, row, col);
            }
        }

        return false; // No solution found
    }

    private int[] findEmptyCell(int[][] grid) {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (grid[row][col] == 0) {
                    return new int[]{row, col};
                }
            }
        }
        return null; // No empty cell found
    }

    private boolean tryNumber(int[][] grid, int row, int col, int num) {
        if (isSafe(grid, row, col, num)) {
            grid[row][col] = num;
            return true;
        }
        return false;
    }

    private void undoMove(int[][] grid, int row, int col) {
        grid[row][col] = 0; // Backtrack
    }


    private boolean isSafe(int[][] grid, int row, int col, int num) {
        return !usedInRow(grid, row, num) &&
                !usedInCol(grid, col, num) &&
                !usedInBox(grid, row - row % 3, col - col % 3, num);
    }

    private boolean usedInRow(int[][] grid, int row, int num) {
        for (int col = 0; col < SIZE; col++) {
            if (grid[row][col] == num) {
                return true;
            }
        }
        return false;
    }

    private boolean usedInCol(int[][] grid, int col, int num) {
        for (int row = 0; row < SIZE; row++) {
            if (grid[row][col] == num) {
                return true;
            }
        }
        return false;
    }

    private boolean usedInBox(int[][] grid, int startRow, int startCol, int num) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i + startRow][j + startCol] == num) {
                    return true;
                }
            }
        }
        return false;
    }

    private void printSudokuGrid(int[][] grid) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}
