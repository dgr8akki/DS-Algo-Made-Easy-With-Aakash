package Leetcode;

class Solution {
  public int lengthOfLastWord(String s) {
    if (s == null && s.length() == 0)
      return 0;
    int n = s.length();
    int prevChars = 0;
    for (int i = n - 1; i >= 0; i--) {
      if (s.charAt(i) == ' ' && prevChars != 0)
        break;
      else if (s.charAt(i) != ' ')
        prevChars++;
    }
    return prevChars;
  }
}
