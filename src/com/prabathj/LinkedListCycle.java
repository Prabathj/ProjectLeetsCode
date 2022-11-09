package com.prabathj;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public boolean hasCycle(ListNode head) {
        
    	Set<ListNode> nodeset=new HashSet<>();
    	
    	boolean flag=false;
    	
    	while(head!=null) {
    		
    		if(nodeset.contains(head))
    			return true;
    		else {
    			nodeset.add(head);
    			head=head.next;
    		}
    		
    	}
    	
    	
    	return flag;
    }
}
