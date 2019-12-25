package CodingNinjas.StringAlgorithms;

/**
 * KMP
 */
public class KMP {

  public static void main(String[] args) {
    String text = "The quick brown fox jumps";
    String pattern = "quick";
    System.out.println(patternMatchingKMP(text, pattern));
  }

  private static int[] getLps(String text) {
    int len = text.length();
    int[] lps = new int[len];
    int i = 1, j = 0;
    while (i < len) {
      if (text.charAt(i) == text.charAt(j)) {
        lps[i] = j + 1;
        i++;
        j++;
      } else {
        if (j == 0) {
          lps[i] = 0;
          i++;
        } else {
          j = lps[j - 1];
        }
      }
    }
    return lps;
  }

  private static int patternMatchingKMP(String text, String pattern) {
    int textLen = text.length();
    int patLen = pattern.length();
    int i = 0, j = 0;
    int[] lps = getLps(pattern);
    while (i < textLen && j < patLen) {
      if (text.charAt(i) == pattern.charAt(j)) {
        i++;
        j++;
      } else {
        if (j == 0) {
          i++;
        } else {
          j = lps[j - 1];
        }
      }
    }
    if (j == patLen)
      return i - j;
    return -1;
  }
}
