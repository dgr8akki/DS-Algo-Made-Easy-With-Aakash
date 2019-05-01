class Solution {
  private int depthX;
  private int depthY;
  private TreeNode parentX;
  private TreeNode parentY;
  public boolean isCousins(TreeNode root, int x, int y) {
      dfs(root, x, y, 0, null);
      return depthX == depthY && parentX != parentY;
  }
  
  private void dfs(TreeNode root, int x, int y, int depth, TreeNode parent)  {
      if (root == null) {
          return;
      }
      if (root.val == x) {
          depthX = depth;
          parentX = parent;
      } else if (root.val == y) {
          depthY =depth;
          parentY = parent;
      }
      dfs(root.left, x, y, depth+1, root);
      dfs(root.right, x, y, depth + 1, root);
  }
}
