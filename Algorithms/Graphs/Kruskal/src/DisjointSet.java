package Algorithms.Graphs.Kruskal.src;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DisjointSet {
  private Map<Vertex, Node> map = new HashMap<>();

  public DisjointSet(List<Vertex> vertexList) {
    for(Vertex vertex: vertexList)
      makeSet(vertex);
  }

  public void makeSet(Vertex vertex) {
    map.put(vertex, new Node(vertex));
  }

  public Node find(Vertex vertex) {
    Node currentNode = map.get(vertex);
    return find(currentNode);
  }

  private Node find(Node currentNode) {
    if(currentNode.getParent() == currentNode)
      return currentNode;
    currentNode.setParent(find(currentNode.getParent()));
    return  currentNode.getParent();
  }

  public void union(Vertex firstVertex, Vertex secondVertex) {
//    Node firstEdgeNode = map.get(firstEdge);
//    Node secondEdgeNode = map.get(secondEdge);
    Node firstEdgeNodeParent = find(firstVertex);
    Node secondEdgeNodeParent = find(secondVertex);
    if(firstEdgeNodeParent == secondEdgeNodeParent) return;
    if(firstEdgeNodeParent.getRank() == secondEdgeNodeParent.getRank()) {
      firstEdgeNodeParent.setRank(firstEdgeNodeParent.getRank() + 1);
      secondEdgeNodeParent.setParent(firstEdgeNodeParent);
    } else if(firstEdgeNodeParent.getRank() > secondEdgeNodeParent.getRank()) {
      secondEdgeNodeParent.setParent(firstEdgeNodeParent);
    } else
      firstEdgeNodeParent.setParent(secondEdgeNodeParent);
  }
}
