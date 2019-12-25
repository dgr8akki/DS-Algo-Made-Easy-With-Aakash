package Leetcode;

class Solution_53_MaximumSubarray {
  public int maxSubArray(int[] prices) {
    int globalMax = Integer.MIN_VALUE;
    int sum = 0;
    boolean allNegative = true;
    int maxSoFar = Integer.MIN_VALUE;
    for (int i : prices) {
      if (i > 0)
        allNegative = false;
      sum += i;
      if (sum <= 0)
        sum = 0;
      maxSoFar = Math.max(maxSoFar, i);
      globalMax = Math.max(sum, globalMax);
    }
    return allNegative ? maxSoFar : globalMax;
  }
}
