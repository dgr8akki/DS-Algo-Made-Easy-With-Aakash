package Leetcode;

class Solution_239_SlidingWindowMax {
  public int[] maxSlidingWindow(int[] nums, int k) {
    if (nums == null || k <= 0)
      return new int[0];
    int[] result = new int[nums.length - k + 1];
    int max = Integer.MIN_VALUE;
    int j = 0;
    int prevMaxIndex = 0;
    for (int i = 0; i < nums.length - k + 1; i++) {
      for (; j < i + k; j++) {
        if (nums[j] > max) {
          max = nums[j];
          prevMaxIndex = j;
        }
      }
      result[i] = max;
      if (prevMaxIndex >= i + 1) {
        j = i + 1 + k - 1;
      } else {
        max = Integer.MIN_VALUE;
        j = i + 1;
      }
    }
    return result;
  }
}
