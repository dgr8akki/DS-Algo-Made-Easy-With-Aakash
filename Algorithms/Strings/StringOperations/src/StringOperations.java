import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class StringOperations {
  String reverse(String text) {
    StringBuilder reverseString = new StringBuilder();
    for(int index = text.length() - 1; index >= 0 ; index--)
      reverseString.append(text.charAt(index));
    return reverseString.toString();
  }

  List<String> getAllSuffix(String text) {
    List<String> suffixList = new ArrayList<>();
    for(int index = text.length() - 1; index >= 0 ; index--)
      suffixList.add(text.substring(index));
    return suffixList;
  }

  List<String> getAllPrefix(String text) {
    List<String> prefixList = new ArrayList<>();
    for(int index = 0; index <= text.length() ; index++)
      prefixList.add(text.substring(0, index));
    return prefixList;
  }

  String longestRepeatedSubstring(String text) {
    int lengthOfText = text.length();
    List<String> suffixList = getAllSuffix(text);
    Collections.sort(suffixList);
    String longestRepeatedSubstring = "";
    for(int index = 0; index < lengthOfText - 1; index++) {
      String temp = longestCommonPrefix(suffixList.get(index), suffixList.get(index + 1));
      longestRepeatedSubstring = longestRepeatedSubstring.length() > temp.length()
                                  ? longestRepeatedSubstring
                                  : temp;
    }
    return longestRepeatedSubstring;
  }

  String longestCommonPrefix(String first, String second) {
    int lengthOfSmallString = Math.min(first.length(), second.length());
    for(int index = 0; index < lengthOfSmallString; index++)
      if(first.charAt(index) != second.charAt(index))
        return first.substring(0, index);
    return second.substring(0, lengthOfSmallString);
  }
}
