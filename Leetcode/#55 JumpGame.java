class Solution {
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
}
