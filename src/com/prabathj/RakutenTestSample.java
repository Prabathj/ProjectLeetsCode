package com.prabathj;

import java.util.HashSet;
import java.util.Set;

public class RakutenTestSample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a= {1};
		System.out.println(RakutenTestSample.solution(a));
	}
	
	
    public static int solution(int[] A) {
        // write your code in Java SE 8
    
    	int sol=1;
    
    	Set<Integer> s=new HashSet<>();
  	  	
    	for(int i=0;i<A.length;i++) {
    		
    		s.add(A[i]);
    		
    	}
    
    	for(int i=0;i<A.length;i++) {
    		
    		if(!s.contains(sol)) {
    			return sol;
    		}
    		sol++;
    	}   	
    	
    	return sol;
    	
    }
}
