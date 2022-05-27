package tasks.tasks3;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import tasks.task3.DepthFirstSearch;
import tasks.task3.GraphBuilder;
import tasks.task3.GraphUtils;
import tasks.task3.UndirectedGraph;


import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestGraphUtils {

    @Before
    public void setup() {
    }

    @After
    public void cleanup() {

    }

    @Test
    public void minDistance() {
        GraphBuilder graphBuilder = new GraphBuilder();
        UndirectedGraph ug = graphBuilder.buildUndirectedGraph("C:\\GitHub\\W2DataStructures_Tree\\src\\main\\java\\tasks\\task3\\graph_builder_test.txt");
        GraphUtils utils = new GraphUtils();
        int response = utils.minDistance(ug, "0", "4");
        assertEquals(response, 2);
        response = utils.minDistance(ug, "0", "5");
        assertEquals(response, 1);
        response = utils.minDistance(ug, "0", "3");
        assertEquals(response, 1);
        response = utils.minDistance(ug, "0", "6");
        assertEquals(response, 3);
    }

    @Test
    public void nodesWithinDistance() {
        GraphBuilder graphBuilder = new GraphBuilder();
        UndirectedGraph ug = graphBuilder.buildUndirectedGraph("C:\\GitHub\\W2DataStructures_Tree\\src\\main\\java\\tasks\\task3\\graph_builder_test.txt");
        GraphUtils utils = new GraphUtils();
        Set<String> response = utils.nodesWithinDistance(ug,"0", 1);
        assertEquals(response.contains("3"), true);
        assertEquals(response.contains("5"), true);
        assertEquals(response.contains("2"), true);
        assertEquals(response.contains("1"), true);
        assertEquals(response.contains("6"), false);


    }

    @Test
    public void isHamiltonianPath() {
        GraphBuilder graphBuilder = new GraphBuilder();
        UndirectedGraph ug = graphBuilder.buildUndirectedGraph("C:\\GitHub\\W2DataStructures_Tree\\src\\main\\java\\tasks\\task3\\graph_builder_test.txt");
        GraphUtils utils = new GraphUtils();

        List<String> values = new LinkedList<String>();
        values.add("0");
        values.add("5");
        values.add("1");
        values.add("2");
        values.add("0");

        boolean response = utils.isHamiltonianPath(ug, values);
        assertEquals(response, true);
    }
}


