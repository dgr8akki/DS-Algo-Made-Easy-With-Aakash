class Solution {
  public String smallestFromLeaf(TreeNode root) {
    return dfs(root, "");
  }

  public String dfs(TreeNode node, String suffix) {
    if (null == node) {
      return suffix;
    }
    suffix = "" + (char) ('a' + node.val) + suffix;
    if (null == node.left && null == node.right) {
      return suffix;
    }
    if (null == node.left || null == node.right) {
      return (null == node.left) ? dfs(node.right, suffix) : dfs(node.left, suffix);
    }

    String left = dfs(node.left, suffix);
    String right = dfs(node.right, suffix);

    return left.compareTo(right) <= 0 ? left : right;
  }
}
