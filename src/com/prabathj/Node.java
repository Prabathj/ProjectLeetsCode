package com.prabathj;

public class Node {
	
	public int key;
	public Node right;		//Represent the link via this link we can get right/left node
	public Node left;
	
	public Node(int key, Node right, Node left) {
		super();
		this.key = key;
		this.right = right;
		this.left = left;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}
	
	

}
