
import java.util.ArrayList;
import java.util.List;
public class VertexDijkstra implements Comparable<VertexDijkstra>{
    private int price;
    private String name;
    private List<EdgeDijkstra> edges;
    private boolean visited;
    private VertexDijkstra previosVertex;
    private int minDistance = Integer.MAX_VALUE;
    public VertexDijkstra(String name) {
        this.name = name;
        this.edges = new ArrayList<>();
    }
    public void addNeighbour(EdgeDijkstra edge) {
        this.edges.add(edge);
    }
    public List<EdgeDijkstra> getEdges() {
        return edges;
    }
    public void setEdges(List<EdgeDijkstra> edges) {
        this.edges = edges;
    }
    public boolean isVisited() {
        return visited;
    }
    public void setVisited(boolean visited) {
        this.visited = visited;
    }
    public VertexDijkstra getPreviosVertex() {
        return previosVertex;
    }
    public void setPreviosVertex(VertexDijkstra previosVertex) {
        this.previosVertex = previosVertex;
    }
    public int getMinDistance() {
        return minDistance;
    }
    public void setMinDistance(int minDistance) {
        this.minDistance = minDistance;
    }
    public int size(){
        return edges.size();
    }
    public int getPrice(int num){
        price = 0;
        switch(num){
            case 0:
            price = getMinDistance()*2;
            case 1:
            price = getMinDistance()*4;
            case 2:
            price = getMinDistance()*5;
        }
        return price;
    }
    public int getPriceTransit(int num){
        price = 0;
        switch(num){
            case 0:
                price = (int) ((int)getMinDistance()*1.5);
            case 1:
                price = getMinDistance()*2;
            case 2:
                price  = getMinDistance()*3;
        }
        return price;
    }
    @Override
    public String toString() {
        return name;
    }
    @Override
    public int compareTo(VertexDijkstra otherVertex) {
        return Integer.compare(this.minDistance, otherVertex.minDistance);
    }
}
