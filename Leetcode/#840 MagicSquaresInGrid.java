class Solution {
  public int numMagicSquaresInside(int[][] grid) {
    int rows = grid.length, cols = grid[0].length;
    int xor = 1 ^ 2 ^ 3 ^ 4 ^ 5 ^ 6 ^ 7 ^ 8 ^ 9;
    if (rows < 2 || cols < 2) {
      return 0;
    }
    int count = 0;
    for (int i = 0; i < rows - 2; i++) {
      for (int j = 0; j < cols - 2; j++) {
        int el1 = grid[i][j], el2 = grid[i][j + 1], el3 = grid[i][j + 2];
        int el4 = grid[i + 1][j], el5 = grid[i + 1][j + 1], el6 = grid[i + 1][j + 2];
        int el7 = grid[i + 2][j], el8 = grid[i + 2][j + 1], el9 = grid[i + 2][j + 2];
        if ((el1 ^ el2 ^ el3 ^ el4 ^ el5 ^ el6 ^ el7 ^ el8 ^ el9) != xor)
          continue;
        int sum1 = el1 + el2 + el3;
        int sum2 = el4 + el5 + el6;
        int sum3 = el7 + el8 + el9;
        int sum4 = el1 + el4 + el7;
        int sum5 = el2 + el5 + el8;
        int sum6 = el3 + el6 + el9;
        int sum7 = el1 + el5 + el9;
        int sum8 = el3 + el5 + el7;
        if (sum1 == sum2 && sum2 == sum3 && sum3 == sum4 && sum4 == sum5 && sum5 == sum6 && sum6 == sum7
            && sum7 == sum8) {
          count++;
        }
      }
    }
    return count;
  }
}
