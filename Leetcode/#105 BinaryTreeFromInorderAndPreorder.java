class Solution {
  int pStart = 0;

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0)
      return null;
    Map<Integer, Integer> indexes = new HashMap();
    for (int i = 0; i < inorder.length; i++) {
      indexes.put(inorder[i], i);
    }
    return helper(preorder, inorder, 0, preorder.length - 1, indexes);
  }

  private TreeNode helper(int[] preorder, int[] inorder, int pstart, int pend, Map<Integer, Integer> indexes) {
    if (pstart > pend || pStart >= preorder.length)
      return null;
    int idx = indexes.get(preorder[pStart]);
    TreeNode root = new TreeNode(preorder[pStart]);
    pStart++;
    root.left = helper(preorder, inorder, pstart, idx - 1, indexes);
    root.right = helper(preorder, inorder, idx + 1, pend, indexes);
    return root;
  }
}
