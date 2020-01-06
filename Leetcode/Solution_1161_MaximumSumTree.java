package Leetcode;

class Solution_1161_MaximumSumTree {
  public int maxLevelSum(TreeNode root) {
    int level = 1, max = Integer.MIN_VALUE, maxLevel = 1;
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);
    while (!q.isEmpty()) {
      int sum = 0;
      for (int sz = q.size(); sz > 0; --sz) {
        TreeNode n = q.poll();
        sum += n.val;
        if (n.left != null)
          q.offer(n.left);

        if (n.right != null)
          q.offer(n.right);
      }
      if (max < sum) {
        max = sum;
        maxLevel = level;
      }
      ++level;
    }
    return maxLevel;
  }
}
