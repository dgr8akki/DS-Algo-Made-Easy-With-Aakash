import java.util.*;

class Graph {

  class Node {
    int value;
    List<Node> adjacentNodes[];

    Node(int val) {
      this.value = val;
      adjacentNodes = new LinkedList<>();
    }
  }

  int totalNumberOfNodes;

  Graph(int totalNumberOfNodes) {

    this.totalNumberOfNodes = totalNumberOfNodes;

    for(int i = 0; i < totalNumberOfNodes; i++)
      adjacentNodes[i] = new LinkedList<>();
  }

  public void addEdge(Graph graph, int source, int dest) {
    graph.adjacentNodes[source].add(dest);
    graph.adjacentNodes[dest].add(source);
  }

  public void printGraph(Graph graph) {
    for (int node = 0; node < graph.totalNumberOfNodes; node++) {
      System.out.println("Adjacency list of vertex " + node);
      System.out.print("head");
      for (Integer pCrawl : graph.adjacentNodes[node]) {
        System.out.print(" -> " + pCrawl);
      }
      System.out.println("\n");
    }
  }

  public void BreadFirstTraversal(int sourceNode) {
    boolean visited[] = new boolean[totalNumberOfNodes];

    LinkedList<Integer> queue = new LinkedList<Integer>();

    visited[s] = true;
  }

  public static void main(String[] args) {
    Graph graph = new Graph(5);

    graph.addEdge(graph, 0, 1);
    graph.addEdge(graph, 0, 4);
    graph.addEdge(graph, 1, 2);
    graph.addEdge(graph, 1, 3);
    graph.addEdge(graph, 1, 4);
    graph.addEdge(graph, 2, 3);
    graph.addEdge(graph, 3, 4);
    graph.printGraph(graph);
  }
}
