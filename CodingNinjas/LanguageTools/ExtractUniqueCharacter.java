import java.util.Set;
import java.util.HashSet;

class solution {

  public static String uniqueChar(String str) {
    StringBuilder builder = new StringBuilder();
    Set<Character> set = new HashSet<>();
    for (int i = 0; i < str.length(); i++) {
      char currentCharacter = str.charAt(i);
      if (!set.contains(currentCharacter)) {
        builder.append(currentCharacter);
        set.add(currentCharacter);
      }
    }

    return builder.toString();
  }
}
