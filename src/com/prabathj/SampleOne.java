package com.prabathj;

public class SampleOne {

	public final String name;
	public final int age;
	
	{
		name="prabath";
	}
	
	public SampleOne() {
		age=10;
	}
	
	public SampleOne(int value) {
		age=10;
	}	
	
	public static void main(String[] args) {
		SampleOne obj=new SampleOne();
		System.out.println(obj.name);

	}

}
