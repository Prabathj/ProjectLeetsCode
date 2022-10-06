package com.prabathj;

import java.util.ArrayList;
import java.util.List;

public class ReorderList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public void reorderList(ListNodeR head) {
    	
    	List<ListNodeR> list=new ArrayList<>();
    	
    	ListNodeR tmp=head;
    	int i=0;
    	while(tmp!=null) {
    		
    		list.add(i, tmp);
    		tmp=tmp.next;
    		i++;
    		
    	}

    	int S=0,E=i-1;
    	
    	ListNodeR node=new ListNodeR();
    	head=node.next;
    	
    	while(S<E) {
    		
    		ListNodeR s=list.get(S);
    		ListNodeR e=list.get(E);
    		e.next=null;
    		s.next=e;
    		node.next=s;
    		node=s.next;
    		S++;
    		E--;
    	}
    	
    	if(S==E)
    		node.next=list.get(S);
    	
        
    	
    }	
	
    public void reorderListBest(ListNodeR head) {
    	
    	ListNodeR S=head,E=head;
    	
    	
    	while(S!=null && E!=null) {
    		
    		E=E.next;
    		
    		if(E!=null) {
    			E=E.next;
    			
    		}else
    			break;
    		
    		S=S.next;
    		
    	}
    	
    	
    	  	
    	ListNodeR prv=null,tmp=null,cur=S.next;
    	S.next=null;
    	
    	while(cur!=null) {
    		
    		tmp=cur.next;
    		cur.next=prv;
    		prv=cur;
    		
    		cur=tmp;
    		
    	}
    	
    	ListNodeR rH=prv;
    	
    	ListNodeR h=new ListNodeR(),dummy=new ListNodeR();
    	
    	h=head;
    	
    	while(h!=null && rH!=null) {
    		
    		ListNodeR tmp2=rH;
    		ListNodeR tmp1=h.next;
    		dummy.next=h;
    		dummy=dummy.next;
    		
    		if(dummy!=null) {
    			dummy.next=tmp2;
    			rH=rH.next;
    			dummy=dummy.next;
    		}

    		h=tmp1;
    	}
    	
    	dummy.next=h.next;
        
    	
    }	

}

class ListNodeR {
    int val;
    ListNodeR next;
    ListNodeR() {}
    ListNodeR(int val) { this.val = val; }
    ListNodeR(int val, ListNodeR next) { this.val = val; this.next = next; }
}