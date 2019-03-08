public class CodingNinjas {
  String cn = "CODINGNINJA";

  public int solve(String[] Graph, int N, int M) {
    int[] xOffset = { 0, 1, 1, -1, 0, -1, -1, 1 };
    int[] yOffset = { -1, -1, 0, -1, 1, 0, 1, 1 };
    boolean[][] isVisited = new boolean[N][M];
    int[] current = new int[1];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (Graph[i].charAt(j) == 'C' && !isVisited[i][j]) {
          dfsUtil(i, j, isVisited, xOffset, yOffset, N, M, current, Graph, 0);
          if (current[0] > 0)
            return 1;
        }
      }
    }
    return 0;
  }

  private void dfsUtil(int x, int y, boolean[][] isVisited, int[] xOffset, int[] yOffset, int N, int M, int[] count,
      String cake[], int currentCharacterIndex) {
    if (currentCharacterIndex >= cn.length() - 1) {
      count[0]++;
      return;
    }
    isVisited[x][y] = true;
    for (int i = 0; i < xOffset.length; i++)
      if (isValid(x + xOffset[i], y + yOffset[i], isVisited, N, M, cake, currentCharacterIndex + 1))
        dfsUtil(x + xOffset[i], y + yOffset[i], isVisited, xOffset, yOffset, N, M, count, cake,
            currentCharacterIndex + 1);

    isVisited[x][y] = false;
  }

  private boolean isValid(int x, int y, boolean[][] isVisited, int N, int M, String cake[], int currentCharacterIndex) {
    return currentCharacterIndex < cn.length() && x >= 0 && x < N && y < M && y >= 0
        && cake[x].charAt(y) == cn.charAt(currentCharacterIndex) && !isVisited[x][y];
  }
}
