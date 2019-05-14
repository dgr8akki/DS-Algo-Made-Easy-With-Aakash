class Solution {
  public int[][] generateMatrix(int n) {
    int counter = 1;
    int[][] matrix = new int[n][n];

    if (matrix.length == 0)
      return new int[0][0];

    int rowBegin = 0;
    int rowEnd = matrix.length - 1;
    int colBegin = 0;
    int colEnd = matrix[0].length - 1;

    while (rowBegin <= rowEnd && colBegin <= colEnd) {
      for (int j = colBegin; j <= colEnd; j++)
        matrix[rowBegin][j] = counter++;
      rowBegin++;

      for (int j = rowBegin; j <= rowEnd; j++)
        matrix[j][colEnd] = counter++;
      colEnd--;

      if (rowBegin <= rowEnd)
        for (int j = colEnd; j >= colBegin; j--)
          matrix[rowEnd][j] = counter++;
      rowEnd--;

      if (colBegin <= colEnd)
        for (int j = rowEnd; j >= rowBegin; j--)
          matrix[j][colBegin] = counter++;
      colBegin++;
    }

    return matrix;
  }
}
