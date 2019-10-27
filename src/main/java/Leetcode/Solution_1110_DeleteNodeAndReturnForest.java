package Leetcode;

class Solution_1110_DeleteNodeAndReturnForest {
  Set<Integer> toDeleteSet;
  List<TreeNode> res = new ArrayList<>();

  public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
    res = new ArrayList<>();
    toDeleteSet = new HashSet<>();
    for (int i : to_delete)
      toDeleteSet.add(i);
    helper(root, true);
    return res;
  }

  private TreeNode helper(TreeNode node, boolean is_root) {
    if (node == null)
      return null;
    boolean deleted = toDeleteSet.contains(node.val);
    if (is_root && !deleted)
      res.add(node);
    node.left = helper(node.left, deleted);
    node.right = helper(node.right, deleted);
    return deleted ? null : node;
  }
}
