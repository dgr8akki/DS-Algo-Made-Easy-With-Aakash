import java.util.*;

/**
 * PermutationSwaps
 */
public class PermutationSwaps {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    while (t-- > 0) {
      int n = in.nextInt();
      int e = in.nextInt();
      List<List<Integer>> adjacencyList = new ArrayList<>();
      for (int i = 0; i < n; i++)
        adjacencyList.add(new ArrayList<>());

      int[] p = new int[n];
      int[] q = new int[n];

      for (int i = 0; i < n; i++)
        p[i] = in.nextInt();
      for (int i = 0; i < n; i++)
        q[i] = in.nextInt();
      for (int i = 0; i < e; i++) {
        int s = in.nextInt();
        int end = in.nextInt();
        adjacencyList.get(s - 1).add(end - 1);
        adjacencyList.get(end - 1).add(s - 1);
      }

      System.out.println(solve(adjacencyList, p, q, n));
    }
    in.close();
  }

  private static String solve(List<List<Integer>> adjacencyList, int[] p, int[] q, int n) {
    Set<Set<Integer>> components = new HashSet<>();

    boolean[] isVisited = new boolean[n];
    for(int i = 0 ; i < n; i++) {
      if(!isVisited[i]) {
        Set<Integer> component = new HashSet<>();
        dfsUtil(adjacencyList, i, isVisited, component);
        components.add(component);
      }
    }

    for(Set<Integer> comp : components) {
      Set<Integer> temp = new HashSet<>();
      for(int com : comp) {
        temp.add(p[com]);
      }
      for(int com : comp) {
        if(!temp.contains(q[com]))
          return "NO";
      }
    }
    return "YES";
  }

  private static void dfsUtil(List<List<Integer>> adjacencyList, int start, boolean[] isVisited, Set<Integer> component) {
    isVisited[start] = true;
    component.add(start);

    for(int neighbour : adjacencyList.get(start))
      if(!isVisited[neighbour])
        dfsUtil(adjacencyList, neighbour, isVisited, component);
  }
}
