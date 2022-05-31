package tasks.task3;

import java.util.*;

/*
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the signature of any of the methods!
 */

public class GraphUtils {

	public static int minDistance(Graph graph, String src, String dest) {
		if (graph == null ||
				src == null ||
				dest == null ||
				!graph.containsElement(src) ||
				!graph.containsElement(dest)) {
			return -1;
		}
		Node srcNode = graph.getNode(src);
		Node destNode = graph.getNode(dest);

		int dist = 0;
		if (src == dest) {
			return dist;
		}

		return minDistance(graph, srcNode, destNode, new HashSet<>(), dist);
	}

	private static int minDistance(Graph graph, Node src, Node dest, Set<Node> visited, int dist) {
		dist++;
		visited.add(src);
		Set<Node> neighbors = graph.getNodeNeighbors(src);
//		System.out.println(src.element + " neighbors are: " + neighbors);
		if (neighbors.contains(dest)) {
//			System.out.println("Contains " + dest.element + " and distance is " + dist);
			return dist;
		}

		List<Integer> distances = new ArrayList();
		for (Node neighbor : neighbors) {
			Set<Node> visitedAux = new HashSet<>();
			for (Node n: visited) {
				visitedAux.add(n);
			}
			if (!visitedAux.contains(neighbor)) {
//				System.out.println("Visited: " + visited2 + ". Now looking on neighbor: " + neighbor.element + " with distance " + dist);
				int d = minDistance(graph, neighbor, dest, visitedAux, dist);
				if (d >= 0) {
					distances.add(d);
				}
			}
		}

		if (distances.isEmpty()) {
			return -1;
		}

		int minDist = distances.get(0);
		for (int d: distances) {
			if (minDist > d)
				minDist = d;
		}
		return minDist;
	}
	

	public static Set<String> nodesWithinDistance(Graph graph, String src, int distance) {
		if (graph == null ||
				src == null ||
				distance < 1 ||
				!graph.containsElement(src)) {
			return null;
		}

		Set<String> nodesWithinDistance = new HashSet<>();
		Node srcNode = graph.getNode(src);

		nodesWithinDistance(graph, srcNode, distance, new HashSet<Node>(), nodesWithinDistance, 0);
		return nodesWithinDistance;
	}

	private static void nodesWithinDistance(Graph graph, Node current, int distance, Set<Node> visited, Set<String> nodesWithinDistance, int progress) {
		if (progress == distance) {
			return;
		}

		visited.add(current);
		progress++;
		Set<Node> neighbors = graph.getNodeNeighbors(current);
		for (Node neighbor: neighbors) {
			if (!visited.contains(neighbor)) {
				nodesWithinDistance(graph, neighbor, distance, visited, nodesWithinDistance, progress);
				nodesWithinDistance.add(neighbor.getElement());
			}
		}
	}

	public static boolean isHamiltonianPath(Graph g, List<String> values) {
		if (g == null || values == null) {
			return false;
		}

		if (values.get(0) != values.get(values.size() - 1)) {
			return false;
		}

		Set<Node> visited = new HashSet<>();
		for (int i = 0; i < values.size() - 1 ; i++) {
			if (!g.containsElement(values.get(i)) || !g.containsElement(values.get(i + 1))) {
				return false;
			}

			Node current = g.getNode(values.get(i));
			if (visited.contains(current)) {
				return false;
			}
			visited.add(current);
			Node next = g.getNode(values.get(i + 1));
			Set<Node> neighbors = g.getNodeNeighbors(current);
			if (!neighbors.contains(next)) {
				return false;
			}
		}

		if (visited.size() < g.getNumNodes()) {
			return false;
		}

		return true; // this line is here only so this code will compile if you don't modify it
	}
	
}
