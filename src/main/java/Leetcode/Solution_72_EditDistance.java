package Leetcode;

class Solution {
  public int minDistance(String word1, String word2) {
    int l1 = word1.length(), l2 = word2.length();

    if (l1 == 0) {
      return l2;
    }

    if (l2 == 0) {
      return l1;
    }

    return memoize(word1, word2, l1 - 1, l2 - 1, new HashMap<String, Integer>());
  }

  public int memoize(String w1, String w2, int i, int j, HashMap<String, Integer> map) {
    String key = i + ":" + j;
    if (map.containsKey(key)) {
      return map.get(key);
    }

    if (i == -1)
      return j + 1;
    if (j == -1)
      return i + 1;

    int res;

    if (w1.charAt(i) == w2.charAt(j)) {
      res = memoize(w1, w2, i - 1, j - 1, map);
    } else {
      res = min(memoize(w1, w2, i, j - 1, map), // Add
          memoize(w1, w2, i - 1, j, map), // Remove
          memoize(w1, w2, i - 1, j - 1, map) // Replace
      ) + 1;
    }

    map.put(key, res);

    return res;
  }

  public int min(int a, int b, int c) {
    return a >= b ? (b >= c ? c : b) : (a >= c ? c : a);
  }
}
