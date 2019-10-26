package Leetcode;

import java.util.*;

class Solution {
  public static int[] findErrorNums(int[] nums) {
    int[] res = new int[2];
    for (int i = 0; i < nums.length; i++) {
      int index = nums[i] < 0 ? -nums[i] : nums[i];
      index--;
      if (nums[index] < 0) {
        res[0] = index + 1;
        continue;
      }
      nums[index] = -nums[index];
    }
    // System.out.println(Arrays.toString(nums));
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > 0) {
        res[1] = i + 1;
        break;
      }
    }
    // System.out.println(Arrays.toString(nums));
    return res;
  }

  public static void main(String[] args) {
    int[] A = { 1, 2, 2, 4 };
    int[] r = findErrorNums(A);
    System.out.println(Arrays.toString(r));
  }
}
