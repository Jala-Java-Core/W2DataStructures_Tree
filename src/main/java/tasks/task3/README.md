# Task 3

In this assignment, you will implement methods used for exploring graphs.

In completing this assignment, you will:

    Become more familiar with the “adjacency set” representation of a graph
    Apply what you have learned about how to traverse a graph
    Demonstrate that you can use graphs to solve common problems in Computer Science


## Getting Started

This package includes the following .java files: graphs.Graph, graphs.UndirectedGraph, graphs.DirectedGraph, graphs.Edge, graphs.Node, graphs.BreadthFirstSearch, and graphs.DepthFirstSearch. These files include the implementations for the adjacency set representation of a graph (undirected and directed) along with breadth-first search and depth-first search implementations that we saw in the lessons.

We have also provided GraphBuilder.java, which includes static methods for generating directed and undirected graphs from an input file. These methods assume that the input file is formatted as follows:

    each line of the file consists of the values/labels of two nodes in the graph, separated by a single whitespace
    there is an edge in the graph between the two nodes; if the graph is directed, the edge is directed from the first node to the second

For instance, if the input file looked like this:

    cat dog
    
    dog platypus

and the graph were directed, there would be an edge from “cat” to “dog,” and from “dog” to “platypus.”

We have provided a file graph_builder_test.txt that you can use as input for testing the methods that you will implement in this assignment. You are, of course, free to create your own input files, but this is the file we will use to assess your solution. If you are using Eclipse, be sure to put this file in the root directory of your project.

Last, GraphUtils.java contains the unimplemented methods for the code that you will write in this assignment.

## Activity

Implement the following methods in the GraphUtils.java file:

minDistance: Given a Graph, this method returns the shortest distance (in terms of number of edges) from the node labeled src to the node labeled dest. The method should return -1 for any invalid inputs, including: null values for the graphs.Graph, src, or dest; there is no node labeled src or dest in the graph; there is no path from src to dest. Keep in mind that this method does not just return the distance of any path from src to dest, it must be the shortest path.

nodesWithinDistance: Given a Graph, this method returns a Set of the values of all nodes within the specified distance (in terms of number of edges) of the node labeled src, i.e. for which the minimum number of edges from src to that node is less than or equal to the specified distance. The value of the node itself should not be in the Set, even if there is an edge from the node to itself. The method should return null for any invalid inputs, including: null values for the graphs.Graph or src; there is no node labeled src in the graph; distance less than 1. However, if distance is greater than or equal to 1 and there are no nodes within that distance (meaning: src is the only node in the graph), the method should return an empty Set.

isHamiltonianPath: Given a Graph, this method indicates whether the List of node values represents a Hamiltonian Path. A Hamiltonian Path is a valid path through the graph in which every node in the graph is visited exactly once, except for the start and end nodes, which are the same, so that it is a cycle. If the values in the input List represents a Hamiltonian Path, the method should return true, but the method should return false otherwise, e.g. if the path is not a cycle, if some nodes are not visited, if some nodes are visited more than once, if some values do not have corresponding nodes in the graph, if the input is not a valid path (i.e., there is a sequence of nodes in the List that are not connected by an edge), etc. The method should also return false if the input Graph or List is null.

For all of these, be sure to test your implementation with both directed and undirected graphs.

Please do not change the signature of any of the three methods, and please do not create any additional .java files for your solution; if you need additional classes, you can define them in GraphUtils.java. You may modify graphs.BreadthFirstSearch.java and/or graphs.DepthFirstSearch.java as part of your solution but please do not modify any of the other code that we distributed. Last, please be sure that all code  is in the default package, i.e. there is no “package” declaration at the top of the source code.
