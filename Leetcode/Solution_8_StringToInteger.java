package Leetcode;

public class Solution_8_StringToInteger {
  public int myAtoi(String str) {
    double result = 0;
    int boundry = 1;
    int count = 0;
    char[] charArr = str.toCharArray();
    for (char c : charArr) {
      count++;
      if (c >= '0' && c <= '9') {
        result *= 10;
        result += (c - '0');
      } else if (c == '-' && count == 1) {
        boundry = -1;
      } else if (c == '+' && count == 1) {
        boundry = 1;
      } else if (c == ' ' && count == 1) {
        count--;
      } else {
        break;
      }
    }
    if (result > Integer.MAX_VALUE) {
      if (boundry == 1)
        return Integer.MAX_VALUE;
      else
        return Integer.MIN_VALUE;
    } else {
      return (int) (result * boundry);
    }
  }
}
