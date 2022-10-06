package com.prabathj;

import java.util.Stack;


public class DailyTemperatures {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]={73,74,75,71,69,72,76,73};
		int[] dailyTemperatures = DailyTemperatures.dailyTemperatures(a);
		System.out.println();
	}
	
    public static int[] dailyTemperatures(int[] temperatures) {
        
    	int result[] =new int[temperatures.length];
    	for(int i=0;i<temperatures.length;i++)
    		result[i]=0;
    	
    	Stack<Pair> stack=new Stack<>();
    	
    	int S=0;
    	stack.push(new Pair(temperatures[S], S));
    	for(S=1;S<temperatures.length;S++) {
    		
    		while(!stack.empty()) {
    			
    			if(stack.peek().value >= temperatures[S]){
    				stack.push(new Pair(temperatures[S], S));
    				break;
    			}else {
    				
    				Pair p=stack.pop();
    				result[p.key]=S-p.key;
    				
    			}
    				
    		}
    		if(stack.empty())
    			stack.push(new Pair(temperatures[S], S));
    		
    	}
    	
    	
    	
    	return result;
    }
}


class Pair{
	
	int key;
	int value;
	
	public Pair(int value, int key) {
		super();
		this.key = key;
		this.value = value;
	}

	
}