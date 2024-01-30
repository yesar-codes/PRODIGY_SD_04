# PRODIGY_SD_04

# Sudoku Solver

A Sudoku Solver implemented in Java using the backtracking algorithm. The program takes an unsolved Sudoku grid as input, fills in the missing numbers, and displays the completed Sudoku grid.

## Usage

1. Clone the repository to your local machine:

    ```bash
    git clone https://github.com/yesar-codes/sudoku-solver-java.git
    ```

2. Compile the Java file:

    ```bash
    javac SudokuSolver.java
    ```

3. Run the program:

    ```bash
    java SudokuSolver
    ```

4. Follow the on-screen instructions to see the solved Sudoku grid.

## Input Sudoku Grid

Modify the `sudokuGrid` array in the `main` method of `SudokuSolver.java` to input your own unsolved Sudoku puzzle.

```java
int[][] sudokuGrid = {
    {8, 0, 0, 0, 0, 0, 0, 0, 0},
    {0, 0, 3, 6, 0, 0, 0, 0, 0},
    {0, 7, 0, 0, 9, 0, 2, 0, 0},
    // ... (continue with your puzzle)
};
