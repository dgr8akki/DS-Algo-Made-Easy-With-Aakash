class Solution {
  public int[][] imageSmoother(int[][] M) {
    int r = M.length, c = M[0].length;
    int[][] res = new int[r][c];
    for (int i = 0; i < r; i++)
      for (int j = 0; j < c; j++)
        res[i][j] = getSmoother(M, i, j, r - 1, c - 1);
    return res;
  }

  private int getSmoother(int[][] M, int i, int j, int r, int c) {
    int sum = M[i][j];
    int count = 1;

    if (i > 0 && j > 0) {
      sum += M[i - 1][j - 1];
      count++;
    }

    if (i > 0 && j >= 0 && j <= c) {
      sum += M[i - 1][j];
      count++;
    }

    if (i > 0 && j < c) {
      sum += M[i - 1][j + 1];
      count++;
    }

    if (i >= 0 && i <= r && j < c) {
      sum += M[i][j + 1];
      count++;
    }

    if (i < r && j < c) {
      sum += M[i + 1][j + 1];
      count++;
    }

    if (i < r && j >= 0 && j <= c) {
      sum += M[i + 1][j];
      count++;
    }

    if (i < r && j > 0) {
      sum += M[i + 1][j - 1];
      count++;
    }

    if (i >= 0 && i <= r && j > 0) {
      sum += M[i][j - 1];
      count++;
    }
    return (int) Math.floor(sum / count);
  }
}
