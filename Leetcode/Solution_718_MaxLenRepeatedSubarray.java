package Leetcode;

class Solution_718_MaxLenRepeatedSubarray {
  public int findLength(int[] a, int[] b) {
    int m = a.length, n = b.length;
    if (m == 0 || n == 0)
      return 0;
    int[][] dp = new int[m + 1][n + 1];
    int max = 0;
    for (int i = m - 1; i >= 0; i--)
      for (int j = n - 1; j >= 0; j--) {
        dp[i][j] = a[i] == b[j] ? 1 + dp[i + 1][j + 1] : 0;
        max = Math.max(max, dp[i][j]);
      }
    return max;
  }
}
