package Leetcode;

class Solution {
  private static int M = 1_000_000_007;

  public int numTrees(int n) {
    return countTreesIterative(n);
  }

  public static int countTreesIterative(int n) {
    if (n == 0 || n == 1)
      return 1;
    int[] dp = new int[n + 1];
    dp[0] = 1;
    dp[1] = 1;
    dp[2] = 2;
    for (int i = 3; i <= n; i++)
      for (int k = 1; k <= i; k++)
        dp[i] += (dp[i - k] * dp[k - 1]);

    return dp[n];
  }
}
