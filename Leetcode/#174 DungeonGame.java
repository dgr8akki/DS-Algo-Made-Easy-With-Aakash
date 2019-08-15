class Solution {
  public int calculateMinimumHP(int[][] dungeon) {
    int m = dungeon.length;
    int n = m == 0 ? 0 : dungeon[0].length;
    int[][] minRequred = new int[m + 1][n + 1];

    for (int i = 0; i < m + 1; i++)
      minRequred[i][n] = Integer.MAX_VALUE;
    for (int j = 0; j < n + 1; j++)
      minRequred[m][j] = Integer.MAX_VALUE;

    minRequred[m][n - 1] = 0;
    minRequred[m - 1][n] = 0;

    for (int i = m - 1; i >= 0; i--)
      for (int j = n - 1; j >= 0; j--)
        minRequred[i][j] = Math.max(Math.min(minRequred[i + 1][j], minRequred[i][j + 1]) - dungeon[i][j], 0);

    return minRequred[0][0] + 1;
  }
}
