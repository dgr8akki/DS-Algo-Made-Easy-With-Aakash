package Leetcode;

public class Solution {
  public List<Integer> lexicalOrder(int n) {
    List<Integer> res = new ArrayList<>();
    for (int i = 1; i < 10; i++)
      dfs(i, n, res);

    return res;
  }

  public void dfs(int current, int n, List<Integer> res) {
    if (current > n)
      return;
    else {
      res.add(current);
      for (int i = 0; i < 10; ++i) {
        if (10 * current + i > n)
          return;
        dfs(10 * current + i, n, res);
      }
    }
  }
}
