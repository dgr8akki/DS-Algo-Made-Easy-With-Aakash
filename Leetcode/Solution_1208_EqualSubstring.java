class Solution_1208_EqualSubstring {
  public int equalSubstring(String s, String t, int maxCost) {
    int[] costs = new int[s.length()];

    for (int i = 0; i < s.length(); i++)
      costs[i] = Math.abs(s.charAt(i) - t.charAt(i));

    int result = 0;
    for (int i = 0; i < costs.length; i++) {
      int subresult = 1;
      int cost = costs[i];
      if (cost > maxCost)
        continue;
      int start = i;
      while ((cost <= maxCost) && (++start < costs.length) && (cost + costs[start]) <= maxCost) {
        cost += costs[start];
        subresult++;
      }
      result = Math.max(result, subresult);
    }
    return result;
  }
}
