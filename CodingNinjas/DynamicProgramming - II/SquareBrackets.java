import java.util.Scanner;

/**
 * SquareBrackets
 */
public class SquareBrackets {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int d = in.nextInt();
    while(d-- > 0) {
      int n = in.nextInt();
      int k = in.nextInt();
      boolean[] isOnlyOpenNeededHere = new boolean[(2 * n) + 1];
      while(k-- > 0)
        isOnlyOpenNeededHere[in.nextInt() - 1] = true;
      System.out.println(solve(n, isOnlyOpenNeededHere));
    }
    in.close();
  }

  private static int solve(int n, boolean[] isOnlyOpenNeededHere) {
    int[][] dp = new int[n + 1][n + 1];
    return squareBracketMemoizedUtil(n, isOnlyOpenNeededHere, 0, 0, dp);
  }

  private static int squareBracketMemoizedUtil(int n, boolean[] isOnlyOpenNeededHere, int currentOpeningCount, int currentClosingCount, int[][] dp) {
    if(currentClosingCount > n || currentOpeningCount > n) return 0;
    if(currentClosingCount == n && currentOpeningCount == n) return 1;
    if(dp[currentOpeningCount][currentClosingCount] > 0) return dp[currentOpeningCount][currentClosingCount];
    //Only opening bracket.
    if(currentClosingCount == currentOpeningCount || isOnlyOpenNeededHere[currentClosingCount + currentOpeningCount]) {
      dp[currentOpeningCount][currentClosingCount] = squareBracketMemoizedUtil(n, isOnlyOpenNeededHere, currentOpeningCount + 1, currentClosingCount, dp);
      return dp[currentOpeningCount][currentClosingCount];
    }
    //Only closing bracket.
    if(currentOpeningCount == n) {
      dp[currentOpeningCount][currentClosingCount] = squareBracketMemoizedUtil(n, isOnlyOpenNeededHere, currentOpeningCount, currentClosingCount + 1, dp);
      return dp[currentOpeningCount][currentClosingCount];
    }
    //Both can be apply
    dp[currentOpeningCount][currentClosingCount] = squareBracketMemoizedUtil(n, isOnlyOpenNeededHere, currentOpeningCount, currentClosingCount + 1, dp)
    + squareBracketMemoizedUtil(n, isOnlyOpenNeededHere, currentOpeningCount + 1, currentClosingCount, dp);
    return dp[currentOpeningCount][currentClosingCount];
  }

  private static int squareBracketUtil(int n, boolean[] isOnlyOpenNeededHere, int currentOpeningCount, int currentClosingCount) {
    if(currentClosingCount > n || currentOpeningCount > n) return 0;
    if(currentClosingCount == n && currentOpeningCount == n) return 1;

    //Only opening bracket.
    if(currentClosingCount == currentOpeningCount || isOnlyOpenNeededHere[currentClosingCount + currentOpeningCount]) {
      return squareBracketUtil(n, isOnlyOpenNeededHere, currentOpeningCount + 1, currentClosingCount);
    }
    //Only closing bracket.
    if(currentOpeningCount == n) {
      return squareBracketUtil(n, isOnlyOpenNeededHere, currentOpeningCount, currentClosingCount + 1);
    }
    //Both can be apply
    return squareBracketUtil(n, isOnlyOpenNeededHere, currentOpeningCount, currentClosingCount + 1)
    + squareBracketUtil(n, isOnlyOpenNeededHere, currentOpeningCount + 1, currentClosingCount);
  }
}
