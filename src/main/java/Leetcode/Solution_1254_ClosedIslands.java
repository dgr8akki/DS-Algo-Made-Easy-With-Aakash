class Solution_1254_ClosedIslands {

  int[][] dir = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

  public int closedIsland(int[][] grid) {
    int res = 0;
    for (int i = 0; i < grid.length; i++)
      for (int j = 0; j < grid[0].length; j++)
        if (grid[i][j] == 0)
          if (dfs(grid, i, j))
            res++;

    return res;
  }

  public boolean dfs(int[][] grid, int x, int y) {

    if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length)
      return false;

    if (grid[x][y] == 1)
      return true;

    grid[x][y] = 1;

    boolean res = true;

    for (int[] d : dir)
      res = res & dfs(grid, x + d[0], y + d[1]);

    return res;
  }
}
