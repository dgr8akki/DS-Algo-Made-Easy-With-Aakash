package CodingNinjas.AdvanceGraphs;

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
      for (int i = 0; i < n; i++) {
        adjacencyList.add(new ArrayList<>());
      }
      while (m-- > 0) {
        int x = in.nextInt();
        int y = in.nextInt();
        adjacencyList.get(x - 1).add(y - 1);
      }
      System.out.println(solve(adjacencyList, n));
    }
    in.close();
  }

  private static int solve(List<List<Integer>> adjacencyList, int n) {
    int count = 0;
    Set<Integer> visited = new HashSet<>();
    Stack<Integer> finishedVertices = new Stack<>();
    for (int i = 0; i < n; i++) {
      if (!visited.contains(i)) {
        dfsUtil(adjacencyList, n, visited, finishedVertices, i);
      }
    }

    visited.clear();
    while (!finishedVertices.empty()) {
      int current = finishedVertices.pop();
      if (!visited.contains(current)) {
        dfsUtil2(adjacencyList, current, visited, n);
        count++;
      }
    }
    return count;
  }

  private static void dfsUtil2(List<List<Integer>> adjacencyList, int start, Set<Integer> visited, int n) {
    visited.add(start);
    for (int neighbour : adjacencyList.get(start)) {
      if (!visited.contains(neighbour)) {
        dfsUtil2(adjacencyList, neighbour, visited, n);
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
