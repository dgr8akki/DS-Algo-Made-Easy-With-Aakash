package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution_113_PathSum2 {
  public static void dfs(TreeNode root, int sum, List<List<Integer>> res, List<Integer> path) {
    if (root == null) {
      return;
    }
    path.add(root.val);

    if (root.left == null && root.right == null) {
      if (root.val == sum) {
        res.add(new ArrayList<>(path));
      }
      return;
    }
    if (root.left != null) {
      Solution_113_PathSum2.dfs(root.left, sum - root.val, res, path);
      path.remove(path.size() - 1);
    }
    if (root.right != null) {
      Solution_113_PathSum2.dfs(root.right, sum - root.val, res, path);
      path.remove(path.size() - 1);
    }
  }

  public static List<List<Integer>> pathSum(TreeNode root, int sum) {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    Solution_113_PathSum2.dfs(root, sum, res, path);
    return res;
  }
}
