package tasks.task3;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the signature of any of the methods!
 */

public class GraphUtils {

	public static int minDistance(Graph graph, String src, String dest) {

		BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch(graph);

		Node start = graph.getNode(src);
		Node end = graph.getNode(dest);

		breadthFirstSearch.bfs(start);

		return breadthFirstSearch.getShortestPath(end);
	}
	

	public static Set<String> nodesWithinDistance(Graph graph, String src, int distance) {
		if (graph == null || src == null || distance < 1) return null;

		BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch(graph);

		Node start = graph.getNode(src);

		breadthFirstSearch.bfs(start);

		Map<Node, Integer> distances = breadthFirstSearch.getDistanceSet();

		Set<String> nodes = new HashSet<String>();

		for (Map.Entry<Node, Integer> entry : distances.entrySet()) {
			if (entry.getValue() <= distance && entry.getKey().getElement().compareTo(src) != 0) {
				nodes.add(entry.getKey().getElement());
			}
		}

		return nodes;
	}


	public static boolean isHamiltonianPath(Graph g, List<String> values) {
		if (g == null || values == null) return false;

		boolean validHamiltonianPath = true;

		for (int i = 0; i < values.size(); i++) {
			Node src = g.getNode(values.get(i));
			Node dest = g.getNode(values.get((i + 1) % values.size()));
			Set<Edge> srcEdges = g.getNodeEdges(src);

			if (srcEdges == null) {
				validHamiltonianPath = false;
				break;
			}

			Edge edge = new Edge(src, dest);
			validHamiltonianPath &= srcEdges.contains(edge);
		}

		return validHamiltonianPath;
	}
	
}
