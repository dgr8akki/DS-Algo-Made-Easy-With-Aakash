
public class SudokuSolver {

  public static boolean sudokuSolver(int board[][]) {
    return isSolvable(board, 0, 0);
  }

  private static boolean isSolvable(int[][] board, int row, int col) {
    if(row == 9 && ++col == 9) return true;

    if( row == 9) row = 0;

    if(board[row][col] != 0)
      return isSolvable(board, row + 1, col);

    for(int i = 1; i <= 9; i++) {
      if(isFeasible(board, row, col, i)) {
        board[row][col] = i;

        if(isSolvable(board, row + 1, col))
          return true;
        board[row][col] = 0;
      }
    }
    return false;
  }

  private static boolean isFeasible(int[][] board, int row, int col, int val) {
    //Check in row and Col
    for(int i = 0; i < 9; i++)
      if(board[row][i] == val || board[i][col]== val)
        return false;

    //Check in same small box
    int smallBoxRowStart = row - (row % 3);
    int smallBoxColStart = col - (col % 3);

    for(int i = smallBoxRowStart; i < smallBoxRowStart + 3; i++)
      for(int j = smallBoxColStart; j < smallBoxColStart + 3; j++)
        if(board[i][j] == val)
          return false;

    return true;
  }
}
