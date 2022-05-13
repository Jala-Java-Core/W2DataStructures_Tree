package graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class Graph {
    // Code W2-13

    private Map<Node, Set<Edge>> adjacencySets;
    private int numNodes;
    protected int numEdges;

    public Graph() {
        adjacencySets = new HashMap<Node, Set<Edge>>();
        numNodes = 0;
        numEdges = 0;
    }

    public Set<Edge> getNode(Node node) {
        return adjacencySets.get(node);
    }

    public int getNumNodes() {
        return this.numNodes;
    }

    public int getNumEdges() {
        return this.numEdges;
    }

    public boolean containsNode(Node node) {
        return adjacencySets.containsKey(node);
    }

    public boolean addNode(Node newNode) {
        if (newNode == null || containsNode(newNode)) {
            return false;
        }
        Set<Edge> newAdjacencySet = new HashSet<Edge>();
        adjacencySets.put(newNode, newAdjacencySet);
        numNodes++;
        return true;
    }

    public Set<Node> getNodeNeighbors(Node node) {
        if (!containsNode(node)) {
            return null;
        }
        Set<Edge> nodeEdges = adjacencySets.get(node);
        Set<Node> nodeNeighbors = new HashSet<Node>();
        for (Edge e : nodeEdges) {
            Node neighbor = e.getDestination();
            nodeNeighbors.add(neighbor);
        }
        return nodeNeighbors;
    }

    // Directed graph and undirected graph has different implementations
    public abstract boolean addEdge(Node node1, Node node2, int weight);
    public abstract boolean removeEdge(Node node1, Node node2, int weight);

    public boolean addEdgeFromTo(Node source, Node destination, int weight) {
        Edge newEdge = new Edge(source, destination, weight);
        Set<Edge> sourceEdges = adjacencySets.get(source);
        if (!sourceEdges.contains(newEdge)) {
            sourceEdges.add(newEdge);
            return true;
        }
        return false;
    }
}
