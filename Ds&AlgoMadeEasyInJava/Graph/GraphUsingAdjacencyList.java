import java.util.*;

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
    // adjList.get(dest).add(src);
  }

  public void removeEdge(int src, int dest) {
    adjList.get(src).remove((Object)dest);
    // adjList.get(dest).remove((Object)src);
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

  public void bfs(int startNode) {
    boolean[] isVisited = new boolean[vertices];
    Queue<Integer> queue = new LinkedList<>();
    queue.add(startNode);
    System.out.println();
    System.out.println("BFS");
    while(!queue.isEmpty()){
      int currentNode = queue.remove();
      if(!isVisited[currentNode]) {
        System.out.print(currentNode + " ");
        isVisited[currentNode] = true;
      }
      for(int node : adjList.get(currentNode))
        if(!isVisited[node])
          queue.add(node);
    }
  }

  public void topologicalSort() {
    boolean[] isVisited = new boolean[vertices];
    Stack<Integer> stack = new Stack<>();
    for(int currentVertex = 0; currentVertex < vertices; currentVertex++) {
      if(isVisited[currentVertex]) continue;
      topSortUtils(currentVertex, stack, isVisited);
    }
    System.out.println();
    System.out.println("Topological Sort");
    for (int v : stack)
      System.out.print(v + " ");
  }

  private void topSortUtils(int vertex, Stack<Integer> stack, boolean[] isVisited) {
    isVisited[vertex] = true;
    for(int childVertex :  adjList.get(vertex)) {
      if(isVisited[childVertex]) continue;
      topSortUtils(childVertex, stack, isVisited);
    }
    stack.push(vertex);
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
  }
}
