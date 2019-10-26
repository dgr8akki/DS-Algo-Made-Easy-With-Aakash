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
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        int min = Math.min(leftDepth, rightDepth);
        int max = Math.max(leftDepth, rightDepth);
        return 1 + (min > 0 ? min : max);
    }
}