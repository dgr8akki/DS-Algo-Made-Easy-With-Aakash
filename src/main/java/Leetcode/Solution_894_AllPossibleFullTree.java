package Leetcode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
  public List<TreeNode> allPossibleFBT(int k) {
    List<TreeNode> list = new ArrayList<>();
    if (k % 2 == 0)
      return list;
    if (k == 1) {
      list.add(new TreeNode(0));
      return list;
    }
    for (int i = 1; i < k; i += 2) {
      List<TreeNode> leftList = allPossibleFBT(i);
      List<TreeNode> rightList = allPossibleFBT(k - 1 - i);
      for (TreeNode l : leftList)
        for (TreeNode r : rightList) {
          TreeNode n = new TreeNode(0);
          n.left = l;
          n.right = r;
          list.add(n);
        }
    }
    return list;
  }
}
