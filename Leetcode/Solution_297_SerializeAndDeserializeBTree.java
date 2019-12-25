package Leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_297_SerializeAndDeserializeBTree {

  private static void serialize(TreeNode root, StringBuilder sb) {
    if (root == null) {
      sb.append("#").append(",");
    } else {
      sb.append(root.val).append(",");
      Solution_297_SerializeAndDeserializeBTree.serialize(root.left, sb);
      Solution_297_SerializeAndDeserializeBTree.serialize(root.right, sb);
    }
  }

  private static TreeNode deserialize(Queue<String> q) {
    String s = q.poll();
    if (s.equals("#")) {
      return null;
    }
    TreeNode root = new TreeNode(Integer.parseInt(s));
    root.left = Solution_297_SerializeAndDeserializeBTree.deserialize(q);
    root.right = Solution_297_SerializeAndDeserializeBTree.deserialize(q);
    return root;
  }

  public static String serialize(TreeNode root) {
    StringBuilder sb = new StringBuilder();
    Solution_297_SerializeAndDeserializeBTree.serialize(root, sb);
    return sb.toString();
  }

  public static TreeNode deserialize(String data) {
    Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
    return Solution_297_SerializeAndDeserializeBTree.deserialize(q);
  }
}
