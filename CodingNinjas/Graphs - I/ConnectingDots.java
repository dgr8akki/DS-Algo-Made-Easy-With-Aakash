/**
 * ConnectingDots
 */
public class ConnectingDots {

  public int solve(String[] Graph, int N, int M) {
    int[] xOffset = { 0, 1, 0, -1 };
    int[] yOffset = { -1, 0, 1, 0 };
    boolean[][] isVisited = new boolean[N][M];
    boolean[][] isBeingVisited = new boolean[N][M];
    int[] current = new int[1];
    for (char c = 'A'; c <= 'Z'; c++) {
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
          if (Graph[i].charAt(j) == c && !isVisited[i][j]) {
            dfsUtil(i, j, isVisited, isBeingVisited, xOffset, yOffset, N, M, current, Graph, c);
            if (current[0] > 4)
              return 1;
            current[0] = 0;
          }
        }
      }
    }
    return 0;
  }

  private void dfsUtil(int x, int y, boolean[][] isVisited, boolean[][] isBeingVisited, int[] xOffset, int[] yOffset,
      int N, int M, int[] count, String cake[], char currentCharacter) {
    isBeingVisited[x][y] = true;
    count[0]++;
    for (int i = 0; i < xOffset.length; i++) {
      if (isValid(x + xOffset[i], y + yOffset[i], isVisited, isBeingVisited, N, M, cake, currentCharacter)) {
        isVisited[x + xOffset[i]][y + yOffset[i]] = true;
        dfsUtil(x + xOffset[i], y + yOffset[i], isVisited, isBeingVisited, xOffset, yOffset, N, M, count, cake,
            currentCharacter);
        if (isBeingVisited[x + xOffset[i]][y + yOffset[i]] && count[0] >= 3)
          break;
      }
      isVisited[x][y] = true;
      isBeingVisited[x][y] = true;
    }
  }

  private boolean isValid(int x, int y, boolean[][] isVisited, boolean[][] isBeingVisited, int N, int M, String cake[],
      char currentCharacter) {
    return x >= 0 && x < N && y < M && y >= 0 && cake[x].charAt(y) == currentCharacter && !isVisited[x][y];
  }
}
