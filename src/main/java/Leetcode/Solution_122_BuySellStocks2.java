package Leetcode;

public class Solution_122_BuySellStocks2 {
  public static int maxProfit(int[] prices) {
    int total = 0;
    for (int i = 0; i < prices.length - 1; i++) {
      if (prices[i + 1] > prices[i]) {
        total += prices[i + 1] - prices[i];
      }
      System.out.println(total);
    }

    return total;
  }
}

class Solution_122_BuySellStocks22 {
  private static int maxProfitUtil(int[] prices, int n, int day, int isPurchased, int[][] dp) {
    if (day == n) {
      return 0;
    }
    if (dp[day][isPurchased] > 0) {
      return dp[day][isPurchased];
    }
    int optionToSkip =
        Solution_122_BuySellStocks22.maxProfitUtil(prices, n, day + 1, isPurchased, dp);

    int optionToSell =
        isPurchased == 1
            ? Solution_122_BuySellStocks22.maxProfitUtil(prices, n, day + 1, 0, dp) + prices[day]
            : Integer.MIN_VALUE;

    int optionToBuy =
        isPurchased == 1
            ? Integer.MIN_VALUE
            : Solution_122_BuySellStocks22.maxProfitUtil(prices, n, day + 1, 1, dp) - prices[day];

    return dp[day][isPurchased] = Math.max(optionToSkip, Math.max(optionToSell, optionToBuy));
  }

  public static int maxProfit(int[] prices) {
    int[][] dp = new int[prices.length + 1][2];
    return Solution_122_BuySellStocks22.maxProfitUtil(prices, prices.length, 0, 0, dp);
  }
}
