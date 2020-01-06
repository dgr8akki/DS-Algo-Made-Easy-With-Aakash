package Leetcode;

class Solution_139_WordBreak {
  public boolean wordBreak(String s, List<String> words) {
    return wordBreak(s, 0, words, new HashSet<>());
  }

  private boolean wordBreak(String s, int t, List<String> words, Set<Integer> cache) {
    if (t == s.length()) {
      return true;
    }

    if (cache.contains(t)) {
      return false;
    }

    for (String w : words) {
      if (s.startsWith(w, t)) {
        if (wordBreak(s, t + w.length(), words, cache)) {
          return true;
        } else {
          cache.add(t + w.length());
        }
      }
    }

    return false;
  }
}
