package com.prabathj;

public class MergeTwoSortedLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
    public ListNodeN mergeTwoLists(ListNodeN list1, ListNodeN list2) {
        
    	
    	ListNodeN dummy= new ListNodeN();
    	ListNodeN tail=dummy;
    	
    	while(list1!=null && list2!=null) {
    		
    		
    		if(list1.val<=list2.val) {
    			
    			tail.next=list1;
    			tail=list1;
    			list1=list1.next;
    		}else {
    			tail.next=list2;
    			tail=list2;
    			list2=list2.next;   			
    			
    		}
    		
    	}
    	
    	if(list1!=null) {
    		
    		tail.next=list1;
    		
    	}
    	
    	if(list2!=null) {
    		
    		tail.next=list2;
    		
    	}   	
    	
    	return dummy.next;
    	
    }
    
    
}

class ListNodeN {
    int val;
    ListNodeN next;
    ListNodeN() {}
    ListNodeN(int val) { this.val = val; }
    ListNodeN(int val, ListNodeN next) { this.val = val; this.next = next; }
}