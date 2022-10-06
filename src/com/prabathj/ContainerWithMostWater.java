package com.prabathj;

public class ContainerWithMostWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] val= {1,5,6,2,5,4,8,3,7,2,9,6,4};
		int twoSum = ContainerWithMostWater.maxArea(val);
		System.out.println(twoSum);
		int maxAreaN = ContainerWithMostWater.maxAreaN(val);
		System.out.println(maxAreaN);
	}
	
    public static int maxArea(int[] height) {
        
    	
    	int max=0,maxsub=0,maxm=0;
    	
    	int s=0,e=height.length-1,sm=0;
    	
    	while(s<e) {
    		
    		
    		while(sm<e){
    			
    			if(height[e]>=height[sm]) {
    				
    				maxsub=(e-sm)*height[sm];
    				if(maxsub>=max) {
    					max=maxsub;
    				}
    					
    			//break;
    				sm++;
    				e=height.length-1;
    			}else {
    				
    				maxm=(e-sm)*height[e];
    				if(maxm>max)
    					max=maxm;
    				
    				e--;
    			}
    			
    			
    		}
    		
    		e=height.length-1;
    		s++;
    		sm=s;
    	}
    	
    	
    	return max;
    }     
    
    public static int maxAreaN(int[] height) {
    
    	int s=0, e=height.length-1;
    	int area=0,maxarea=0;
    	
    	while(s<e) {
    		
    		area=minOfH(height[s],height[e]) *(e-s);
    		
    		if(maxarea<area)
    			maxarea=area;
    		
    		if(height[s]>height[e])
    			e--;
    		else
    			s++;
    			
    	}
    	
    	return maxarea;
    }
    
    public static int minOfH(int h1,int h2) {
    	
    	if(h1>h2)
    		return h2;

    	else
    		return h1;
    				
    }
    
    
}
