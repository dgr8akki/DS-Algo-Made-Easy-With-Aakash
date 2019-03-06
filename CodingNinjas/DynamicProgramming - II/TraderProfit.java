import java.util.Scanner;

/**
 * TraderProfit
 */
public class TraderProfit {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    while(t-- > 0) {
      int k = in.nextInt();
      int n = in.nextInt();
      int[] arr = new int[n];
      for(int i = 0; i < n; i++)
        arr[i] = in.nextInt();
      System.out.println(solve(n, arr, k));
    }
    in.close();
  }

  private static int solve(int n, int[] arr, int k) {
    int[][][] dp = new int[n + 1][k + 1][2];
    return traderProfitUtil(0, arr, k, dp, 0);
  }

  private static int traderProfitUtil(int currentDay, int[] arr, int k, int[][][] dp, int isOngoing) {
    int caseIfSellOnCurrentDay = Integer.MIN_VALUE, caseIfIgnoreCurrentDay = Integer.MIN_VALUE, caseIfBuyOnCurrentDay  = Integer.MIN_VALUE;
    if(currentDay == arr.length) return 0;
    if(dp[currentDay][k][isOngoing] > 0) return dp[currentDay][k][isOngoing];
    caseIfIgnoreCurrentDay = traderProfitUtil(currentDay + 1, arr, k, dp, isOngoing);

    // We can buy or sell.
    // Let's sell.
    if(isOngoing == 1) {
      caseIfSellOnCurrentDay = traderProfitUtil(currentDay + 1, arr, k - 1, dp, 0) + arr[currentDay];
    } else {
      // Let's buy.
      if(k > 0) {
        caseIfBuyOnCurrentDay = traderProfitUtil(currentDay + 1, arr, k, dp, 1) - arr[currentDay];
      }
    }
    dp[currentDay][k][isOngoing] = Math.max(caseIfSellOnCurrentDay, Math.max(caseIfIgnoreCurrentDay, caseIfBuyOnCurrentDay));
    return dp[currentDay][k][isOngoing];
  }
}
