class Solution {
  public int findMin(int[] A) {
    int start = 0, mid = -1, end = A.length - 1;
    while (start < end) {
      if (A[start] < A[end])
        return A[start];
      mid = (start + end) / 2;
      if (A[mid] >= A[start]) {
        start = mid + 1;
      } else {
        end = mid;
      }
    }
    return A[start];
  }
}
