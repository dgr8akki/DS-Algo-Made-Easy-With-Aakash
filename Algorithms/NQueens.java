public class NQueens {
  int[][] chessBoard;
  int totalQueens;

  public NQueens(int n) {
    totalQueens = n;
    chessBoard = new int[n][n];
  }

  public void solve() {
    if (setQueens(0))
      printSolution();
    else
      System.out.println("There is no solution exists");
  }

  private boolean setQueens(int currentRow) {
    if (currentRow == totalQueens)
      return true;

    for (int currentCol = 0; currentCol < totalQueens; currentCol++) {
      if (isValidPlace(currentRow, currentCol)) {
        chessBoard[currentRow][currentCol] = 1;

        if (setQueens(currentRow + 1))
          return true;
        else
          chessBoard[currentRow][currentCol] = 0;
      }
    }
    return false;
  }

  private boolean isValidPlace(int currentRow, int currentCol) {
    // Position is valid if and only if there is no queen in that column and upper side diagonals.

    // Check for same column.
    for(int i = 0; i < currentCol; i++)
      if(chessBoard[currentRow][i] == 1) return false;

    // Check for diagonal towards top left.
    int i = currentRow, j = currentCol;
    while(i >= 0 && j >= 0) {
      if(chessBoard[i][j] == 1) return false;
      i--;
      j--;
    }

    // Check for diagonal towards top right.
    i = currentRow;
    j = currentCol;
    while(i < totalQueens && j >= 0) {
      if(chessBoard[i][j] == 1) return false;
      i++;
      j--;
    }
    return false;
  }

  public void printSolution() {
    for (int row = 0; row < totalQueens; row++) {
      for (int col = 0; col < totalQueens; col++) {
        if (chessBoard[row][col] == 1)
          System.out.print(" * ");
        else
          System.out.print(" - ");
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    NQueens queens = new NQueens(4);
    queens.solve();
  }
}
