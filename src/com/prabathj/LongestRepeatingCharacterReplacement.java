package com.prabathj;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class LongestRepeatingCharacterReplacement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(LongestRepeatingCharacterReplacement.characterReplacement("ABAACA", 2));
	}
	

	    public static int characterReplacement(String s, int k) {
	        
	    	Map<Character,Integer> map=new HashMap<>();
	    	
	    	int L=0;
	    	int R=0;
	    	int length=0,d=0,max=0;
	    	
	    	
	    	for(;R<s.length();R++) {
	    		
	    		map.put(s.charAt(R), map.getOrDefault(s.charAt(R),0)+1);
	    		max=getMapMax(map);
	    		d=(R-L)+1-max;	    		
	    		
	    		if(d<=k) {
	    			
	    			length=Math.max(length,(R-L)+1);

	    		}else {
	    			while(d>k) {
	    				map.put(s.charAt(L), map.get(s.charAt(L))-1);
	    				L++;
	    	    		max=getMapMax(map);
	    	    		d=(R-L)+1-max;	   	    				
	    			}
	    		}
	    			
	    	}
	    	
	    	return length;
			/*
			 * while(R<a.length) { int max=getMapMax(map); d=length-max;
			 * 
			 * while(d<=k && R< s.length() ) { char c=a[R]; length++; int
			 * cc=map.getOrDefault(c, -1); if(cc==-1) { map.put(c, 1); }else {
			 * map.put(c,(cc+1)); }
			 * 
			 * max=getMapMax(map); d=length-max; R++; }
			 * 
			 * if(d>k) length--;
			 * 
			 * if(count<length) count=length;
			 * 
			 * 
			 * 
			 * char c=a[L]; int cc=map.get(c);
			 * 
			 * map.put(c,(cc-1)); length--;
			 * 
			 * 
			 * L++;
			 * 
			 * 
			 * }
			 * 
			 * return count;
			 */   	
	    }

	    public static int getMapMax(Map<Character,Integer> map) {
	    	
	    	Set<Entry<Character, Integer>> entrySet = map.entrySet();
	    	
	    	int max=0;
	    	for (Entry<Character, Integer> entry : entrySet) {
				int n=entry.getValue();
	    		if(max<n)
	    			max=n;
	    		
	    		
	    		
			}
	    	return max;
	    	
	    }

	    

}
