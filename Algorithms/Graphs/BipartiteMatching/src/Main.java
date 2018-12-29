import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		
		int N = 5;
		double inf = Double.POSITIVE_INFINITY;
		
		FlowNetwork flowNetwork = new FlowNetwork(2*N+2);
		
		List<Vertex> vertexList = new ArrayList<>();
		
		vertexList.add(new Vertex(0, "s"));
		
		vertexList.add(new Vertex(1, "A"));
		vertexList.add(new Vertex(2, "B"));
		vertexList.add(new Vertex(3, "C"));
		vertexList.add(new Vertex(4, "D"));
		vertexList.add(new Vertex(5, "E"));
		
		vertexList.add(new Vertex(6, "1"));
		vertexList.add(new Vertex(7, "2"));
		vertexList.add(new Vertex(8, "3"));
		vertexList.add(new Vertex(9, "4"));
		vertexList.add(new Vertex(10, "5"));
		
		vertexList.add(new Vertex(11, "t"));
		
		for(int i=0;i<N;i++){
			flowNetwork.addEdge(new Edge(vertexList.get(0), vertexList.get(i+1), 1));
			flowNetwork.addEdge(new Edge(vertexList.get(i+1+N),vertexList.get(11), 1));
		}
		
		flowNetwork.addEdge(new Edge(vertexList.get(1), vertexList.get(6), inf));
		flowNetwork.addEdge(new Edge(vertexList.get(2), vertexList.get(6), inf));
		
		flowNetwork.addEdge(new Edge(vertexList.get(1), vertexList.get(7), inf));
		flowNetwork.addEdge(new Edge(vertexList.get(3), vertexList.get(7), inf));

		flowNetwork.addEdge(new Edge(vertexList.get(3), vertexList.get(8), inf));
		flowNetwork.addEdge(new Edge(vertexList.get(5), vertexList.get(8), inf));
		
		flowNetwork.addEdge(new Edge(vertexList.get(1), vertexList.get(9), inf));
		flowNetwork.addEdge(new Edge(vertexList.get(4), vertexList.get(9), inf));
		
		flowNetwork.addEdge(new Edge(vertexList.get(4), vertexList.get(10), inf));
		
		EdmondsKarpAlgorithm edmondsKarpAlgorithm = new EdmondsKarpAlgorithm(flowNetwork, vertexList.get(0),vertexList.get(11));
		System.out.println("Maximum number of pairs: "+edmondsKarpAlgorithm.getMaxFlow());
		
		for (int v = 0; v < N; v++) {
            for (Edge e : flowNetwork.getAdjacencies(vertexList.get(v+1))) {
                if (e.getFromVertex().equals(v) && e.getFlow() > 0)
                   System.out.println(e.getFromVertex() + "-" + e.getTargetVertex());
            }
        }
	}
}
