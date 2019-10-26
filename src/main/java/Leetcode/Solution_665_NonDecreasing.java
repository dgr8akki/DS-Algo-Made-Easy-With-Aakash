package Leetcode;

class Solution {
  public boolean checkPossibility(int[] nums) {
    boolean once = false;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] < nums[i - 1]) {
        if (once) {
          return false;
        } else {
          once = true;
          int temp = nums[i - 1];
          nums[i - 1] = nums[i];
          if (i >= 2 && nums[i - 2] > nums[i - 1]) {
            nums[i - 1] = temp;
            nums[i] = temp;
          }
        }
      }
    }
    return true;
  }
}
