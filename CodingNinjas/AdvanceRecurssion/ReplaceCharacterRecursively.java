package CodingNinjas.AdvanceRecurssion;

public class ReplaceCharacterRecursively {

  /**
   * Given an input string S and two characters c1 and c2, you need to replace every occurrence of character c1 with character c2 in the given string.
   * @param input
   * @param c1
   * @param c2
   * @return
   */

	public static String replaceCharacter(String input, char c1, char c2) {
		return replaceCharacter(input, 0, c1, c2, "");
	}
  	private static String replaceCharacter(String input, int index, char c1, char c2, String res) {
		if(index == input.length())
          return res;
      	if(input.charAt(index) == c1)
          return replaceCharacter(input, index + 1, c1, c2, res + c2);
      	return replaceCharacter(input, index + 1, c1, c2, res + input.charAt(index));
	}
}
