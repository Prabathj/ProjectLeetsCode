package com.prabathj;

import java.util.Stack;

public class EvaluateReversePolishNotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public static int evalRPN(String[] tokens) {
        
    	Stack <Integer> stack=new Stack<>();
    	

    	String symbols="*+-/";
    	
    	for(int i=0;i<tokens.length;i++) {
    		
    		if(symbols.indexOf(tokens[i])<0) {
    			stack.push(Integer.parseInt(tokens[i]));
    		}else {
    			
    			int val3=0;
    			if(stack.capacity()>=2) {
    			int val2=stack.pop();
    			int val1=stack.pop();
    			
    			switch(tokens[i]) {
    			
    			case "+":
    				 			
    			 val3=val1+val2;
    			break;
    			case "-":
		 			
    				val3=val1-val2;
    			break;
    			case "*":
		 			
    				val3=val1*val2;
    			break;
    			case "/":
		 			
    				val3=val1/val2;
    			break;
  			
    			}
    			stack.push(val3);
    			}else if(stack.empty()) {
    				stack.push(0);
    				break;
    			}else {
    				break;
    			}
    		}
    		
    		
    	}
    	
    	return stack.pop();
    }	
	
}
