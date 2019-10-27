package Leetcode;

class Solution_747_LargestNumberTwiceOthers {
  public int dominantIndex(int[] nums) {
    int firstLargest = Integer.MIN_VALUE, secondLargest = Integer.MIN_VALUE;
    int idx = 0, res = -1;
    for (int i : nums) {
      if (i > firstLargest) {
        secondLargest = firstLargest;
        firstLargest = i;
        res = idx;
      } else if (i > secondLargest) {
        secondLargest = i;
      }

      idx++;
    }

    return firstLargest >= 2 * secondLargest ? res : -1;
  }
}
