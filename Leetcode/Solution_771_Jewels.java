package Leetcode;

import java.util.Arrays;

class Solution_771_Jewels {
  public int numJewelsInStones(String J, String S) {
    if (S == null || J == null || S.length() == 0 || J.length() == 0)
      return 0;
    Map<Character, Integer> map = new HashMap<>();
    for (char s : S.toCharArray()) {
      map.put(s, map.getOrDefault(s, 0) + 1);
    }
    int count = 0;
    for (char j : J.toCharArray()) {
      count += map.getOrDefault(j, 0);
    }
    return count;
  }
}
