package com.prabathj;

public class RakutenTest {

	public static void main(String[] args) {
		int x = 12, y = 21;   //declaring values  
		// bitwise XOR     
		// 0101 ^ 0111 = 0101 = 2    
		// Performing an operation with xor and traditional operator   
//		System.out.println("x ^ y = " + (x ^ y)); 
		
		System.out.println(RakutenTest.solution(101, 106));

	}

    public static int solution(int M, int N) {
        
    	if(N>M) {
    		int result=solution(M,N-1);
    		//int xor=M^(N-1);
    		return result^N;
    		
    	}else {
    		return M;
    	}
    	
    	
    	
    }	

	
}
