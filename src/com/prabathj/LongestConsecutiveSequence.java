package com.prabathj;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums= {0,3,7,2,5,8,4,6,0,1};
		System.out.println(LongestConsecutiveSequence.longestConsecutive(nums));
		
	}

	 public static int longestConsecutive(int[] nums) {
		 
		 Set<Integer> numsSet =new HashSet<>();
		 
		 //O(n)
		 for (int i : nums) {
			numsSet.add(i);
		 }
		 
		 int prev=0;
		 int post=0;
		 int count=0;
		 int prevCount=0;
		 for (int i : nums) {
			
			 post=i+1;
			 prev=i-1;
			 count=0;
			if(numsSet.contains(prev)) {
				//not
			}else {
				//worst case first element is a start so run while for whole set O(n) at any other given time it is O(1)
				//So in the time comeplexity O(n)+ [O(1)+O(1)+...........] n time O(n) +O(n) -> O(n)
				count++;
				while(numsSet.contains(post)) {		
					post++;
					count++;
				}				
			}
			if(count>prevCount)
				prevCount=count; 
			 
		 }
		 
		 return prevCount;
	 }
}
