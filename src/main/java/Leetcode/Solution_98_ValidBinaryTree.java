package Leetcode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
  public boolean isValidBST(TreeNode root) {
    return isValidBSTUtil(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
  }

  public boolean isValidBSTUtil(TreeNode head, double min, double max) {
    if (head == null)
      return true;
    if (head.val <= min || head.val >= max)
      return false;
    return (isValidBSTUtil(head.left, min, head.val) && isValidBSTUtil(head.right, head.val, max));
  }
}
