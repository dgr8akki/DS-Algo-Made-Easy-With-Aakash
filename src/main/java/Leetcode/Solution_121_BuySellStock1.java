package Leetcode;

class Solution_121_BuySellStock1 {
  public static int maxProfit(int[] prices) {
    int globalMax = 0;
    int sum = 0;
    for (int i = 1; i < prices.length; i++) {
      sum += (prices[i] - prices[i - 1]);
      if (sum <= 0) {
        sum = 0;
      }
      globalMax = Math.max(sum, globalMax);
    }
    return globalMax;
  }
}

class Solution_121_BuySellStock12 {
  public static int maxProfit(int[] prices) {
    int sellFirst = 0, holdFirst = Integer.MIN_VALUE;

    for (int price : prices) {
      sellFirst = Math.max(sellFirst, holdFirst + price);
      holdFirst = Math.max(holdFirst, -price);
    }

    return sellFirst;
  }
}
