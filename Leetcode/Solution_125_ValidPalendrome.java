package Leetcode;

class Solution_125_ValidPalendrome {
  public boolean isPalindrome(String s) {
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (Character.isLetter(c) || Character.isDigit(c))
        builder.append(Character.toLowerCase(c));
    }
    String temp = builder.toString();
    return builder.reverse().toString().equalsIgnoreCase(temp);
  }
}
