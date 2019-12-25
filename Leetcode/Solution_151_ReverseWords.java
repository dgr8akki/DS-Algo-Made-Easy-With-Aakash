package Leetcode;

class Solution_151_ReverseWords {
  public String reverseWords(String s) {
    String[] words = s.trim().split(" +");
    Collections.reverse(Arrays.asList(words));
    return String.join(" ", words);
  }
}
