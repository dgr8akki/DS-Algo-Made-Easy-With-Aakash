package DsAlgoMadeEasyInJava.Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GraphUsingAdjacencyList {

  private final int vertices;
  private final LinkedList<LinkedList<Integer>> adjList;

  private GraphUsingAdjacencyList(int verticesCount) {
    vertices = verticesCount;
    adjList = new LinkedList<>();
    for (int i = 0; i < verticesCount; i++) {
      adjList.add(new LinkedList<>());
    }
  }

  public static void main(String[] args) {
    GraphUsingAdjacencyList graph = new GraphUsingAdjacencyList(5);
    graph.addEdge(0, 2);
    graph.addEdge(1, 3);
    graph.addEdge(1, 4);
    graph.addEdge(3, 2);
    graph.addEdge(4, 3);
    graph.addEdge(2, 4);
    graph.removeEdge(2, 4);
    graph.print();
    graph.dfs(1);
    graph.dfsRecursive(1);
    graph.bfs(1);
    graph.topologicalSort();
    graph.unweightedShortestPath(1);
  }

  public void addEdge(int src, int dest) {
    adjList.get(src).add(dest);
    // adjList.get(dest).add(src);
  }

  private void removeEdge(int src, int dest) {
    adjList.get(src).remove((Object) dest);
    // adjList.get(dest).remove((Object)src);
  }

  public void dfs(int startNode) {
    boolean[] isvisited = new boolean[vertices];
    Stack<Integer> stack = new Stack<>();
    stack.push(startNode);
    System.out.println();
    System.out.println("DFS");

    while (!stack.isEmpty()) {
      int currentNode = stack.pop();
      if (!isvisited[currentNode]) {
        System.out.print(currentNode + " => ");
        isvisited[currentNode] = true;
      }

      for (int node : adjList.get(currentNode)) {
        if (!isvisited[node]) {
          stack.push(node);
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

  private void dfsUtils(int currentNode, boolean[] isVisited) {
    isVisited[currentNode] = true;
    System.out.print(currentNode + " => ");
    for (int node : adjList.get(currentNode)) {
      if (!isVisited[node]) {
        dfsUtils(node, isVisited);
      }
    }
  }

  public void print() {
    for (int index = 0; index < adjList.size(); index++) {
      for (int jindex = -1; jindex < adjList.get(index).size(); jindex++) {
        if (jindex == -1) {
          System.out.print(index + " => ");
          continue;
        }
        if (jindex == 0) {
          System.out.print(adjList.get(index).get(jindex));
          continue;
        }
        System.out.print(" , " + adjList.get(index).get(jindex));
      }
      System.out.println();
    }
  }

  private void bfs(int startNode) {
    boolean[] isVisited = new boolean[vertices];
    Queue<Integer> queue = new LinkedList<>();
    queue.add(startNode);
    System.out.println();
    System.out.println("BFS");
    while (!queue.isEmpty()) {
      int currentNode = queue.remove();
      if (!isVisited[currentNode]) {
        System.out.print(currentNode + " ");
        isVisited[currentNode] = true;
      }
      for (int node : adjList.get(currentNode)) {
        if (!isVisited[node]) {
          queue.add(node);
        }
      }
    }
  }

  private void topologicalSort() {
    boolean[] isVisited = new boolean[vertices];
    Stack<Integer> stack = new Stack<>();
    for (int currentVertex = 0; currentVertex < vertices; currentVertex++) {
      if (isVisited[currentVertex]) {
        continue;
      }
      topSortUtils(currentVertex, stack, isVisited);
    }
    System.out.println();
    System.out.println("Topological Sort");
    for (int v : stack) {
      System.out.print(v + " ");
    }
  }

  private void topSortUtils(int vertex, Stack<Integer> stack, boolean[] isVisited) {
    isVisited[vertex] = true;
    for (int childVertex : adjList.get(vertex)) {
      if (isVisited[childVertex]) {
        continue;
      }
      topSortUtils(childVertex, stack, isVisited);
    }
    stack.push(vertex);
  }

  private void unweightedShortestPath(int sourceNode) {
    Queue<Integer> queue = new LinkedList<>();
    int[] distance = new int[vertices];
    int[] path = new int[vertices];

    for (int i = 0; i < distance.length; i++) {
      distance[i] = -1;
    }
    distance[sourceNode] = 0;
    queue.add(sourceNode);

    while (!queue.isEmpty()) {
      int currentNode = queue.remove();
      for (int neighbour : adjList.get(currentNode)) {
        if (distance[neighbour] == -1) {
          distance[neighbour] = distance[currentNode] + 1;
          path[neighbour] = currentNode;
          queue.add(neighbour);
        }
      }
    }

    queue.clear();
    System.out.println("Shortest distance from node " + sourceNode + " to all other nodes is :");
    System.out.println(Arrays.toString(distance));
    System.out.println("With the help of below vertices");
    System.out.println(Arrays.toString(path));
  }
}
