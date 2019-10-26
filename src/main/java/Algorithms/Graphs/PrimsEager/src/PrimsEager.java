package Algorithms.Graphs.PrimsEager.src;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class PrimsEager {
  private List<Edge> solutionTree;
  private List<Vertex> unvisitedVertexList;
  private PriorityQueue<Edge> queue;
  private double totalCost;

  PrimsEager(List<Vertex> vertexList) {
    this.unvisitedVertexList = vertexList;
    solutionTree = new ArrayList<>();
    queue = new PriorityQueue<>();
  }

  void createMST(Vertex vertex) {
    this.unvisitedVertexList.remove(vertex);

    while (!this.unvisitedVertexList.isEmpty()) {
      for (Edge edge : vertex.getAdjacencyList())
        if (this.unvisitedVertexList.contains(edge.getDestinationVertex()))
          this.queue.add(edge);

      Edge minimumWeightedEdge = this.queue.remove();
      this.solutionTree.add(minimumWeightedEdge);
      this.totalCost += minimumWeightedEdge.getWeight();

      vertex = minimumWeightedEdge.getDestinationVertex();
      this.unvisitedVertexList.remove(vertex);
    }

    for(Edge edge : solutionTree){
      System.out.print(""+edge.getSourceVertex()+""+edge.getDestinationVertex()+"-");
    }

    System.out.println("Total Cost is: " + totalCost);
  }
}
