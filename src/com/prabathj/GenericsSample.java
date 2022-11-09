package com.prabathj;

import java.util.Arrays;
import java.util.List;

public class GenericsSample {

	public static void m1(List<Object> list) {
		
		list.stream().forEach(obj->System.out.println(obj));
		
	}
	
	
	public static void m2(List<? extends Object> list) {
		
		list.stream().forEach(obj->System.out.println(obj));
		
	}
		
	public static void m3(List<? super Object> list) {
		
		list.stream().forEach(obj->System.out.println(obj));
		
	}
	
	public static void main(String[] args) {
		
		List<String> abc=Arrays.asList("a","b","c");
		//GenericsSample.m1(abc);	//compile error
		
		GenericsSample.m2(abc);
		
		//GenericsSample.m3(abc);		//compile error
	}

}
