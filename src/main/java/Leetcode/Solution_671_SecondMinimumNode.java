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
    public int findSecondMinimumValue(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        getNodes(root, list);
        if(list.size() <= 1) return -1;
        Collections.sort(list);
        int smallest = list.get(0);
        int secondSmallest = -1;
        for(int node: list) {          
          if(node == smallest) continue;
          if(node > smallest) return node;
        }
      return secondSmallest;
    }
  
  private void getNodes(TreeNode root, List<Integer> list) {
    if(root == null) return;
    getNodes(root.left, list);
    list.add(root.val);
    getNodes(root.right, list);
  }
}