package Leetcode;

class Solution_154_FindMinimumInRotatedArray {
  public int findMin(int[] nums) {
    int lo = 0, hi = nums.length - 1;
    while (lo < hi) {
      int mi = lo + (hi - lo) / 2;
      if (nums[mi] > nums[hi])
        lo = mi + 1;
      else if (nums[mi] < nums[lo]) {
        hi = mi;
        lo++;
      } else
        hi--;
    }

    return nums[lo];
  }
}
