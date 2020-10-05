class Solution {

  Map<Integer, Integer> m = new HashMap<>();

  public int deepestLeavesSum(TreeNode root) {
    if (root == null)
      return 0;
    deepestLeavesSum(root, 0);

    int max = -1;
    for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
      max = entry.getKey() > max ? entry.getKey() : max;
    }

    return m.get(max);
  }

  public void deepestLeavesSum(TreeNode node, int level) {
    if (node.left == null && node.right == null) {
      m.put(level, m.getOrDefault(level, 0) + node.val);
      return;
    }

    if (node.left != null)
      deepestLeavesSum(node.left, level + 1);
    if (node.right != null)
      deepestLeavesSum(node.right, level + 1);
  }
}
