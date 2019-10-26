package Leetcode;

class Solution {
  public TreeNode bstFromPreorder(int[] preorder) {
    return bstFromPreorderUtil(preorder, 0, preorder.length - 1);
  }

  private TreeNode bstFromPreorderUtil(int[] A, int start, int end) {
    if (start > end)
      return null;
    TreeNode root = new TreeNode(A[start]);
    if (start == end)
      return root;
    int index;
    for (index = start + 1; index <= end; index++)
      if (A[index] > root.val)
        break;

    root.left = bstFromPreorderUtil(A, start + 1, index - 1);
    root.left = bstFromPreorderUtil(A, index, end);
    return root;
  }
}
