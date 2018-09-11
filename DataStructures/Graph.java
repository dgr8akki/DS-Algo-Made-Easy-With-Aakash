import java.util.*;

class Graph {
  int totalNumberOfNodes;
  List<Integer> adjacentNodes[];

  Graph(int totalNumberOfNodes) {

    this.totalNumberOfNodes = totalNumberOfNodes;

    adjacentNodes = new LinkedList[totalNumberOfNodes];

    for(int i = 0; i < totalNumberOfNodes; i++)
      adjacentNodes[i] = new LinkedList<>();
  }

  public void addEdge(Graph graph, int source, int dest) {
    graph.adjacentNodes[source].add(dest);
    graph.adjacentNodes[dest].add(source);
  }

  public void printGraph() {
    printGraph(this);
  }

  private void printGraph(Graph graph) {
    for (int node = 0; node < graph.totalNumberOfNodes; node++) {
      System.out.println("Adjacency list of vertex " + node);
      System.out.print("head");
      for (Integer pCrawl : graph.adjacentNodes[node]) {
        System.out.print(" -> " + pCrawl);
      }
      System.out.println("\n");
    }
  }

  public void breadthFirstTraversal(int sourceNode) {
    boolean visited[] = new boolean[totalNumberOfNodes];

    LinkedList<Integer> queue = new LinkedList<Integer>();

    visited[sourceNode] = true;
    queue.add(sourceNode);

    System.out.print("BFS from " + sourceNode);

    while(!queue.isEmpty()) {
      int currentNode = queue.pollFirst();
      System.out.print(" -> " + currentNode );

      Iterator<Integer> iterator = adjacentNodes[currentNode].listIterator();

      while(iterator.hasNext()) {
        int tempNode = iterator.next();

        if(!visited[tempNode]) {
          visited[tempNode] = true;
          queue.add(tempNode);
        }
      }
    }
    System.out.println();
  }

  public void depthFirstTraversal(int sourceNode) {
    boolean visited[] = new boolean[totalNumberOfNodes];

    Stack<Integer> stack = new Stack<Integer>();

    visited[sourceNode] = true;
    stack.push(sourceNode);

    System.out.print("DFS from " + sourceNode);

    while (!stack.isEmpty()) {
      int currentNode = stack.pop();
      System.out.print(" -> " + currentNode);

      Iterator<Integer> iterator = adjacentNodes[currentNode].listIterator();

      while (iterator.hasNext()) {
        int tempNode = iterator.next();

        if (!visited[tempNode]) {
          visited[tempNode] = true;
          stack.push(tempNode);
        }
      }
    }
    System.out.println();
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
    graph.printGraph();
    graph.breadthFirstTraversal(1);
    graph.breadthFirstTraversal(0);
    graph.breadthFirstTraversal(2);
    graph.depthFirstTraversal(0);
    graph.depthFirstTraversal(1);
    graph.depthFirstTraversal(2);
  }
}
