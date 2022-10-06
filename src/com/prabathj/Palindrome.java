package com.prabathj;

public class Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(Palindrome.isPalindrome(" ,A mn, a plan, a canal: Panama"));
	}
	
    public static boolean isPalindrome(String s) {
        
    	String lowerCase = s.toLowerCase();
    	
    	char[] charArray = lowerCase.toCharArray();

    	int end=charArray.length-1;   
    	
    	for(int start=0;start<charArray.length;) {
    		
    		if(start>=end)
    			return true;
    		
    		char cS=charArray[start];
    		
    		if(!Character.isAlphabetic(cS) && !Character.isDigit(cS)){
    			start++;
    		}else {
    			
    			char cE=charArray[end];
    			while(!Character.isAlphabetic(cE) && !Character.isDigit(cE)) {
    				cE=charArray[--end];
    			}
    			
    			if(cE!=cS)
    				return false;
    			
    			end--;
    			start++;
    		}
    		
    		
    	}
    	
    	return true;
    }
}
