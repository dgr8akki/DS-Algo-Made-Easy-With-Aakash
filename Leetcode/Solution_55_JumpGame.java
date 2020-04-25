package Leetcode;

class Solution_55_JumpGame {
  public boolean canJump(int[] nums) {
    int max = 0;
    for (int idx = 0; idx < nums.length; idx++) {
      if (idx == 0 || max >= idx)
        max = Math.max(max, idx + nums[idx]);
      else
        return false;
    }
    return max >= nums.length - 1;
  }

  public boolean canJump(int[] nums) {
    return canJump(nums, 0, new int[nums.length + 1]) == 1 ? true : false;
  }

  private int canJump(int[] nums, int current, int[] dp) {
    if (dp[current] != 0)
      return dp[current];
    if (current == nums.length - 1)
      return dp[current] = 1;

    for (int i = 1; i <= nums[current]; i++)
      if (canJump(nums, current + i, dp) == 1)
        return dp[current] = 1;
    return dp[current] = -1;
  }
}
