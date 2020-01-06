package Leetcode;

class Solution_7_ReverseInteger {
  public int reverse(int x) {
    if (x <= Integer.MIN_VALUE)
      return 0;
    if (x < 0)
      return -1 * reverse(-1 * x);
    int temp = x;
    int digits = 0;
    while (temp > 0) {
      temp /= 10;
      digits++;
    }

    if (Long.parseLong(new StringBuilder(Integer.toString(x)).reverse().toString()) > Integer.MAX_VALUE)
      return 0;

    int number = 0;
    for (int i = 0; x > 0; i++) {
      number += ((x % 10) * (int) Math.pow(10, --digits));
      x = x / 10;
      System.out.println(number + " , " + x);
    }

    return number;
  }
}
