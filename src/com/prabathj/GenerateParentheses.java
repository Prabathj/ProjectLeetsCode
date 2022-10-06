package com.prabathj;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenerateParentheses {

	public static void main(String[] args) {
		
		List<String> generateParenthesis = GenerateParentheses.generateParenthesis(2);
		System.out.println();
	}
	
    public static List<String> generateParenthesis(int n) {
        
    	List<String> list=new ArrayList<>();
    	
    	Stack<Character> stack=new Stack<>();
    	
    	paranteseis(stack,0,0,n);
    	
    	int i=1,index=0;
    	Character[] a=new Character[n*2]; 
    	for (Character c : stack) {
			
    		if(i==n*2) {
    			
    			list.add(String.valueOf(a));
    			i=1;
    			index=0;
    		}else {
    			i++;
    			a[index]=c;
    			index++;
    		}
    		
    		
		}
    	
    	
    	
    	return list;
    }
    
    public static void paranteseis(Stack<Character> stack,int open,int close,int n ) {
    	
    	if(open==n && close==n)
    		return;
    	
    	
    	if(open<n) {
    		stack.push('(');
    		paranteseis(stack,open+1,close,n);
    		stack.pop();    
    		//the recursive process may repeat the same character set from this point 
    		//but because of this POP the path is changed
    	}
    		
    	if(close<open && close<n) {
    		stack.push(')');
    		paranteseis(stack,open,close+1,n);
    		stack.pop();
    	}
    	

    }
    
    
}
