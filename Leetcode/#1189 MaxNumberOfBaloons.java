class Solution {
  public int maxNumberOfBalloons(String text) {
    int[] chars = new int[26];
    for (char c : text.toCharArray())
      chars[c - 'a']++;

    int min = chars[1];
    min = Math.min(min, chars[0]);
    min = Math.min(min, chars[11] / 2);
    min = Math.min(min, chars[14] / 2);
    min = Math.min(min, chars[13]);
    return min;
  }
}
