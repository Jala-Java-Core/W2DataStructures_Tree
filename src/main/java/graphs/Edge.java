package graphs;

public class Edge {
    // Code W2-13
    private final Node source;
    private final Node destination;
    private final int weight;

    public Edge(Node source, Node destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    public String toString() {
        return "(" + this.source.toString() + "," + this.destination.toString() + "," + this.weight + ")";
    }

    public Node getSource() {
        return this.source;
    }

    public Node getDestination() {
        return this.destination;
    }

    public int getWeight() {
        return this.weight;
    }

    //@Override
    public boolean equals(Edge otherEdge) {
        Node otherSource = otherEdge.getSource();
        Node otherDest = otherEdge.getDestination();
        int otherWeight = otherEdge.getWeight();
        return (otherSource.equals(destination))
                && otherDest.equals(destination)
                && otherWeight == weight;
    }

    @Override
    public int hashCode() {
        return source.hashCode() + destination.hashCode() + this.weight;
    }
}
