package Leetcode;

class Solution {
  public int maxProfit(int[] prices, int fee) {
    if (prices == null || prices.length == 0)
      return 0;

    int len = prices.length;
    int buy = -prices[0], sell = 0;
    for (int i = 1; i < len; i++) {
      int tmpbuy = buy;
      buy = Math.max(buy, sell - prices[i]);
      sell = Math.max(sell, tmpbuy + prices[i] - fee);
    }
    return Math.max(buy, sell);
  }
}
