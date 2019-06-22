class Solution {
  public int partitionDisjoint(int[] A) {
    int globalMax = A[0];
    int leftMax = A[0];
    int boundary = 0;

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
