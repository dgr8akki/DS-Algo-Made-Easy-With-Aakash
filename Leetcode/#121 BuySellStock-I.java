class Solution {
  public int maxProfit(int[] prices) {
    int T_i10 = 0, T_i11 = Integer.MIN_VALUE;

    for (int price : prices) {
      T_i10 = Math.max(T_i10, T_i11 + price);
      T_i11 = Math.max(T_i11, -price);
    }

    return T_i10;
  }
}

class Solution {
  public int maxProfit(int[] prices) {
    int globalMax = 0;
    int sum = 0;
    for (int i = 1; i < prices.length; i++) {
      sum += (prices[i] - prices[i - 1]);
      if (sum <= 0)
        sum = 0;
      globalMax = Math.max(sum, globalMax);
    }
    return globalMax;
  }
}
