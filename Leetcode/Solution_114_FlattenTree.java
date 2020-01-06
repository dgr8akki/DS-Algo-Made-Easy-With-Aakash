package Leetcode;

class Solution_114_FlattenTree {

  private TreeNode prev;

  public void flatten(TreeNode root) {
    if (root == null)
      return;
    prev = null;
    preorder(root);
  }

  private void preorder(TreeNode curr) {
    if (curr == null)
      return;

    if (prev != null) {
      prev.right = curr;
      prev.left = null;
    }

    prev = curr;
    TreeNode right = curr.right;
    preorder(curr.left);
    preorder(right);
  }
}
