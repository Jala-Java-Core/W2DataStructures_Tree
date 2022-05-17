package graphs;

import graphs.Graph;
import graphs.Node;

public class DirectedGraph extends Graph {
    public DirectedGraph() {
        super();
    }

    public boolean addEdge(Node source, Node dest, int weight) {
        addNode(source); // only adds if node not already in graph
        addNode(dest);

        boolean addSuccess = addEdgeFromTo(source, dest, weight);

        if (addSuccess) {
            super.numEdges++;
        }
        return addSuccess;
    }

    @Override
    public boolean removeEdge(Node node1, Node node2, int weight) {
        return false;
    }
}
