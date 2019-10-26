package Leetcode;

class Solution {
  public int diameterOfBinaryTree(TreeNode root) {
    if (root == null)
      return 0;
    int diameterFromRoot = height(root.left) + height(root.right);
    int leftDiameter = diameterOfBinaryTree(root.left);
    int rightDiameter = diameterOfBinaryTree(root.right);
    return Math.max(diameterFromRoot, Math.max(leftDiameter, rightDiameter));
  }

  private int height(TreeNode root) {
    if (root == null)
      return 0;
    return 1 + Math.max(height(root.left), height(root.right));
  }
}
