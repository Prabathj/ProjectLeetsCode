package com.prabathj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestCaseOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Integer a=1234;
		Object o=a;

		//Object m=new Object();
		//Long x=(Long) m;	//Runtime exception
		
		Object m=new Long(1234l);
		Long c=(Long) m;
		
		String s="ss";
		Object bn=s;
		
		Long e=1234L;
		
		String ss=String.valueOf(e);
		
		Double t=Double.parseDouble(ss);
		
		List<Long> lsit=new ArrayList<Long>();

		
		int[] A= {1, 3, 6, 4, 5, 2}; 
		System.out.println(TestCaseOne.solution(A));
		
	}

    public static int solution(int[] A) {
        // write your code in Java SE 8
    	
    	
    	
    	Set<Integer>  set=new HashSet<>();
    	
    	
    	int s=0,a=0;
    	
    	for(s=0;s<A.length;s++) {
    		
    		a=A[s];
    		set.add(a);
    	}
    	int o=1;
    	for(s=0;s<A.length;s++) {
    		if(set.add(o)) {
    			return o;
    		}else
    			o++;
    	}    	

    	return o;
    }
}
