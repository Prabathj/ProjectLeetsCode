package com.prabathj;

import java.util.Arrays;

public class KokoEatingBananas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(KokoEatingBananas.minEatingSpeed(new int[] {805306368,805306368,805306368},1000000000));
		//System.out.println(KokoEatingBananas.minEatingSpeed(new int[] {30,30,30},35));
	}
	
	public static int minEatingSpeed(int[] piles, int h) {
		
		Arrays.sort(piles);
		
		int min=Integer.MAX_VALUE;
		int speed=Integer.MAX_VALUE;
		return search(0,piles[piles.length-1]-1,piles,h,speed,min);

	}
    
	public static int search(int s, int e, int[] piles, int h,int speed,int min) {
		
		
		if(s>e)
			return speed;
		int m=(s+e)/2;
		
		int time=calcualteTime(piles, m+1,h);
		

		
		if(time<=h) {
			if((m+1)<speed) {
				speed=m+1;
			}				
			return search(s,m-1,piles,h,speed,min);
		
		}else
			return search(m+1,e,piles,h,speed,min);
		
		
	}
	
	public static int calcualteTime(int[] piles,int speed,int h ) {
		
		int time=0;
		
		for (int i : piles) {
			
			if(time>h)
				return h+1;
			
			if(i%speed==0)
				time+=(i/speed);
			else {
				time+=(i/speed);
				time++;
			}
			
		}
		
		
		return time;
		
	} 
    
}
