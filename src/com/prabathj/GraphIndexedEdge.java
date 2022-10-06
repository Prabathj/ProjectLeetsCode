package com.prabathj;

//Edge 0--[4]---1   = src=0, dst=1, direction=false, weight=4

public class GraphIndexedEdge {
	
	public int src;
	public int dst;
	public boolean direction;		//true=bidirectional(undirected), false=unidirectional
	public int weight;
	
	public GraphIndexedEdge(int src, int dst, boolean direction, int weight) {
		super();
		this.src = src;
		this.dst = dst;
		this.direction = direction;
		this.weight = weight;
	}

}
