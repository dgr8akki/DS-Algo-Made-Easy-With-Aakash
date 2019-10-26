package Leetcode;

class Solution {
  int postOrderIndex;

  public TreeNode buildTree(int[] inorder, int[] postorder) {
    postOrderIndex = postorder.length - 1;
    return buildTree(inorder, postorder, 0, inorder.length - 1);
  }

  private TreeNode buildTree(int[] inorder, int[] postorder, int start, int end) {
    if (start > end) {
      return null;
    }
    int inorderIndex = this.getInorderIndex(inorder, start, end, postorder[postOrderIndex]);
    TreeNode root = new TreeNode(inorder[inorderIndex]);
    postOrderIndex--;
    root.right = buildTree(inorder, postorder, inorderIndex + 1, end);
    root.left = buildTree(inorder, postorder, start, inorderIndex - 1);
    return root;
  }

  private int getInorderIndex(int[] inorder, int start, int end, int target) {
    for (int i = start; i <= end; i++) {
      if (inorder[i] == target) {
        return i;
      }
    }
    return -1;
  }
}
