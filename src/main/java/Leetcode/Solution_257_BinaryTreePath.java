package Leetcode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class Solution_257_BinaryTreePath {
  private static void dfs(TreeNode root, List<String> paths, String path) {
    if (root == null) {
      return;
    }
    if (root.left == null && root.right == null) {
      path = path + root.val;
      paths.add(path);
      return;
    }
    Solution_257_BinaryTreePath.dfs(root.left, paths, path + root.val + "->");
    Solution_257_BinaryTreePath.dfs(root.right, paths, path + root.val + "->");
  }

  public static List<String> binaryTreePaths(TreeNode root) {
    if (root == null) {
      return Collections.emptyList();
    }

    List<String> paths = new LinkedList<>();
    Solution_257_BinaryTreePath.dfs(root, paths, "");
    return paths;
  }
}
