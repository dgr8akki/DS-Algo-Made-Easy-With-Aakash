class Solution {
  public int[] sortedSquares(int[] A) {
    int n = A.length;
    int[] res = new int[n];
    int left = 0, right = n - 1;
    for (int i = n - 1; i >= 0; i--) {
      if (A[left] * A[left] > A[right] * A[right]) {
        res[i] = A[left] * A[left];
        left++;
      } else {
        res[i] = A[right] * A[right];
        right--;
      }
    }
    return res;
  }
}
