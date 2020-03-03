package DataStructures;

import java.util.LinkedList;
import java.util.List;

class GraphWithNodes {

  private final int totalNumberOfNodes;
  private final LinkedList[] adjacentNodes = new LinkedList[0];

  private GraphWithNodes(int totalNumberOfNodes) {

    this.totalNumberOfNodes = totalNumberOfNodes;

    for (int i = 0; i < totalNumberOfNodes; i++) {
      adjacentNodes[i] = new LinkedList<>();
    }
  }

  public static void main(String[] args) {
    GraphWithNodes graph = new GraphWithNodes(5);

    GraphWithNodes.addEdge(graph, 0, 1);
    GraphWithNodes.addEdge(graph, 0, 4);
    GraphWithNodes.addEdge(graph, 1, 2);
    GraphWithNodes.addEdge(graph, 1, 3);
    GraphWithNodes.addEdge(graph, 1, 4);
    GraphWithNodes.addEdge(graph, 2, 3);
    GraphWithNodes.addEdge(graph, 3, 4);
    GraphWithNodes.printGraph(graph);
  }

  public static void addEdge(GraphWithNodes graph, int source, int dest) {
    graph.adjacentNodes[source].add(dest);
    graph.adjacentNodes[dest].add(source);
  }

  private static void printGraph(GraphWithNodes graph) {
    for (int node = 0; node < graph.totalNumberOfNodes; node++) {
      System.out.println("Adjacency list of vertex " + node);
      System.out.print("head");
      for (Object pCrawl : graph.adjacentNodes[node]) {
        System.out.print(" -> " + pCrawl);
      }
      System.out.println("\n");
    }
  }

  public void BreadFirstTraversal(int sourceNode) {
    boolean[] visited = new boolean[totalNumberOfNodes];

    LinkedList<Integer> queue = new LinkedList<>();

    visited[sourceNode] = true;
  }

  class Node {
    int value;
    List<Integer> adjacentNodes[];

    Node(int val) {
      value = val;
    }
  }
}
