package Leetcode;

class Solution_1072_FlipCoinsForMaxRow {
  public int maxEqualRowsAfterFlips(int[][] matrix) {
    int ans = 0;
    int m = matrix.length, n = matrix[0].length;
    int[] flip = new int[n];
    for (int i = 0; i < m; i++) {
      int cnt = 0;
      for (int j = 0; j < n; j++)
        flip[j] = 1 - matrix[i][j];
      for (int k = 0; k < m; k++) {
        if (Arrays.equals(matrix[k], matrix[i]) || Arrays.equals(matrix[k], flip))
          cnt++;
      }
      ans = Math.max(ans, cnt);
    }
    return ans;
  }
}
