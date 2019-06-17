class Solution {
  public int maxCoins(int[] iNums) {
    int[] nums = new int[iNums.length + 2];
    int n = 1;
    for (int x : iNums)
      if (x > 0)
        nums[n++] = x;
    nums[0] = nums[n++] = 1;

    int[][] dp = new int[n][n];
    return burst(dp, nums, 0, n - 1);
  }

  public int burst(int[][] dp, int[] nums, int left, int right) {
    if (left + 1 == right)
      return 0;
    if (dp[left][right] > 0)
      return dp[left][right];
    int ans = 0;
    for (int i = left + 1; i < right; ++i) {
      int prevOption = ans;
      int selectCurrent = nums[left] * nums[i] * nums[right] + burst(dp, nums, left, i) + burst(dp, nums, i, right);
      ans = Math.max(prevOption, selectCurrent);
    }
    return dp[left][right] = ans;
  }
}
