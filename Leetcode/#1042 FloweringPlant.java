class Solution {
  public int[] gardenNoAdj(int N, int[][] paths) {
    Map<Integer, Set<Integer>> G = new HashMap<>();
    for (int i = 0; i < N; i++)
      G.put(i, new HashSet<>());
    for (int[] p : paths) {
      G.get(p[0] - 1).add(p[1] - 1);
      G.get(p[1] - 1).add(p[0] - 1);
    }
    int[] res = new int[N];
    for (int i = 0; i < N; i++) {
      int[] colors = new int[5];
      for (int j : G.get(i))
        colors[res[j]] = 1;
      for (int c = 4; c > 0; --c)
        if (colors[c] == 0)
          res[i] = c;
    }
    return res;
  }
}
