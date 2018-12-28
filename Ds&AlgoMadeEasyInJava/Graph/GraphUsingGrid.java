import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class GraphUsingGrid {

  static class Location {
    int x;
    int y;

    Location(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
  int vertices;
  int[][] graph;

  GraphUsingGrid(int vertices) {
    this.vertices = vertices;
    graph = new int[vertices][vertices];
  }

  public void print() {
    for(int i = 0; i < vertices; i++) {
      for(int j = 0; j < vertices; j++)
        System.out.print(graph[i][j] + " ");
      System.out.println();
    }
  }

    public void print(String[][] m) {
    for(int i = 0; i < vertices; i++) {
      for(int j = 0; j < vertices; j++)
        System.out.print(m[i][j] + " ");
      System.out.println();
    }
  }

  public void addEdge (int row, int col) {
    graph[row][col] = 1;
  }

  public void initializeGraph (int[][] graph) {
    this.graph = graph;
  }

  public void removeEdge (int row, int col) {
    graph[row][col] = 0;
  }

  public void dfs (Location startLocation) {
    int[] xOffset = {0,1,0,-1};
    int[] yOffset = {-1,0,1,0};
    Stack<Location> stack = new Stack<>();
    boolean[][] isVisited = new boolean[vertices][vertices];
    stack.push(startLocation);

    while(!stack.isEmpty()) {
      Location currenLocation = stack.pop();

      if(!isVisited[currenLocation.x][currenLocation.y]) {
        System.out.print("("+currenLocation.x + "," + currenLocation.y+") => ");
        isVisited[currenLocation.x][currenLocation.y] = true;
      }

      for(int i = 0; i < xOffset.length; i++) {
        if(isValid(currenLocation.x + xOffset[i], currenLocation.y + yOffset[i], isVisited))
          stack.push(new Location(currenLocation.x + xOffset[i], currenLocation.y + yOffset[i]));
      }
    }
  }

  public void dfsPathToDestination (Location startLocation, Location destLocation) {
    if(isSame(startLocation, destLocation))
      System.out.println("Destination is same as starting location");
    int[] xOffset = {0,1,0,-1};
    int[] yOffset = {-1,0,1,0};
    Stack<Location> stack = new Stack<>();
    boolean[][] isVisited = new boolean[vertices][vertices];
    stack.push(startLocation);

    while(!stack.isEmpty()) {
      Location currenLocation = stack.pop();
      if(isSame(currenLocation, destLocation)) {
        System.out.print("("+currenLocation.x + "," + currenLocation.y+") Destination Reached");
        return;
      }
      if(!isVisited[currenLocation.x][currenLocation.y]) {
        System.out.print("("+currenLocation.x + "," + currenLocation.y+") => ");
        isVisited[currenLocation.x][currenLocation.y] = true;
      }

      for(int i = 0; i < xOffset.length; i++) {
        if(isValid(currenLocation.x + xOffset[i], currenLocation.y + yOffset[i], isVisited))
          stack.push(new Location(currenLocation.x + xOffset[i], currenLocation.y + yOffset[i]));
      }
    }
  }

  private boolean isSame(Location a, Location b) {
    return a.x == b.x && a.y == b.y;
  }

  public void dfsRecursive (Location startLocation) {
    int[] xOffset = {0,1,0,-1};
    int[] yOffset = {-1,0,1,0};
    boolean[][] isVisited = new boolean[vertices][vertices];
    dfsUtil(startLocation, isVisited, xOffset, yOffset);
  }

  private void dfsUtil(Location currenLocation, boolean[][] isVisited, int[] xOffset, int[] yOffset) {
    System.out.print("("+currenLocation.x + "," + currenLocation.y+") => ");
    isVisited[currenLocation.x][currenLocation.y] = true;
    for(int i = 0; i < xOffset.length; i++)
      if(isValid(currenLocation.x + xOffset[i], currenLocation.y + yOffset[i], isVisited))
        dfsUtil(new Location(currenLocation.x + xOffset[i], currenLocation.y + yOffset[i]), isVisited, xOffset, yOffset);
  }

  public void bfs (Location startLocation) {
    int[] xOffset = {0,1,0,-1};
    int[] yOffset = {-1,0,1,0};
    Queue<Location> queue = new LinkedList<>();
    boolean[][] isVisited = new boolean[vertices][vertices];
    queue.add(startLocation);

    while(!queue.isEmpty()) {
      Location currenLocation = queue.remove();

      if(!isVisited[currenLocation.x][currenLocation.y]) {
        System.out.print("("+currenLocation.x + "," + currenLocation.y+") => ");
        isVisited[currenLocation.x][currenLocation.y] = true;
      }

      for(int i = 0; i < xOffset.length; i++) {
        if(isValid(currenLocation.x + xOffset[i], currenLocation.y + yOffset[i], isVisited))
          queue.add(new Location(currenLocation.x + xOffset[i], currenLocation.y + yOffset[i]));
      }
    }
  }

  public void bfsPathToDestination (Location startLocation, Location destLocation) {
    if(isSame(startLocation, destLocation))
      System.out.println("Destination is same as starting location");
    int[] xOffset = {0,1,0,-1};
    int[] yOffset = {-1,0,1,0};
    String[][] results = new String[vertices][vertices];
    for(int i = 0; i < vertices; i++)
      for(int j = 0; j < vertices; j++)
        results[i][j] = Integer.toString(graph[i][j]);

    Location[][] parentOfPosition = new Location[vertices][vertices];
    parentOfPosition[startLocation.x][startLocation.y] = null;
    Queue<Location> queue = new LinkedList<>();
    boolean[][] isVisited = new boolean[vertices][vertices];
    queue.add(startLocation);
    while(!queue.isEmpty()) {
      Location currenLocation = queue.remove();
      if(isSame(currenLocation, destLocation)) {
        // results[startLocation.x][startLocation.y] = "S";
        System.out.println(printPath(results, parentOfPosition, destLocation));
        results[currenLocation.x][currenLocation.y] = "D";
        print(results);
        // System.out.print("("+currenLocation.x + "," + currenLocation.y+") Destination Reached");
        return;
      }
      if(!isVisited[currenLocation.x][currenLocation.y]) {
        // results[currenLocation.x][currenLocation.y] = "#";
        // System.out.print("("+currenLocation.x + "," + currenLocation.y+") => ");
        isVisited[currenLocation.x][currenLocation.y] = true;
      }

      for(int i = 0; i < xOffset.length; i++) {
        if(isValid(currenLocation.x + xOffset[i], currenLocation.y + yOffset[i], isVisited)) {
          queue.add(new Location(currenLocation.x + xOffset[i], currenLocation.y + yOffset[i]));
          parentOfPosition[currenLocation.x + xOffset[i]][currenLocation.y + yOffset[i]] = currenLocation;
        }
      }
    }
  }

  private String printPath(String[][] result, Location[][] mat, Location end) {
    if (mat[end.x][end.y] == null) {
      result[end.x][end.y] = "S";
      return "[ " + end.x + " , " + end.y + "]";
    }
    
    result[end.x][end.y] = "#";
    return printPath(result, mat, mat[end.x][end.y]) + ", [ " + end.x + " , " + end.y + " ]";
  }

  private boolean isValid(int x, int y, boolean[][] isVisited) {
    return x >= 0 && x < vertices && y < vertices && y >= 0 && graph[x][y] == 1 && !isVisited[x][y];
  }

  public static void main(String[] args) {
    GraphUsingGrid graph = new GraphUsingGrid(10);
    int[][] g =
    {
        { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
        { 1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
        { 1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
        { 0, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
        { 1, 1, 1, 0, 1, 1, 1, 0, 1, 0 },
        { 1, 0, 1, 1, 1, 1, 0, 1, 0, 0 },
        { 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
        { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
        { 1, 1, 0, 0, 0, 0, 1, 0, 0, 1 },
        { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 }
    };
    graph.initializeGraph(g);
    graph.print();
    System.out.println("***************DFS*****************");
    graph.dfs(new Location(0, 0));
    System.out.println("****************BFS****************");
    graph.bfs(new Location(0, 0));
    System.out.println("****************DFS Recursive****************");
    graph.dfsRecursive(new Location(0, 0));
    System.out.println("****************DFS PathToDestination****************");
    graph.dfsPathToDestination(new Location(0, 0), new Location(4, 6));
    System.out.println("****************BFS PathToDestination****************");
    graph.bfsPathToDestination(new Location(0, 0), new Location(4, 6));
  }
}
