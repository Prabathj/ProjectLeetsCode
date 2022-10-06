package com.prabathj;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(ValidParentheses.isValid("()"));
		
	}

    public static boolean isValid(String s) {
    	
    	String open= "({[";
    	String close= ")}]";
    	//char[] close= {')','}',']'};

    	Stack<Character> stack=new Stack<Character>();
    	
    	for(int i=0;i<s.length();i++) {
    		
    		char c=s.charAt(i);
    		int in=open.indexOf(c);
    		if(in>-1) {
    			stack.push(c);
    		}else {
    			
    			int cl=close.indexOf(c);
    			
    			if(cl<0 || stack.isEmpty()|| open.charAt(cl)!=stack.pop())  			
    				return false;
    		}
    		
    	}
    	
    	if(stack.isEmpty())
    		return true;
    	else
    		return false;
    	
        
    }	
}
