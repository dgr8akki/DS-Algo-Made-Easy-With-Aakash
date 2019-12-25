package Leetcode;

class Solution_279_PerfectSquare {
  public int numSquares(int n) {
    int[] dp = new int[n + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;
    for (int currentNumber = 1; currentNumber <= n; currentNumber++) {
      int min = Integer.MAX_VALUE;
      int numberToBeChecked = 1;
      while (currentNumber - numberToBeChecked * numberToBeChecked >= 0) {
        min = Math.min(min, dp[currentNumber - numberToBeChecked * numberToBeChecked] + 1);
        numberToBeChecked++;
      }
      dp[currentNumber] = min;
    }
    return dp[n];
  }
}
