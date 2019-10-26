package Leetcode;

class Solution {
  public int climbStairs(int n) {
    if (n == 0 || n == 1)
      return 1;
    int lastSecond = 1, last = 1, current = 0;
    for (int i = 2; i <= n; i++) {
      current = lastSecond + last;
      lastSecond = last;
      last = current;
    }
    return current;
  }
}
