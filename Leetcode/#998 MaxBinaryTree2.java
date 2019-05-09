class Solution {
  public TreeNode insertIntoMaxTree(TreeNode n, int v) {
    if (n == null)
      return new TreeNode(v);
    if (v > n.val) {
      TreeNode node = new TreeNode(v);
      node.left = n;
      return node;
    }
    n.right = insertIntoMaxTree(n.right, v);
    return n;
  }
}
