import java.util.Arrays;

public class AVL {
  class Node {
    int val;
    int ht;
    Node left;
    Node right;

    Node(int v) {
      this.val = v;
      this.ht = 0;
      this.left = null;
      this.right = null;
    }
  }

  public Node root;

  private Node rotateRight(Node root) {
    Node newRoot = root.left;
    root.left = newRoot.right;
    newRoot.right = root;
    correctHeight(root);
    correctHeight(newRoot);
    return newRoot;
  }

  private Node rotateLeft(Node root) {
    Node newRoot = root.right;
    root.right = newRoot.left;
    newRoot.left = root;
    correctHeight(root);
    correctHeight(newRoot);
    return newRoot;
  }

  public void createTreeFromArray (int[] arr) {
    for(int el : arr)
      insert(el);
  }

  public void insert (int value) {
    this.root = insert(this.root, value);
  }

  private Node insert(Node root, int val) {
    if(root == null) {
      return new Node(val);
    }

    if(val > root.val)
      root.right = insert(root.right, val);
    else
      root.left = insert(root.left, val);

    int balanceFactor = getBalanceFactor(root);

    if(balanceFactor > 1) {
      if(getBalanceFactor(root.left) == -1)
        root.left = rotateLeft(root.left);
      return rotateRight(root);
    }

    if(balanceFactor < -1) {
      if(getBalanceFactor(root.right) == 1)
        root.right = rotateRight(root.right);
      return rotateLeft(root);
    }

    correctHeight(root);

    return root;
  }

  public void delete(int value) {
    this.root = delete(this.root, value);
  }

  private Node delete(Node head, int k) {
    if (head == null) {
      System.out.println("Key not found");
      return head;
    }
    if (k < head.val)
      head.left = delete(head.left, k);
    else if (k > head.val)
      head.right = delete(head.right, k);
    else {
      if (head.left == null && head.right == null) head = null;
      else if (head.left == null && head.right != null)
        head = head.right;
      else if (head.left != null && head.right == null)
        head = head.left;
      else if (head.left != null && head.right != null) {
        Node nextInorderedNode = getNextInorderedNode(head.right);
        if (nextInorderedNode == null)
          head = head.left;
        else {
          head.val = nextInorderedNode.val;
          head.right = delete(head.right, nextInorderedNode.val);
        }
      }
    }

    if (head == null) {
      return head;
    }

    correctHeight(head);

    int balanceFactor = getBalanceFactor(head);

    if (balanceFactor > 1) {
      if (getBalanceFactor(head.left) == -1)
        head.left = rotateLeft(head.left);
      return rotateRight(head);
    }

    if (balanceFactor < -1) {
      if (getBalanceFactor(head.right) == 1)
        head.right = rotateRight(head.right);
      return rotateLeft(head);
    }

    return head;
  }

  private Node getNextInorderedNode(Node head) {
    if (head == null)
      return null;
    if (head.right == null && head.left == null)
      return head;
    Node node = getNextInorderedNode(head.left);
    return node == null ? head : node;
  }

  private static int getBalanceFactor(Node root) {
    int leftHeight = root.left == null ? -1 : root.left.ht;
    int rightHeight = root.right == null ? -1 : root.right.ht;
    return leftHeight - rightHeight;
  }

  private static void correctHeight(Node root) {
    root.ht = 1 + Math.max(root.left == null ? -1 : root.left.ht, root.right == null ? -1 : root.right.ht);
  }

  public static void main(String[] args) {
    int[] array = {1,2,3,0,9,8,7,6,-1,-3};
    AVL avl = new AVL();
    avl.createTreeFromArray(array);
    avl.delete(0);
    System.out.println(Arrays.toString(array));
  }
}
