package Algorithms.Graphs.BellmanFord.src;

import java.util.List;

public class BellmanFord {

  private List<Vertex> vertexList;
  private List<Edge> edgeList;

  public BellmanFord(List<Vertex> vertexList, List<Edge> edgeList) {
    this.vertexList = vertexList;
    this.edgeList = edgeList;
  }

  public void bellmanFord(Vertex sourceVertex, Vertex targetVertex) {

    sourceVertex.setDistance(0);

    for (Vertex vertex : vertexList) {
      for (Edge edge : edgeList) {

        if (edge.getSourceVertex().getDistance() == Integer.MAX_VALUE) {
          continue;
        }

        int newDistance = (int) (edge.getSourceVertex().getDistance() + edge.getWeight());

        if (newDistance < edge.getDestinationVertex().getDistance()) {
          edge.getDestinationVertex().setDistance(newDistance);
          edge.getDestinationVertex().setPredecessor(edge.getSourceVertex());
        }
      }
    }

    for (Edge edge : edgeList) {
      if (edge.getSourceVertex().getDistance() != Integer.MAX_VALUE) {
        if (hasCycle(edge)) {
          System.out.println("Negative edge weight cycles detected!");
          return;
        }
      }
    }

    if (targetVertex.getDistance() != Integer.MAX_VALUE) {
      System.out.println("There is a shortest path from sourco to target, with cost: " + targetVertex.getDistance());

      Vertex actualVertex = targetVertex;
      while (actualVertex.getPredecessor() != null) {
        System.out.print(actualVertex + "-");
        actualVertex = actualVertex.getPredecessor();
      }

    } else {
      System.out.println("There is no path from source to target...");
    }
  }

  private boolean hasCycle(Edge edge) {
    return edge.getDestinationVertex().getDistance() > edge.getSourceVertex().getDistance() + edge.getWeight();
  }
}
