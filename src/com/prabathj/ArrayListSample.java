package com.prabathj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

public class ArrayListSample {

	public static void main(String[] args) {
		
		//Sample for
		//new comment for feature_linked_list
		
		List<Integer> list=new ArrayList<>();
		list.add(10);
		list.add(8);
		list.add(0);
		list.add(null);
		list.add(6);
		list.add(2, 8); //shift existing elements to tight side to make space
		
		for (Integer integer : list) {
			System.out.print(integer+",");				//10,8,8,0,null,6
		}
		System.out.println();
		list.get(0);		//10
		list.indexOf(8);	//1
		list.lastIndexOf(8);	//2
		list.remove(0);		//8,8,0,null,6,
		list.remove(Integer.valueOf(0));
		for (Integer integer : list) {
			System.out.print(integer+",");				//8,8,null,6,
		}			
		
		list.set(0, 6);		//6,8,8,0,null,6,
		//list.sort(null);	
		//list.subList(3, 5);		//0,null
	
		
		LinkedList<Integer> alist=new LinkedList<>();
		
		
		Stack<Integer> stack=new Stack<>();
		
		stack.push(20);
		stack.push(2);
		stack.push(10);
		stack.push(50);
		stack.push(70);
		
		System.out.println(stack.search(70));
		
		Vector<Integer> vector=new Vector<>();
		
	
		
	}

}
