import java.util.Scanner;

/**
 * AdjacentBitCounts
 */
public class AdjacentBitCounts {
  int M = 1_000_000_000 + 7;

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int dataSetCount = in.nextInt();
    while(dataSetCount-- > 0) {
      int dataSetNumber = in.nextInt();
      int n = in.nextInt();
      int k = in.nextInt();
      System.out.println(dataSetNumber + " " + solve(n, k));
    }
    in.close();
  }

  private static long solve(int n, int k) {
    // long recursiveResult = bitCountRecursiveUtil(n, k, false) + bitCountRecursiveUtil(n, k, true);
    long[][][] dp = new long[n + 1][k + 1][2];
    long memoizedResult = bitCountMemoizedUtil(n, k, false, dp) + bitCountMemoizedUtil(n, k, true, dp);
    return memoizedResult;
  }

  private static long bitCountMemoizedUtil(int n, int k, boolean isFirstBitSet, long[][][] dp) {
    if(k < 0)
      return 0;
    if(n == 1) {
      if(k == 0) return 1;
      return 0;
    }
    dp[1][0][0] = 1;
    dp[1][0][1] = 1;
    if(isFirstBitSet) {
      if(dp[n][k][1] <= 0)
        dp[n][k][1] = bitCountMemoizedUtil(n - 1, k - 1, true, dp) + bitCountMemoizedUtil(n - 1, k, false, dp);
      return dp[n][k][1];
    }
    if(dp[n][k][0] <= 0)
      dp[n][k][0] = bitCountMemoizedUtil(n - 1, k, true, dp) + bitCountMemoizedUtil(n - 1, k, false, dp);
    return dp[n][k][0];
  }

  private static long bitCountRecursiveUtil(int n, int k, boolean isFirstBitSet) {
    if(k < 0)
      return 0;
    if(n == 1) {
      if(k == 0) return 1;
      return 0;
    }
    if(isFirstBitSet)
      return bitCountRecursiveUtil(n - 1, k - 1, true) + bitCountRecursiveUtil(n - 1, k, false);
    return bitCountRecursiveUtil(n - 1, k, true) + bitCountRecursiveUtil(n - 1, k, false);
  }
}
