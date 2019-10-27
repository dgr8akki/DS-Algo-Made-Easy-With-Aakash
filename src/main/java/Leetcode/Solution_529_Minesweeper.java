package Leetcode;

public class Solution_529_Minesweeper {
  public char[][] updateBoard(char[][] board, int[] click) {
    int x = click[0], y = click[1];
    if (board[x][y] == 'M') {
      board[x][y] = 'X';
      return board;
    }

    dfs(board, x, y);
    return board;
  }

  int[] xOffset = { -1, 0, 1, -1, 1, 0, 1, -1 };
  int[] yOffset = { -1, 1, 1, 0, -1, -1, 0, 1 };

  private void dfs(char[][] board, int x, int y) {
    if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != 'E')
      return;

    int num = getNumsOfBombs(board, x, y);

    if (num == 0) {
      board[x][y] = 'B';
      for (int i = 0; i < 8; i++)
        dfs(board, x + xOffset[i], y + yOffset[i]);
    } else
      board[x][y] = (char) ('0' + num);
  }

  private int getNumsOfBombs(char[][] board, int x, int y) {
    int num = 0;
    for (int i = 0; i < 8; i++) {
      int nx = x + xOffset[i], ny = y + yOffset[i];
      if (nx < 0 || nx >= board.length || ny < 0 || ny >= board[0].length)
        continue;
      if (board[nx][ny] == 'M' || board[nx][ny] == 'X')
        num++;
    }
    return num;
  }
}
