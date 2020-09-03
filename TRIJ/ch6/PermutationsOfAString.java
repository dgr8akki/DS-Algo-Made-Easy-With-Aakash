package com.trijs.ch6;

public class PermutationsOfAString {
  private int list(String prefix, String s, int count) {
    if (s.length() == 0) {
      System.out.println(prefix);
      return count + 1;
    }
    for (int i = 0; i < s.length(); i++) {
      char currentCharacter = s.charAt(i);
      String remainingString = s.substring(0, i) + s.substring(i + 1);
      count = list(prefix + currentCharacter, remainingString, count);
    }
    return count;
  }

  private void permuteList(String s) {
    int count = 0;
    count = list("", s, count);
    System.out.println("Total permutations are : " + count);
  }

  public static void main(String[] args) {
    PermutationsOfAString permutationsOfAString = new PermutationsOfAString();
    permutationsOfAString.permuteList("ABCD");
  }
}
