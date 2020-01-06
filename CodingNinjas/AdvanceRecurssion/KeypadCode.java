package CodingNinjas.AdvanceRecurssion;

import java.util.List;
import java.util.ArrayList;

public class KeypadCode {

  // Return a string array that contains all the possible strings
  public static String[] keypad(int n) {
    String[] map = new String[10];
    List<String> result = new ArrayList<String>();

    map[0] = "";
    map[1] = "";
    map[2] = "abc";
    map[3] = "def";
    map[4] = "ghi";
    map[5] = "jkl";
    map[6] = "mno";
    map[7] = "pqrs";
    map[8] = "tuv";
    map[9] = "wxyz";

    keypad(n, map, result);

    return result.toArray(new String[0]);
  }

  private static void keypad(int n, String[] map, List<String> result) {
    if(n == 0 || n == 1) {
      result.add(0, "");
      return;
    }
    keypad(n / 10, map, result);
    String currentButton = map[n % 10];
    int size = result.size();
    for(int i = 0; i < size; i++) {
      String temp = result.remove(0);
      for(int j = 0; j < currentButton.length(); j++) {
        result.add(temp + currentButton.charAt(j));
      }
    }
  }

  public static void main(String[] args) {
    String[] ar = keypad(200);
    for(String s: ar) {
      System.out.println(s);
    }
  }
}
