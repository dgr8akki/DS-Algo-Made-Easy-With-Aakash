package Leetcode;

public class Solution {
  public List<List<Integer>> pathSum(TreeNode root, int sum) {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    dfs(root, sum, res, path);
    return res;
  }

  public void dfs(TreeNode root, int sum, List<List<Integer>> res, List<Integer> path) {
    if (root == null)
      return;
    path.add(root.val);

    if (root.left == null && root.right == null) {
      if (root.val == sum)
        res.add(new ArrayList<Integer>(path));
      return;
    }
    if (root.left != null) {
      dfs(root.left, sum - root.val, res, path);
      path.remove(path.size() - 1);
    }
    if (root.right != null) {
      dfs(root.right, sum - root.val, res, path);
      path.remove(path.size() - 1);
    }
  }
}
