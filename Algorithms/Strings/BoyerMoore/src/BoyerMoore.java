import java.util.HashMap;
import java.util.Map;

class BoyerMoore {
  private final int TEXT_SIZE, PATTERN_SIZE;
  private String text;
  private String pattern;
  private Map<Character, Integer> mismatchShiftTable;

  BoyerMoore(String text, String pattern) {
    this.text = text;
    this.pattern = pattern;
    this.mismatchShiftTable = new HashMap<>();
    TEXT_SIZE = text.length();
    PATTERN_SIZE = pattern.length();
    for (int i = 0; i < PATTERN_SIZE; i++)
      this.mismatchShiftTable.put(pattern.charAt(i), Math.max(1, PATTERN_SIZE - i - 1));
  }

  int search() {
    int numberOfSkips;
    for (int textIndex = 0; textIndex < TEXT_SIZE; textIndex += numberOfSkips) {
      numberOfSkips = 0;
      for (int patternIndex = PATTERN_SIZE - 1; patternIndex >= 0; patternIndex--) {
        char textCurrentCharacter = text.charAt(textIndex + patternIndex);
        if (pattern.charAt(patternIndex) != textCurrentCharacter) {
          numberOfSkips = this.mismatchShiftTable.containsKey(textCurrentCharacter)
            ? mismatchShiftTable.get(textCurrentCharacter)
            : PATTERN_SIZE;
          break;
        }
      }
      if (numberOfSkips == 0) return textIndex;
    }
    return -1;
  }
}
