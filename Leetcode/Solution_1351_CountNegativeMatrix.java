class Solution {
  public int countNegatives(int[][] grid) {
    int res = 0;
    for (int[] row : grid)
      res += bs(row);
    
    return res;
  }

  int bs(int[] row) {
    int l = 0, r = row.length;
    while (l < r) {
      int m = l + (r - l) / 2;
      if (row[m] < 0)
        r = m;
      else
        l = m + 1;
    }
    return row.length - l;
  }
}
