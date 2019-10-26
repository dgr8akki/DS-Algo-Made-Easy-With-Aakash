package Leetcode;

class Solution {
  public int longestPalindrome(String s) {
    int[] chars = new int[256];
    for (char c : s.toCharArray()) {
      chars[c]++;
    }

    int countOdd = 0;
    for (int i = 0; i < 256; i++) {
      if (chars[i] % 2 != 0)
        countOdd++;
    }

    return countOdd > 0 ? s.length() - countOdd + 1 : s.length();
  }
}
