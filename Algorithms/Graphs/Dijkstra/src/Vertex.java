package Algorithms.Graphs.Dijkstra.src;

import java.util.ArrayList;
import java.util.List;

public class Vertex implements Comparable<Vertex> {
  private String data;
  private List<Edge> adjacencyList;
  private double distance;
  private Vertex predecessor;
  private boolean isVisited;

  Vertex(String data) {
    this.data = data;
    this.adjacencyList = new ArrayList<>();
    this.distance = Double.MAX_VALUE;;
  }

  Vertex getPredecessor() {
    return predecessor;
  }

  void setPredecessor(Vertex predecessor) {
    this.predecessor = predecessor;
  }

  public boolean isVisited() {
    return isVisited;
  }

  public void setVisited(boolean visited) {
    isVisited = visited;
  }


  void addNeighbour(Edge edge) {
    this.adjacencyList.add(edge);
  }

  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }

  List<Edge> getAdjacencyList() {
    return adjacencyList;
  }

  public void setAdjacencyList(List<Edge> adjacencyList) {
    this.adjacencyList = adjacencyList;
  }

  double getDistance() {
    return distance;
  }

  void setDistance(double distance) {
    this.distance = distance;
  }

  @Override
  public int compareTo(Vertex anotherVertex) {
    return Double.compare(this.distance, anotherVertex.distance);
  }

  @Override
  public String toString() {
    return this.data;
  }
}
