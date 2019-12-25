package Leetcode;

class Solution_807_KeepCitySkyline {
  public int maxIncreaseKeepingSkyline(int[][] grid) {
    int n = grid.length;
    int[] col = new int[n], row = new int[n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        row[i] = Math.max(row[i], grid[i][j]);
        col[j] = Math.max(col[j], grid[i][j]);
      }
    }
    int res = 0;
    for (int i = 0; i < n; i++)
      for (int j = 0; j < n; j++)
        res += Math.min(row[i], col[j]) - grid[i][j];
    return res;
  }
}
