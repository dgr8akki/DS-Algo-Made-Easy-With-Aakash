package Leetcode;

class Solution_309_BuyStockWithCoolDown {
  public int maxProfit(int[] prices) {
    if (prices == null || prices.length <= 1)
      return 0;

    int buyLast = -prices[0], buyCurrent = buyLast;
    int sellLast = 0, sellCurrent = 0, sellNext = 0;

    for (int i = 1; i < prices.length; i++) {
      buyLast = Math.max(buyCurrent, sellNext - prices[i]);
      sellLast = Math.max(sellCurrent, buyCurrent + prices[i]);
      buyCurrent = buyLast;
      sellNext = sellCurrent;
      sellCurrent = sellLast;
    }
    return sellLast;
  }
}
