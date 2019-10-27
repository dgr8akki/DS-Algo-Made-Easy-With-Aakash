package Leetcode;

class Solution_999_CapturesForRook {
  public int numRookCaptures(char[][] board) {
    int posRow = -1;
    int posCol = -1;
    int count = 0;
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        if (board[i][j] == 'R') {
          posRow = i;
          posCol = j;
          break;
        }
      }
    }

    for (int i = posRow - 1; i >= 0; i--) {
      if (board[i][posCol] == 'p') {
        count++;
        break;
      } else if (board[i][posCol] == '.')
        continue;
      else
        break;
    }

    for (int i = posRow + 1; i <= 7; i++) {
      if (board[i][posCol] == 'p') {
        count++;
        break;
      } else if (board[i][posCol] == '.')
        continue;
      else
        break;
    }

    for (int j = posCol - 1; j >= 0; j--) {
      if (board[posRow][j] == 'p') {
        count++;
        break;
      } else if (board[posRow][j] == '.')
        continue;
      else
        break;
    }

    for (int j = posCol + 1; j <= 7; j++) {
      if (board[posRow][j] == 'p') {
        count++;
        break;
      } else if (board[posRow][j] == '.')
        continue;
      else
        break;
    }

    return count;
  }
}
