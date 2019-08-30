class Solution {
  public int largestOverlap(int[][] A, int[][] B) {
    int ans = 0;
    for (int row = -A.length; row < A.length; row++)
      for (int col = -A[0].length; col < A[0].length; col++)
        ans = Math.max(ans, overlap(A, B, row, col));
    return ans;
  }

  public int overlap(int[][] A, int[][] B, int rowOffset, int colOffset) {
    int ans = 0;
    for (int row = 0; row < A.length; row++)
      for (int col = 0; col < A[0].length; col++) {
        if ((row + rowOffset < 0 || row + rowOffset >= A.length)
            || (col + colOffset < 0 || col + colOffset >= A.length))
          continue;
        if (A[row][col] == 1 && B[row + rowOffset][col + colOffset] == 1)
          ans++;
      }
    return ans;
  }
}
