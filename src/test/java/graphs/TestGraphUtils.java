package graphs;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import tasks.task3.DirectedGraph;
import tasks.task3.GraphBuilder;
import tasks.task3.GraphUtils;
import tasks.task3.UndirectedGraph;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class TestGraphUtils {
    @Test
    public void minDistance_DirectedGraph() {
        DirectedGraph graph = GraphBuilder.buildDirectedGraph("graph_builder_test.txt");
        Assert.assertEquals("assert 1",2, GraphUtils.minDistance(graph, "0", "4"));
        Assert.assertEquals("assert 2",2, GraphUtils.minDistance(graph, "2", "6"));
        Assert.assertEquals("assert 3",1, GraphUtils.minDistance(graph, "7", "8"));
        Assert.assertEquals("assert 4",-1, GraphUtils.minDistance(graph, "0", "18"));
    }

    @Test
    public void minDistance_UndirectedGraph() {
        UndirectedGraph graph = GraphBuilder.buildUndirectedGraph("graph_builder_test.txt");
        Assert.assertEquals(2, GraphUtils.minDistance(graph, "0", "4"));
        Assert.assertEquals(2, GraphUtils.minDistance(graph, "2", "6"));
        Assert.assertEquals(1, GraphUtils.minDistance(graph, "7", "8"));
        Assert.assertEquals(-1, GraphUtils.minDistance(graph, "0", "18"));
    }

    @Test
    public void nodesWithinDistance_DirectedGraph() {
        DirectedGraph graph = GraphBuilder.buildDirectedGraph("graph_builder_test.txt");
        Set<String> nodesWithinDistance = GraphUtils.nodesWithinDistance(graph, "0", 2);
        Assert.assertTrue(nodesWithinDistance.contains("1"));
        Assert.assertTrue(nodesWithinDistance.contains("2"));
        Assert.assertTrue(nodesWithinDistance.contains("3"));
        Assert.assertTrue(nodesWithinDistance.contains("4"));
        Assert.assertTrue(nodesWithinDistance.contains("5"));
    }

    @Test
    public void nodesWithinDistance_UndirectedGraph() {
        UndirectedGraph graph = GraphBuilder.buildUndirectedGraph("graph_builder_test.txt");
        Set<String> nodesWithinDistance = GraphUtils.nodesWithinDistance(graph, "0", 2);
        Assert.assertTrue(nodesWithinDistance.contains("1"));
        Assert.assertTrue(nodesWithinDistance.contains("2"));
        Assert.assertTrue(nodesWithinDistance.contains("3"));
        Assert.assertTrue(nodesWithinDistance.contains("4"));
        Assert.assertTrue(nodesWithinDistance.contains("5"));
    }

    @Test
    public void isHamiltonianPath_DirectedGraph_True() {
        List<String> values = new ArrayList<>();
        values.add("0");
        values.add("1");
        values.add("2");
        values.add("5");
        values.add("3");
        values.add("4");
        values.add("6");
        values.add("7");
        values.add("8");
        values.add("0");
        DirectedGraph graph = GraphBuilder.buildDirectedGraph("graph_builder_test.txt");
        Assert.assertTrue(GraphUtils.isHamiltonianPath(graph, values));
    }

    @Test
    public void isHamiltonianPath_DirectedGraph_False() {
        List<String> values = new ArrayList<>();
        values.add("0");
        values.add("1");
        values.add("2");
        values.add("5");
        values.add("3");
        values.add("4");
        values.add("5");
        values.add("7");
        DirectedGraph graph = GraphBuilder.buildDirectedGraph("graph_builder_test.txt");
        Assert.assertFalse(GraphUtils.isHamiltonianPath(graph, values));
    }

    @Test
    public void isHamiltonianPath_UndirectedGraph_True() {
        List<String> values = new ArrayList<>();
        values.add("0");
        values.add("1");
        values.add("2");
        values.add("5");
        values.add("3");
        values.add("4");
        values.add("6");
        values.add("7");
        values.add("8");
        values.add("0");
        UndirectedGraph graph = GraphBuilder.buildUndirectedGraph("graph_builder_test.txt");
        Assert.assertTrue(GraphUtils.isHamiltonianPath(graph, values));
    }

    @Test
    public void isHamiltonianPath_UndirectedGraph_False() {
        List<String> values = new ArrayList<>();
        values.add("0");
        values.add("1");
        values.add("2");
        values.add("5");
        values.add("3");
        values.add("4");
        values.add("5");
        values.add("7");
        UndirectedGraph graph = GraphBuilder.buildUndirectedGraph("graph_builder_test.txt");
        Assert.assertFalse(GraphUtils.isHamiltonianPath(graph, values));
    }
}
