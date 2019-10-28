package Hackerrank.Practise;

import java.util.ArrayList;

/*
class Node {
  int data;
  Node left;
  Node right;

  Node(int val) {
    data = val;
  }
}
*/
class IsThisABinaryTree {
  private static void inorder(Node root, ArrayList<Integer> list) {
    if (root == null) {
      return;
    }
    if (root.left == null && root.right == null) {
      list.add(root.data);
      return;
    }
    IsThisABinaryTree.inorder(root.left, list);
    list.add(root.data);
    IsThisABinaryTree.inorder(root.right, list);
  }

  static boolean checkBST(Node root) {
    ArrayList<Integer> list = new ArrayList<>();
    IsThisABinaryTree.inorder(root, list);
    if (list.size() <= 1) {
      return true;
    }
    for (int i = 1; i <= list.size() - 1; i++) {
      if (list.get(i) <= list.get(i - 1)) {
        return false;
      }
    }
    return true;
  }
}
