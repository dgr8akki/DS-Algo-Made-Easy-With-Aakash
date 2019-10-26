package Leetcode;

class Solution {
  public String convertToTitle(int n) {
    StringBuilder builder = new StringBuilder();
    while (n > 0) {
      n--;
      builder.insert(0, (char) ('A' + n % 26));
      n /= 26;
    }
    return builder.toString();
  }

  public int titleToNumber(String s) {
    int result = 0;
    for (int i = 0; i < s.length(); i++) {
      result *= 26;
      result += (s.charAt(i) - 'A' + 1);
    }
    return result;
  }
}
