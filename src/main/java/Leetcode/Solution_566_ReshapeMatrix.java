package Leetcode;

class Solution {
  public int[][] matrixReshape(int[][] A, int r, int c) {
    int m = A.length, n = A[0].length;
    if (m * n != r * c)
      return A;
    int[][] B = new int[r][c];
    int p = 0;
    int[] temp = new int[m * n];
    for (int i = 0; i < m; i++)
      for (int j = 0; j < n; j++)
        temp[p++] = A[i][j];
    p = 0;
    for (int i = 0; i < r; i++)
      for (int j = 0; j < c; j++)
        B[i][j] = temp[p++];
    return B;
  }
}
