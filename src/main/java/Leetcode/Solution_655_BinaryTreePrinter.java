package Leetcode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
  public List<List<String>> printTree(TreeNode root) {
    int height = height(root);
    int wide = wide(root);
    List<List<String>> result = new ArrayList<>();
    for (int i = 0; i < height; i++) {
      List<String> list = new ArrayList<>();
      for (int j = 0; j < wide; j++)
        list.add("");

      result.add(list);
    }
    print(result, root, 0, 0, wide - 1);
    return result;
  }

  private void print(List<List<String>> result, TreeNode root, int row, int left, int right) {
    if (root == null)
      return;
    int center = (left + right) / 2;
    result.get(row).set(center, String.valueOf(root.val));
    print(result, root.left, row + 1, left, center);
    print(result, root.right, row + 1, center + 1, right);
  }

  private int height(TreeNode node) {
    if (node == null)
      return 0;
    return 1 + Math.max(height(node.left), height(node.right));
  }

  private int wide(TreeNode node) {
    if (node == null)
      return 0;
    return 1 + 2 * Math.max(wide(node.left), wide(node.right));
  }
}
