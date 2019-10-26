package Leetcode;

class Solution {
  public int stoneGameII(int[] piles) {
    Integer[][] dp = new Integer[piles.length][piles.length + 1];
    int[] prefixSum = new int[piles.length + 1];
    for (int i = 0; i < piles.length; ++i)
      prefixSum[i + 1] = prefixSum[i] + piles[i];

    dfs(dp, prefixSum, 0, 1);

    return dp[0][1];
  }

  private int dfs(Integer[][] dp, int[] prefixSum, int curIdx, int m) {
    if (curIdx + 1 >= prefixSum.length || m > dp.length)
      return 0;

    if (dp[curIdx][m] != null)
      return dp[curIdx][m];

    if (prefixSum.length - curIdx - 1 <= 2 * m) {
      dp[curIdx][m] = prefixSum[prefixSum.length - 1] - prefixSum[curIdx];
      return dp[curIdx][m];
    }

    int minLoss = Integer.MAX_VALUE, newM = 0, lossTmp = 0;

    for (int i = 1; i <= 2 * m; ++i) {
      newM = Math.max(i, m);
      lossTmp = dfs(dp, prefixSum, curIdx + i, newM);
      minLoss = Math.min(minLoss, lossTmp);
    }

    dp[curIdx][m] = prefixSum[prefixSum.length - 1] - prefixSum[curIdx] - minLoss;
    return dp[curIdx][m];
  }
}
