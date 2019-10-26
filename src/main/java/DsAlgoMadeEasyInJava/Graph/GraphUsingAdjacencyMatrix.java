package DsAlgoMadeEasyInJava.Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class GraphUsingAdjacencyMatrix {
  private final int vertices;
  private final boolean[][] adjMatrix;

  private GraphUsingAdjacencyMatrix(int vertices) {
    this.vertices = vertices;
    adjMatrix = new boolean[vertices][vertices];
    // for(int i = 1; i <= vertices; i++) adjMatrix[i][i] = true;
  }

  public static void main(String[] args) {
    GraphUsingAdjacencyMatrix graph = new GraphUsingAdjacencyMatrix(5);
    graph.addEdge(2, 3);
    graph.addEdge(0, 2);
    graph.addEdge(0, 3);
    graph.addEdge(1, 3);
    graph.addEdge(1, 4);
    graph.addEdge(3, 2);
    graph.addEdge(4, 3);
    graph.addEdge(0, 1);
    graph.print();
    graph.dfs(0);
    graph.dfsRecursive(0);
    graph.bfs(0);
    graph.topologicalSort();
  }

  private static boolean[] processNode(int node, boolean[] isVisited) {
    if (!isVisited[node]) {
      System.out.print(node + " => ");
      isVisited[node] = true;
    }
    return isVisited;
  }

  public void addEdge(int src, int dest) {
    if ((src >= 0 && src < vertices) && (dest >= 0 && dest < vertices)) {
      if (!adjMatrix[src][dest]) {
        adjMatrix[src][dest] = true;
        // adjMatrix[dest][src] = true;
      }
    }
  }

  public void removeEdge(int src, int dest) {
    if ((src >= 0 && src < vertices) && (dest >= 0 && dest < vertices)) {
      if (adjMatrix[src][dest]) {
        adjMatrix[src][dest] = false;
        // adjMatrix[dest][src] = false;
      }
    }
  }

  public boolean isEdge(int src, int dest) {
    if ((src >= 0 && src < vertices) && (dest >= 0 && dest < vertices)) {
      return (adjMatrix[src][dest] || adjMatrix[dest][src]);
    }
    return false;
  }

  public void dfs(int startNode) {
    Stack<Integer> stack = new Stack<>();
    System.out.println();
    System.out.println("DFS");
    boolean isVisited[] = new boolean[vertices];
    stack.push(startNode);

    while (!stack.isEmpty()) {
      int currentNode = stack.pop();
      isVisited = processNode(currentNode, isVisited);
      // Put currentNode's neighbour in stack
      for (int i = 0; i < vertices; i++) {
        if (adjMatrix[currentNode][i] && !isVisited[i]) {
          stack.push(i);
        }
      }
    }
  }

  private void bfs(int startNode) {
    Queue<Integer> queue = new LinkedList<>();
    System.out.println();
    System.out.println("BFS");
    boolean isVisited[] = new boolean[vertices];
    queue.add(startNode);

    while (!queue.isEmpty()) {
      int currentNode = queue.remove();
      isVisited = processNode(currentNode, isVisited);
      // Put currentNode's neighbour in stack
      for (int i = 0; i < vertices; i++) {
        if (adjMatrix[currentNode][i] && !isVisited[i]) {
          queue.add(i);
        }
      }
    }
  }

  private void dfsRecursive(int startNode) {
    boolean[] isVisited = new boolean[vertices];
    System.out.println();
    System.out.println("Recursive DFS");
    dfsUtils(startNode, isVisited);
  }

  private void topologicalSort() {
    boolean[] isVisited = new boolean[vertices];
    Stack<Integer> stack = new Stack<>();

    for (int vertex = 0; vertex < vertices; vertex++) {
      if (isVisited[vertex]) {
        continue;
      }
      topSortUtils(vertex, stack, isVisited);
    }

    System.out.println();
    System.out.println("Topological Sort");
    for (int v : stack) {
      System.out.print(v + " ");
    }
  }

  private void topSortUtils(int vertex, Stack<Integer> stack, boolean[] isVisited) {
    isVisited[vertex] = true;

    for (int childVertex = 0; childVertex < vertices; childVertex++) {
      if (adjMatrix[vertex][childVertex]) {
        if (isVisited[childVertex]) {
          continue;
        }
        topSortUtils(childVertex, stack, isVisited);
      }
    }

    stack.push(vertex);
  }

  private void dfsUtils(int currentNode, boolean[] isVisited) {
    System.out.print(currentNode + " => ");
    isVisited[currentNode] = true;
    for (int i = 0; i < vertices; i++) {
      if (adjMatrix[currentNode][i] && !isVisited[i]) {
        dfsUtils(i, isVisited);
      }
    }
  }

  public void print() {
    for (int i = -1; i < vertices; i++) {
      for (int j = -1; j < vertices; j++) {
        if (i == -1 && j == -1) {
          System.out.print("  ");
          continue;
        }
        if (i == -1) {
          System.out.print(j + " ");
          continue;
        }
        if (j == -1) {
          System.out.print(i + " ");
          continue;
        }
        System.out.print(adjMatrix[i][j] ? "1 " : "0" + " ");
      }
      System.out.println();
    }
  }
}
