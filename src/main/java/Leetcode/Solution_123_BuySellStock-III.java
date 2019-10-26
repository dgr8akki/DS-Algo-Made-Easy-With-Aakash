package Leetcode;

public class Solution {
  public int maxProfit(int[] prices) {
    int hold1 = Integer.MIN_VALUE, hold2 = Integer.MIN_VALUE;
    int release1 = 0, release2 = 0;
    for (int i : prices) {
      release2 = Math.max(release2, hold2 + i);
      hold2 = Math.max(hold2, release1 - i);
      release1 = Math.max(release1, hold1 + i);
      hold1 = Math.max(hold1, -i);
    }
    return release2;
  }
}
