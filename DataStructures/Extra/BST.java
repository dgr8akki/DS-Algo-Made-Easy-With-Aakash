package DataStructures;

import java.util.*;

public class BST {
  public class Node {
    int value;
    Node left;
    Node right;

    Node(int value) {
      this.value = value;
    }
  }

  private Node root;

  private void printRootValue() {
    System.out.print(this.root.value);
  }

  public void insert(int val) {
    root = insert(root, val);
  }

  private Node insert(Node head, int val) {
    if (head == null) {
      return new Node(val);
    }
    if (val >= head.value)
      head.right = insert(head.right, val);
    else
      head.left = insert(head.left, val);
    return head;
  }

  public void createTree(int[] arr) {
    for (int el : arr)
      insert(el);
  }

  public void inorder() {
    inorderTraversal(this.root);
  }

  private void inorderTraversal(Node head) {
    if (head == null)
      return;
    inorderTraversal(head.left);
    System.out.print(head.value + " ");
    inorderTraversal(head.right);
  }

  public void preorder() {
    preorderTraversal(this.root);
  }

  private void preorderTraversal(Node head) {
    if (head == null)
      return;
    System.out.print(head.value + " ");
    preorderTraversal(head.left);
    preorderTraversal(head.right);
  }

  public void postorder() {
    postorderTraversal(this.root);
  }

  private void postorderTraversal(Node head) {
    if (head == null)
      return;
    postorderTraversal(head.left);
    postorderTraversal(head.right);
    System.out.print(head.value + " ");
  }

  public void searchInBSTusingDFS(int key) {
    dfs(this.root, key);
  }

  private void dfs(Node head, int k) {
    if (head == null)
      return;
    Stack<Node> stack = new Stack<Node>();
    Map<Node, Boolean> isVisited = new HashMap<>();
    stack.push(head);
    while (!stack.isEmpty()) {
      Node currentNode = stack.pop();

      if (!isVisited.containsKey(currentNode) && currentNode != null) {
        isVisited.put(currentNode, true);
        System.out.print(currentNode.value + " ");
        stack.push(currentNode.left);
        stack.push(currentNode.right);
      }
    }
  }

  public void searchInBSTusingBFS(int key) {
    bfs(this.root, key);
  }

  private void bfs(Node head, int k) {
    if (head == null)
      return;
    Queue<Node> queue = new LinkedList<Node>();
    Map<Node, Boolean> isVisited = new HashMap<>();
    queue.add(head);
    while (!queue.isEmpty()) {
      Node currentNode = queue.poll();

      if (!isVisited.containsKey(currentNode) && currentNode != null) {
        isVisited.put(currentNode, true);
        System.out.print(currentNode.value + " > ");
        // if(currentNode.value == k) return currentNode;
        queue.add(currentNode.left);
        queue.add(currentNode.right);
      }
    }
  }

  public void searchInBST(int key) {
    if (search(this.root, key) == null) {
      System.out.println("NOT FOUND");
    } else {
      System.out.println("KEY FOUND" + search(this.root, key).value);
    }
  }

  private Node search(Node head, int k) {
    if (head == null || head.value == k)
      return head;
    if (k < head.value)
      head.left = search(head.left, k);
    else if (k > head.value)
      head.right = search(head.right, k);
    return null;
  }

  public Node delete(Node head, int k) {
    if (head == null) {
      System.out.println("Key not found");
      return head;
    }
    if (k < head.value)
      head.left = delete(head.left, k);
    else if (k > head.value)
      head.right = delete(head.right, k);
    else if (k == head.value) {
      if (head.left == null && head.right == null)
        head = null;
      else if (head.left == null && head.right != null)
        head = head.right;
      else if (head.left != null && head.right == null)
        head = head.left;
      else if (head.left != null && head.right != null) {
        Node nextInorderedNode = getNextInorderedNode(head.right);
        if (nextInorderedNode == null)
          head = head.left;
        else {
          head.value = nextInorderedNode.value;
          head.right = delete(head.right, nextInorderedNode.value);
        }
      }
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

  public void delete(int k) {
    this.root = delete(this.root, k);
  }

  public void invertTree() {
    this.root = invertTree(this.root);
  }

  public Node invertTree(Node head) {
    if (head == null)
      return head;

    head = swapChildren(head);

    head.left = invertTree(head.left);
    head.right = invertTree(head.right);
    return head;
  }

  private Node swapChildren(Node head) {
    if (head.left == null && head.right == null)
      return head;
    Node temp = head.left;
    head.left = head.right;
    head.right = temp;
    return head;
  }

  public void getNthHighestNodeFromTreeUsingList(int n) {
    ArrayList<Node> inordereNodesList = new ArrayList<>();
    this.root = reverseInorderTraversal(inordereNodesList, this.root);
    System.out.println(inordereNodesList.get(n - 1).value);
  }

  private Node reverseInorderTraversal(ArrayList<Node> inordereNodesList, Node head) {
    if (head == null)
      return head;
    head.right = reverseInorderTraversal(inordereNodesList, head.right);
    inordereNodesList.add(head);
    head.right = reverseInorderTraversal(inordereNodesList, head.left);
    return head;
  }

  public void validateBST() {
    if (isValidBSTUtil(this.root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY))
      System.out.println("It's a valid BST");
    else
      System.out.println("Oops!!! Not a valid BST");
  }

  public boolean isValidBSTUtil(Node head, double min, double max) {
    if (head == null)
      return true;
    if (head.value <= min || head.value >= max)
      return false;
    return (isValidBSTUtil(head.left, min, head.value) && isValidBSTUtil(head.right, head.value, max));
  }

  public static void main(String[] args) {
    BST bst = new BST();
    int[] input = { -1, 2, 3, 1, 4, 12, 21, 11 };
    bst.createTree(input);
    bst.insert(100);
    bst.insert(10);
    bst.preorder();
    System.out.println();
    bst.inorder();
    System.out.println();
    bst.postorder();
    bst.searchInBST(-1);
    bst.delete(12);
    bst.searchInBSTusingBFS(-1);
    bst.preorder();
    System.out.println();
    System.out.println("BFS");
    bst.searchInBSTusingBFS(-1);
    System.out.println("DFS");
    bst.searchInBSTusingDFS(-1);
    System.out.println();
    System.out.println("BEFORE INVERT INORDER");
    bst.inorder();
    bst.invertTree();
    System.out.println();
    System.out.println("POST INVERT INORDER");
    bst.inorder();
    bst.getNthHighestNodeFromTreeUsingList(2);
    bst.validateBST();
  }
}
