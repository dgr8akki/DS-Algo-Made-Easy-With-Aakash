package Leetcode;

class Solution {
  public List<String> commonChars(String[] A) {
    List<String> list = new ArrayList<>();
    int[] min = new int[26];
    Arrays.fill(min, Integer.MAX_VALUE);

    for (String s : A) {
      int[] current = new int[26];
      for (int i = 0; i < s.length(); i++)
        current[s.charAt(i) - 'a']++;

      for (int i = 0; i < 26; i++)
        min[i] = Math.min(min[i], current[i]);
    }

    for (int i = 0; i < 26; i++)
      while (min[i]-- > 0)
        list.add("" + (char) (i + 'a'));

    return list;
  }
}
