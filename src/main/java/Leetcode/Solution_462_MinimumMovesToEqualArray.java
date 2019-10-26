package Leetcode;

public class Solution {
  public int minMoves2(int[] nums) {
    Arrays.sort(nums);
    int i = 0, j = nums.length - 1;
    int count = 0;
    while (i < j) {
      count += nums[j] - nums[i];
      i++;
      j--;
    }
    return count;
  }
}
