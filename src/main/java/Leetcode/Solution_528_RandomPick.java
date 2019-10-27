package Leetcode;

import java.util.Random;
import java.util.TreeMap;

class Solution_528_RandomPick {
  private int cnt = 0;
  private final TreeMap<Integer, Integer> map = new TreeMap<>();
  private final Random rnd = new Random();

  public Solution_528_RandomPick(int[] w) {
    for (int idx = 0; idx < w.length; idx++) {
      cnt += w[idx];
      map.put(cnt, idx);
    }
  }

  public int pickIndex() {
    int key = map.higherKey(rnd.nextInt(cnt));
    return map.get(key);
  }
}
