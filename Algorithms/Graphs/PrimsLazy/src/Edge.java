package Algorithms.Graphs.PrimsLazy.src;

public class Edge implements Comparable<Edge> {
  private Vertex sourceVertex;
  private Vertex destinationVertex;
  private double weight;

  public Edge(Vertex sourceVertex, Vertex destinationVertex, double weight) {
    this.sourceVertex = sourceVertex;
    this.destinationVertex = destinationVertex;
    this.weight = weight;
  }

  public Vertex getSourceVertex() {
    return sourceVertex;
  }

  public void setSourceVertex(Vertex sourceVertex) {
    this.sourceVertex = sourceVertex;
  }

  public Vertex getDestinationVertex() {
    return destinationVertex;
  }

  public void setDestinationVertex(Vertex destinationVertex) {
    this.destinationVertex = destinationVertex;
  }

  public double getWeight() {
    return weight;
  }

  public void setWeight(double weight) {
    this.weight = weight;
  }

  @Override
  public int compareTo(Edge anotherEdge) {
    return Double.compare(this.weight, anotherEdge.weight);
  }
}
