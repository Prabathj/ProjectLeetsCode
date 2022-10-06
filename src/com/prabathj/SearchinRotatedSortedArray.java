package com.prabathj;

public class SearchinRotatedSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(SearchinRotatedSortedArray.search(new int[] {3,-2,-1,0},-1));
		System.out.println(SearchinRotatedSortedArray.search(new int[] {5,1},5));
		//System.out.println(SearchinRotatedSortedArray.search(new int[] {4,5,6,7,8,1,2,3},8));

	}
	
	public  static int search(int[] nums, int target) {
		
		if(nums.length==1 && nums[0]==target)
			return 0;
		else if(nums.length==1 && nums[0]!=target)
			return -1;
		else
			return search1(0,nums.length-1,nums,target);
	}
	
	public static int search1(int s,int e,int[] nums, int target) {
		if(s>e)
			return -1;
		
		if(nums[s]<=nums[e]) {
			//no rotation
			return searchNoRotate(s,e,nums,target);
		}else {
			return searchRotate(s,e,nums,target);
		}
		
	}
	
	public  static int searchRotate(int s,int e,int[] nums, int target) {
		
		if(s>e)
			return -1;
		
		int m=(s+e)/2;
		
		if(nums[m]==target)
			return m;
		
		//First need to find out which side we are in
		//Left Portion
		if(nums[s]<=nums[m]) {
			
			if(nums[m]<target) { //Need to check only right side of the left portion
				return search1(m+1,e,nums, target);
			}else {
				
				if(nums[s]<=target)
					return search1(s,m-1,nums, target);
				else
					return search1(m+1,e,nums, target);
			}
			
			
		}else {
		//	if(nums[s]>nums[m]){		//right portion	
		
			
			if(nums[m]<target) { //Need to check only right side of the left portion
				
				if(nums[e]>=target)
					return search1(m+1,e,nums, target);
				else
					return search1(s,m-1,nums, target);				
				
			}else {
				return search1(s,m-1,nums, target);
			}			
			
			
		}
	
	}
	
	
	
	
	public static int searchNoRotate(int s,int e,int[] nums, int target) {

		if(s>e)
			return -1;
		
		int m=(s+e)/2;
		
		if(nums[m]<target)
			return searchNoRotate(m+1, e, nums, target);
		else if(nums[m]>target)
			return searchNoRotate(s, m-1, nums, target);
		else
			return m;
		
	}	
	
}
