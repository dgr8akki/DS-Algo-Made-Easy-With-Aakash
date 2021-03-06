package Leetcode;

class Solution_485_MaxConsecutiveOne {
  public int findMaxConsecutiveOnes(int[] nums) {
    int count = 0, max = 0;
    for (int n : nums) {
      if (n == 1) {
        count++;
        max = Math.max(max, count);
      } else
        count = 0;
    }
    return max;
  }
}
