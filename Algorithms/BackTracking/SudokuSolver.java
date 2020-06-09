package Algorithms.BackTracking;

public class SudokuSolver {
  private static final int MAX_NUMBER = 9;
  private final int[][] sudoku;

  private SudokuSolver(int[][] sudoku) {
    this.sudoku = sudoku;
  }

  public static void main(String[] args) {
    int[][] board = new int[][] { { 1, 3, 0, 0, 0, 6, 0, 0, 0 }, { 0, 0, 0, 0, 0, 7, 0, 6, 2 },
        { 7, 6, 0, 1, 9, 0, 0, 0, 0 }, { 0, 2, 7, 0, 8, 0, 0, 0, 3 }, { 9, 1, 0, 0, 0, 0, 0, 0, 0 },
        { 0, 8, 3, 9, 7, 0, 2, 5, 4 }, { 8, 7, 0, 0, 0, 0, 0, 4, 0 }, { 0, 0, 0, 0, 0, 0, 7, 0, 0 },
        { 0, 0, 6, 0, 3, 4, 0, 0, 0 } };
    SudokuSolver solver = new SudokuSolver(board);
    solver.solve();
  }

  public void solve() {
    if (isSolvable(0, 0))
      printResult();
    else
      System.out.println("Not Solvable");
  }

  private boolean isSolvable(int row, int col) {
    if (row == MAX_NUMBER && ++col == MAX_NUMBER) {
      return true;
    }

    if (row == MAX_NUMBER) {
      row = 0;
    }

    if (sudoku[row][col] != 0) {
      return isSolvable(row + 1, col);
    }

    for (int value = 1; value <= MAX_NUMBER; value++) {
      if (isFeasible(row, col, value)) {
        sudoku[row][col] = value;

        if (isSolvable(row + 1, col)) {
          return true;
        }

        sudoku[row][col] = 0;
      }
    }
    return false;
  }

  private boolean isFeasible(int row, int col, int value) {

    for (int i = 0; i < MAX_NUMBER; i++) {
      if (sudoku[i][col] == value || sudoku[row][i] == value) {
        return false;
      }
    }

    int boxRowStart = row - (row % 3);
    int boxColStart = col - (col % 3);

    // System.out.println("Offset numbers: " + rowOffset + ", " + colOffset);

    for (int i = boxRowStart; i < boxRowStart + 3; i++) {
      for (int j = boxColStart; j < boxColStart + 3; j++) {
        if (sudoku[i][j] == value) {
          return false;
        }
      }
    }
    return true;
  }

  private void printResult() {
    for (int i = 0; i < MAX_NUMBER; i++) {
      for (int j = 0; j < MAX_NUMBER; j++) {
        System.out.print(sudoku[i][j] + " ");
        if (j > 0 && (j + 1) % 3 == 0) {
          System.out.print(" ");
        }
      }
      System.out.println();
      if (i > 0 && (i + 1) % 3 == 0) {
        System.out.println();
      }
    }
  }
}
