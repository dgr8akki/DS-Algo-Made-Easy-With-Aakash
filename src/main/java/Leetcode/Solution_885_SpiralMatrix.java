package Leetcode;

class Solution {
  public int[][] spiralMatrixIII(int R, int C, int r, int c) {
    int[][] res = new int[R * C][2];
    res[0] = new int[] { r, c };
    int x = 0, y = 1, n = 0, i = 0, tmp, j = 1;
    while (j < R * C) {
      r += x;
      c += y;
      i++;
      if (0 <= r && r < R && 0 <= c && c < C)
        res[j++] = new int[] { r, c };
      if (i == n / 2 + 1) {
        i = 0;
        n++;
        tmp = x;
        x = y;
        y = -tmp;
      }
    }
    return res;
  }
}
