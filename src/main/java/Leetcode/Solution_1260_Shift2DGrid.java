class Solution_1260_Shift2DGrid {
  public static List<List<Integer>> shiftGrid(int[][] grid, int k) {
    int[][] temp = new int[grid.length][grid[0].length]; // took temp grid
    int n = grid.length;
    int m = grid[0].length;
    int mod = n * m;
    k = k % mod;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        int p = j + k;
        int r = p / (m);
        if (p < m) {
          temp[i][p] = grid[i][j];
        } else {
          temp[(i + r) % n][p % m] = grid[i][j];
        }
      }
    }

    List<List<Integer>> result = new LinkedList<>();
    for (int[] t : temp) {
      LinkedList<Integer> c = new LinkedList<>();
      for (int i : t)
        c.add(i);
      result.add(c);
    }
    return result;
  }
}
