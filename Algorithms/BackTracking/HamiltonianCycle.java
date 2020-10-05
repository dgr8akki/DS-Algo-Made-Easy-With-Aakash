package Algorithms.BackTracking;

public class HamiltonianCycle {
  private final int[][] graph;
  private final int[] hamiltonianPath;
  private final int totalVertex;

  private HamiltonianCycle(int[][] g) {
    graph = g;
    hamiltonianPath = new int[g.length];
    totalVertex = g.length;
  }

  public static void main(String[] args) {
    int[][] graph = { { 0, 1, 1, 1, 0, 0 }, { 1, 0, 1, 0, 1, 0 }, { 1, 1, 1, 1, 0, 1 }, { 1, 0, 1, 0, 0, 1 },
        { 0, 1, 0, 0, 0, 1 }, { 0, 1, 1, 1, 1, 1 } };
    HamiltonianCycle cycle = new HamiltonianCycle(graph);

    cycle.solve(0);
    cycle.solve(1);
    cycle.solve(2);
  }

  public void solve(int source) {
    hamiltonianPath[0] = source;

    if (containsFeasibleSolutionFrom(1)) {
      printSolution();
    } else {
      System.out.println("Given graph contains no Hamiltonian cycle from source vertex as: " + source);
    }
  }

  private boolean containsFeasibleSolutionFrom(int currentHamiltonianPathArrayIndex) {
    if (currentHamiltonianPathArrayIndex == totalVertex) {
      return isEdge(hamiltonianPath[currentHamiltonianPathArrayIndex - 1], hamiltonianPath[0]);
    }

    for (int vertex = 0; vertex < totalVertex; vertex++) {
      if (isFeasible(vertex, currentHamiltonianPathArrayIndex)) {
        hamiltonianPath[currentHamiltonianPathArrayIndex] = vertex;
        if (containsFeasibleSolutionFrom(currentHamiltonianPathArrayIndex + 1)) {
          return true;
        }
      }
    }
    return false;
  }

  private boolean isFeasible(int vertex, int currentHamiltonianPathArrayIndex) {
    // Is current vertex connected with last vertex in hamilonian path?
    if (!isEdge(hamiltonianPath[currentHamiltonianPathArrayIndex - 1], vertex)) {
      return false;
    }

    // Is current vertex already visited?
    for (int i = 0; i < currentHamiltonianPathArrayIndex; i++) {
      if (hamiltonianPath[i] == vertex) {
        return false;
      }
    }
    return true;
  }

  private boolean isEdge(int vertex1, int vertex2) {
    return graph[vertex1][vertex2] == 1;
  }

  private void printSolution() {
    System.out.println("One of the Hamiltonian Cycle is: ");
    for (int vertex : hamiltonianPath) {
      System.out.print((char) (vertex + 97) + " => ");
    }
    System.out.print((char) (hamiltonianPath[0] + 97) + "\n");
  }
}
