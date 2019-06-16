class Solution {
  public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
    Map<String, Map<String, Double>> map = new HashMap<>();
    for (int i = 0; i < values.length; i++) {
      map.putIfAbsent(equations.get(i).get(0), new HashMap<>());
      map.putIfAbsent(equations.get(i).get(1), new HashMap<>());
      map.get(equations.get(i).get(0)).put(equations.get(i).get(1), values[i]);
      map.get(equations.get(i).get(1)).put(equations.get(i).get(0), 1 / values[i]);
    }
    double[] result = new double[queries.size()];
    for (int i = 0; i < queries.size(); i++)
      result[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), 1, map, new HashSet<>());
    return result;
  }

  double dfs(String s, String t, double r, Map<String, Map<String, Double>> map, Set<String> visited) {
    if (!map.containsKey(s) || !visited.add(s))
      return -1;
    if (s.equals(t))
      return r;
    Map<String, Double> next = map.get(s);
    for (String c : next.keySet()) {
      double result = dfs(c, t, r * next.get(c), map, visited);
      if (result != -1)
        return result;
    }
    return -1;
  }
}
