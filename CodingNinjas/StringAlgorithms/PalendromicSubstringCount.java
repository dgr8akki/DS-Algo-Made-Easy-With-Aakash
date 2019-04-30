/**
 * PalendromicSubstringCount
 */
public class PalendromicSubstringCount {

  public static int countPalindromeSubstrings(String text) {
    int len = text.length(), maxCount = 0, count = 0;
    for (int i = 0; i < len; i++) {
      int left = i, right = i;
      while (left >= 0 && right < len && text.charAt(left) == text.charAt(right)) {
        maxCount = Math.max(maxCount, right - left + 1);
        left--;
        right++;
        count++;
      }
      left = i;
      right = i + 1;
      while (left >= 0 && right < len && text.charAt(left) == text.charAt(right)) {
        maxCount = Math.max(maxCount, right - left + 1);
        left--;
        right++;
        count++;
      }
    }
    return count;
  }

  public static void main(String[] args) {
    String text = "ThehTababababababababbababababa";
    System.out.println(countPalindromeSubstrings(text));
  }
}
