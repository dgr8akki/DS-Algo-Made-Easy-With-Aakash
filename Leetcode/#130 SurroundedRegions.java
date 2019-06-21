class Solution {
  static int directions[][] = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
  static boolean visited[][];

  public static void solve(char[][] board) {

    if (board.length == 0)
      return;

    visited = new boolean[board.length][board[0].length];

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] == 'O' && !visited[i][j] && connectedWithEdge(board, i, j)) {
          board[i][j] = backTrack(board, i, j);
        }
      }
    }

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (visited[i][j] == true)
          board[i][j] = 'O';
        else
          board[i][j] = 'X';
      }
    }
  }

  public static char backTrack(char[][] board, int row, int col) {

    if (!isValid(board, row, col))
      return ' ';
    if (board[row][col] == 'X')
      return board[row][col];

    visited[row][col] = true;
    board[row][col] = 'X';

    for (int i = 0; i < directions.length; i++) {
      backTrack(board, row + directions[i][0], col + directions[i][1]);
    }

    return board[row][col];
  }

  public static boolean isValid(char[][] board, int row, int col) {
    return ((row >= 0 && row < board.length) && (col >= 0 && col < board[0].length));
  }

  public static boolean connectedWithEdge(char[][] board, int row, int col) {
    return ((row == 0 || row == board.length - 1) || (col == 0 || col == board[0].length - 1));
  }
}
