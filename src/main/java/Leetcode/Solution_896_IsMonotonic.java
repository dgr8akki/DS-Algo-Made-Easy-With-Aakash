package Leetcode;

class Solution {
  public boolean isMonotonic(int[] A) {
    // System.out.println("isMonotonicIncreasing: " + isMonotonicIncreasing(A));
    // System.out.println("isMonotonicDecreasing: " + isMonotonicIncreasing(A));
    return isMonotonicIncreasing(A) || isMonotonicDecreasing(A);
  }

  public boolean isMonotonicIncreasing(int[] A) {
    int last = A[0];
    for (int a : A) {
      if (a >= last)
        last = a;
      else
        return false;
    }
    return true;
  }

  public boolean isMonotonicDecreasing(int[] A) {
    int last = A[0];
    for (int a : A) {
      if (a <= last)
        last = a;
      else
        return false;
    }
    return true;
  }
}
