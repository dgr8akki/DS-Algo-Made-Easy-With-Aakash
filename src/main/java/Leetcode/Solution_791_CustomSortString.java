package Leetcode;

class Solution {
  public String customSortString(String S, String T) {
    int[] tt = new int[26];
    for (int i = 0; i < T.length(); i++) {
      char c = T.charAt(i);
      tt[c - 'a']++;
    }

    StringBuilder ans = new StringBuilder();
    for (char s : S.toCharArray()) {
      while (tt[s - 'a'] != 0) {
        ans.append(s);
        tt[s - 'a']--;
      }
    }
    for (int i = 0; i < 26; i++) {
      while (tt[i] != 0) {
        ans.append((char) (i + 'a'));
        tt[i]--;
      }
    }
    return ans.toString();

  }
}
