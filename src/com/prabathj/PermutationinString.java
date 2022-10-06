package com.prabathj;

import java.util.HashMap;
import java.util.Map;

public class PermutationinString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(PermutationinString.checkInclusion("adc","dcda"));
	}
	
	 public static boolean checkInclusion(String s1, String s2) {
        
		 Map<Character,Integer> maps1=new HashMap<>();
		 
		 for (int i=0;i<s1.length();i++) {
			
			 maps1.put(s1.charAt(i), maps1.getOrDefault(s1.charAt(i), 0)+1);
		 
		}

		 int L=0,R=0;
		 
		 Map<Character,Integer> maps2=new HashMap<>();
		 
		 
		 while(R<s2.length()) {
			 
			 if((R-L+1)<=s1.length()) {
			 
			 if(maps1.get(s2.charAt(R))!=null) {
					maps2.put(s2.charAt(R), maps2.getOrDefault(s2.charAt(R), 0)+1);
					R++;				 
				 
			 }else {
					R++;
					L=R;
					maps2.clear();				 
			 }
			 
			 }else {
				 

						if(maps2.equals(maps1))
							return true;
						else {
							maps2.put(s2.charAt(L), maps2.getOrDefault(s2.charAt(L), 0)-1);
							L++;
							
						}				 
				 
				 
			 }
			 
			 
		 }
		 
		 
			/*
			 * for(;R<s2.length();) {
			 * 
			 * while((R-L+1)<=s1.length() && R<s2.length()) {
			 * 
			 * if(maps1.get(s2.charAt(R))!=null) {
			 * 
			 * }else { R++; L=R; maps2.clear(); break; } }
			 * 
			 * if(!maps2.isEmpty()) { if(maps2.equals(maps1)) return true; else { L++; R=L;
			 * maps2.clear(); } } }
			 */
		 if(maps2.equals(maps1)) 
			 return true;
		 else
			 return false;

    }
}
