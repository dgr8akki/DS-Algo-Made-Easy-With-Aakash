package Leetcode;

class Solution_968_IntervalListIntersection {
  public int[][] intervalIntersection(int[][] A, int[][] B) {
    if (A == null || A.length == 0 || B == null || B.length == 0) {
      return new int[0][0];
    }

    int m = A.length, n = B.length;
    int i = 0, j = 0;
    List<int[]> res = new ArrayList<>();
    while (i < m && j < n) {
      int[] a = A[i];
      int[] b = B[j];

      int startMax = Math.max(a[0], b[0]);
      int endMin = Math.min(a[1], b[1]);

      if (endMin >= startMax)
        res.add(new int[] { startMax, endMin });

      if (a[1] == endMin)
        i++;

      if (b[1] == endMin)
        j++;

    }

    return res.toArray(new int[0][0]);
  }
}
