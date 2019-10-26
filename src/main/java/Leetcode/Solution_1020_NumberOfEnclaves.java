package Leetcode;

class Solution {
  public int numEnclaves(int[][] A) {
    int count = 0;
    for (int i = 0; i < A.length; i++)
      for (int j = 0; j < A[i].length; j++)
        if (i == 0 || j == 0 || i == A.length - 1 || j == A[i].length - 1)
          dfs(A, i, j);
    for (int i = 0; i < A.length; i++)
      for (int j = 0; j < A[i].length; j++)
        if (A[i][j] == 1)
          count++;
    return count;
  }

  private void dfs(int[][] A, int i, int j) {
    if (i < 0 || i >= A.length || j < 0 || j >= A[i].length || A[i][j] == 0)
      return;
    A[i][j] = 0;
    dfs(A, i + 1, j);
    dfs(A, i - 1, j);
    dfs(A, i, j + 1);
    dfs(A, i, j - 1);
  }
}
