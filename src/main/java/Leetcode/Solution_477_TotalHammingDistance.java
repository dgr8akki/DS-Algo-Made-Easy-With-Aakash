package Leetcode;

class Solution {
  public int totalHammingDistance(int[] nums) {
    int res = 0;
    for (int i = 0; i < nums.length; i++)
      for (int j = i + 1; j < nums.length; j++)
        if (i != j)
          res += Integer.bitCount(nums[i] ^ nums[j]);
    return res;
  }
}
