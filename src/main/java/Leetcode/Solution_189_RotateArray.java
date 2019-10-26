package Leetcode;

class Solution {
  public void rotate(int[] nums, int k) {

    if (nums == null || nums.length < 2)
      return;

    k = k % nums.length;
    reverse(nums, 0, nums.length - k - 1);
    reverse(nums, nums.length - k, nums.length - 1);
    reverse(nums, 0, nums.length - 1);
  }

  private void reverse(int[] nums, int firstIndex, int secondIndex) {
    int tmp = 0;
    while (firstIndex < secondIndex) {
      tmp = nums[firstIndex];
      nums[firstIndex++] = nums[secondIndex];
      nums[secondIndex--] = tmp;
    }
  }
}
