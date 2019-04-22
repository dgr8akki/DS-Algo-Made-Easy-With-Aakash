class Solution {
  public int rob(int[] nums) {
      int[] dp = new int[nums.length + 1];
      Arrays.fill(dp, -1);
      return robUtil(nums, 0, nums.length, dp);
  }

  private int robUtil(int[] nums, int idx, int n, int[] dp) {
    if(idx >= n) return 0;
    if(dp[idx] >= 0) return dp[idx];
    int optionToSkip = robUtil(nums, idx + 1, n, dp);
    int optionToRob = nums[idx] + robUtil(nums, idx + 2, n, dp);
    return dp[idx] = Math.max(optionToSkip, optionToRob);
  }
}
