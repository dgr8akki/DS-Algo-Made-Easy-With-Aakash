class Solution_1288_RemoveCoveredIntervals {
  public int removeCoveredIntervals(int[][] A) {
    int res = 0, left = -1, right = -1;
    Arrays.sort(A, (a, b) -> a[0] - b[0]);
    for (int[] v : A) {
      if (v[0] > left && v[1] > right) {
        left = v[0];
        ++res;
      }
      right = Math.max(right, v[1]);
    }
    return res;
  }
}
