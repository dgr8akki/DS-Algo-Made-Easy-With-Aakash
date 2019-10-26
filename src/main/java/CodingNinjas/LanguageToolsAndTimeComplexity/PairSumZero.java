package CodingNinjas.LanguageToolsAndTimeComplexity;

import java.util.HashMap;
import java.util.Map;

class Solution {
  public static void PairSum(int[] input, int size) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int element : input) {
      if (map.containsKey(element)) {
        map.put(element, map.get(element) + 1);
      } else {
        map.put(element, 1);
      }
    }

    for (int element : input) {
      // Check for its pair and get frequency
      int pairElement = -1 * element;
      if (map.containsKey(pairElement)) {
        int freq = map.get(pairElement);
        if (map.containsKey(element)) {
          freq *= map.get(element);
        }
        map.put(element, 0);
        map.put(pairElement, 0);
        while (freq-- > 0) {
          System.out
              .println(element < (-1 * element) ? element + " " + (-1 * element) : (-1 * element) + " " + element);
        }
      }
    }
  }
}
