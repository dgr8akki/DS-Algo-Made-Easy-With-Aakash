package CodingNinjas.LanguageTools;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

class Main {

  static Map<String, Integer> map = new HashMap<>();

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    boolean containsDuplicate = false;
    String names = in.nextLine();
    for (String name : names.split(" "))
      if (map.containsKey(name))
        map.put(name, map.get(name) + 1);
      else
        map.put(name, 1);
    for (String name : map.keySet()) {
      int freq = map.get(name);
      if (freq > 1) {
        containsDuplicate = true;
        System.out.println(name + " " + freq);
      }
    }
    if (!containsDuplicate)
      System.out.println("-1");
  }
}
