package Leetcode;

class Solution_688_KnightProbabInChess {
  int[][] direction = new int[][] { { 2, 1 }, { -2, 1 }, { 2, -1 }, { -2, -1 }, { 1, 2 }, { 1, -2 }, { -1, 2 },
      { -1, -2 } };

  public double knightProbability(int N, int K, int r, int c) {
    double[][][] ways = new double[K + 1][N][N];
    ways[0][r][c] = 1;
    for (int k = 1; k <= K; ++k)
      for (int i = 0; i < N; ++i)
        for (int j = 0; j < N; ++j)
          for (int[] dir : direction) {
            int oldR = i - dir[0];
            int oldC = j - dir[1];
            if (oldR >= 0 && oldC >= 0 && oldR < N && oldC < N)
              ways[k][i][j] += (ways[k - 1][oldR][oldC] / 8.0);
          }
    double res = 0;
    for (int i = 0; i < N; ++i)
      for (int j = 0; j < N; ++j)
        res += ways[K][i][j];

    return res;
  }
}
