package com.prabathj;

import java.util.Stack;
import java.util.Vector;

public class MinStack {

	public Stack<Integer> stack;
	public Stack<Integer> minVal;

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

    public MinStack() {
    	this.stack=new Stack<Integer>();
    	this.minVal=new Stack<Integer>();
    	minVal.push(Integer.MAX_VALUE);

    }
    
    public void push(int val) {

    	stack.push(val);
    	
    	minVal.push(Math.min(val, minVal.peek()));
        
    }
    
    public void pop() {
        
    	stack.pop();
    	minVal.pop();

    	
    }
    
    public int top() {

        return stack.peek();
    }
    
    public int getMin() {
        
    	return minVal.peek();
    }	
	
}
