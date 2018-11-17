import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class GraphUsingAdjacencyList {

  private int vertices;
  private LinkedList<LinkedList<Integer>> adjList;

  GraphUsingAdjacencyList(int verticesCount) {
    this.vertices = verticesCount;
    this.adjList = new LinkedList<LinkedList<Integer>>();
    for(int i = 0; i < verticesCount; i++) {
      adjList.add(new LinkedList<>());
    }
  }

  public void addEdge(int src, int dest) {
    adjList.get(src).add(dest);
    adjList.get(dest).add(src);
  }

  public void removeEdge(int src, int dest) {
    adjList.get(src).remove((Object)dest);
    adjList.get(dest).remove((Object)src);
  }

  public void dfs(int startNode) {
    boolean isvisited[] = new boolean[vertices];
    Stack<Integer> stack = new Stack<>();
    stack.push(startNode);
    System.out.println();
    System.out.println("DFS");

    while(!stack.isEmpty()) {
      int currentNode = stack.pop();
      if(!isvisited[currentNode]) {
        System.out.print(currentNode + " => ");
        isvisited[currentNode] = true;
      }

      for(int node : adjList.get(currentNode))
        if(!isvisited[node]) stack.push(node);
    }
  }

  public void dfsRecursive(int startNode) {
    boolean[] isVisited = new boolean[vertices];
    System.out.println();
    System.out.println("Recursive DFS");
    dfsUtils(startNode, isVisited);
  }

  private void dfsUtils(int currentNode, boolean[] isVisited) {
    isVisited[currentNode] = true;
    System.out.print(currentNode + " => ");
    for(int node : adjList.get(currentNode))
      if(!isVisited[node])
        dfsUtils(node, isVisited);
  }

  public void print() {
    for(int index = 0; index < adjList.size(); index++) {
      for(int jindex = -1; jindex < adjList.get(index).size(); jindex++) {
        if(jindex == -1) {
          System.out.print(index + " => ");
          continue;
        }
        if(jindex == 0) {
          System.out.print(adjList.get(index).get(jindex));
          continue;
        }
        System.out.print(" , " + adjList.get(index).get(jindex));
      }
      System.out.println();
    }
  }
  public static void main(String[] args) {
    GraphUsingAdjacencyList graph = new GraphUsingAdjacencyList(5);
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
  }
}
