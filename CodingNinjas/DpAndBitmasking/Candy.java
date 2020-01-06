package CodingNinjas.DpAndBitmasking;

import java.util.Arrays;
import java.util.Scanner;

public class Candy {

  private static long solve(int[][] like, int n) {
    int currentRowIdx = 0;
    int mask = 0;
    // return candyCountRecursive(like, n, currentRowIdx, mask);
    long[] dp = new long[(1 << n) - 1];
    Arrays.fill(dp, -1);
    return candyCountMemoized(like, n, currentRowIdx, mask, dp);
  }

  private static long candyCountMemoized(int[][] like, int n, int currentRowIdx, int mask, long[] dp) {
    if(currentRowIdx >= n) {
      return 1;
    }
    if(dp[mask] != -1) {
      return dp[mask];
    }
    long ways = 0;
    for(int i = 0; i < n; i++) {
      if(like[currentRowIdx][i] == 1 && (mask & (1 << i)) == 0) {
        ways += candyCountMemoized(like, n, currentRowIdx + 1, mask | (1 << i), dp);
      }
    }
    return dp[mask] = ways;
  }

  private static long candyCountRecursive(int[][] like, int n, int currentRowIdx, int mask) {
    if(currentRowIdx >= n) {
      return 1;
    }

    long ways = 0;
    for(int i = 0; i < n; i++) {
      if(like[currentRowIdx][i] == 1 && (mask & (1 << i)) == 0) {
        ways += candyCountRecursive(like, n, currentRowIdx + 1, mask | (1 << i));
      }
    }
    return ways;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[][] like = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        like[i][j] = in.nextInt();
      }
    }
    in.close();

    System.out.println(solve(like, n));
  }
}
