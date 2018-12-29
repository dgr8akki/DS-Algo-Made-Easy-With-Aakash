public class Edge {

	private Vertex fromVertex;
	private Vertex targetVertex;
	private final double capacity;
	private double flow;

	public Edge(Vertex fromVertex, Vertex targetVertex, double capacity) {
		this.fromVertex = fromVertex;
		this.targetVertex = targetVertex;
		this.capacity = capacity;
		this.flow = 0.0;
	}

	public Vertex getFromVertex() {
		return fromVertex;
	}

	public void setFromVertex(Vertex fromVertex) {
		this.fromVertex = fromVertex;
	}

	public Vertex getTargetVertex() {
		return targetVertex;
	}

	public void setTargetVertex(Vertex targetVertex) {
		this.targetVertex = targetVertex;
	}

	public double getFlow() {
		return flow;
	}

	public void setFlow(double flow) {
		this.flow = flow;
	}

	public double getCapacity() {
		return capacity;
	}

	Vertex getOther(Vertex vertex) {
		if (vertex == fromVertex) {
			return targetVertex;
		} else {
			return fromVertex;
		}
	}

	double getResidualCapacity(Vertex vertex) {
		if (vertex == fromVertex) {
			return flow; // backward edge
		} else {
			return capacity - flow; // forward edge
		}
	}

	void addResidualFlowTo(Vertex vertex, double delteFlow) {

		if (vertex == fromVertex) {
			flow = flow - delteFlow; // backward edge
		} else {
			flow = flow + delteFlow; // forward edge
		}
	}

	@Override
	public String toString() {
		return fromVertex + "-" + targetVertex + " " + flow + "/" + capacity;
	}
}
