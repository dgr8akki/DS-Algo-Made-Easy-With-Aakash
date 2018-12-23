import java.util.List;

class CycleDetector {

  void detect(List<Vertex> graph) {
    for (Vertex v :
      graph) {
      if (!v.isVisited())
        dfs(v);
    }
  }

  private void dfs(Vertex v) {
    v.setBeingVisited(true);

    for (Vertex neighbour : v.getNeighbours()) {
      if (neighbour.isBeingVisited()) {
        System.out.println("Cycle Detected");
        break;
      }

      if (!neighbour.isVisited()) {
        neighbour.setVisited(true);
        dfs(neighbour);
      }

      v.setVisited(true);
      v.setBeingVisited(true);
    }
  }
}
