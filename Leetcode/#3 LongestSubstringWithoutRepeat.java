class Solution {
  public int lengthOfLongestSubstring(String s) {
    int i = 0, j = 0, max = 0;
    Set<Character> set = new HashSet<>();
    while (j < s.length()) {
      if (set.contains(s.charAt(j))) {
        set.remove(s.charAt(i++));

      } else {
        set.add(s.charAt(j++));
        max = Math.max(max, set.size());
      }
    }

    return max;
  }
}
