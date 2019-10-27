package Leetcode;

class Solution_508_MostFrequentSubtreeSum {
  Map<Integer, Integer> count = new HashMap<Integer, Integer>();
  int maxCount = 0;

  public int[] findFrequentTreeSum(TreeNode root) {
    dfs(root);
    List<Integer> res = new ArrayList<>();
    for (int s : count.keySet()) {
      if (count.get(s) == maxCount)
        res.add(s);
    }
    return res.stream().mapToInt(i -> i).toArray();
  }

  private int dfs(TreeNode root) {
    if (root == null)
      return 0;
    int s = dfs(root.left) + dfs(root.right) + root.val;
    count.put(s, count.getOrDefault(s, 0) + 1);
    maxCount = Math.max(maxCount, count.get(s));
    return s;
  }
}
