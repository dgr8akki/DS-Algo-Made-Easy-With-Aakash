import java.util.Scanner;

/**
 * SubsetSum
 */
public class SubsetSum {

  private static String isSubsetSumPossible(int[] arr, int sum, int n) {
    boolean[][] dp = new boolean[n + 1][sum + 1];
    for(int i = 0; i <= n; i++)
      dp[i][0] = true;
    for(int i = 1; i <= n; i++) {
      for(int j = 1; j <= sum; j++) {
        boolean notTakingItem = dp[i - 1][j];
        boolean takingItem = false;
        if(j - arr[i - 1] >= 0)
          takingItem = dp[i - 1][j - arr[i - 1]];
        dp[i][j] = notTakingItem || takingItem;
      }
    }
    return dp[n][sum] ? "Yes" : "No";
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] arr = new int[n];
    for(int i = 0; i < n; i++)
      arr[i] = in.nextInt();
    int k = in.nextInt();
    in.close();
    System.out.println(isSubsetSumPossible(arr, k, n));
  }
}
