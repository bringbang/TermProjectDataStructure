public class EdgeDijkstra {
    private int weight;
    private VertexDijkstra startVertex;
    private VertexDijkstra targetVertex;
    public EdgeDijkstra(int weight, VertexDijkstra startVertex, VertexDijkstra targetVertex) {
        this.weight = weight;
        this.startVertex = startVertex;
        this.targetVertex = targetVertex;
    }
    public int getWeight(){
        return weight;
    }
    public void setWeight(int w){
        this.weight=w;
    }
    public VertexDijkstra getStartVertex() {
        return startVertex;
    }
    public void setStartVertex(VertexDijkstra startVertex) {
        this.startVertex = startVertex;
    }
    public VertexDijkstra getTargetVertex() {
        return targetVertex;
    }
    public void setTargetVertex(VertexDijkstra targetVertex) {
        this.targetVertex = targetVertex;
    }
}
