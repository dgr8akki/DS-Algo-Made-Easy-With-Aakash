public class RemoveDuplicatesRecursively {
  /**
   * Given a string S, remove consecutive duplicates from it recursively.
   *
   * @param s
   * @return
   */

	public static String removeConsecutiveDuplicates(String s) {
		return removeConsecutiveDuplicates(s, "", 0, Character.MIN_VALUE);
	}
  	private static String removeConsecutiveDuplicates(String s, String res, int index, char lastCharacter) {
		if(index == s.length()) return res;
      	if(s.charAt(index) == lastCharacter) {
          return removeConsecutiveDuplicates(s, res, index + 1, lastCharacter);
        }
      	return removeConsecutiveDuplicates(s, res + s.charAt(index), index + 1, s.charAt(index));
	}
}
