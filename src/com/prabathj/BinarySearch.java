package com.prabathj;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(BinarySearch.search(new int[] {-1,0,3,5,9,12}, -1));
	}
	
	
    public static int search(int[] nums, int target) {
        
    	return binarySearch(0, nums.length-1, nums, target);
    }
    
    public static int binarySearch(int start,int end,int[] nums,int target) {
    	
    	if(start>end)
    		return -1;
    	
    	int mid=(start+end)/2;			
    				
    	if(nums[mid]>target) {
    		return binarySearch(start, mid-1, nums, target);
    	}else if(nums[mid]<target) {
    		return binarySearch(mid+1, end, nums, target);
    	}else
    		return mid;
    	
    	
    }
}
