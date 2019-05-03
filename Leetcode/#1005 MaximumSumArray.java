class Solution {
  public int largestSumAfterKNegations(int[] A, int K) {
    Arrays.sort(A);
    for (int i = 0; K > 0 && i < A.length && A[i] < 0; ++i, --K)
      A[i] = -A[i];
    int res = 0, min = Integer.MAX_VALUE;
    for (int a : A) {
      res += a;
      min = Math.min(min, a);
    }
    return res - (K % 2) * min * 2;
  }
}
