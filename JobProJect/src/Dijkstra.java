import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
public class Dijkstra {
    public void computePath(VertexDijkstra sourceVertex) {
        sourceVertex.setMinDistance(0);
        PriorityQueue<VertexDijkstra> priorityQueue = new PriorityQueue<>();
        priorityQueue.clear();
        priorityQueue.add(sourceVertex);
        while (!priorityQueue.isEmpty()) {
            VertexDijkstra vertex = priorityQueue.poll();
            for (EdgeDijkstra edge : vertex.getEdges()) {
                VertexDijkstra v = edge.getTargetVertex();
                VertexDijkstra u = edge.getStartVertex();
                int weight = edge.getWeight();
                int minDistance = vertex.getMinDistance() + weight;
                if (minDistance < v.getMinDistance()) {
                    priorityQueue.remove(vertex);
                    v.setPreviosVertex(vertex);
                    v.setMinDistance(minDistance);
                    priorityQueue.add(v);
                }
            }
        }
    }
    public List<VertexDijkstra> getShortestPathTo(VertexDijkstra targetVerte) {
        List<VertexDijkstra> path = new ArrayList<>();
        for (VertexDijkstra vertex = targetVerte; vertex != null; vertex = vertex.getPreviosVertex()) {
            if(vertex!=vertex.getPreviosVertex()){
                path.add(vertex);
            }
        }
        Collections.reverse(path);
        return path;
    }
}