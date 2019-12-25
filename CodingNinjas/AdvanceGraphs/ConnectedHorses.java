package CodingNinjas.AdvanceGraphs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * ConnectedHorses
 */
public class ConnectedHorses {
  private static final int M = 1000000007;
  private static Map<Integer, Long> factorial = new HashMap<>();

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    while (t-- > 0) {
      int n = in.nextInt();
      int m = in.nextInt();
      int q = in.nextInt();

      int[][] chess = new int[n][m];
      boolean[][] isVisited = new boolean[n][m];
      for (int i = 0; i < n; i++) {
        Arrays.fill(isVisited[i], true);
      }

      for (int i = 0; i < q; i++) {
        int x = in.nextInt() - 1;
        int y = in.nextInt() - 1;
        chess[x][y] = 1;
        isVisited[x][y] = false;
      }
      // solve(chess, n, m, isVisited);
      System.out.println(solve(chess, n, m, isVisited));

    }
    in.close();
  }

  private static long solve(int[][] chess, int n, int m, boolean[][] isVisited) {
    long res = 1;
    int[] xOffset = { 2, 2, -2, -2, 1, -1, 1, -1 };
    int[] yOffset = { 1, -1, 1, -1, 2, 2, -2, -2 };
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (chess[i][j] == 1 && !isVisited[i][j]) {
          int[] count = new int[1];
          dfsUtil(chess, i, j, isVisited, count, xOffset, yOffset);
          res = ((res % M) * fact(count[0])) % M;
        }
      }
    }

    return res;
  }

  private static long fact(int n) {
    if (n == 0) {
      return 1;
    }
    if (factorial.containsKey(n) && factorial.get(n) > 0) {
      return factorial.get(n) % M;
    }
    long prod = 1;
    for (int i = 1; i <= n; i++) {
      prod = ((prod % M) * (i % M)) % M;
    }
    factorial.put(n, prod % M);
    return prod % M;
  }

  private static void dfsUtil(int[][] chess, int i, int j, boolean[][] isVisited, int[] count, int[] xOffset,
                              int[] yOffset) {
    isVisited[i][j] = true;
    count[0]++;
    for (int in = 0; in < xOffset.length; in++) {
      if (isValid(chess, i + xOffset[in], j + yOffset[in], isVisited)) {
        dfsUtil(chess, i + xOffset[in], j + yOffset[in], isVisited, count, xOffset, yOffset);
      }
    }
  }

  private static boolean isValid(int[][] chess, int i, int j, boolean[][] isVisited) {
    return i >= 0 && i < chess.length && j >= 0 && j < chess[0].length && !isVisited[i][j] && chess[i][j] == 1;
  }
}
