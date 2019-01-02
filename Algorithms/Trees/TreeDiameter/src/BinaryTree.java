import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTree {
  private Node root;

  public Node getRoot() {
    return root;
  }

  public void setRoot(Node root) {
    this.root = root;
  }

  int getDiameter() {
    return getDiameter(this.root);
  }

  private int getDiameter(Node root) {
    if(root == null) return 0;
    int option1 = height(root.getLeft()) + height(root.getRight());
    int option2 = getDiameter(root.getLeft());
    int option3 = getDiameter(root.getRight());
    return Math.max(option1, Math.max(option2, option3));
  }

  private int height(Node root) {
    if(root == null) return 0;
    return 1 + Math.max(height(root.getLeft()), height(root.getRight()));
  }

  void init() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter root node data:");
    this.root = new Node(scanner.nextInt());
    Queue<Node> queue = new LinkedList<>();
    queue.add(root);
    while(!queue.isEmpty()) {
    Node currentNode = queue.remove();
      System.out.println("Enter left child data of : " + currentNode.getData());
      int value = scanner.nextInt();
      if(value != -1) {
        currentNode.setLeft(new Node(value));
        queue.add(currentNode.getLeft());
      }
      System.out.println("Enter right child data of : " + currentNode.getData());
      value = scanner.nextInt();
      if(value != -1) {
        currentNode.setRight(new Node(value));
        queue.add(currentNode.getRight());
      }
    }
  }
}
