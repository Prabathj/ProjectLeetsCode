package com.prabathj;

//Map can store any Type so when we are not limited to index we can use Map to represent Graph

public class GraphMapImplementation {

	public static void main(String[] args) {
		
		Graph<Integer> graph=new Graph<>();

		graph.addEdge(new GraphEdge<Integer>(8, 3, true, 1));
		graph.addEdge(new GraphEdge<Integer>(8, 10, true, 1));
		graph.addEdge(new GraphEdge<Integer>(3, 1, true, 1));
		graph.addEdge(new GraphEdge<Integer>(3, 6, true, 1));
		graph.addEdge(new GraphEdge<Integer>(6, 4, true, 1));
		graph.addEdge(new GraphEdge<Integer>(6, 7, true, 1));
		graph.addEdge(new GraphEdge<Integer>(1, 4, true, 1));
		graph.addEdge(new GraphEdge<Integer>(3, 10, true, 1));
		graph.addEdge(new GraphEdge<Integer>(10, 14, true, 1));
		graph.addEdge(new GraphEdge<Integer>(6, 14, true, 1));
		graph.addEdge(new GraphEdge<Integer>(7, 14, true, 1));
		
		graph.printGraph();
		
		graph.BFS(new GraphNode<Integer>(8, 1));
		
		graph.DFS(new GraphNode<Integer>(8, 1));
		
		
		GraphIndex graphIndex=new GraphIndex(8);

		graphIndex.addEdge(new GraphIndexedEdge(0, 1, true, 1));
		graphIndex.addEdge(new GraphIndexedEdge(0, 2, true, 1));
		graphIndex.addEdge(new GraphIndexedEdge(1, 3, true, 1));
		graphIndex.addEdge(new GraphIndexedEdge(1, 4, true, 1));
		graphIndex.addEdge(new GraphIndexedEdge(2, 5, true, 1));
		graphIndex.addEdge(new GraphIndexedEdge(3, 6, true, 1));
		graphIndex.addEdge(new GraphIndexedEdge(4, 7, true, 1));
		graphIndex.addEdge(new GraphIndexedEdge(4, 6, true, 1));
		graphIndex.addEdge(new GraphIndexedEdge(4, 5, true, 1));
		graphIndex.addEdge(new GraphIndexedEdge(1, 2, true, 1));
		graphIndex.addEdge(new GraphIndexedEdge(5, 7, true, 1));
		
		graphIndex.printGraph();
		
		graphIndex.BFS(new GraphIndexedNode(0, 1));
		
		graphIndex.DFS(new GraphIndexedNode(0, 1));
		
		
	}

}
