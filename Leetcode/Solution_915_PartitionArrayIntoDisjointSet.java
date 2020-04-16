package Leetcode;

class Solution_915_PartitionArrayIntoDisjointSet {
  public int partitionDisjoint(int[] A) {
    int globalMax = A[0], leftMax = A[0], boundary = 0;

    for (int i = 0; i < A.length; i++) {
      globalMax = A[i] > globalMax ? A[i] : globalMax;
      if (A[i] < leftMax) {
        boundary = i;
        leftMax = globalMax > leftMax ? globalMax : leftMax;
      }
    }
    return boundary + 1;
  }
}
