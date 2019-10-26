package Leetcode;

import java.util.HashMap;

class Solution {
  public static boolean isIsomorphic(String s, String t) {
    HashMap map = new HashMap();
    if (s.length() != t.length()) {
      return false;
    }
    char[] ss = s.toCharArray();
    char[] tt = t.toCharArray();
    for (int i = 0; i < ss.length; i++) {
      if (!map.containsKey(ss[i])) {
        if (map.containsValue(tt[i])) {
          return false;
        }
        map.put(ss[i], tt[i]);
      } else {
        if (!map.get(ss[i]).equals(tt[i])) {
          return false;
        }
      }
    }
    return true;
  }
}
