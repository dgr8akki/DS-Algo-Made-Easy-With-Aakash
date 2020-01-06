class Solution_1202_SmallestStringSwap {
  private int[] parent;

  public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
    if (s == null || s.length() == 0) {
      return null;
    }
    parent = new int[s.length()];
    for (int i = 0; i < parent.length; i++) {
      parent[i] = i;
    }

    for (List<Integer> pair : pairs) {
      union(pair.get(0), pair.get(1));
    }

    Map<Integer, PriorityQueue<Character>> map = new HashMap<>();
    char[] sChar = s.toCharArray();
    for (int i = 0; i < sChar.length; i++) {
      int root = find(i);
      map.putIfAbsent(root, new PriorityQueue<>());
      map.get(root).offer(sChar[i]);
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < sChar.length; i++) {
      sb.append(map.get(find(i)).poll());
    }
    return sb.toString();
  }

  private int find(int index) {
    while (parent[index] != index) {
      parent[index] = parent[parent[index]];
      index = parent[index];
    }
    return index;
  }

  private void union(int a, int b) {
    int aParent = find(a);
    int bParent = find(b);
    if (aParent < bParent) {
      parent[bParent] = aParent;
    } else {
      parent[aParent] = bParent;
    }
  }
}
