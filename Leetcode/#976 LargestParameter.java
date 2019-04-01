class Solution {
  public int largestPerimeter(int[] A) {
    Arrays.sort(A);
    int i = A.length - 3;
    while (i >= 0) {
      int s1 = A[i + 2];
      int s2 = A[i + 1];
      int s3 = A[i];

      if (s1 < s2 + s3)
        return s1 + s2 + s3;
      i--;
    }
    return 0;
  }
}
