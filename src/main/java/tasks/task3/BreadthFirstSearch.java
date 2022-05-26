package tasks.task3;

import java.util.*;

/*
 * SD2x Homework #6
 * This is an implementation of Breadth First Search (BFS) on a graph.
 * You may modify and submit this code if you'd like.
 */

public class BreadthFirstSearch {
	protected Set<Node> marked;
	protected Graph graph;
	public Map<Node, Integer> distanceBetweenNodes;

	public BreadthFirstSearch(Graph graphToSearch) {
		marked = new HashSet<Node>();
		graph = graphToSearch;
		distanceBetweenNodes = new HashMap<Node, Integer>();

		for (Node node : graph.getAllNodes()) {
			distanceBetweenNodes.put(node, Integer.MAX_VALUE);
		}
	}

	/**
	 * This method was discussed in the lesson
	 */
	public boolean bfs(Node start, String elementToFind) {
		if (!graph.containsNode(start)) {
			return false;
		}
		if (start.getElement().equals(elementToFind)) {
			return true;
		}
		Queue<Node> toExplore = new LinkedList<Node>();
		marked.add(start);
		toExplore.add(start);
		while (!toExplore.isEmpty()) {
			Node current = toExplore.remove();
			for (Node neighbor : graph.getNodeNeighbors(current)) {
				if (!marked.contains(neighbor)) {
					if (neighbor.getElement().equals(elementToFind)) {
						return true;
					}
					marked.add(neighbor);
					toExplore.add(neighbor);
				}
			}
		}
		return false;
	}

	public void fillDistances(Node start) {
		if (graph.containsNode(start)) {
			Queue<Node> toExplore = new LinkedList<Node>();
			marked.add(start);
			toExplore.add(start);
			distanceBetweenNodes.put(start, 0);

			while (!toExplore.isEmpty()) {
				Node current = toExplore.remove();
				for (Node neighbor : graph.getNodeNeighbors(current)) {
					int distance = Math.min(distanceBetweenNodes.get(neighbor), distanceBetweenNodes.get(current) + 1);
					distanceBetweenNodes.put(neighbor, distance);
					if (!marked.contains(neighbor)) {
						marked.add(neighbor);
						toExplore.add(neighbor);
					}
				}
			}
		}
	}
}
