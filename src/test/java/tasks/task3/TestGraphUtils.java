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
    Graph balancedGraph;

    @BeforeEach
    public void setup() {
        undirectedGraph = GraphBuilder.buildUndirectedGraph(System.getProperty("user.dir") + "\\src\\test\\java\\tasks\\task3\\undirected_graph_test.txt");
        directedGraph = GraphBuilder.buildDirectedGraph(System.getProperty("user.dir") + "\\src\\test\\java\\tasks\\task3\\directed_graph_test.txt");
        balancedGraph = GraphBuilder.buildUndirectedGraph(System.getProperty("user.dir") + "\\src\\test\\java\\tasks\\task3\\balanced_graph_test.txt");
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
    public void nodesWithinDistanceBalancedGraphValid() {
        Set expectedResult = new HashSet<>();
        expectedResult.add("B");
        expectedResult.add("C");
        expectedResult.add("H");
        expectedResult.add("I");

        assertEquals(expectedResult, GraphUtils.nodesWithinDistance(balancedGraph, "A", 2));
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

    @Test
    public void isHamiltonianPathInvalidGraph() {
        List<String> path = new ArrayList<>();
        path.add("A");
        path.add("B");
        path.add("E");
        assertFalse(GraphUtils.isHamiltonianPath(null, path));
    }

    @Test
    public void isHamiltonianPathInvalidPathEmpty() {
        List<String> path = new ArrayList<>();
        assertFalse(GraphUtils.isHamiltonianPath(undirectedGraph, path));
    }

    @Test
    public void isHamiltonianPathInvalidPathNull() {
        assertFalse(GraphUtils.isHamiltonianPath(undirectedGraph, null));
    }
}

