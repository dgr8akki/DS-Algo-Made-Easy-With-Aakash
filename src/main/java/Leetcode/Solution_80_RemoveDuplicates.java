package Leetcode;

class Solution {
  public int removeDuplicates(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int prev = nums[0], count = 1, i = 0;
    for (int j = 1; j < nums.length; j++) {
      if (nums[j] == prev) {
        count++;
        continue;
      }
      if (count == 1) {
        nums[i] = prev;
        i++;
      } else {
        nums[i] = prev;
        nums[i + 1] = prev;
        i += 2;
      }
      count = 1;
      prev = nums[j];
    }

    if (count == 1) {
      nums[i] = prev;
      i++;
    } else {
      nums[i] = prev;
      nums[i + 1] = prev;
      i += 2;
    }

    return i;
  }
}
