class Solution {
  public int getMaximumGold(int[][] grid) {
    int max = 0;

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 0)
          continue;
        int[] current = new int[1];
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        dfsUtil(grid, i, j, visited, current);
        max = Math.max(max, current[0]);
      }
    }

    return max;
  }

  private void dfsUtil(int[][] grid, int i, int j, boolean[][] visited, int[] current) {

    if (allVisited(i, j, visited))
      return;

    if (isSafe(i, j, visited, grid)) {
      current[0] += grid[i][j];
      visited[i][j] = true;

      dfsUtil(grid, i - 1, j, visited, current);
      dfsUtil(grid, i + 1, j, visited, current);
      dfsUtil(grid, i, j - 1, visited, current);
      dfsUtil(grid, i, j + 1, visited, current);
    }

  }

  private boolean isSafe(int i, int j, boolean[][] visited, int[][] grid) {
    return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && !visited[i][j] && grid[i][j] > 0;
  }

  private boolean allVisited(int i, int j, boolean[][] visited) {
    return isVisited(i - 1, j, visited) && isVisited(i + 1, j, visited) && isVisited(i, j - 1, visited)
        && isVisited(i, j + 1, visited);
  }

  private boolean isVisited(int i, int j, boolean[][] visited) {
    return i >= 0 && i < visited.length && j >= 0 && j < visited[0].length && visited[i][j];
  }
}
