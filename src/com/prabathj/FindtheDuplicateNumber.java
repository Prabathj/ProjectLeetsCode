package com.prabathj;

public class FindtheDuplicateNumber {

	public static void main(String[] args) {
		
		FindtheDuplicateNumber.findDuplicate(new int[]{1,3,4,2,2});

	}

    public static int findDuplicate(int[] nums) {
    	
    	int fast=0,slow=0;
    	
    	
    	do {
    		
    		slow=nums[slow];
    		fast=nums[nums[fast]];
    		
    	}while(fast!=slow);
    	

    	int nSlow=0;
    	
    	while(nSlow!=fast){
    		
    		nSlow=nums[nSlow];
    		fast=nums[fast];
    		
    	}
    	
    	
    	return fast;
    	
    	
        
    }

	
	
	
}
