package com.trijs.ch6;

import java.util.HashMap;
import java.util.Map;

public class TelephoneToWords {
  void generate(String number) {
    if (number.length() == 0)
      return;

    Map<Character, char[]> map = new HashMap<>();
    map.put('2', new char[] { 'a', 'b', 'c' });
    map.put('3', new char[] { 'd', 'e', 'f' });
    map.put('4', new char[] { 'g', 'h', 'i' });
    map.put('5', new char[] { 'j', 'k', 'l' });
    map.put('6', new char[] { 'm', 'n', 'o' });
    map.put('7', new char[] { 'p', 's', 'r' });
    map.put('8', new char[] { 'v', 't', 'u' });
    map.put('9', new char[] { 'y', 'w', 'x' });
    generate(number, 0, "", map);
  }

  private void generate(String number, int index, String current, Map<Character, char[]> map) {
    if (index == number.length()) {
      System.out.println(current);
      return;
    }

    if (number.charAt(index) == '1' || number.charAt(index) == '0')
      return;

    for (char currentChar : map.get(number.charAt(index)))
      generate(number, index + 1, current + currentChar, map);
  }

  public static void main(String[] args) {
    TelephoneToWords telephoneToWords = new TelephoneToWords();
    telephoneToWords.generate("799592434");
  }
}
