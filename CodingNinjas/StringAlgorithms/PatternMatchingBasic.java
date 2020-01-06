package CodingNinjas.StringAlgorithms;

/**
 * PatternMatchingBasic
 */
public class PatternMatchingBasic {
  public static void main(String[] args) {
    String text = "The quick brown fox jumps";
    String pattern = "T";
    System.out.println(patternMatching(text, pattern));
  }

  private static int patternMatching(String text, String pattern) {
    int textLen = text.length();
    int patLen = pattern.length();
    for (int i = 0; i < (textLen - patLen); i++) {
      int j = 0;
      for (; j < patLen; j++) {
        if (text.charAt(i + j) != pattern.charAt(j))
          break;
      }
      if (j == patLen)
        return i;
    }
    return -1;
  }
}
