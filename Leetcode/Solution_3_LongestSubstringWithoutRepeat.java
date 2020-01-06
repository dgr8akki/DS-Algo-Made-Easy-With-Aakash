package Leetcode;

import java.util.HashSet;
import java.util.Set;

class Solution_3_LongestSubstringWithoutRepeat {
  public static int lengthOfLongestSubstring(String s) {
    int leftRunner = 0, rightRunner = 0, max = 0;
    Set<Character> set = new HashSet<>();
    while (rightRunner < s.length()) {
      if (set.contains(s.charAt(rightRunner))) {
        set.remove(s.charAt(leftRunner++));
      } else {
        set.add(s.charAt(rightRunner++));
        max = Math.max(max, set.size());
      }
    }
    return max;
  }
}
