class Solution {
  public int kthSmallest(TreeNode root, int k) {
    int leftNodesCount = countNodes(root.left);
    if (k <= leftNodesCount)
      return kthSmallest(root.left, k);
    if (k > leftNodesCount + 1)
      return kthSmallest(root.right, k - 1 - leftNodesCount);
    return root.val;
  }

  public int countNodes(TreeNode n) {
    if (n == null)
      return 0;
    return 1 + countNodes(n.left) + countNodes(n.right);
  }
}
