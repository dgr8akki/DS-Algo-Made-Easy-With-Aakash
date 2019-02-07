import java.util.Scanner;

/**
 * CoinChangeProblem
 */
public class CoinChangeProblem {
  public static int countWaysToMakeChange(int denominations[], int value) {
    int rows = denominations.length + 1;
    int cols = value + 1;
    int[][] dp = new int[rows][cols];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if(i == 0) continue;
        if(j == 0) {
          dp[i][j] = 1;
          continue;
        }
        if (j - denominations[i - 1] >= 0)
          dp[i][j] = dp[i][j - denominations[i - 1]] + dp[i - 1][j];
        else
          dp[i][j] = dp[i - 1][j];
      }
    }
    return dp[rows - 1][cols - 1];
  }

  public static int countWaysToMakeChangeRecursive(int denominations[], int value) {
    return 0;
  }

  public static int countWaysToMakeChangeMemoized(int denominations[], int value) {
    return 0;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] denominations = new int[n];
    for (int i = 0; i < n; i++)
      denominations[i] = in.nextInt();
    int value = in.nextInt();
    in.close();
    System.out.println(countWaysToMakeChange(denominations, value));
  }
}