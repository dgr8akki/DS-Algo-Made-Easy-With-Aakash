package Leetcode;

class Solution_883_ProjectionOfShapes {
  public static int projectionArea(int[][] grid) {
    int res = 0;
    int n = grid.length;
    for (int i = 0, v = 0; i < n; ++i, res += v, v = 0) {
      for (int j = 0; j < n; ++j) {
        v = Math.max(v, grid[i][j]);
      }
    }
    for (int j = 0, v = 0; j < n; ++j, res += v, v = 0) {
      for (int i = 0; i < n; ++i) {
        v = Math.max(v, grid[i][j]);
      }
    }
    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < n; ++j) {
        if (grid[i][j] > 0) {
          res++;
        }
      }
    }
    return res;
  }
}
