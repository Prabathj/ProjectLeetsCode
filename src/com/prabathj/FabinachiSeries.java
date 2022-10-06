package com.prabathj;

public class FabinachiSeries {

	public static void main(String[] args) {

		System.out.println(FabinachiSeries.fab(5));

	}

	public static int fab(int n) {
		
		if(n==1 || n==2)
			return 1;
		
		if(n>=3) {
			
			int sum=fab(n-1)+fab(n-2);
			System.out.println(sum);
			return sum;
		}
		
		return 0;
		
		
	}
	
}
