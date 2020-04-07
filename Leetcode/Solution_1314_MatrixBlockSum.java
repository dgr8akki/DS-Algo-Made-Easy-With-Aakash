class Solution {
  public int[][] matrixBlockSum(int[][] mat, int k) {
    int m = mat.length;
    if (m == 0)
      return new int[][] { {} };
    int n = mat[0].length;
    int[][] presum = new int[m][n];
    int[][] res = new int[m][n];
    presum[0][0] = mat[0][0];
    for (int i = 1; i < m; i++) {
      presum[i][0] = presum[i - 1][0] + mat[i][0];
    }

    for (int j = 1; j < n; j++) {
      presum[0][j] = presum[0][j - 1] + mat[0][j];
    }

    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        presum[i][j] = presum[i - 1][j] + presum[i][j - 1] - presum[i - 1][j - 1] + mat[i][j];
      }
    }

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        int r = Math.min(m - 1, i + k);
        int c = Math.min(n - 1, j + k);
        int right = i - k - 1 < 0 ? 0 : presum[i - k - 1][c];
        int left = j - k - 1 < 0 ? 0 : presum[r][j - k - 1];
        int middle = i - k - 1 < 0 || j - k - 1 < 0 ? 0 : presum[i - k - 1][j - k - 1];
        res[i][j] = presum[r][c] - left - right + middle;
      }
    }
    return res;
  }
}
