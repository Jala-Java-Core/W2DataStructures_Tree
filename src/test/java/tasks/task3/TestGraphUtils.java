package tasks.task3;
import org.junit.After;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestGraphUtils {
    Graph undirectedGraph;
    Graph directedGraph;

    @BeforeEach
    public void setup() {
        undirectedGraph = new UndirectedGraph();
        directedGraph = new DirectedGraph();

        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        Node e = new Node("E");
        Node f = new Node("F");
        Node g = new Node("G");
        Node h = new Node("H");
        Node i = new Node("I");

        undirectedGraph.addEdge(a, b);
        undirectedGraph.addEdge(a, f);
        undirectedGraph.addEdge(a, e);
        undirectedGraph.addEdge(b, e);
        undirectedGraph.addEdge(b, f);
        undirectedGraph.addEdge(c, f);
        undirectedGraph.addEdge(c, d);
        undirectedGraph.addEdge(d, e);
        undirectedGraph.addEdge(g, h);

        directedGraph.addEdge(a, b);
        directedGraph.addEdge(a, d);
        directedGraph.addEdge(a, e);
        directedGraph.addEdge(b, e);
        directedGraph.addEdge(c, g);
        directedGraph.addEdge(d, c);
        directedGraph.addEdge(e, f);
        directedGraph.addEdge(e, g);
        directedGraph.addEdge(f, g);
        directedGraph.addEdge(g, a);
        directedGraph.addEdge(h, i);
    }

    @After
    public void cleanup() {

    }

    @Test
    public void minDistanceUndirectedGraphExistingPath() {
        assertEquals(2, GraphUtils.minDistance(undirectedGraph, "A", "D"));
    }

    @Test
    public void minDistanceUndirectedGraphNonExistingPath() {
        assertEquals(-1, GraphUtils.minDistance(undirectedGraph, "A", "H"));
    }

    @Test
    public void minDistanceDirectedGraphExistingPath() {
        assertEquals(2, GraphUtils.minDistance(directedGraph, "A", "C"));
    }

    @Test
    public void minDistanceDirectedGraphNonExistingPath() {
        assertEquals(-1, GraphUtils.minDistance(directedGraph, "A", "H"));
    }

    @Test
    public void nodesWithinDistanceUndirectedGraphValid() {
        Set expectedResult = new HashSet<>();
        expectedResult.add("B");
        expectedResult.add("E");
        expectedResult.add("F");

        assertEquals(expectedResult, GraphUtils.nodesWithinDistance(undirectedGraph, "A", 1));
    }

    @Test
    public void nodesWithinDistanceDirectedGraphValid() {
        Set expectedResult = new HashSet<>();
        expectedResult.add("B");
        expectedResult.add("D");
        expectedResult.add("E");

        assertEquals(expectedResult, GraphUtils.nodesWithinDistance(directedGraph, "A", 1));
    }

    @Test
    public void nodesWithinDistanceInvalidGraph() {
        assertNull(GraphUtils.nodesWithinDistance(null, "A", 1));
    }

    @Test
    public void nodesWithinDistanceInvalidSrc() {
        assertNull(GraphUtils.nodesWithinDistance(undirectedGraph, null, 1));
    }

    @Test
    public void nodesWithinDistanceInvalidDistance() {
        assertNull(GraphUtils.nodesWithinDistance(undirectedGraph, "A", 0));
    }

    @Test
    public void isHamiltonianPathUndirectedGraphValid() {
        List<String> path = new ArrayList<>();
        path.add("A");
        path.add("B");
        path.add("E");
        assertTrue(GraphUtils.isHamiltonianPath(undirectedGraph, path));
    }

    @Test
    public void isHamiltonianPathUndirectedGraphInvalid() {
        List<String> path = new ArrayList<>();
        path.add("A");
        path.add("B");
        path.add("F");
        path.add("E");
        assertFalse(GraphUtils.isHamiltonianPath(undirectedGraph, path));
    }

    @Test
    public void isHamiltonianPathDirectedGraphValid() {
        List<String> path = new ArrayList<>();
        path.add("A");
        path.add("B");
        path.add("E");
        path.add("G");
        assertTrue(GraphUtils.isHamiltonianPath(directedGraph, path));
    }

    @Test
    public void isHamiltonianPathDirectedGraphInvalid() {
        List<String> path = new ArrayList<>();
        path.add("A");
        path.add("B");
        path.add("E");
        path.add("F");
        assertFalse(GraphUtils.isHamiltonianPath(directedGraph, path));
    }
}

