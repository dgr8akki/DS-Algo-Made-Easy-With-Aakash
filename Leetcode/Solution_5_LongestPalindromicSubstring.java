package Leetcode;

class Solution_5_LongestPalindromicSubstring {
  public String longestPalindrome(String s) {
    return lps(s);
  }

  private static String lps(String text) {
    int len = text.length(), maxCount = 0, idx = 0;
    for (int i = 0; i < len; i++) {
      int left = i, right = i;
      while (left >= 0 && right < len && text.charAt(left) == text.charAt(right)) {
        if (maxCount < right - left + 1) {
          maxCount = right - left + 1;
          idx = left;
        }
        maxCount = Math.max(maxCount, right - left + 1);

        left--;
        right++;
      }
      left = i;
      right = i + 1;
      while (left >= 0 && right < len && text.charAt(left) == text.charAt(right)) {
        if (maxCount < right - left + 1) {
          maxCount = right - left + 1;
          idx = left;
        }
        left--;
        right++;
      }
    }
    return text.substring(idx, idx + maxCount);
  }
}
