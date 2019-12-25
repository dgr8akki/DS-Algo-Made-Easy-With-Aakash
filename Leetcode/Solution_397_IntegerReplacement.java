package Leetcode;

class Solution_397_IntegerReplacement {
  public int min = Integer.MAX_VALUE;

  public int integerReplacement(int n) {
    if (n < 1)
      return -1;

    helper(n, 0);
    return min;
  }

  public void helper(long n, int count) {
    if (n < 1)
      return;
    if (n == 1) {
      min = Math.min(min, count);
      return;
    }
    if (n % 2 == 0)
      helper(n / 2, count + 1);
    else {
      helper(n + 1, count + 1);
      helper(n - 1, count + 1);
    }
  }
}
