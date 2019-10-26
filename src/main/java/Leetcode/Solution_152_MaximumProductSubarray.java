package Leetcode;

class Solution {
  public int maxProduct(int[] nums) {
    int res = nums[0], max = nums[0], min = nums[0];
    for (int i = 1; i < nums.length; i++) {
      int next_max = Math.max(max * nums[i], Math.max(min * nums[i], nums[i]));
      int next_min = Math.min(min * nums[i], Math.min(max * nums[i], nums[i]));
      min = next_min;
      max = next_max;
      res = Math.max(res, max);
    }
    return res;
  }
}
