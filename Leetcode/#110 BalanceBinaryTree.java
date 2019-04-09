/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
  public boolean isBalanced(TreeNode root) {
    if (root == null)
      return true;
    int left = root.left != null ? maxDepth(root.left) : 0;
    int right = root.right != null ? maxDepth(root.right) : 0;
    if (Math.abs(left - right) < 2)
      return isBalanced(root.left) && isBalanced(root.right);
    return false;
  }

  public int maxDepth(TreeNode root) {
    if (root == null)
      return 0;
    if (root.left == null && root.right == null)
      return 1;
    return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
  }
}
