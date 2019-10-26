package Leetcode;

class Solution {
  public int maxAreaOfIsland(int[][] grid) {
    boolean[][] visited = new boolean[grid.length][grid[0].length];
    int max = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (!visited[i][j] && grid[i][j] == 1) {
          int[] count = new int[1];
          dfs(grid, i, j, visited, count);
          max = Math.max(count[0], max);
        }
      }
    }
    return max;
  }

  private void dfs(int[][] grid, int i, int j, boolean[][] visited, int[] count) {
    if (isValid(i, j, grid, visited)) {
      count[0]++;
      visited[i][j] = true;
    }
    if (isValid(i + 1, j, grid, visited))
      dfs(grid, i + 1, j, visited, count);
    if (isValid(i, j + 1, grid, visited))
      dfs(grid, i, j + 1, visited, count);
    if (isValid(i, j - 1, grid, visited))
      dfs(grid, i, j - 1, visited, count);
    if (isValid(i - 1, j, grid, visited))
      dfs(grid, i - 1, j, visited, count);
  }

  private boolean isValid(int i, int j, int[][] grid, boolean[][] visited) {
    return i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && grid[i][j] == 1 && !visited[i][j];
  }
}
