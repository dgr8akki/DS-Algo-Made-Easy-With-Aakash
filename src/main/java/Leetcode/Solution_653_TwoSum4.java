package Leetcode;

class Solution {
  public boolean findTarget(TreeNode root, int k) {
    return dfs(root, root, k);
  }

  public boolean dfs(TreeNode root, TreeNode current, int targetValue) {
    if (current == null)
      return false;
    return search(root, current, targetValue - current.val) || dfs(root, current.left, targetValue)
        || dfs(root, current.right, targetValue);
  }

  public boolean search(TreeNode root, TreeNode current, int targetValue) {
    if (root == null)
      return false;
    return (root.val == targetValue) && (root != current)
        || (root.val < targetValue) && search(root.right, current, targetValue)
        || (root.val > targetValue) && search(root.left, current, targetValue);
  }
}
