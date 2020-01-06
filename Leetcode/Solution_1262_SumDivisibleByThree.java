class Solution_1262_SumDivisibleByThree {
  public int maxSumDivThree(int[] nums) {
    int[] dp = new int[] { 0, Integer.MIN_VALUE, Integer.MIN_VALUE };
    for (int a : nums) {
      int[] dp2 = new int[3];
      for (int i = 0; i < 3; ++i)
        dp2[(i + a) % 3] = Math.max(dp[(i + a) % 3], dp[i] + a);
      dp = dp2;
    }
    return dp[0];
  }
}
