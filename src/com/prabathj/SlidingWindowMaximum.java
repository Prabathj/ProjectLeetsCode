package com.prabathj;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.DelayQueue;

public class SlidingWindowMaximum {

	public static void main(String[] args) {
		
		int w[] = {1,3,-1,-3,5,3,6,7};
		
		//int w[] = {7,2,4};
		int[] maxSlidingWindow = SlidingWindowMaximum.maxSlidingWindow(w, 3);
		
		for (int i : maxSlidingWindow) {
			System.out.print(i+",");
		}
	}
	
	
	public static int[] maxSlidingWindowMine(int[] nums, int k) {
        
		int[] ret=new int[nums.length-(k-1)];
		
		Queue<Integer> queue=new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				
				return o2-o1;
			}
		});
		
		if(k==1)
			return nums;
		
		int L=0,R=0,size=0,p=0,prev=Integer.MIN_VALUE,second=Integer.MIN_VALUE,max=Integer.MIN_VALUE;
		
		while(R<nums.length) {
			
			if(size<k) {
				
				if(max<nums[R]) {
					second=max;
					max=nums[R];
				}else if(second<nums[R]) {
					second=nums[R];
				}
					
				
				size++;
				R++;
			}else {
				
				ret[p++]=max;
				
				if(max==nums[L] ) {
					if(second<nums[R])
						max=nums[R];
				}
					
				
				
				prev=0;
				L++;
				size--;
					
				}
	
			}
		
			if(size==k) {
				ret[p++]=prev;			
			}
				
		
				
		return ret;
			}
	
	public static int[] maxSlidingWindow(int[] nums, int k) {
		int res[]=new int[nums.length -(k-1)];
		
		Deque<Integer> queue=new LinkedList<>();
		
		int L=0,R=0,size=0;
		while(R<nums.length) {
			
			while(size>=k) {
				
			}
			
			
			if(size<k) {
				
				queue.addLast(nums[R]);
				
			}
			
			
			
			
		}
		
		
		return null;
		
		
		
		
		
		
	}			
}
