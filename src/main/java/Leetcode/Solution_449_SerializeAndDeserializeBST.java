package Leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_449_SerializeAndDeserializeBST {

  private static void serialize(TreeNode root, StringBuilder sb) {
    if (root == null) {
      return;
    }
    sb.append(root.val).append(",");
    Solution_449_SerializeAndDeserializeBST.serialize(root.left, sb);
    Solution_449_SerializeAndDeserializeBST.serialize(root.right, sb);
  }

  public static TreeNode deserialize(String data) {
    if (data.isEmpty()) {
      return null;
    }
    Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
    return Solution_449_SerializeAndDeserializeBST.deserialize(
        q, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  private static TreeNode deserialize(Queue<String> q, int lower, int upper) {
    if (q.isEmpty()) {
      return null;
    }
    String s = q.peek();
    int val = Integer.parseInt(s);
    if (val < lower || val > upper) {
      return null;
    }
    q.poll();
    TreeNode root = new TreeNode(val);
    root.left = Solution_449_SerializeAndDeserializeBST.deserialize(q, lower, val);
    root.right = Solution_449_SerializeAndDeserializeBST.deserialize(q, val, upper);
    return root;
  }

  public static String serialize(TreeNode root) {
    StringBuilder sb = new StringBuilder();
    Solution_449_SerializeAndDeserializeBST.serialize(root, sb);
    return sb.toString();
  }

  static class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
      this.val = val;
    }
  }
}
