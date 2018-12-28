public class Node {
  private Vertex vertex;
  private Node parent;
  private int rank;

  public Vertex getVertex() {
    return vertex;
  }

  public void setVertex(Vertex vertex) {
    this.vertex = vertex;
  }

  public Node getParent() {
    return parent;
  }

  public void setParent(Node parent) {
    this.parent = parent;
  }

  public int getRank() {
    return rank;
  }

  public void setRank(int rank) {
    this.rank = rank;
  }

  Node(Vertex vertex) {
    this.vertex = vertex;
    this.parent = this;
  }
}
