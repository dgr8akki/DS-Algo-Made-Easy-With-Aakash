package Leetcode;

class Solution {
  public String countAndSay(int n) {
    StringBuilder s = new StringBuilder("1");
    for (int i = 0; i < n - 1; ++i) {
      StringBuilder sb = new StringBuilder();
      int count = 1;
      char c = s.charAt(0);
      s.append("a");
      for (int j = 1; j < s.length(); ++j) {
        if (s.charAt(j) == c) {
          count++;
        } else {
          sb.append("" + count + c);
          count = 1;
          c = s.charAt(j);
        }
      }
      s = sb;
    }
    return s.toString();
  }
}
