package com.prabathj;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

//This graph can represent directed/undirected [edges are bidirectional is called an undirected graph] 
//,weighted and any type of Nodes Indexed or Not

public class Graph<T> {

	public Map<T,List<GraphNode<T>>> graph=new HashMap<>();
	
	public void addEdge(GraphEdge<T> edge) {

		//[A] ->[ (B,3),(C,4),(E,5)]
		
		//Source
		
		List<GraphNode<T>> listS = graph.get(edge.src);
		
		if(listS==null) {
			graph.put( edge.src, new LinkedList<>());	
		}
		
		graph.get(edge.src).add( (GraphNode<T>) new GraphNode<T>(edge.dst, edge.weight));

		//Destination
		
		List<GraphNode<T>> listD = graph.get(edge.dst);
		
		if(listD==null) {
			graph.put( edge.dst, new LinkedList<>());	
		}
		
			
		//Only if Bidirectional
		if(edge.direction==true) {
			
			graph.get(edge.dst).add( (GraphNode<T>) new GraphNode<T>(edge.src, edge.weight));	
		}
		
	}
	
	public void printGraph() {
		
		Set<Entry<T, List<GraphNode<T>>>> entrySet = graph.entrySet();
		
		for (Entry<T, List<GraphNode<T>>> entry : entrySet) {
			
			System.out.print(entry.getKey() + "-->");
			List<GraphNode<T>> value = entry.getValue();
			
			for (GraphNode<T> entry2 : value) {
				System.out.print(entry2.value+" ");
			}
			System.out.println();
		}
		
	}
	
	
	public void BFS(GraphNode<T> root) {
		
		Queue<T> queue=new LinkedList<>();		//Use to keep tab of parent Nodes
		Set<T> seen=new HashSet<>();			//Keep node which already processed
		
		queue.add(root.value);
		
		while(!queue.isEmpty()) {
			
			T node = queue.poll();
			
			//If Node already processed no need to look
			if(!seen.contains(node)) {
				seen.add(node);
				System.out.println(node);
				
			}
			
			List<GraphNode<T>> list = graph.get(node);
			
			//Explore the adjacent nodes
			for (GraphNode<T> t : list) {
				if(!seen.contains(t.value)) {
					queue.add(t.value);
				}				
			}
		}
	}
	
	
	public void DFS(GraphNode<T> root) {
		
		Stack<T> stack=new Stack<>();
		Set<T> seen=new HashSet<>();
		
		
		stack.push(root.value);
		
		while(!stack.isEmpty()) {
			
			T node = stack.pop();
			
			if(!seen.contains(node)) {
				seen.add(node);
				System.out.println(node);
			}
			
			List<GraphNode<T>> list = graph.get(node);
			
			for (GraphNode<T> graphNode : list) {
				
				if(!seen.contains(graphNode.value)) {
					stack.push(graphNode.value);
				}
			}
			
		}
		
	}
	
}
