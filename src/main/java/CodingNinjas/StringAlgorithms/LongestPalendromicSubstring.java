package CodingNinjas.StringAlgorithms;

/**
 * LongestPalendromicSubstring
 */
public class LongestPalendromicSubstring {

  public static void main(String[] args) {
    String text = "ThehTababababababababbababababa";
    System.out.println(lps(text));
  }

  private static int lps(String text) {
    int len = text.length(), maxCount = 0;
    for (int i = 0; i < len; i++) {
      int left = i, right = i;
      while (left >= 0 && right < len && text.charAt(left) == text.charAt(right)) {
        maxCount = Math.max(maxCount, right - left + 1);
        left--;
        right++;
      }
      left = i;
      right = i + 1;
      while (left >= 0 && right < len && text.charAt(left) == text.charAt(right)) {
        maxCount = Math.max(maxCount, right - left + 1);
        left--;
        right++;
      }
    }
    return maxCount;
  }
}
