package Leetcode;

class Solution_994_RottenOranges {
  int[][] dirs = new int[][] { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };

  public int orangesRotting(int[][] grid) {
    int min = 0;
    int r = grid.length, c = grid[0].length;

    while (true) {
      boolean foundRot = false;
      boolean foundFresh = false;
      for (int i = 0; i < r; i++) {
        for (int j = 0; j < c; j++) {
          if (grid[i][j] == min + 2) {
            foundRot = true;
            grid[i][j] = 0;
            for (int[] a : dirs) {
              int newX = i + a[0];
              int newY = j + a[1];
              if (newX >= 0 && newX < r && newY >= 0 && newY < c && grid[newX][newY] == 1) {
                grid[newX][newY] = min + 3;
              }
            }
          }
          if (grid[i][j] == 1) {
            foundFresh = true;
          }
        }
      }
      if (!foundRot) {
        if (foundFresh) {
          return -1;
        }
        break;
      }
      min++;
    }
    return min == 0 ? min : min - 1;
  }
}
