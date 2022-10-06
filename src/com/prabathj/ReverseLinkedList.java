package com.prabathj;

public class ReverseLinkedList {
	
    public ListNode reverseList(ListNode head) {
        
    	ListNode prev=null,next=null;
    	
    	ListNode current=head;
    	
    	while(current!=null) {
    		next=current.next;
    		current.next=prev;
    		prev=current;

    		current=next;

    	}

    	return prev;
    }
    
    public ListNode reverseListRecursive(ListNode head) {
        
    	return recursive(head, null);
    }    
    
    public ListNode recursive(ListNode head,ListNode prev) {
        
    	if(head==null)
    		return prev;
    	else {
    		
    		ListNode nxt=head.next;
    		head.next=prev;
    		return recursive(nxt, head);
    	}
    	
    }     
    
    
}





class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}