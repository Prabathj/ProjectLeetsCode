package com.prabathj;

public class AddTwoNumbersLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	
    	
    	ListNode dummy=new ListNode();
    	ListNode head=dummy;
    	
    	int prev=0;
    	
    	while(l1!=null && l2!=null) {
    		
    		int f=l1.val+l2.val+prev;
    		
    		prev=f/10;
    		int rem=f%10;

    		dummy.next=new ListNode(rem,null);
    		dummy=dummy.next;
    		l1=l1.next;
    		l2=l2.next;
    		
    	}
    	
    	if(l1!=null) {
    		dummy=this.remainList(l1, dummy, prev);
    		prev=0;
    	}
    	
    	if(l2!=null) {
    		dummy=this.remainList(l2, dummy, prev);
    		prev=0;
    	}
    	
    	if(prev!=0) {
    		dummy.next=new ListNode(prev,null);
    		dummy=dummy.next;    		
    	}
    	
    	
		return head.next;
        
    }
    
    public ListNode remainList(ListNode list, ListNode dummy,int prev) {

		while(list!=null) {

        		int f=list.val+prev;
        		
        		prev=f/10;
        		int rem=f%10;

        		dummy.next=new ListNode(rem,null);
        		dummy=dummy.next;
        		list=list.next; 			
			
		}   
    	if(prev!=0) {
    		dummy.next=new ListNode(prev,null);
    		dummy=dummy.next;    		
    	}
    	return dummy;
    }
    
}
 
