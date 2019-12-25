package Leetcode;

import java.util.HashMap;
import java.util.Map;

class Solution_1_twoSum {
  public static int[] twoSum(int[] numbers, int target) {
    int[] result = new int[2];
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < numbers.length; i++) {
      if (map.containsKey(target - numbers[i])) {
        result[1] = i;
        result[0] = map.get(target - numbers[i]) - 1;
        return result;
      }
      map.put(numbers[i], i + 1);
    }
    return result;
  }
}
