public class SudokuSolver {
  private int[][] sudoku;
  private static int MAX_NUMBER = 9;
  SudokuSolver(int[][] sudoku) {
    this.sudoku = sudoku;
  }

  public void solve() {
    if(isSolvable(0, 0))
      printResult();
    else
      System.out.println("Not Solvable");
  }

  public boolean isSolvable(int row, int col) {
    if( row == MAX_NUMBER && ++col == MAX_NUMBER ) return true;

    if( row == MAX_NUMBER) row = 0;

    if(sudoku[row][col] != 0)
      return isSolvable(row + 1, col);

    for(int value = 1; value <= MAX_NUMBER; value++) {
      if(isFeasible(row, col, value)) {
        this.sudoku[row][col] = value;

        if(isSolvable(row + 1, col))
          return true;

        this.sudoku[row][col] = 0;
      }
    }
    return false;
  }

  private boolean isFeasible(int row, int col, int value) {

    for(int i = 0; i < MAX_NUMBER; i++)
      if(sudoku[i][col] == value || sudoku[row][i] == value)
        return false;

    int boxRowStart = row - (row % 3);
    int boxColStart = col - (col % 3);

    // System.out.println("Offset numbers: " + rowOffset + ", " + colOffset);

    for(int i = boxRowStart; i < boxRowStart + 3; i++)
      for(int j = boxColStart; j < boxColStart + 3; j++) {
        if(sudoku[i][j] == value)
          return false;
      }
    return true;
  }

  private void printResult() {
    for(int i = 0; i < MAX_NUMBER; i++) {
      for(int j = 0; j < MAX_NUMBER; j++) {
        System.out.print(sudoku[i][j] + " ");
        if(j > 0 && (j + 1) % 3 == 0)
          System.out.print(" ");
      }
      System.out.println();
      if(i > 0 && (i + 1) % 3 == 0)
          System.out.println();
    }
  }
  public static void main(String[] args) {
    int[][] board = new int[][]
	  {
			{3, 0, 6, 5, 0, 8, 4, 0, 0},
			{5, 2, 0, 0, 0, 0, 0, 0, 0},
			{0, 8, 7, 0, 0, 0, 0, 3, 1},
			{0, 0, 3, 0, 1, 0, 0, 8, 0},
			{9, 0, 0, 8, 6, 3, 0, 0, 5},
			{0, 5, 0, 0, 9, 0, 6, 0, 0},
			{1, 3, 0, 0, 0, 0, 2, 5, 0},
			{0, 0, 0, 0, 0, 0, 0, 7, 4},
			{0, 0, 5, 2, 0, 6, 3, 0, 0}
	  };
    SudokuSolver solver = new SudokuSolver(board);
    solver.solve();
  }
}
