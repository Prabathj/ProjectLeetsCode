package com.prabathj;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.Map.Entry;
import java.util.Queue;

//This graph can represent directed/undirected [edges are bidirectional is called an undirected graph] 
//,weighted and any type of Nodes only Indexed 

public class GraphIndex {

	//This graph is handled based on Index
	public List<List<GraphIndexedNode>> graph=new LinkedList<>();
	
	public GraphIndex(int maxNodes) {
		
		for(int i=0;maxNodes>i;i++) {
			
			graph.add(i,new LinkedList<>());
			
		}
		
		
	}
	
	public void addEdge(GraphIndexedEdge edge) {
		
		List<GraphIndexedNode> listS = graph.get(edge.src);
		
		listS.add(new GraphIndexedNode(edge.dst, edge.weight));
		
		//BiDirectional -No direction
		if(edge.direction==true) {
			List<GraphIndexedNode> listD = graph.get(edge.dst);
			listD.add(new GraphIndexedNode(edge.src, edge.weight));
		}
	}
	
	public void printGraph() {
		
		int i=0;
		for (List<GraphIndexedNode> list : graph) {
			
			System.out.print(i + "-->");
			
			for (GraphIndexedNode entry : list) {
				System.out.print(entry.value+" ");
			}
			System.out.println();
			i++;
		}
		
	}	
	
	public void BFS(GraphIndexedNode root) {
		
		Queue<Integer> queue=new LinkedList<>();
		Set<Integer> seen=new HashSet<>();
		
		queue.add(root.value);
		
		while(!queue.isEmpty()) {
			
			Integer value = queue.poll();
			
			if(!seen.contains(value)) {
				seen.add(value);
				System.out.println(value);
				List<GraphIndexedNode> list = graph.get(value);
				
				for (GraphIndexedNode graphIndexedNode : list) {
					
					if(!seen.contains(graphIndexedNode.value)) {
						queue.add(graphIndexedNode.value);
					}
				}				
			}
			

		}		
		
	}
	
	
	public void DFS(GraphIndexedNode root) {
		
		Stack<Integer> stack=new Stack<>();
		Set<Integer> seen=new HashSet<>();
		
		stack.push(root.value);
		
		while(!stack.isEmpty()) {
			
			Integer value = stack.pop();
			
			if(!seen.contains(value)) {
				seen.add(value);
				System.out.println(value);
				List<GraphIndexedNode> list = graph.get(value);
				
				for (GraphIndexedNode graphIndexedNode : list) {
					
					if(!seen.contains(graphIndexedNode.value)) {
						stack.push(graphIndexedNode.value);
					}
				}				
			}
			

		}
		
		
	}
	
	
}
