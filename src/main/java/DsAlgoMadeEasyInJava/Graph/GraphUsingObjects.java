package DsAlgoMadeEasyInJava.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GraphUsingObjects {
  private final int verticesCount;
  private final ArrayList<Vertex> vertices;
  private GraphUsingObjects(int verticesCount) {
    this.verticesCount = verticesCount;
    vertices = new ArrayList<>();

    for (int i = 0; i < verticesCount; i++) {
      vertices.add(new Vertex(i));
    }
  }

  public static void main(String[] args) {
    GraphUsingObjects graph = new GraphUsingObjects(5);
    graph.addEdge(1, 2);
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
  }

  private Vertex getNodeVertex(int data) {
    for (Vertex current : vertices) {
      if (current.data == data) {
        return current;
      }
    }
    return null;
  }

  public void addEdge(int src, int dest) {
    vertices.get(src).neighbours.add(new Vertex(dest));
    vertices.get(dest).neighbours.add(new Vertex(src));
  }

  private void removeEdge(int src, int dest) {
    vertices.get(src).neighbours.remove(getNodeVertex(dest));
    vertices.get(dest).neighbours.remove(getNodeVertex(src));
  }

  public void print() {
    for (int index = 0; index < vertices.size(); index++) {
      for (int jindex = -1; jindex < vertices.get(index).neighbours.size(); jindex++) {
        if (jindex == -1) {
          System.out.print(index + " => ");
          continue;
        }
        if (jindex == 0) {
          System.out.print(vertices.get(index).neighbours.get(jindex).data);
          continue;
        }
        System.out.print(" , " + vertices.get(index).neighbours.get(jindex).data);
      }
      System.out.println();
    }
  }

  private void bfs(int data) {
    System.out.println();
    System.out.println("BFS");
    Vertex startNode = getNodeVertex(data);
    Queue<Vertex> queue = new LinkedList<>();
    boolean[] isVisited = new boolean[verticesCount];
    queue.add(startNode);

    while (!queue.isEmpty()) {
      Vertex currentNode = queue.remove();
      if (!isVisited[currentNode.data]) {
        System.out.print(currentNode.data + " => ");
        isVisited[currentNode.data] = true;
      }

      for (Vertex node : currentNode.neighbours) {
        if (!isVisited[node.data]) {
          queue.add(node);
        }
      }
    }
  }

  public void dfs(int data) {
    System.out.println();
    System.out.println("DFS");
    Vertex startNode = getNodeVertex(data);
    Stack<Vertex> stack = new Stack<>();
    boolean[] isVisited = new boolean[verticesCount];
    stack.push(startNode);

    while (!stack.isEmpty()) {
      Vertex currentNode = stack.pop();
      if (!isVisited[currentNode.data]) {
        System.out.print(currentNode.data + " => ");
        isVisited[currentNode.data] = true;
      }

      for (Vertex node : currentNode.neighbours) {
        if (!isVisited[node.data]) {
          stack.push(node);
        }
      }
    }
  }

  private void dfsRecursive(int data) {
    Vertex startNode = getNodeVertex(data);
    boolean[] isVisited = new boolean[verticesCount];
    System.out.println();
    System.out.println("Recursive DFS");
    dfsUtils(startNode, isVisited);
  }

  private void dfsUtils(Vertex currentNode, boolean[] isVisited) {
    System.out.print(currentNode.data + " => ");
    isVisited[currentNode.data] = true;

    for (Vertex node : currentNode.neighbours) {
      if (!isVisited[node.data]) {
        dfsUtils(node, isVisited);
      }
    }
  }

  class Vertex {
    int data;
    ArrayList<Vertex> neighbours;

    Vertex(int data) {
      this.data = data;
      neighbours = new ArrayList<>();
    }
  }
}
