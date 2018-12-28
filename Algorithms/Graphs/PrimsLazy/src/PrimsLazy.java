import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class PrimsLazy {
  private List<Edge> solutionTree;
  private List<Vertex> unvisitedVertexList;
  private PriorityQueue<Edge> queue;
  private double totalCost;

  PrimsLazy(List<Vertex> vertexList) {
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
  }
}
