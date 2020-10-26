package Leetcode;

class Solution_52_NQueens2 {
  public int totalNQueens(int n) {
    if (n == 1)
      return 1;
    if (n < 4)
      return 0;
    int[][] chess = new int[n][n];
    return solve(0, n, chess);
  }

  private static int solve(int row, int n, int[][] chess) {
    if (row == n)
      return 1;

    int count = 0;

    for (int col = 0; col < n; col++) {
      if (isSafe(row, col, n, chess)) {
        chess[row][col] = 1;
        count += solve(row + 1, n, chess);
        chess[row][col] = 0;
      }
    }
    return count;
  }

  private static boolean isSafe(int currentRow, int currentCol, int totalQueens, int[][] chessBoard) {
    if (currentRow >= 0 && currentRow < totalQueens && currentCol >= 0 && currentCol < totalQueens) {

      if (chessBoard[currentRow][currentCol] == 1)
        return false;

      for (int i = 0; i < currentCol; i++) {
        if (chessBoard[currentRow][i] == 1)
          return false;
      }

      for (int r = 0; r < currentRow; r++) {
        if (chessBoard[r][currentCol] == 1)
          return false;
      }

      // Check for diagonal towards top left.
      int i = currentRow, j = currentCol;
      while (i >= 0 && j >= 0) {
        if (chessBoard[i][j] == 1)
          return false;
        i--;
        j--;
      }

      // Check for diagonal towards top right.
      i = currentRow;
      j = currentCol;
      while (j < totalQueens && i >= 0) {
        if (chessBoard[i][j] == 1)
          return false;
        j++;
        i--;
      }

      return true;
    }
    return false;
  }
}
