package com.prabathj;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MinimumWindowSubstring {

	public static void main(String[] args) {
		
		System.out.println(MinimumWindowSubstring.minWindow("ADOBECODEBANCQ", "ABC"));

	}

    public static String minWindow(String s, String t) {
        
    	Map<Character,Integer> required=new HashMap<>();
    	
    	for(int i=0;i<t.length();i++) {
    		
    		required.put(t.charAt(i),required.getOrDefault(t.charAt(i), 0)+1);
    		
    	}
    	
    	
    	int requiredCount=required.size();
    	int haveCount=0;
    	int L=0,R=0;
    	int size=Integer.MAX_VALUE,start=0,end=0;
    	Map<Character,Integer> have=new HashMap<>();
    	
    	while(L<s.length()) {
    		
    		if(R<s.length()) {
    		
	    		if(requiredCount>haveCount ) {
	    			
		    		if(required.get(s.charAt(R))!=null) {
		    			have.put(s.charAt(R), have.getOrDefault(s.charAt(R), 0)+1);
		    			haveCount=getHaveCount(required,have);
		    		}		
	    			R++;
	    		}else {
	    			
	    			if(size>(R-L)) {
	    				size=Math.min(R-L, size);
	    				start=L;
	    				end=R;
	    				
	    			}
	    			
	    			
		    		if(required.get(s.charAt(L))!=null) {
		    			have.put(s.charAt(L), have.getOrDefault(s.charAt(L), 0)-1);
		    			haveCount=getHaveCount(required,have);
		    		}    			
	    			L++;
	    		}
	    		
    		}else {
    			if(requiredCount==haveCount) {
	    			if(size>(R-L)) {
	    				size=Math.min(R-L, size);
	    				start=L;
	    				end=R;
	    				
	    			}
		    		if(required.get(s.charAt(L))!=null) {
		    			have.put(s.charAt(L), have.getOrDefault(s.charAt(L), 0)-1);
		    			haveCount=getHaveCount(required,have);
		    		}    			
	    			  				
    			}else
    				break;
    			
    			L++; 
    		}

    	}
    	
    	
    	return s.substring(start, end);
    }	
    
    public static int getHaveCount(Map<Character,Integer> r,Map<Character,Integer> h) {
    	
    	Set<Character> entrySet = h.keySet();
    	int re=0;
    	for (Character entry : entrySet) {
			if(h.get(entry)>=r.get(entry))
				re++;
    		
		}
    	
    	return re;
    }
    
}
