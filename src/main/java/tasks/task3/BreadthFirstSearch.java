package tasks.task3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Map;

/*
 * SD2x Homework #6
 * This is an implementation of Breadth First Search (BFS) on a graph.
 * You may modify and submit this code if you'd like.
 */

public class BreadthFirstSearch {
	protected Set<Node> marked;
	protected Graph graph;
	protected Map<Node, Integer> distance;

	public BreadthFirstSearch(Graph graphToSearch) {
		marked = new HashSet<Node>();
		graph = graphToSearch;
		distance = new HashMap<Node, Integer>();

		for (Node node : graph.getAllNodes()) {
			distance.put(node, Integer.MAX_VALUE);
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

	/**
	 * Overriding the method to visit all other nodes from start, and calculate shortest path.
	 */
	public void bfs(Node start) {
		if (!graph.containsNode(start)) {
			return;
		}
		Queue<Node> toExplore = new LinkedList<Node>();
		marked.add(start);
		toExplore.add(start);
		distance.put(start, 0);

		while (!toExplore.isEmpty()) {
			Node current = toExplore.remove();
			for (Node neighbor : graph.getNodeNeighbors(current)) {
				distance.put(neighbor, Math.min(distance.get(neighbor), distance.get(current) + 1));
				if (!marked.contains(neighbor)) {
					marked.add(neighbor);
					toExplore.add(neighbor);
				}
			}
		}
	}

	/**
	 * Checks on distance set and get the shortest path to a node end.
	 */
	public int getShortestPath(Node end) {
		if (!marked.contains(end)) {
			return -1;
		}

		return distance.get(end);
	}

	/**
	 * Gets distance set
	 */
	public Map<Node, Integer> getDistanceSet() {
		return distance;
	}
}
