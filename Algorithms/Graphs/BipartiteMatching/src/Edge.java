package Algorithms.Graphs.BipartiteMatching.src;

public class Edge {

  private final Vertex fromVertex;
  private final Vertex targetVertex;
  private final double capacity;
  private double flow;

  public Edge(Vertex fromVertex, Vertex targetVertex, double capacity) {
    this.fromVertex = fromVertex;
    this.targetVertex = targetVertex;
    this.capacity = capacity;
    this.flow = 0;
  }

  public Edge(Edge edge) {
    this.fromVertex = edge.fromVertex;
    this.targetVertex = edge.targetVertex;
    this.capacity = edge.capacity;
    this.flow = edge.flow;
  }

  public Vertex getFromVertex() {
    return fromVertex;
  }

  public Vertex getTargetVertex() {
    return targetVertex;
  }

  public double capacity() {
    return capacity;
  }

  public double getFlow() {
    return flow;
  }

  public Vertex getOther(Vertex vertex) {
    if (vertex.equals(fromVertex)) {
      return targetVertex;
    } else {
      return fromVertex;
    }
  }

  public double getResidualCapacityTo(Vertex vertex) {
    if (vertex.equals(fromVertex)) {
      return flow; // backward edge
    } else {
      return capacity - flow; // forward edge
    }
  }

  public void addResidualFlowTo(Vertex vertex, double deltaFlow) {
    if (vertex.equals(fromVertex)) {
      flow -= deltaFlow; // backward edge
    } else {
      flow += deltaFlow; // forward edge
    }
  }

  public String toString() {
    return fromVertex + "->" + targetVertex + " " + flow + "/" + capacity;
  }
}
