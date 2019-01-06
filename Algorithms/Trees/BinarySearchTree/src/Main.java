public class Main {
  public static void main(String[] args) {
    BST<Integer> bst = new BST<>();
    bst.insert(2);
    bst.insert(1);
    bst.insert(3);
    bst.delete(1);
    bst.inorderTraversal();
  }
}
