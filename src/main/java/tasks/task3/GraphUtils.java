package tasks.task3;

import java.util.*;

/*
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the signature of any of the methods!
 */

public class GraphUtils {

	public static int minDistance(Graph graph, String src, String dest) {
		if (graph == null ||!graph.containsElement(src) || !graph.containsElement(dest)) {
			return -1;
		}
		if (src == dest) {
			return 0;
		}
		BreadthFirstSearch bfs = new BreadthFirstSearch(graph);
		Node start = graph.getNode(src);
		if (!bfs.bfs(start,dest)) {
			return 0;
		}
		HashSet<Node> marked = new HashSet<Node>();
		int response = 0;
		Set<Node> neighbors = new HashSet<Node>();
		neighbors.add(start);
		boolean destIsFound = false;
		while (!destIsFound) {
			neighbors = getNodesToReview(graph, neighbors, marked, start);
			for (Node neighbor: neighbors) {
				if (neighbor.getElement().equals(dest)) {
					destIsFound = true;
				}
			}
			marked = getMarkedNodes(graph, neighbors);
			response++;
		}
		return response;
	}

	private static Set<Node> getNodesToReview(Graph graph, Set<Node> nodes, HashSet<Node> marked, Node start) {
		Set<Node> response = new HashSet<Node>();
		for (Node node: nodes) {
			response.add(node);
		}
		for (Node node: nodes) {
			Set<Node> neighbors = graph.getNodeNeighbors(node);
			for (Node neighbor: neighbors) {
				if (!marked.contains(neighbor)) {
					response.add(neighbor);
				}
			}
		}
		return response;
	}

	private static HashSet<Node> getMarkedNodes(Graph graph, Set<Node> neighbors) {
		HashSet<Node> marked = new HashSet<Node>();
		for (Node neighbor : neighbors) {
			marked.add(neighbor);
		}
		return marked;
	}

	public static Set<String> nodesWithinDistance(Graph graph, String src, int distance) {
		if (graph == null ||!graph.containsElement(src) || distance < 0) {
			return null;
		}
		if (distance == 0) {
			Set<String> empty = new HashSet<>();
			return empty;
		}
		Node start = graph.getNode(src);
		HashSet<Node> marked = new HashSet<Node>();
		HashSet<String> response = new HashSet<String>();
		Set<Node> nodesToAdd = new HashSet<Node>();
		for (int i = 0; i < distance; i++) {
			nodesToAdd = getNodesToAdd(graph, nodesToAdd, start);
			response = addNodes(nodesToAdd, marked, response);
			marked = getMarkedNodes(graph, response);
		}

		return response;
	}

	private static HashSet<String> addNodes(Set<Node> nodesToAdd, HashSet<Node> marked, HashSet<String> response) {
		for (Node node : nodesToAdd) {
			if (!marked.contains(node)) {
				response.add(node.getElement());
			}
		}
		return response;
	}

	private static HashSet<Node> getMarkedNodes(Graph graph, HashSet<String> response) {
		HashSet<Node> marked = new HashSet<Node>();
		for (String value : response) {
			marked.add(graph.getNode(value));
		}
		return marked;
	}

	private static Set<Node> getNodesToAdd(Graph graph, Set<Node> nodes, Node start) {
		Set<Node> response = new HashSet<Node>();
		if (nodes.size() == 0) {
			response = graph.getNodeNeighbors(start);
		} else {
			for (Node node: nodes) {
				Set<Node> neighbors = graph.getNodeNeighbors(node);
				for (Node neighbor: neighbors) {
					response.add(neighbor);
				}
			}
		}
		return response;
	}


	public static boolean isHamiltonianPath(Graph g, List<String> values) {
		boolean response = false;
		if (g == null || values == null || values.size() == 0) {
			return response;
		}
		for (int i = 0; i < values.size(); i++) {
			if (g.containsElement(values.get(i)) == false) {
				return response;
			}
		}

		response = true;
		Node node = g.getNode(values.get(0));
		boolean existNeighbor = false;
		for (int i = 1; i < values.size(); i++) {
			Set<Node> nodeNeighbors = g.getNodeNeighbors(node);
			for (Node nodeNeighbor:nodeNeighbors) {
				if (nodeNeighbor.getElement().equals(values.get(i))) {
					existNeighbor = true;
					break;
				}else {
					existNeighbor = false;
				}
			}
			response = response & existNeighbor;
			if (!existNeighbor) {
				break;
			}
			node = g.getNode(values.get(i));
		}
		return response;
	}

}
