package Leetcode;

class Solution_437_PathSumThree {
  public int pathSum(TreeNode root, int sum) {
    if (root == null)
      return 0;
    return dfs(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
  }

  public int dfs(TreeNode root, int sum) {
    if (root == null)
      return 0;

    int temp = root.val == sum ? 1 : 0;
    int left = dfs(root.left, sum - root.val);
    int right = dfs(root.right, sum - root.val);

    return temp + left + right;
  }
}
