package Leetcode;

class Solution_235_LCA {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null)
      return null;
    if (p.val > root.val && q.val > root.val)
      return lowestCommonAncestor(root.right, p, q);
    if (p.val < root.val && q.val < root.val)
      return lowestCommonAncestor(root.left, p, q);
    return root;
  }
}
