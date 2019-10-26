package Leetcode;

class Solution {
  public int countNumbersWithUniqueDigits(int n) {
    if (n == 0)
      return 1;
    if (n == 1)
      return 10;
    int res = 10;
    int nine = 9;
    int temp = 9;
    for (int i = 2; i <= n; i++) {
      temp = temp * nine--;
      res += temp;
    }
    return res;
  }
}
