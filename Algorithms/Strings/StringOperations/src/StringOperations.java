import java.util.ArrayList;
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
}
