class Solution {
  int cnt = 0;
  TreeMap<Integer, Integer> map = new TreeMap<>();
  Random rnd = new Random();

  public Solution(int[] w) {
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
