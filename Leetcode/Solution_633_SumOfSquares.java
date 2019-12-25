package Leetcode;

public class Solution_633_SumOfSquares {
  public boolean judgeSquareSum(int c) {
    if (c < 0)
      return false;

    int left = 0, right = (int) Math.sqrt(c);
    while (left <= right) {
      int cur = left * left + right * right;
      if (cur < c)
        left++;
      else if (cur > c)
        right--;
      else
        return true;

    }
    return false;
  }
}
