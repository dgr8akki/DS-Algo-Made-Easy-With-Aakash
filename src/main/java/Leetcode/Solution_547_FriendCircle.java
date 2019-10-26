package Leetcode;

class Solution {
  public int findCircleNum(int[][] M) {
    int n = M.length;
    List<List<Integer>> adjacencyList = new ArrayList<>();
    for (int i = 0; i < n; i++)
      adjacencyList.add(new ArrayList<>());

    for (int i = 0; i < n; i++) {
      for (int j = i; j < n; j++) {
        if (M[i][j] == 1) {
          adjacencyList.get(i).add(j);
          adjacencyList.get(j).add(i);
        }
      }
    }

    Set<Set<Integer>> components = new HashSet<>();

    boolean[] isVisited = new boolean[n];
    for (int i = 0; i < n; i++) {
      if (!isVisited[i]) {
        Set<Integer> component = new HashSet<>();
        // DFS
        dfsUtil(adjacencyList, i, isVisited, component);
        components.add(component);
      }
    }

    return components.size();
  }

  private static void dfsUtil(List<List<Integer>> adjacencyList, int start, boolean[] isVisited,
      Set<Integer> component) {
    isVisited[start] = true;
    component.add(start);

    for (int neighbour : adjacencyList.get(start))
      if (!isVisited[neighbour])
        dfsUtil(adjacencyList, neighbour, isVisited, component);
  }
}
