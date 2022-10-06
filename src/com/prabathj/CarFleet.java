package com.prabathj;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class CarFleet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(CarFleet.carFleet(10, new int[]{6,8},new int[]{3,2}));
		
	}
	
    public static int carFleet(int target, int[] position, int[] speed) {
        
    	NPair poseed[] =new NPair[position.length];
    	
    	int index=0;
    	
    	for (int i : position) {
			
    		poseed[index]=new NPair(i,speed[index],index);
    		index++;
    		
		}
    	
    	Arrays.sort(poseed);
    	
    	Stack<NPair> stack=new Stack<>();
    	
    	stack.push(poseed[0]);
    	
    	for (int k=1;k<poseed.length;k++) {
			
    		NPair cur=poseed[k];
    		
        	//while(!stack.empty()) {
        		
        		NPair pop = stack.peek();
        		
        		float timeToReachF=(float)(target-pop.pos)/pop.speed;
        		
        		float timeToReachS=(float)(target-cur.pos)/cur.speed;
        		
        		if(timeToReachF>=timeToReachS) {

        			
        		}else {
        			
        			stack.push(cur);
        		}
        		
        		
        	//}    		
    		
    		
		}
    	
    	
    	
    	
    	

    	
    	
    	
    	return stack.size();
    }
    
    
    
    
}

class NPair implements Comparable<NPair>{
	int pos;
	int speed;
	int index;
	
	public NPair(int pos, int speed, int index) {
		super();
		this.pos = pos;
		this.speed = speed;
		this.index = index;
	}

	@Override
	public int compareTo(NPair pos) {
		
		return pos.pos-this.pos;
	}
	
	
	
}