class Solution {
  public List<String> binaryTreePaths(TreeNode root) {
    if (root == null) {
      return Collections.emptyList();
    }

    List<String> paths = new LinkedList<>();
    dfs(root, paths, "");
    return paths;
  }

  private void dfs(TreeNode root, List<String> paths, String path) {
    if (root == null)
      return;
    if (root.left == null && root.right == null) {
      path = path + root.val;
      paths.add(path);
      return;
    }
    dfs(root.left, paths, path + root.val + "->");
    dfs(root.right, paths, path + root.val + "->");
  }
}
