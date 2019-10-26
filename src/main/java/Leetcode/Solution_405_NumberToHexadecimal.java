package Leetcode;

class Solution {
  public String toHex(int n) {
    char[] map = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
    if (n == 0)
      return "" + map[n];
    StringBuilder builder = new StringBuilder();
    while (n != 0) {
      builder.append(map[n & 15]);
      n = n >>> 4;
    }
    return builder.reverse().toString();

  }
}
