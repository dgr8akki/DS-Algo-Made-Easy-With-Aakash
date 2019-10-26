package Leetcode;

class Solution {
  public static int countCharacters(String[] words, String chars) {
    int count = 0;
    int[] seen = new int[26];
    for (char c : chars.toCharArray())
      seen[c - 'a']++;
    for (String word : words) {
      int[] tSeen = Arrays.copyOf(seen, seen.length);
      int Tcount = 0;
      for (char c : word.toCharArray()) {
        if (tSeen[c - 'a'] > 0) {
          tSeen[c - 'a']--;
          Tcount++;
        }
      }
      if (Tcount == word.length())
        count += Tcount;
    }
    return count;
  }
}
