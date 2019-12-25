package DsAlgoMadeEasyInJava.Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class GraphNode {
  int node;
  int distance;

  GraphNode(int node, int distance) {
    this.node = node;
    this.distance = distance;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (getClass() != o.getClass()) {
      return false;
    }
    GraphNode graphNode = (GraphNode) o;

    if (node == graphNode.node && distance == graphNode.distance) {
      return true;
    }
    return false;
  }
}

class Graph {
  private final int vertices;
  private final int[][] adjMatrix;

  private Graph(int vertices) {
    this.vertices = vertices;
    adjMatrix = new int[vertices][vertices];
  }

  public static void main(String[] args) {
    Graph graph = new Graph(5);
    graph.addEdge(2, 3, 1);
    graph.addEdge(0, 2, 1);
    graph.addEdge(0, 3, 1);
    graph.addEdge(1, 3, 1);
    graph.addEdge(1, 4, 1);
    graph.addEdge(3, 2, 1);
    graph.addEdge(4, 3, 1);
    graph.addEdge(0, 1, 1);
    graph.print();
    graph.dijkstra(1);
    graph.bellmanFord(1);
  }

  public void addEdge(int src, int dest, int weight) {
    if ((src >= 0 && src < vertices) && (dest >= 0 && dest < vertices)) {
      adjMatrix[src][dest] = weight;
    }
  }

  public void removeEdge(int src, int dest) {
    if ((src >= 0 && src < vertices) && (dest >= 0 && dest < vertices)) {
      adjMatrix[src][dest] = 0;
    }
  }

  public boolean isEdge(int src, int dest) {
    if ((src >= 0 && src < vertices) && (dest >= 0 && dest < vertices)) {
      return (adjMatrix[src][dest] > 0);
    }
    return false;
  }

  private void dijkstra(int source) {
    int[] distance = new int[vertices];
    int[] parent = new int[vertices];
    PriorityQueue<GraphNode> queue = new PriorityQueue<>(10, (a, b) -> a.distance - b.distance);
    for (int i = 0; i < vertices; i++) {
      distance[i] = Integer.MAX_VALUE;
    }
    boolean[] isVisited = new boolean[vertices];
    distance[source] = 0;
    parent[source] = -1;
    queue.add(new GraphNode(source, distance[source]));

    while (!queue.isEmpty()) {
      GraphNode currentNode = queue.poll();
      isVisited[currentNode.node] = true;

      for (int i = 0; i < vertices; i++) {
        if (adjMatrix[currentNode.node][i] != 0 && !isVisited[i]) {
          int newNeighbourDistance = distance[currentNode.node] + adjMatrix[currentNode.node][i];
          GraphNode neighbourNode = new GraphNode(i, distance[i]);

          if (newNeighbourDistance < distance[i]) {
            distance[i] = newNeighbourDistance;
            parent[i] = currentNode.node;
            queue.remove(neighbourNode);
            neighbourNode.distance = newNeighbourDistance;
            queue.add(neighbourNode);
          }
        }
      }
    }

    queue.clear();
    System.out.println(
        "Shortest distance from node " + source + " using Dijkstra, to all other nodes is :");
    System.out.println(Arrays.toString(distance));
    System.out.println("With the help of below vertices");
    System.out.println(Arrays.toString(parent));
  }

  private void bellmanFord(int source) {
    int[] distance = new int[vertices];
    int[] parent = new int[vertices];
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < vertices; i++) {
      distance[i] = Integer.MAX_VALUE;
    }
    distance[source] = 0;
    parent[source] = -1;
    queue.add(source);

    while (!queue.isEmpty()) {
      int currentNode = queue.poll();

      for (int i = 0; i < vertices; i++) {
        if (adjMatrix[currentNode][i] != 0) {
          int newNeighbourDistance = distance[currentNode] + adjMatrix[currentNode][i];

          if (newNeighbourDistance < distance[i]) {
            distance[i] = newNeighbourDistance;
            parent[i] = currentNode;
            if (!queue.contains(i)) {
              queue.add(i);
            }
          }
        }
      }
    }

    queue.clear();
    System.out.println(
        "Shortest distance from node " + source + " using BellmanFord, to all other nodes is :");
    System.out.println(Arrays.toString(distance));
    System.out.println("With the help of below vertices");
    System.out.println(Arrays.toString(parent));
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
        System.out.print(adjMatrix[i][j] + " ");
      }
      System.out.println();
    }
  }
}
