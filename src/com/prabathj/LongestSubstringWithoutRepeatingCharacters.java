package com.prabathj;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] val= {7,6,4,3,1};
		boolean twoSum = LongestSubstringWithoutRepeatingCharacters.checkInclusion("adc","dcda");
		System.out.println(twoSum);
	}
	
    public static boolean checkInclusion(String s1, String s2) {
        
    	
    	Map<Character,Integer> mapO=new HashMap<>();
    	
    	int i=0;
    	while(i<s1.length()) {
    		char c=s1.charAt(i);
    		
    		int l=mapO.getOrDefault(c, -1);
    		if(l==-1) {
    			mapO.put(c, 1);
    			
    		}else
    			mapO.put(c, l+1);
    		
    			i++;
    	}
    	
    	Map<Character,Integer> mapN=new HashMap<>();
    	
    	int L=0,R=0,le=0;
    	while(R<s2.length()) {
    		
    		char c=s2.charAt(R);
    		Integer v=mapO.get(c);
    		if(v!=null) {
    			le++;
        		int l=mapN.getOrDefault(c, -1);
        		if(l==-1) {
        			mapN.put(c, 1);
        			
        		}else if(v<l)
        			mapN.put(c, l+1);
        		else {
        			if(mapO.equals(mapN))
        				return true;       			
        			
        			char c2=s2.charAt(L);
        			//int l=mapN.get(c);

        			
        		}
        			
        			R++;    			
    			
    		}else {
    			if(mapO.equals(mapN))
    				return true;
    			
    			mapN.clear();
    		    R++;			
    		}
    		
    	}
    	
		if(mapO.equals(mapN))
			return true;    	
		else
			return false;
    } 
    
}
