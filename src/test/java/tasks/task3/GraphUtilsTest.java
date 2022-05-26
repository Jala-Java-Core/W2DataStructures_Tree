package tasks.task3;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class GraphUtilsTest {
    protected GraphBuilder graphBuilder;

    @Before
    public void setup() {
        graphBuilder = new GraphBuilder();
    }

    @After
    public void cleanup() {

    }

    @Test
    public void minDistanceReturnsMinusOne() {
        assertEquals(-1, GraphUtils.minDistance(null, null, null));
        assertEquals(-1, GraphUtils.minDistance(null, null, "2"));
        assertEquals(-1, GraphUtils.minDistance(null, "1", null));
        assertEquals(-1, GraphUtils.minDistance(null, "1", "2"));
    }

    @Test
    public void minDistanceReturnsDistance() {
        var graph =  graphBuilder.buildDirectedGraph("graph_builder_test.txt");
        assertEquals(9, graph.numNodes);
        assertEquals(2, GraphUtils.minDistance(graph, "0", "4"));
        assertEquals(1, GraphUtils.minDistance(graph, "0", "1"));
    }

    @Test
    public void nodesWithinDistanceReturnsNull() {
        assertNull(GraphUtils.nodesWithinDistance(null, null, 0));
        assertNull(GraphUtils.nodesWithinDistance(null, null, 2));
    }

    @Test
    public void nodesWithinDistanceReturnsValue() {
        var graph =  graphBuilder.buildDirectedGraph("graph_builder_test.txt");
        Set expectedSetResult = new HashSet<>();
        expectedSetResult.add("0");
        expectedSetResult.add("1");
        expectedSetResult.add("2");
        expectedSetResult.add("3");
        expectedSetResult.add("5");

        assertEquals(expectedSetResult, GraphUtils.nodesWithinDistance(graph, "0", 1));
    }

    @Test
    public void isHamiltonianPathReturnsNull() {
        List<String> path = new ArrayList<>();
        assertFalse(GraphUtils.isHamiltonianPath(null, path));
        assertFalse(GraphUtils.isHamiltonianPath(null, null));
    }
}
