package Hackerrank.Practise;

	class SelfBalancingTree {

  private static Node rotateRight(Node root) {
    Node newRoot = root.left;
    root.left = newRoot.right;
    newRoot.right = root;
    root.ht = Math.max(root.left.ht, root.right.ht) + 1;
    newRoot.ht = Math.max(newRoot.left.ht, newRoot.right.ht) + 1;
    return newRoot;
  }

  private static Node rotateLeft(Node root) {
    Node newRoot = root.right;
    root.right = newRoot.left;
    newRoot.left = root;
    correctHeight(root);
    correctHeight(newRoot);
    return newRoot;
  }

  private static Node insert(Node root, int val) {
    if(root == null) {
        Node n = new Node();
        n.val = val;
        n.ht = 0;
        return n;
    }
    if(val > root.val) {
      root.right = insert(root.right, val);
    } else {
      root.left = insert(root.left, val);
    }

    int balanceFactor = getBalanceFactor(root);

    if(balanceFactor > 1) {
      if(getBalanceFactor(root.left) == -1) {
        root.left = rotateLeft(root.left);
      }
      return rotateRight(root);
    }

    if(balanceFactor < -1) {
      if(getBalanceFactor(root.right) == 1) {
        root.right = rotateRight(root.right);
      }
      return rotateLeft(root);
    }

    correctHeight(root);

    return root;
  }

    private static int getBalanceFactor(Node root) {
        int leftHeight = root.left == null ? -1 : root.left.ht;
        int rightHeight = root.right == null ? -1 : root.right.ht;
        return leftHeight - rightHeight;
    }

private static void correctHeight(Node root) {
        root.ht = 1 + Math.max(root.left == null ? -1 : root.left.ht, root.right == null ? -1 : root.right.ht);
    }

    	  static class Node {
      int val;	//Value
      int ht;		//Height
      Node left;	//Left child
      Node right;	//Right child
    }
	}