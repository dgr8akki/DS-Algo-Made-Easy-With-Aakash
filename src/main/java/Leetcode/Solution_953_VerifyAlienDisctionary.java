package Leetcode;

class Solution {
  public boolean isAlienSorted(String[] words, String order) {
    int[] actualOrder = new int[26];
    for (int i = 0; i < 26; i++)
      actualOrder[order.charAt(i) - 'a'] = i;
    for (int i = 1; i < words.length; i++) {
      if (compare(words[i - 1], words[i], actualOrder) > 0)
        return false;
    }
    return true;
  }

  public int compare(String s1, String s2, int[] mapping) {
    int n = s1.length(), m = s2.length(), cmp = 0;
    for (int i = 0, j = 0; i < n && j < m && cmp == 0; i++, j++) {
      cmp = mapping[s1.charAt(i) - 'a'] - mapping[s2.charAt(j) - 'a'];
    }
    return cmp == 0 ? n - m : cmp;
  }
}
