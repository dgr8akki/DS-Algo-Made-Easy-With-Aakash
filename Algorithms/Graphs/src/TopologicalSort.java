import java.util.Stack;

public class TopologicalSort {
  private Stack<Vertex> stack = new Stack<>();

  void dfs(Vertex currentVertex) {
    currentVertex.setVisited(true);
    for(Vertex adjacentVertex: currentVertex.getNeighbours())
      if(!adjacentVertex.isVisited())
        dfs(adjacentVertex);

    stack.push(currentVertex);
  }

  public Stack<Vertex> getStack() {
    return stack;
  }
}
