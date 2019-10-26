package Leetcode;

class Solution {
  public int findLengthOfLCIS(int[] A) {
    if (A.length == 0)
      return 0;
    int max = Integer.MIN_VALUE, current = 0;
    for (int i = 0; i < A.length; i++) {
      if (i == 0 || A[i - 1] < A[i])
        max = Math.max(max, ++current);
      else
        current = 1;
    }
    return max;
  }
}
