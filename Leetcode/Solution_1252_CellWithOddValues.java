class Solution_1252_CellWithOddValues {
  public int oddCells(int n, int m, int[][] indices) {
    int[][] rows = new int[n][1];
    int[][] cols = new int[m][1];
    for (int[] a : indices) {
      rows[a[0]][0]++;
      cols[a[1]][0]++;
    }
    int[] rowsCount = { 0, 0 };
    for (int i = 0; i < n; i++) {
      if ((rows[i][0] & 1) == 0)
        rowsCount[0]++;
      else
        rowsCount[1]++;
    }
    int[] colsCount = { 0, 0 };
    for (int i = 0; i < m; i++) {
      if ((cols[i][0] & 1) == 0)
        colsCount[0]++;
      else
        colsCount[1]++;
    }
    return (rowsCount[0] * colsCount[1]) + (rowsCount[1] * colsCount[0]);
  }
}
