public class Node {
  private char character;
  private Node leftChild;
  private Node middleChild;
  private Node rightChild;
  private int value;

  Node(char character) {
    this.character = character;
  }

  public int getValue() {
    return value;
  }

  char getCharacter() {
    return character;
  }

  public void setCharacter(char character) {
    this.character = character;
  }

  Node getLeftChild() {
    return leftChild;
  }

  void setLeftChild(Node leftChild) {
    this.leftChild = leftChild;
  }

  Node getMiddleChild() {
    return middleChild;
  }

  void setMiddleChild(Node middleChild) {
    this.middleChild = middleChild;
  }

  Node getRightChild() {
    return rightChild;
  }

  void setRightChild(Node rightChild) {
    this.rightChild = rightChild;
  }

  void setValue(int value) {
    this.value = value;
  }
}
