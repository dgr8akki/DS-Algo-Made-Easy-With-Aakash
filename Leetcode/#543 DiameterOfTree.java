/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
  public int diameterOfBinaryTree(TreeNode root) {
    if (root == null)
      return 0;
    int option1 = height(root.left) + height(root.right);
    int option2 = diameterOfBinaryTree(root.left);
    int option3 = diameterOfBinaryTree(root.right);
    return Math.max(option1, Math.max(option2, option3));
  }

  private int height(TreeNode root) {
    if (root == null)
      return 0;
    return 1 + Math.max(height(root.left), height(root.right));
  }
}
