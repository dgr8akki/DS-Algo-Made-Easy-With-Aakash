public class Node {
  private String character;
  private boolean visited;
  private boolean isLeaf;
  private Node[] children;

  public Node(String character) {
    this.character = character;
    this.children = new Node[Constant.ALPHABET_SIZE];
  }

  public String getCharacter() {
    return character;
  }

  public void setCharacter(String character) {
    this.character = character;
  }

  public boolean isVisited() {
    return visited;
  }

  public void setVisited(boolean visited) {
    this.visited = visited;
  }

  public boolean isLeaf() {
    return isLeaf;
  }

  public void setLeaf(boolean leaf) {
    isLeaf = leaf;
  }

  public Node[] getChildren() {
    return children;
  }

  public void setChildren(Node[] children) {
    this.children = children;
  }

  @Override
  public String toString() {
    return this.character;
  }

  void addChild(int index, Node node) {
    this.children[index] = node;
  }

  Node getChild(int index) {
    return this.children[index];
  }
}
