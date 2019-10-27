package Leetcode;

public class Solution_623_AddRowToTree {
  public TreeNode addOneRow(TreeNode root, int v, int d) {
    if (d == 0 || d == 1) {
      TreeNode newroot = new TreeNode(v);
      newroot.left = d == 1 ? root : null;
      newroot.right = d == 0 ? root : null;
      return newroot;
    }
    if (root != null && d >= 2) {
      root.left = addOneRow(root.left, v, d > 2 ? d - 1 : 1);
      root.right = addOneRow(root.right, v, d > 2 ? d - 1 : 0);
    }
    return root;
  }
}
