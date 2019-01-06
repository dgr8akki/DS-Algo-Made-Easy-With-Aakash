class BST<T extends Comparable<T>> {
  private Node<T> root;

  void insert(T data) {
    if (root == null)
      root = new Node<>(data);
    else
      insert(root, data);
  }

  private void insert(Node<T> root, T newData) {
    if (root == null)
      root = new Node<>(newData);
    else if (newData.compareTo(root.getData()) < 0) {
      if (root.getLeftChild() != null)
        insert(root.getLeftChild(), newData);
      else
        root.setLeftChild(new Node<>(newData));
    } else {
      if (root.getRightChild() != null)
        insert(root.getRightChild(), newData);
      else
        root.setRightChild(new Node<>(newData));
    }
  }

  public void delete(T data) {
    if (root != null)
      root = delete(root, data);
  }

  private Node<T> delete(Node<T> node, T data) {
    if (node == null) return node;
    if (data.compareTo(node.getData()) < 0) {
      node.setLeftChild(delete(node.getLeftChild(), data));
    } else if (data.compareTo(node.getData()) > 0) {
      node.setRightChild(delete(node.getRightChild(), data));
    } else {
      if (node.getLeftChild() == null && node.getRightChild() == null) {
        System.out.println("Removing a leaf node...");
        return null;
      }

      if (node.getLeftChild() == null) {
        System.out.println("Removing the right child...");
        Node<T> tempNode = node.getRightChild();
        node = null;
        return tempNode;
      } else if (node.getRightChild() == null) {
        System.out.println("Removing the left child...");
        Node<T> tempNode = node.getLeftChild();
        node = null;
        return tempNode;
      }

      System.out.println("Removing item with two children...");
      Node<T> tempNode = getPredecessor(node.getLeftChild());
      node.setData(tempNode.getData());
      node.setLeftChild(delete(node.getLeftChild(), tempNode.getData()));
    }
    return node;
  }

  private Node<T> getPredecessor(Node<T> node) {

    if (node.getRightChild() != null)
      return getPredecessor(node.getRightChild());

    System.out.println("Predecessor is: " + node);
    return node;
  }

  void inorderTraversal() {
    inorderTraversal(this.root);
  }

  private void inorderTraversal(Node<T> root) {
    if (root.getLeftChild() != null)
      inorderTraversal(root.getLeftChild());
    System.out.println(root);
    if (root.getRightChild() != null)
      inorderTraversal(root.getRightChild());
  }
}
