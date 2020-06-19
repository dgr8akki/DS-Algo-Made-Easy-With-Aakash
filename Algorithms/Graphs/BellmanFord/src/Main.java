package Algorithms.Graphs.BellmanFord.src;

import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {

    List<Vertex> vertexList = new ArrayList<>();

    vertexList.add(new Vertex(1));
    vertexList.add(new Vertex(2));
    vertexList.add(new Vertex(3));
    vertexList.add(new Vertex(4));
    vertexList.add(new Vertex(5));

    List<Edge> edgeList = new ArrayList<>();
    edgeList.add(new Edge(vertexList.get(0), vertexList.get(1), 5));
    edgeList.add(new Edge(vertexList.get(0), vertexList.get(3), -4));
    edgeList.add(new Edge(vertexList.get(0), vertexList.get(2), 8));
    edgeList.add(new Edge(vertexList.get(1), vertexList.get(0), -2));
    edgeList.add(new Edge(vertexList.get(2), vertexList.get(1), -3));
    edgeList.add(new Edge(vertexList.get(2), vertexList.get(3), 9));
    edgeList.add(new Edge(vertexList.get(3), vertexList.get(1), 7));
    edgeList.add(new Edge(vertexList.get(4), vertexList.get(0), 6));
    edgeList.add(new Edge(vertexList.get(4), vertexList.get(2), 7));

    BellmanFord bellmannFordAlgorithm = new BellmanFord(vertexList, edgeList);
    bellmannFordAlgorithm.bellmanFord(vertexList.get(4), vertexList.get(3));

  }
}
