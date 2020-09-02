package com.trijs.ch6;

public class PowerSet {
  void generate(String s) {
    powerSet(s, 0, "");
  }

  private void powerSet(String givenString, int index, String currentString) {
    if (index == givenString.length()) {
      System.out.println("{" + currentString + "}");
      return;
    }
    powerSet(givenString, index + 1, currentString + givenString.charAt(index));
    powerSet(givenString, index + 1, currentString);
  }

  public static void main(String[] args) {
    PowerSet powerSet = new PowerSet();
    powerSet.generate("ABV");
  }
}
