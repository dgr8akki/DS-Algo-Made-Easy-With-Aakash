import java.util.ArrayList;
import java.util.Stack;

public class GraphUsingObjects {
  class Vertex {
    int data;
    ArrayList<Vertex> neighbours;

    Vertex(int data) {
      this.data = data;
      neighbours = new ArrayList<>();
    }
  }
  private int verticesCount;
  private ArrayList<Vertex> vertices;

  GraphUsingObjects(int verticesCount) {
    this.verticesCount = verticesCount;
    vertices = new ArrayList<>();

    for(int i = 0; i < verticesCount; i++) {
      vertices.add(new Vertex(i));
    }
  }

  public Vertex getNodeVertex (int data) {
    for(Vertex current : vertices) {
      if(current.data == data)
        return current;
    }
    return null;
  }

  public void addEdge(int src, int dest) {
    vertices.get(src).neighbours.add(new Vertex(dest));
    vertices.get(dest).neighbours.add(new Vertex(src));
  }

  public void removeEdge(int src, int dest) {
    vertices.get(src).neighbours.remove(getNodeVertex(dest));
    vertices.get(dest).neighbours.remove(getNodeVertex(src));
  }

  public void print() {
    for(int index = 0; index < vertices.size(); index++) {
      for(int jindex = -1; jindex < vertices.get(index).neighbours.size(); jindex++) {
        if(jindex == -1) {
          System.out.print(index + " => ");
          continue;
        }
        if(jindex == 0) {
          System.out.print(vertices.get(index).neighbours.get(jindex).data);
          continue;
        }
        System.out.print(" , " + vertices.get(index).neighbours.get(jindex).data);
      }
      System.out.println();
    }
  }

  public void dfs(int data) {
    Vertex startNode = getNodeVertex(data);
    Stack<Vertex> stack = new Stack<>();
    boolean[] isVisited = new boolean[verticesCount];
    stack.push(startNode);

    while(!stack.isEmpty()){
      Vertex currentNode = stack.pop();
      if(!isVisited[currentNode.data]) {
        System.out.print(currentNode.data + " => ");
        isVisited[currentNode.data] = true;
      }

      for(Vertex node : currentNode.neighbours) {
        if(!isVisited[node.data])
          stack.push(node);
      }
    }
  }
  public static void main(String[] args) {
    GraphUsingObjects graph = new GraphUsingObjects(5);
      graph.addEdge(1, 2);
      graph.addEdge(1, 3);
      graph.addEdge(1, 4);
      graph.addEdge(3, 2);
      graph.addEdge(4, 3);
      graph.addEdge(2, 4);
      graph.removeEdge(2, 4);
      graph.print();
      graph.dfs(1);
  }
}