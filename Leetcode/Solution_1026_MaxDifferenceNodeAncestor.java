package Leetcode;

class Solution_1026_MaxDifferenceNodeAncestor {
  public int maxAncestorDiff(TreeNode root) {
    return dfs(root, root.val, root.val);
  }

  public int dfs(TreeNode root, int mn, int mx) {
    if (root == null)
      return mx - mn;
    mx = Math.max(mx, root.val);
    mn = Math.min(mn, root.val);
    return Math.max(dfs(root.left, mn, mx), dfs(root.right, mn, mx));
  }
}
