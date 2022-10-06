package com.prabathj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ThreeSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] val= {-1,0,1,2,-1,-4,3,-2,3};
		List<List<Integer>> twoSum = ThreeSum.threeSum(val);
		System.out.println();
	}
	
    public static List<List<Integer>> threeSum(int[] nums) {
        
    	Arrays.sort(nums);
    	
    	int s=0,e=nums.length-1,val=0,st=1;
    	
    	List<List<Integer>> fList=new ArrayList<>(); 
//    	Set<List<Integer>> set=new HashSet<>();
    	
    	
    	while(s<e) {
    		
    		val=-(nums[s]);

    		if(s==0 || (nums[s]!=nums[s-1])) {
    		
	    		while(st<e) {
	    		
	    			if(s==st-1 || (nums[st]!=nums[st-1])) {
	    				if((e==nums.length-1)||nums[e]!=nums[e+1]) {
	    			
				    		if(val==(nums[st]+nums[e])) {
				    			
				    			List<Integer> list=new ArrayList<Integer>();
				    			list.add(nums[s]);
				    			list.add(nums[st]);
				    			list.add(nums[e]);
			
				    			fList.add(list);;
				    			e--;
				    		}else if(val>(nums[st]+nums[e])) {
				    			
				    			st++;
				    			e=nums.length-1;
				    		}else {
				    			e--;
				    		}
	    				}else {
	    					e--;
	    				}
	    			}else {
	    				
	    				st++;
	    				e=nums.length-1;
	    			}

	    		}
    		
	    		s++;
	    		st=s+1;
	    		e=nums.length-1;
    		}else {
        		s++;
        		st=s+1;
        		e=nums.length-1;    			
    			
    		}
    	}
    	
    	return fList;
    }
    
}