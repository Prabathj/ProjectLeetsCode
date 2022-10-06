package com.prabathj;

public class RemoveNthNodeFromEndofList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


    public ListNode removeNthFromEnd(ListNode head, int n) {
        
    	
    	ListNode E=head;
    	int count=0;

    	while(E!=null && count<n){
    		E=E.next;
    		count++;
    	}

    	ListNode dummy=new ListNode();
    	dummy.next=head;
    	ListNode S=dummy;
    	
    	
    	while(S!=null && E!=null) {
    		S=S.next;
    		E=E.next;
    		
    	}
    	
    	ListNode tmp=S.next;
    	if(tmp!=null)
    		S.next=tmp.next;
    	else
    		S=null;
    	
    	
    	return dummy.next;
    	
    }	
}
