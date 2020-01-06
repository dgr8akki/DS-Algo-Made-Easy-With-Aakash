package com.trijs.ch3;

public class Solution {
  int solve(int n, int a, int b) {
    if(n == 0) return a;
    return solve(n - 1, b, a + b);
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    for (int i = 0; i <= 5; i++)
      System.out.println(solution.solve(i, 0, 1));
  }
}
