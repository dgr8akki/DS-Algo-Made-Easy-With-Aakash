package Leetcode;

class Solution {
  public void nextPermutation(int[] nums) {
    if (nums == null || nums.length < 2)
      return;
    int i = nums.length - 2;
    while (i >= 0 && nums[i] >= nums[i + 1])
      i--;
    if (i >= 0) {
      int j = nums.length - 1;
      while (nums[j] <= nums[i])
        j--;
      swap(nums, i, j);
    }
    reverse(nums, i + 1, nums.length - 1);
  }

  private void reverse(int[] nums, int l, int r) {
    while (l < r)
      swap(nums, l++, r--);
  }

  private void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }
}
