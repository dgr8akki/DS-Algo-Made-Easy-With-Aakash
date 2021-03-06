package CodingNinjas.AdvanceGraphs;

import java.util.*;

/**
 * Bottom
 */
public class Bottom {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    while (true) {
      int n = in.nextInt();
      if (n == 0) {
        break;
      }
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
      solve(adjacencyList, adjacencyListTransposed, n);
    }
    in.close();
  }

  private static void solve(List<List<Integer>> adjacencyList, List<List<Integer>> adjacencyListTransposed, int n) {
    Set<Integer> visited = new HashSet<>();
    Stack<Integer> finishedVertices = new Stack<>();
    Set<Set<Integer>> components = new HashSet<>();
    for (int i = 0; i < n; i++) {
      if (!visited.contains(i)) {
        dfsUtil(adjacencyList, n, visited, finishedVertices, i);
      }
    }

    visited.clear();
    while (!finishedVertices.empty()) {
      int current = finishedVertices.pop();
      if (!visited.contains(current)) {
        Set<Integer> component = new HashSet<>();
        dfsUtil2(adjacencyListTransposed, current, visited, n, component);
        components.add(component);
      }
    }
    printBottom(components, adjacencyList);
  }

  private static void printBottom(Set<Set<Integer>> components, List<List<Integer>> adjacencyList) {
    Set<Integer> answer = new TreeSet<>();
    boolean include = true;
    for (Set<Integer> component : components) {
      include = true;
      for (int node : component) {
        for (int neighbour : adjacencyList.get(node)) {
          if (!component.contains(neighbour)) {
            include = false;
          }
        }
      }
      if (include) {
        answer.addAll(component);
      }
    }

    if (answer.size() > 0) {
      for (int node : answer) {
        System.out.print((node + 1) + " ");
      }
    } else {
      System.out.println();
    }
    System.out.println();
  }

  private static void dfsUtil2(List<List<Integer>> adjacencyListTransposed, int start, Set<Integer> visited, int n,
                               Set<Integer> component) {
    visited.add(start);
    component.add(start);
    for (int neighbour : adjacencyListTransposed.get(start)) {
      if (!visited.contains(neighbour)) {
        dfsUtil2(adjacencyListTransposed, neighbour, visited, n, component);
      }
    }
  }

  private static void dfsUtil(List<List<Integer>> adjacencyList, int n, Set<Integer> visited,
                              Stack<Integer> finishedVertices, int start) {
    visited.add(start);
    for (int neighbour : adjacencyList.get(start)) {
      if (!visited.contains(neighbour)) {
        dfsUtil(adjacencyList, n, visited, finishedVertices, neighbour);
      }
    }
    finishedVertices.push(start);
  }
}
