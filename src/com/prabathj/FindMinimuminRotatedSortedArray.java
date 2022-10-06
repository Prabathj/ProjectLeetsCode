package com.prabathj;

public class FindMinimuminRotatedSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(FindMinimuminRotatedSortedArray.findMin(new int[] {-2,0,4,5,6,7,8,9,10,-4,-3,}));
	}
	
	
    public static int findMin(int[] nums) {
        
    	if(nums[0]<=nums[nums.length -1]) {
    		//no rotate & only one
    		return nums[0];
    	}else {
    		
    		return rotate(0,nums.length-1,nums);
    		
    	}
    	
    	
    }
    
    
    public static int rotate(int s,int e,int[] nums) {
    	
    	if((e-s) <=1)
    		return nums[e];
    	
    	int m=(e+s)/2;
/*    	
    	if(nums[s]>nums[m]) {
    		return rotate(s,m,nums);
    	}else if(nums[m]>nums[e]) {
    		return rotate(m,e,nums);
    	}else {
    		return -1;
    	}
*/    	
    	if(nums[s]>nums[m]) {
    		return rotate(s,m,nums);
    	}else {
    		return rotate(m,e,nums);
    	}

    }
}
