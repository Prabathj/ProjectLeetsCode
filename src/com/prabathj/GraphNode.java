package com.prabathj;

//Node Take any type as its value [0,1,2,3]/[A,B,C]/[A,B,1,2]

public class GraphNode<T> {

	public T value;
	public int weight;
	
	public GraphNode(T value, int weight) {
		super();
		this.value = value;
		this.weight = weight;
	}

}
