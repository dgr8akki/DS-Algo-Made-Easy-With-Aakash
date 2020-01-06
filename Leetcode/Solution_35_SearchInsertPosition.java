package Leetcode;

class Solution_35_SearchInsertPosition {
  public int searchInsert(int[] nums, int target) {
    int expected = Arrays.binarySearch(nums, target);
    if (expected >= 0)
      return expected;
    return (-1 * expected) - 1;
  }
}