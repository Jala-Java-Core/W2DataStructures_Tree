package graphs;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDepthFirstSearch {
    @Before
    public void setup() {

    }

    @After
    public void cleanup() {

    }

    @Test
    public void dfs() {
        Graph graph = new DirectedGraph();
        Node detroit = new Node("Detroit");
        Node chicago = new Node("Chicago");
        Node philadelphia = new Node("Philadelphia");
        Node boston = new Node("Boston");
        Node nYork = new Node("New York");
        Node sanFrancisco = new Node("San Francisco");

        assertEquals(true, graph.addEdge(chicago, boston,1));
        assertEquals(true, graph.addEdge(detroit, chicago, 1));
        assertEquals(true, graph.addEdge(philadelphia, boston, 2));
        assertEquals(true, graph.addEdge(philadelphia, detroit, 1));
        assertEquals(true, graph.addEdge(nYork, philadelphia, 2));
        assertEquals(true, graph.addEdge(nYork, boston, 2));
        assertEquals(true, graph.addEdge(nYork, sanFrancisco, 1));
        assertEquals(true, graph.addEdge(sanFrancisco, philadelphia,1));

        DepthFirstSearch depthFirstSearch = new DepthFirstSearch(graph);

        assertEquals(true, depthFirstSearch.dfs("Chicago", nYork));
    }
}
