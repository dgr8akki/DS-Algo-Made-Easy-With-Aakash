package Algorithms.Graphs.MaxFlow.src;

import java.util.ArrayList;
import java.util.List;

public class FlowNetwork {

  private int numOfVertices;
  private int numOfEdges;
  private List<List<Edge>> adjacenciesList;

  FlowNetwork(int numOfVertices) {
    this.numOfVertices = numOfVertices;
    this.numOfEdges = 0;
    this.adjacenciesList = new ArrayList<>();

    for (int i = 0; i < numOfVertices; ++i) {
      List<Edge> edgeList = new ArrayList<>();
      adjacenciesList.add(edgeList);
    }
  }

  int getNumOfVertices() {
    return this.numOfVertices;
  }

  public int getNumOfEdges() {
    return this.numOfEdges;
  }

  void addEdge(Edge e) {
    Vertex v = e.getFromVertex();
    Vertex w = e.getTargetVertex();
    adjacenciesList.get(v.getId()).add(e);
    adjacenciesList.get(w.getId()).add(e);
    numOfEdges++;
  }

  List<Edge> getAdjacenciesList(Vertex v) {
    return adjacenciesList.get(v.getId());
  }
}
