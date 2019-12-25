package Algorithms.Strings.TST.src;

public class TST {
  private Node root;

  public void put(String key, int value) {
    root = put(root, key, value, 0);
  }

  private Node put(Node node, String key, int value, int index) {
    char currentCharacter = key.charAt(index);

    if(node == null) node = new Node(currentCharacter);

    if(currentCharacter < node.getCharacter())
      node.setLeftChild(put(node.getLeftChild(), key, value, index));
    else if(currentCharacter > node.getCharacter())
      node.setRightChild(put(node.getRightChild(), key, value, index));
    else if(index < key.length() - 1)
      node.setMiddleChild(put(node.getMiddleChild(), key, value, index + 1));
    else
      node.setValue(value);
    return node;
  }

  public Integer get(String key) {
    Node node = get(root, key, 0);
    if(node == null) return null;
    return node.getValue();
  }

  private Node get(Node node, String key, int index) {
    if(node == null) return null;
    char currentCharacter = key.charAt(index);
    if(currentCharacter < node.getCharacter())
      return get(node.getLeftChild(), key, index);
    else if(currentCharacter > node.getCharacter())
      return get(node.getRightChild(), key, index);
    else if(index < key.length() - 1)
      return get(node.getMiddleChild(), key, index + 1);
    return node;
  }
}
