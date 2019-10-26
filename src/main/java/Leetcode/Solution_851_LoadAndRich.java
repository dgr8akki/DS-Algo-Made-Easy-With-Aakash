package Leetcode;

class Solution {
  HashMap<Integer, List<Integer>> richer2 = new HashMap<>();
  int res[];

  public int[] loudAndRich(int[][] richer, int[] quiet) {
    int n = quiet.length;
    for (int i = 0; i < n; ++i)
      richer2.put(i, new ArrayList<Integer>());
    for (int[] v : richer)
      richer2.get(v[1]).add(v[0]);
    res = new int[n];
    Arrays.fill(res, -1);
    for (int i = 0; i < n; i++)
      dfs(i, quiet);
    return res;
  }

  int dfs(int i, int[] quiet) {
    if (res[i] >= 0)
      return res[i];
    res[i] = i;
    for (int j : richer2.get(i))
      if (quiet[res[i]] > quiet[dfs(j, quiet)])
        res[i] = res[j];
    return res[i];
  }
}
