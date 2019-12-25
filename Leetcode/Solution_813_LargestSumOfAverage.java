package Leetcode;

class Solution_813_LargestSumOfAverage {
  public double largestSumOfAverages(int[] A, int K) {
    int N = A.length;
    double[][] dp = new double[N + 1][N + 1];
    double cur = 0;
    for (int i = 0; i < N; ++i) {
      cur += A[i];
      dp[i + 1][1] = cur / (i + 1);
    }
    return search(N, K, A, dp);
  }

  public double search(int n, int k, int[] A, double[][] dp) {
    if (dp[n][k] > 0)
      return dp[n][k];
    if (n < k)
      return 0;
    double cur = 0;
    for (int i = n - 1; i > 0; --i) {
      cur += A[i];
      dp[n][k] = Math.max(dp[n][k], search(i, k - 1, A, dp) + cur / (n - i));
    }
    return dp[n][k];
  }
}
