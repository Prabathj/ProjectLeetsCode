package com.prabathj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TrappingRainWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] val= {5,5,1,7,1,1,5,2,7,6};
		int twoSum = TrappingRainWater.trap(val);
		System.out.println(twoSum);
	}
	
    public static int trap(int[] height) {
        
    	int water=0;
    	int l=0,r=height.length-1;
    	int maxL=height[l],maxR=height[r];
    	
    	while(l<r) {

    		
			/* At a given point we separate array to left and right 
			 * and maxL=height[l], maxR=height[r] at intially
			 * water at any given index= min(maxL,maxR) * height[i]
			 * 
			 * We move to the side left or right based on if(maxL<=maxR)
			 * so at any given index If we are in the left side our maxL smaller than maxR,
			 * so even there are many numbers in the right side least MAX number will be the current maxR
			 * and as we are on the left side min(maxL,maxR) = maxL and it will not change
			 * 
			 * same goes to right side
			 * We move to right side if(maxL>maxR)
			 * 
			 * */
    		
    		

    		if(maxL<=maxR) {
    			l++;		//Ignore the height[0] one as no left
    			if((maxL-height[l])>0) {
    				water+=(maxL-height[l]);
    			}else
    				maxL=height[l];
    			
    			
    			
    		}else {
    			r--;	////Ignore the height[height.length-1]  as no right
    			if((maxR-height[r])>0) {
    				water+=(maxR-height[r]);
    			}else
    				maxR=height[r];
    			
    			
    		}
    		
    	}

    	return water;
    }
    
}