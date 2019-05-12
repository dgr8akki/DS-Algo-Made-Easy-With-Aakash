class Solution {
  class UF {
    int[] parent;
    int[] size;
    int max;

    public UF(int N) {
      parent = new int[N];
      size = new int[N];
      max = 1;
      for (int i = 0; i < N; i++) {
        parent[i] = i;
        size[i] = 1;
      }
    }

    public int find(int x) {
      if (x == parent[x]) {
        return x;
      }
      return parent[x] = find(parent[x]);
    }

    public void union(int x, int y) {
      int rootX = find(x);
      int rootY = find(y);
      if (rootX != rootY) {
        parent[rootX] = rootY;
        size[rootY] += size[rootX];
        max = Math.max(max, size[rootY]);
      }
    }
  }

  public int largestComponentSize(int[] A) {
    int N = A.length;
    Map<Integer, Integer> map = new HashMap<>();
    UF uf = new UF(N);
    for (int i = 0; i < N; i++) {
      int a = A[i];
      for (int j = 2; j * j <= a; j++) {
        if (a % j == 0) {
          if (!map.containsKey(j)) {
            map.put(j, i);
          } else {
            uf.union(i, map.get(j));
          }
          if (!map.containsKey(a / j)) {
            map.put(a / j, i);
          } else {
            uf.union(i, map.get(a / j));
          }
        }
      }
      if (!map.containsKey(a)) {
        map.put(a, i);
      } else {
        uf.union(i, map.get(a));
      }
    }
    return uf.max;
  }
}
/*
 * class Solution { public int largestComponentSize(int[] A) { int n = A.length;
 * List<List<Integer>> adjacencyList = new ArrayList<>(); for(int i = 0; i < n;
 * i++) adjacencyList.add(new ArrayList<>());
 * 
 * for(int i = 0; i < n; i++) for(int j = i + 1; j < n; j++) if(hasEdge(A[j],
 * A[i])) { // System.out.println("True for: " + A[j] + " & " + A[i]);
 * adjacencyList.get(j).add(i); adjacencyList.get(i).add(j); }
 * 
 * Set<Set<Integer>> components = new HashSet<>();
 * 
 * boolean[] isVisited = new boolean[n]; for(int i = 0 ; i < n; i++) {
 * if(!isVisited[i]) { Set<Integer> component = new HashSet<>(); //DFS
 * dfsUtil(adjacencyList, i, isVisited, component); components.add(component); }
 * }
 * 
 * // return max Component int max = 0; for(Set<Integer> comp : components) max
 * = Math.max(max, comp.size()); return max; }
 * 
 * private static void dfsUtil(List<List<Integer>> adjacencyList, int start,
 * boolean[] isVisited, Set<Integer> component) { isVisited[start] = true;
 * component.add(start);
 * 
 * for(int neighbour : adjacencyList.get(start)) if(!isVisited[neighbour])
 * dfsUtil(adjacencyList, neighbour, isVisited, component); }
 * 
 * private static boolean hasEdge(int a, int b) { return gcd(a, b) > 1; }
 * 
 * public static int gcd(int a, int b) { if (b > a) return gcd(b, a); if (b ==
 * 0) return a; return gcd(b, a % b); } }
 * 
 */
