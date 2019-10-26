package CodingNinjas.AdvanceRecurssion;

import java.util.ArrayList;
import java.util.List;

/**
 * StringPermutations
 */
public class StringPermutations {

  public static void printSubs(String s) {
    List<String> st = new ArrayList<>(2 * s.length());
    printSubs(s, "", st);
    for(String string: st)
      System.out.println(string);
  }
  private static void printSubs(String s, String res, List<String> resulList) {
    if(s.length() == res.length()) {
      resulList.add(res);
      return;
    }
    printSubs(s.substring(1), res + s.charAt(index), resulList);
    int size = resulList.size();
    for(int i = 0; i < size; i++)
      resulList.add(s.charAt(0) + resulList.get(i));
  }
  public static void main(String[] args) {
    printSubs("abc");
  }
}