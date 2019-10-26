package Leetcode;

class Solution {
  public int sumRootToLeaf(TreeNode root) {
    if (root == null)
      return 0;
    return dfs(root, 0);
  }

  private int dfs(TreeNode root, int sum) {
    if (root == null)
      return 0;
    sum = (sum * 2) + root.val;
    if (root.left == null && root.right == null)
      return sum;
    return dfs(root.left, sum) + dfs(root.right, sum);
  }
}
