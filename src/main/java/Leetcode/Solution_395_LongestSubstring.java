package Leetcode;

class Solution {
  public int longestSubstring(String s, int k) {
    int d = 0;

    for (int numUniqueTarget = 1; numUniqueTarget <= 26; numUniqueTarget++)
      d = Math.max(d, longestSubstringWithNUniqueChars(s, k, numUniqueTarget));

    return d;
  }

  private int longestSubstringWithNUniqueChars(String s, int k, int numUniqueTarget) {
    int[] map = new int[128];
    int numUnique = 0; // counter 1
    int numNoLessThanK = 0; // counter 2
    int begin = 0, end = 0;
    int d = 0;

    while (end < s.length()) {
      if (map[s.charAt(end)]++ == 0)
        numUnique++; // increment map[c] after this statement
      if (map[s.charAt(end++)] == k)
        numNoLessThanK++; // inc end after this statement

      while (numUnique > numUniqueTarget) {
        if (map[s.charAt(begin)]-- == k)
          numNoLessThanK--; // decrement map[c] after this statement
        if (map[s.charAt(begin++)] == 0)
          numUnique--; // inc begin after this statement
      }

      // if we found a string where the number of unique chars equals our target
      // and all those chars are repeated at least K times then update max
      if (numUnique == numUniqueTarget && numUnique == numNoLessThanK)
        d = Math.max(end - begin, d);
    }

    return d;
  }
}
