package Leetcode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution_606_StringFromTree {
  public String tree2str(TreeNode root) {
    if (root == null)
      return "";
    StringBuilder sb = new StringBuilder();
    tree2str(root, sb);
    return sb.toString();
  }

  public void tree2str(TreeNode t, StringBuilder sb) {
    sb.append(t.val);
    if (t.left != null) {
      sb.append('(');
      tree2str(t.left, sb);
      sb.append(')');
    }
    if (t.right != null) {
      if (t.left == null) {
        sb.append("()");
      }
      sb.append('(');
      tree2str(t.right, sb);
      sb.append(')');
    }
  }
}
