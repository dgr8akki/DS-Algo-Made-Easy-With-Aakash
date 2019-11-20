class Solution_1162_AsFarAsLand {
  public int maxDistance(int[][] grid) {
    int m = grid.length, n = grid[0].length;
    boolean[][] visited = new boolean[m][n];
    Queue<int[]> q = new LinkedList<>();
    for (int i = 0; i < m; i++)
      for (int j = 0; j < n; j++)
        if (grid[i][j] == 1) {
          visited[i][j] = true;
          q.offer(new int[] { i, j });
        }

    int[][] dirs = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
    int result = -1;
    while (!q.isEmpty()) {
      int size = q.size();
      while (size-- > 0) {
        int[] cur = q.poll();
        result = Math.max(result, grid[cur[0]][cur[1]] - 1);
        for (int[] dir : dirs) {
          int x = cur[0] + dir[0], y = cur[1] + dir[1];
          if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y]) {
            visited[x][y] = true;
            grid[x][y] = grid[cur[0]][cur[1]] + 1;
            q.offer(new int[] { x, y });
          }
        }
      }
    }
    return result == 0 ? -1 : result;
  }
}
