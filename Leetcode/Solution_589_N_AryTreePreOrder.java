package Leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution_589_N_AryTreePreOrder {
  public static List<Integer> preorder(Node root) {
    List<Integer> list = new ArrayList<>();
    if (root == null) {
        return list;
    }
    Stack<Node> st = new Stack<>();
    st.add(root);
    while (!st.empty()) {
      Node current = st.pop();
      list.add(current.val);
      for (int i = current.children.size() - 1; i >= 0; i--) {
          if (current.children.get(i) != null) {
              st.add(current.children.get(i));
          }
      }
    }
    // Collections.reverse(list);
    return list;
  }

  static class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
  }
}
