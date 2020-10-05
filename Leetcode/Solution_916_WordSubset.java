package Leetcode;

import java.util.ArrayList;
import java.util.List;

class Solution_916_WordSubset {
  private static int[] counter(String word) {
    int[] count = new int[26];
    for (char c : word.toCharArray())
      count[c - 'a']++;

    return count;
  }

  public static List<String> wordSubsets(String[] A, String[] B) {
    int[] uni = new int[26];
    int[] tmp;
    int i;
    for (String b : B) {
      tmp = Solution_916_WordSubset.counter(b);
      for (i = 0; i < 26; ++i) {
        uni[i] = Math.max(uni[i], tmp[i]);
      }
    }
    List<String> res = new ArrayList<>();
    for (String a : A) {
      tmp = Solution_916_WordSubset.counter(a);
      for (i = 0; i < 26; ++i) {
        if (tmp[i] < uni[i]) {
          break;
        }
      }
      if (i == 26) {
        res.add(a);
      }
    }
    return res;
  }
}
