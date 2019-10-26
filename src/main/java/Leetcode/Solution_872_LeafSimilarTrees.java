package Leetcode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) return true;
        List<Integer> tree1Nodes = getNodes(root1);
        List<Integer> tree2Nodes = getNodes(root2);
        if(tree1Nodes.size() != tree2Nodes.size()) return false;
        for(int i = 0; i < tree1Nodes.size(); i++)
          if(tree1Nodes.get(i) != tree2Nodes.get(i)) return false;
      return true;
    }
  
  private List<Integer> getNodes(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    getNodes(root, list);
    return list;
  }
  
  private void getNodes(TreeNode root, List<Integer> list) {
    if(root == null) return;
    getNodes(root.left, list);
    if(root.left == null && root.right == null) list.add(root.val);
    getNodes(root.right, list);
  }
}