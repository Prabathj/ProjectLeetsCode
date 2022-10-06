package com.prabathj;

//Edge A--[4]---B   = src=A, dst=B, direction=false, weight=4

public class GraphEdge<T> {
	
	public T src;
	public T dst;
	public boolean direction;		//true=bidirectional, false=unidirectional
	public int weight;
	
	public GraphEdge(T src, T dst, boolean direction, int weight) {
		super();
		this.src = src;
		this.dst = dst;
		this.direction = direction;
		this.weight = weight;
	}

}
