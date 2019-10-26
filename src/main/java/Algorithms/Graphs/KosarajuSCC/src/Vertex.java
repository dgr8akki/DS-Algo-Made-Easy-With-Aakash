package Algorithms.Graphs.KosarajuSCC.src;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
  private int id, componentId;
  private String data;
  private List<Vertex> adjacencyList;
  private double distance;
  private Vertex predecessor;
  private boolean isVisited;


  Vertex(int  id, String data) {
    this.id = id;
    this.data = data;
    this.adjacencyList = new ArrayList<>();
    this.distance = Double.POSITIVE_INFINITY;
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

  void addNeighbour(Vertex v) {
    this.adjacencyList.add(v);
  }

  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }

  List<Vertex> getAdjacencyList() {
    return adjacencyList;
  }

  public void setAdjacencyList(List<Vertex> adjacencyList) {
    this.adjacencyList = adjacencyList;
  }

  double getDistance() {
    return distance;
  }

  void setDistance(double distance) {
    this.distance = distance;
  }

  @Override
  public String toString() {
    return this.data;
  }

  public int getComponentId() {
    return componentId;
  }

  public void setComponentId(int componentId) {
    this.componentId = componentId;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
}
