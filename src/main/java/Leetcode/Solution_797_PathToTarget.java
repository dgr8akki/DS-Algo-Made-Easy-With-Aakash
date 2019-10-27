package Leetcode;

class Solution_797_PathToTarget {
  public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
    List<List<Integer>> paths = new ArrayList<>();
    List<Integer> path = new ArrayList<>(Arrays.asList(0));
    dfs(0, path, paths, graph);
    return paths;
  }

  private void dfs(int node, List<Integer> path, List<List<Integer>> paths, int[][] graph) {
    if (node == (graph.length - 1)) {
      paths.add(new ArrayList<>(path));
      return;
    }
    for (int neighbor : graph[node]) {
      path.add(neighbor);
      dfs(neighbor, path, paths, graph);
      path.remove(path.size() - 1);
    }
  }
}
