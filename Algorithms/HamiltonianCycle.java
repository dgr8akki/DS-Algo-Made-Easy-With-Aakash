public class HamiltonianCycle {
  int[][] graph;
  int[] hamiltonianPath;
  int totalVertex;
  public HamiltonianCycle(int[][] g) {
    graph = g;
    hamiltonianPath = new int[g.length];
    totalVertex = g.length;
  }
  public void solve(int source) {
    hamiltonianPath[0] = 0;
    // hamiltonianPath[totalVertex] = 0;

    if(containsFeasibleSolutionFrom(1))
      printSolution();
    else
      System.out.println("Given graph contains no Hamiltonian cycle");
  }

  private boolean containsFeasibleSolutionFrom(int currentHamiltonianPathArrayIndex) {
    if(currentHamiltonianPathArrayIndex == totalVertex) {
      if(isEdge(hamiltonianPath[currentHamiltonianPathArrayIndex - 1], hamiltonianPath[0]))
        return true;
      else
        return false;
    }

    for(int vertex = 0; vertex < totalVertex; vertex++) {
      if(isFeasible(vertex, currentHamiltonianPathArrayIndex)) {
        hamiltonianPath[currentHamiltonianPathArrayIndex] = vertex;

        if(containsFeasibleSolutionFrom(currentHamiltonianPathArrayIndex + 1))
          return true;
      }
    }
    return false;
  }

  private boolean isFeasible(int vertex, int currentHamiltonianPathArrayIndex) {
    // Is current vertex connected with last vertex in hamilonian path?
    if(!isEdge(hamiltonianPath[currentHamiltonianPathArrayIndex - 1], vertex)) return false;

    // Is current vertex already visited?
    for(int vertexAlreadyInHamiltonianPath : hamiltonianPath)
      if(vertexAlreadyInHamiltonianPath == vertex) return false;
    return true;
  }

  private boolean isEdge(int vertex1, int vertex2) {
    return graph[vertex1][vertex2] == 1;
  }

  private void printSolution() {
    System.out.println("One of the Hamiltonian Cycle is: ");
    for(int vertex: hamiltonianPath)
      System.out.print(vertex + " => ");
    System.out.print(hamiltonianPath[0]);
  }
  public static void main(String[] args) {
    int[][] graph = {
      {0,1,1,1,0,0},
      {1,0,1,0,1,0},
      {1,1,1,1,0,1},
      {1,0,1,0,0,1},
      {0,1,0,0,0,1},
      {0,1,1,1,1,1}
    };
    HamiltonianCycle cycle = new HamiltonianCycle(graph);

    cycle.solve(0);
    // cycle.solve(1);
    // cycle.solve(2);
  }
}
