import java.util.*;

/**
 * ConnectedComponents
 */
public class ConnectedComponents {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    List<List<Integer>> adjacencyList = new ArrayList<>();
    for(int i = 0; i < n; i++)
      adjacencyList.add(new ArrayList<>());

    int e = in.nextInt();
    while(e-- > 0) {
      int s = in.nextInt();
      int end = in.nextInt();
      adjacencyList.get(s).add(end);
      adjacencyList.get(end).add(s);
    }
    in.close();

    Set<Set<Integer>> components = new HashSet<>();

    boolean[] isVisited = new boolean[n];
    for(int i = 0 ; i < n; i++) {
      if(!isVisited[i]) {
        Set<Integer> component = new HashSet<>();
        //DFS
        dfsUtil(adjacencyList, i, isVisited, component);
        components.add(component);
      }
    }

    System.out.println(components.size());
    // PRINT Components
    for(Set<Integer> comp : components) {
      for(int com : comp)
        System.out.print(com + " ");
      System.out.println();
    }
  }

  private static void dfsUtil(List<List<Integer>> adjacencyList, int start, boolean[] isVisited, Set<Integer> component) {
    isVisited[start] = true;
    component.add(start);

    for(int neighbour : adjacencyList.get(start))
      if(!isVisited[neighbour])
        dfsUtil(adjacencyList, neighbour, isVisited, component);
  }
}
