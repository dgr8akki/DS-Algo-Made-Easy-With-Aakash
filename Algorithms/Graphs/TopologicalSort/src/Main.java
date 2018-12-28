import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
  public static void main(String[] args) {

    TopologicalSort topologicalOrdering = new TopologicalSort();

    List<Vertex> graph = new ArrayList<>();

    graph.add(new Vertex("0"));
    graph.add(new Vertex("1"));
    graph.add(new Vertex("2"));
    graph.add(new Vertex("3"));
    graph.add(new Vertex("4"));
    graph.add(new Vertex("5"));

    graph.get(2).setNeighbour(graph.get(3));

    graph.get(3).setNeighbour(graph.get(1));

    graph.get(4).setNeighbour(graph.get(0));
    graph.get(4).setNeighbour(graph.get(1));

    graph.get(5).setNeighbour(graph.get(0));
    graph.get(5).setNeighbour(graph.get(2));

    for (Vertex vertex1 : graph) {
      if (!vertex1.isVisited()) {
        topologicalOrdering.dfs(vertex1);
      }
    }

    Stack<Vertex> stack;
    stack = topologicalOrdering.getStack();

    for(int i=0;i<graph.size();i++){
      var vertex = stack.pop();
      System.out.print(vertex+"->");
    }
  }
}
