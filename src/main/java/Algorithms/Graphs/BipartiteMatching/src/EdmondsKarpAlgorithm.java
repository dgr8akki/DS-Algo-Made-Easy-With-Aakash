package Algorithms.Graphs.BipartiteMatching.src;

import java.util.LinkedList;
import java.util.Queue;

public class EdmondsKarpAlgorithm {

	private boolean[] marked;     // marked[v] = true iff s->v path in residual graph
    private Edge[] edgeTo;    // edgeTo[v] = last edge on shortest residual s->v path
    private double valueMaxFlow;         // current value of max flow
  
    public EdmondsKarpAlgorithm(FlowNetwork flowNetwork, Vertex s, Vertex t) {
       
        while (hasAugmentingPath(flowNetwork, s, t)) {

            double bottle = Double.POSITIVE_INFINITY;
            
            for (Vertex v = t; v != s; v = edgeTo[v.getId()].getOther(v)) {
                bottle = Math.min(bottle, edgeTo[v.getId()].getResidualCapacityTo(v));
            }
 
            for (Vertex v = t; v != s; v = edgeTo[v.getId()].getOther(v)) {
                edgeTo[v.getId()].addResidualFlowTo(v, bottle); 
            }

            valueMaxFlow += bottle;
        }
    }

    public double getMaxFlow()  {
        return valueMaxFlow;
    }

    private boolean hasAugmentingPath(FlowNetwork flowNetwork, Vertex s, Vertex t) {
        
    	edgeTo = new Edge[flowNetwork.getNumOfVertices()];
        marked = new boolean[flowNetwork.getNumOfVertices()];

        Queue<Vertex> queue = new LinkedList<Vertex>();
        queue.add(s);
        marked[s.getId()] = true;
       
        while (!queue.isEmpty() && !marked[t.getId()]) {
            Vertex v = queue.remove();

            for (Edge e : flowNetwork.getAdjacencies(v)) {
                Vertex w = e.getOther(v);
         
                if (e.getResidualCapacityTo(w) > 0) {
                    if (!marked[w.getId()]) {
                        edgeTo[w.getId()] = e;
                        marked[w.getId()] = true;
                        queue.add(w);
                    }
                }
            }
        }

        return marked[t.getId()];
    }
}
