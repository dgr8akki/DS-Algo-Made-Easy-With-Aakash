import java.util.*;

/**
 * Dominoes
 */
public class Dominoes {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    while (t-- > 0) {
      int n = in.nextInt();
      int m = in.nextInt();
      List<List<Integer>> adjacencyList = new ArrayList<>(n);
      List<List<Integer>> adjacencyListTransposed = new ArrayList<>(n);
      for (int i = 0; i < n; i++) {
        adjacencyList.add(new ArrayList<>());
        adjacencyListTransposed.add(new ArrayList<>());
      }
      while (m-- > 0) {
        int x = in.nextInt();
        int y = in.nextInt();
        adjacencyList.get(x - 1).add(y - 1);
        adjacencyListTransposed.get(y - 1).add(x - 1);
      }
      // print(adjacencyList);
      // print(adjacencyListTransposed);
      // solve(adjacencyList, adjacencyListTransposed, n);
      System.out.println(solve(adjacencyList, adjacencyListTransposed, n));
    }
    in.close();
  }

  private static void print(List<List<Integer>> adjList) {
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

  private static int solve(List<List<Integer>> adjacencyList, List<List<Integer>> adjacencyListTransposed, int n) {
    Set<Integer> visited = new HashSet<>();
    // print(adjacencyListTransposed);
    Stack<Integer> finishedVertices = new Stack<>();
    Set<Set<Integer>> components = new HashSet<>();
    for (int i = 0; i < n; i++)
      if (!visited.contains(i))
        dfsUtil(adjacencyList, n, visited, finishedVertices, i);

    visited.clear();
    while (!finishedVertices.empty()) {
      int current = finishedVertices.pop();
      if (!visited.contains(current)) {
        Set<Integer> component = new HashSet<>();
        // System.out.println(current);
        dfsUtil2(adjacencyListTransposed, current, visited, n, component);
        // System.out.println(component.size());
        components.add(component);
      }
    }
    return components.size();
  }

  private static void dfsUtil2(List<List<Integer>> adjacencyListTransposed, int start, Set<Integer> visited, int n,
      Set<Integer> component) {
    visited.add(start);
    component.add(start);
    // System.out.println("Component: " + Arrays.toString(component.toArray()));
    for (int neighbour : adjacencyListTransposed.get(start)) {
      if (!visited.contains(neighbour))
        dfsUtil2(adjacencyListTransposed, neighbour, visited, n, component);
    }
  }

  private static void dfsUtil(List<List<Integer>> adjacencyList, int n, Set<Integer> visited,
      Stack<Integer> finishedVertices, int start) {
    visited.add(start);
    for (int neighbour : adjacencyList.get(start)) {
      if (!visited.contains(neighbour))
        dfsUtil(adjacencyList, n, visited, finishedVertices, neighbour);
    }
    finishedVertices.push(start);
  }
}
