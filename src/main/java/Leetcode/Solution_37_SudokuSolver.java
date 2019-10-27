package Leetcode;

class Solution_37_SudokuSolver {
  public class SudokuSolver {
    private int[][] sudoku;
    private char[][] sudo;
    int MAX_NUMBER = 9;

    SudokuSolver(int[][] sudoku, char[][] b) {
      this.sudoku = sudoku;
    }

    public int[][] solve() {
      if (isSolvable(0, 0))
        return sudoku;
      else
        return new int[1][1];
    }

    public boolean isSolvable(int row, int col) {
      if (row == MAX_NUMBER && ++col == MAX_NUMBER)
        return true;

      if (row == MAX_NUMBER)
        row = 0;

      if (sudoku[row][col] != 0)
        return isSolvable(row + 1, col);

      for (int value = 1; value <= MAX_NUMBER; value++) {
        if (isFeasible(row, col, value)) {
          this.sudoku[row][col] = value;

          if (isSolvable(row + 1, col))
            return true;

          this.sudoku[row][col] = 0;
        }
      }
      return false;
    }

    private boolean isFeasible(int row, int col, int value) {

      for (int i = 0; i < MAX_NUMBER; i++)
        if (sudoku[i][col] == value || sudoku[row][i] == value)
          return false;

      int boxRowStart = row - (row % 3);
      int boxColStart = col - (col % 3);

      // System.out.println("Offset numbers: " + rowOffset + ", " + colOffset);

      for (int i = boxRowStart; i < boxRowStart + 3; i++)
        for (int j = boxColStart; j < boxColStart + 3; j++) {
          if (sudoku[i][j] == value)
            return false;
        }
      return true;
    }

    private void printResult() {
      for (int i = 0; i < MAX_NUMBER; i++) {
        for (int j = 0; j < MAX_NUMBER; j++) {
          sudo[i][j] = (char) (sudoku[i][j] + '0');
        }
      }
    }
  }

  public void solveSudoku(char[][] b) {
    int[][] board = new int[9][9];
    for (int i = 0; i < 9; i++)
      for (int j = 0; j < 9; j++)
        if (b[i][j] != '.')
          board[i][j] = Character.getNumericValue(b[i][j]);
    board = new SudokuSolver(board, b).solve();
    for (int i = 0; i < 9; i++)
      for (int j = 0; j < 9; j++)
        b[i][j] = (char) (board[i][j] + '0');
  }
}
