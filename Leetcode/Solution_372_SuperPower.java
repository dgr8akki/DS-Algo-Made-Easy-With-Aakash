package Leetcode;

class Solution_372_SuperPower {
  int ans = 1;

  public int superPow(int a, int[] b) {
    int res = 1;
    for (int i = 0; i < b.length; i++) {
      res = pow(res, 10) * pow(a, b[i]) % 1337;
    }
    return res;
  }

  public int pow(int a, int b) {
    if (b == 0)
      return 1;
    if (b == 1)
      return a % 1337;
    return pow(a % 1337, b / 2) * pow(a % 1337, b - b / 2) % 1337;
  }
}
