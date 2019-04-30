import java.util.Arrays;

/**
 * LongestPrefixSuffix
 */
public class LongestPrefixSuffix {
  public static void main(String[] args) {
    String text = "ababdbabdbababdbadbdbdbadbadbadbabdbadbabd";
    int[] lps = getLps(text);
    System.out.println(Arrays.toString(lps));
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
}
