package Leetcode;

public class Solution_553_OptimalDivision {
  public String optimalDivision(int[] nums) {
    int n = nums.length;
    String expr = "";
    for (int i = 0; i < n; i++) {
      if (i > 0) {
        expr += "/";
      }
      if (i == 1 && n > 2) {
        expr += "(";
      }
      expr += nums[i];
      if (i == n - 1 && n > 2) {
        expr += ")";
      }
    }
    return expr;
  }
}
