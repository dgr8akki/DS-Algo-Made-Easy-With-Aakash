package Algorithms.Graphs.Kruskal.src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Kruskal {

  private List<Edge> solutionTree = new ArrayList<>();

  void spanningTree(List<Vertex> vertexList, List<Edge> edgeList) {
    DisjointSet set = new DisjointSet(vertexList);
    Collections.sort(edgeList);

    for(Edge currentEdge: edgeList) {

      Vertex startingVertex = currentEdge.getSourceVertex();
      Vertex endingVertex = currentEdge.getDestinationVertex();

      if(set.find(startingVertex) != set.find(endingVertex)) {
        solutionTree.add(currentEdge);
        set.union(startingVertex, endingVertex);
      }
    }

    for(Edge edge : solutionTree){
      System.out.print(""+edge.getSourceVertex()+""+edge.getDestinationVertex()+"-");
    }
  }
}
