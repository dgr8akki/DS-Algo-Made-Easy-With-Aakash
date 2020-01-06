package Leetcode;

class Solution_781_RabbitsInForest {
  public int numRabbits(int[] answers) {
    Map<Integer, Integer> m = new HashMap<>();
    for (int i : answers)
      m.put(i, m.getOrDefault(i, 0) + 1);
    int res = 0;
    for (int i : m.keySet())
      res += (m.get(i) + i) / (i + 1) * (i + 1);
    return res;
  }
}
