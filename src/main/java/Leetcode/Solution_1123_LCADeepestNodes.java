package Leetcode;

class Solution {
  int deepest = 0;
  TreeNode lca;

  public TreeNode lcaDeepestLeaves(TreeNode root) {
    helper(root, 0);
    return lca;
  }

  private int helper(TreeNode node, int depth) {
    deepest = Math.max(deepest, depth);
    if (node == null) {
      return depth;
    }
    int left = helper(node.left, depth + 1);
    int right = helper(node.right, depth + 1);
    if (left == deepest && right == deepest)
      lca = node;
    return Math.max(left, right);
  }
}
