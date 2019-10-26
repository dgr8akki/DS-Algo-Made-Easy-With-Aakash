package Leetcode;

class Solution {

  Map<TreeNode, Integer> map = new HashMap<>();

  public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
    List<Integer> res = new LinkedList<>();
    find(root, target);
    dfs(root, target, K, map.get(root), res);
    return res;
  }

  private int find(TreeNode root, TreeNode target) {
    if (root == null)
      return -1;
    if (root == target) {
      map.put(root, 0);
      return 0;
    }
    int left = find(root.left, target);
    if (left >= 0) {
      map.put(root, left + 1);
      return left + 1;
    }
    int right = find(root.right, target);
    if (right >= 0) {
      map.put(root, right + 1);
      return right + 1;
    }
    return -1;
  }

  private void dfs(TreeNode root, TreeNode target, int K, int length, List<Integer> res) {
    if (root == null)
      return;
    if (map.containsKey(root))
      length = map.get(root);
    if (length == K)
      res.add(root.val);
    dfs(root.left, target, K, length + 1, res);
    dfs(root.right, target, K, length + 1, res);
  }
}
