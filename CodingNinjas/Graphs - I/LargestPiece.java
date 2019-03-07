public class solution {
  public int solve(int vertices, String cake[]) {
    int[] xOffset = { 0, 1, 0, -1 };
    int[] yOffset = { -1, 0, 1, 0 };
    boolean[][] isVisited = new boolean[vertices][vertices];
    int max = 0;
    int[] current = new int[1];
    for (int i = 0; i < vertices; i++) {
      for (int j = 0; j < vertices; j++) {
        if (cake[i].charAt(j) == '1' && !isVisited[i][j]) {
          dfsUtil(i, j, isVisited, xOffset, yOffset, vertices, current, cake);
          if (current[0] > max)
            max = current[0];
          current[0] = 0;
        }
      }
    }
    return max;
  }

  private void dfsUtil(int x, int y, boolean[][] isVisited, int[] xOffset, int[] yOffset, int vertices, int[] count,
      String cake[]) {
    isVisited[x][y] = true;
    count[0]++;
    for (int i = 0; i < xOffset.length; i++)
      if (isValid(x + xOffset[i], y + yOffset[i], isVisited, vertices, cake))
        dfsUtil(x + xOffset[i], y + yOffset[i], isVisited, xOffset, yOffset, vertices, count, cake);
  }

  private boolean isValid(int x, int y, boolean[][] isVisited, int vertices, String cake[]) {
    return x >= 0 && x < vertices && y < vertices && y >= 0 && cake[x].charAt(y) == '1' && !isVisited[x][y];
  }
}
