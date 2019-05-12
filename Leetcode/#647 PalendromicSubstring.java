class Solution {
  public int countSubstrings(String text) {
    int len = text.length(), maxCount = 0;
    for (int i = 0; i < len; i++) {
      int left = i, right = i;
      while (left >= 0 && right < len && text.charAt(left) == text.charAt(right)) {
        left--;
        right++;
        maxCount++;
      }
      left = i;
      right = i + 1;
      while (left >= 0 && right < len && text.charAt(left) == text.charAt(right)) {
        left--;
        right++;
        maxCount++;
      }
    }
    return maxCount;
  }
}
