package com.prabathj;

import java.util.LinkedList;
import java.util.List;

public class DijkstraSortestPathAlgorithm {
	
	public List<List<Node>> adjList=new LinkedList<>();
	public static final int V=6;
	
	public class Node{
		public int v;
		public int w;
		public Node(int v, int w) {
			super();
			this.v = v;
			this.w = w;
		}
		
	}
	
	public class Edge{
		
		public int src;
		public int dst;
		public int w;
		
		public boolean dir;		//true=bidirect , false

		public Edge(int src, int dst, int w, boolean dir) {
			super();
			this.src = src;
			this.dst = dst;
			this.w = w;
			this.dir = dir;
		}
		
	}
	
	
	

	public DijkstraSortestPathAlgorithm(int V) {
	
		for(int i=0;i<V;i++) {
			adjList.add(new LinkedList<>());
		}
		
	}

	public void addEdge(Edge edge) {
		
		adjList.get(edge.src).add(new Node(edge.dst,edge.w));
		if(edge.dir)
			adjList.get(edge.dst).add(new Node(edge.src,edge.w));
		
	}

	public void printGraph() {
		int i=0;
		for (List<Node> list : adjList) {
			System.out.print(i+" ->");
			for (Node node : list) {
				System.out.print("("+node.v+","+node.w+")");
			}
			System.out.println();
			i++;
		}
		
	}
	
	
	public void dijkstraAlgo(int src) {
		
		boolean seen[]=new boolean[V];			//keep track of nodes which shortest path calculated
		int shortedValue[]=new int[V];			//Keep the value of the shortest path of each node
		
		for(int i=0;i<V;i++) {
			seen[i]=false;
			shortedValue[i]=Integer.MAX_VALUE;		//Set infinite initially as no node is shorted
		}
		
		seen[src]=true;
		shortedValue[src]=0;
		
		//Only V-1 nodes need to be visited as Last node no need to visited as it is sorted when come
		//to its previous iteration eg: V=10  then index 0-9 , 
		//the 10th time no need to iterate as at 8th time all the nodes are sorted

		for(int i=0;i<(V-1);i++) {
			
			int nodeI=this.getMin(shortedValue, seen);
			List<Node> adjListOfshortedNode = adjList.get(nodeI);
			
			for (Node node : adjListOfshortedNode) {
				//process only if it is not shorted already
				if(!seen[node.v]) {
					
					int possibleV =shortedValue[nodeI] + node.w;
					
					if(possibleV<shortedValue[node.v]) {
						shortedValue[node.v]=possibleV;
					}
					
				}
				
			}
			seen[nodeI]=true;
			
		}
		
		int k=0;
		for (int i : shortedValue) {
			System.out.println(k+" "+i);
			k++;
		}
		
	}
	
	//This will find the available shortest path of the current evaluated nodes
	public int getMin(int shortedValue[],boolean seen[]) {
		
		int min=Integer.MAX_VALUE;
		int minNode=0;
		for(int i=0; i<V;i++) {
			
			if((shortedValue[i]<min) && !seen[i]) {
				min=shortedValue[i];
				minNode=i;
			}
			
			
		}
		
		return minNode;
		
	}

	public static void main(String[] args) {
		
		DijkstraSortestPathAlgorithm algo=new DijkstraSortestPathAlgorithm(V);
		algo.addEdge(algo.new Edge(0, 1, 2, false));
		algo.addEdge(algo.new Edge(0, 2, 4, false));
		algo.addEdge(algo.new Edge(1, 3, 7, false));
		algo.addEdge(algo.new Edge(2, 4, 3, false));
		algo.addEdge(algo.new Edge(1, 2, 1, false));
		algo.addEdge(algo.new Edge(4, 3, 2, false));
		algo.addEdge(algo.new Edge(3, 5, 1, false));
		algo.addEdge(algo.new Edge(4, 5, 5, false));
		
		algo.printGraph();

		algo.dijkstraAlgo(0);
		
	}

}
