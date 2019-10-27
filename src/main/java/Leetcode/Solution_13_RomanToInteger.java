package Leetcode;

class Solution_13_RomanToInteger {
  public int romanToInt(String s) {
    int count = 0;

    Map<String, Integer> map = new HashMap<>();
    map.put("I", 1);
    map.put("V", 5);
    map.put("X", 10);
    map.put("L", 50);
    map.put("C", 100);
    map.put("D", 500);
    map.put("M", 1000);

    char[] sol = s.toCharArray();
    for (int i = 0; i < sol.length - 1; i++) {
      int current = map.get(String.valueOf(sol[i]));
      int next = map.get(String.valueOf(sol[i + 1]));
      if (current < next)
        count -= current;
      else
        count += current;
    }

    int current = map.get(String.valueOf(sol[sol.length - 1]));
    count += current;
    return count;
  }
}
