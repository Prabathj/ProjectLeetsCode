package com.prabathj;

public class TwoSum2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] val= {2,7,10,11,13,15,17,23,67};
		int[] twoSum = TwoSum2.twoSum2(val,24);
		System.out.println(twoSum[0]+" "+twoSum[1]);
	}
	
    public static int[] twoSum(int[] numbers, int target) {
        
    	int start=0;
    	int end= numbers.length-1;
    	int[] result = {-1,-1};
    	
    	for (int i : numbers) {
		
    		if((i+numbers[end]) ==target) {
    			result[0]=start;
    			result[1]=end;
    			return result;
    		
    		}else if((i+numbers[end]) > target) {
    			
    			end--;
    			while((i+numbers[end]) >= target && start<end) {
    				
    				if((i+numbers[end]) ==target) {
    	    			result[0]=start;
    	    			result[1]=end;  
    	    			return result;
    				}	
    				end--;
    			}
    			
    			i++;
    			end=numbers.length-1;
    		}else if((i+numbers[end]) < target) {
    			i++;
    			
    		}
    			
    		
    		
		}
    	
    	
    	
    	
    	return result;
    }    
    
    public static int[] twoSum2(int[] numbers, int target) {
        
    	int start=0;
    	int end= numbers.length-1;
    	int[] result = {-1,-1};
    	
    	
    	while(start<end) {
    		
    		if((numbers[start]+numbers[end])==target) {
    			result[0]=start;
    			result[1]=end;
    			return result;    			
    			
    		}else if((numbers[start]+numbers[end])>target) {
    			end--;
    		}else{
    			end=numbers.length-1;
    			start++;
    		}
    	}
    	
    	return result;
    }        
    
}
