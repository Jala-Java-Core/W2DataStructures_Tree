package tasks.task3;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the signature of any of the methods!
 */

public class GraphUtils {

	public static int minDistance(Graph graph, String src, String dest) {
		if (graph == null || src == null || dest == null) {
			return  -1;
		}
		Node srcNode = graph.getNode(src);
		Node destNode = graph.getNode(dest);

		BreadthFirstSearch searchBreadth = new BreadthFirstSearch(graph);
		searchBreadth.fillDistances(srcNode);

		return searchBreadth.distanceBetweenNodes.get(destNode);
	}


	public static Set<String> nodesWithinDistance(Graph graph, String src, int distance) {
		if (graph == null || src == null || distance < 1) {
			return  null;
		}
		Set<String> nodesInDistance = new HashSet<>();

		Node srcNode = graph.getNode(src);
		BreadthFirstSearch searchBreadth = new BreadthFirstSearch(graph);
		searchBreadth.fillDistances(srcNode);

		for (var entry : searchBreadth.distanceBetweenNodes.entrySet()) {
			if (entry.getValue() <= distance) {
				nodesInDistance.add(entry.getKey().getElement());
			}
		}

		return nodesInDistance;
	}

	public static boolean isHamiltonianPath(Graph g, List<String> values) {
		if (g == null || values == null || values.size() < 1) {
			return  false;
		}
		boolean isHamilton = true;

		for (int index = 0; index < values.size(); index++) {
			Node current = g.getNode(values.get(index));
			Node next = g.getNode(values.get(index + 1));
			Set<Edge> currentEdges = g.getNodeEdges(current);

			if (currentEdges == null) {
				return false;
			}
			Edge edge = new Edge(current, next);
			isHamilton = currentEdges.contains(edge);
		}

		return isHamilton;
	}
	
}
