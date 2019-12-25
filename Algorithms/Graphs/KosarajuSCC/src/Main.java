package Algorithms.Graphs.KosarajuSCC.src;

import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {

    List<Vertex> vertexList = new ArrayList<>();

    vertexList.add(new Vertex(0, "a"));
    vertexList.add(new Vertex(1, "b"));
    vertexList.add(new Vertex(2, "c"));
    vertexList.add(new Vertex(3, "d"));
    vertexList.add(new Vertex(4, "e"));
    vertexList.add(new Vertex(5, "f"));
    vertexList.add(new Vertex(6, "g"));
    vertexList.add(new Vertex(7, "h"));


    List<Edge> edgeList = new ArrayList<Edge>();

    edgeList.add(new Edge(1, vertexList.get(0), vertexList.get(1)));

    edgeList.add(new Edge(1, vertexList.get(1), vertexList.get(2)));
    edgeList.add(new Edge(1, vertexList.get(1), vertexList.get(4)));
    edgeList.add(new Edge(1, vertexList.get(1), vertexList.get(5)));

    edgeList.add(new Edge(1, vertexList.get(2), vertexList.get(3)));
    edgeList.add(new Edge(1, vertexList.get(2), vertexList.get(6)));

    edgeList.add(new Edge(1, vertexList.get(3), vertexList.get(2)));
    edgeList.add(new Edge(1, vertexList.get(3), vertexList.get(7)));

    edgeList.add(new Edge(1, vertexList.get(4), vertexList.get(0)));
    edgeList.add(new Edge(1, vertexList.get(4), vertexList.get(5)));

    edgeList.add(new Edge(1, vertexList.get(5), vertexList.get(6)));

    edgeList.add(new Edge(1, vertexList.get(6), vertexList.get(5)));

    edgeList.add(new Edge(1, vertexList.get(7), vertexList.get(3)));
    edgeList.add(new Edge(1, vertexList.get(7), vertexList.get(6)));



    Graph graph = new Graph(edgeList, vertexList);

//		for(Vertex v : graph.getTransposeGraph().getVertexList()){
//			for(Vertex u : v.getAdjaenciesList()){
//				System.out.println(v+"->"+u);
//			}
//		}

    Kosaraju kosarajuAlgorithm = new Kosaraju(graph);

    System.out.println(kosarajuAlgorithm.getCount());

    for(Vertex vertex : vertexList){
      System.out.println(vertex+" - "+vertex.getComponentId());
    }

  }
}
