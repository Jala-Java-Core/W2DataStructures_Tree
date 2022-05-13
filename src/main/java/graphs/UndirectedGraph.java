package graphs;

import graphs.Graph;

public class UndirectedGraph extends Graph {

    public UndirectedGraph() {
        super();
    }

    public boolean addEdge(Node node1, Node node2, int weight) {
        addNode(node1); // only adds if node not already in graph
        addNode(node2);

        boolean addEdgeSuccess = (addEdgeFromTo(node1, node2, weight)
        && addEdgeFromTo(node2, node1, weight));

        if (addEdgeSuccess) {
            super.numEdges++;
        }
        return addEdgeSuccess;
    }

    @Override
    public boolean removeEdge(Node node1, Node node2, int weight) {
        return false;
    }
}
