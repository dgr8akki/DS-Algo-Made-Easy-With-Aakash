package Leetcode;

class Solution {
  public int numEquivDominoPairs(int[][] dominoes) {
    Map<Integer, Integer> count = new HashMap<>();
    int res = 0;
    for (int[] d : dominoes) {
      int k = Math.min(d[0], d[1]) * 10 + Math.max(d[0], d[1]);
      count.put(k, count.getOrDefault(k, 0) + 1);
    }
    for (int v : count.values())
      res += v * (v - 1) / 2;

    return res;
  }
}
