import java.util.*;

class Graph {
  int V;
  List<Integer> adjacentNodes[];

  Graph(int v) {
    this.V = v;

    adjacentNodes = new LinkedList[this.V];

    for(int i = 0; i < V; i++)
      adjacentNodes[i] = new LinkedList<>();
  }

  public void addEdge(Graph graph, int source, int dest) {
    graph.adjacentNodes[source].add(dest);
    graph.adjacentNodes[dest].add(source);
  }

  public void printGraph(Graph graph) {
    for (int v = 0; v < graph.V; v++) {
      System.out.println("Adjacency list of vertex " + v);
      System.out.print("head");
      for (Integer pCrawl : graph.adjacentNodes[v]) {
        System.out.print(" -> " + pCrawl);
      }
      System.out.println("\n");
    }
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
