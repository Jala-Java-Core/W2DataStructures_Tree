package graphs;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBreadthFirstSearch {
    @Before
    public void setup() {

    }

    @After
    public void cleanup() {

    }

    @Test
    public void bfs() {
        Graph graph = new UndirectedGraph();
        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        Node e = new Node("E");
        Node f = new Node("F");

        assertEquals(true, graph.addEdge(a, a, 1));
        assertEquals(true, graph.addEdge(a, b, 1));
        assertEquals(true, graph.addEdge(a, f, 1));
        assertEquals(true, graph.addEdge(b, e, 1));
        assertEquals(true, graph.addEdge(b, c, 1));
        assertEquals(true, graph.addEdge(c, e, 1));
        assertEquals(true, graph.addEdge(c, d, 1));
        assertEquals(true, graph.addEdge(c, f, 1));
        assertEquals(true, graph.addEdge(f, e, 1));

        BreadthFirstSearch bsfInstance = new BreadthFirstSearch(graph);
        boolean result = bsfInstance.bfs("D", a);
        assertEquals(true, result);
    }
}
