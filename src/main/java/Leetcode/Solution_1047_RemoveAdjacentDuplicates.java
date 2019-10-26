package Leetcode;

class Solution {
  public String removeDuplicates(String S) {
    StringBuilder builder = new StringBuilder();
    for (char c : S.toCharArray()) {
      int size = builder.length();
      if (size > 0 && builder.charAt(size - 1) == c)
        builder.deleteCharAt(size - 1);
      else
        builder.append(c);
    }
    return builder.toString();
  }
}
