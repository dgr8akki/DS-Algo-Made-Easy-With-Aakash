public class Vertex {

	private int id;
	private String name;
	private boolean visited;
	
	public Vertex(int id, String name){
		this.id = id;
		this.name = name;
	}

	public int getId(){
		return this.id;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	@Override
	public String toString() {
		return this.name+"-"+this.id;
	}
}
