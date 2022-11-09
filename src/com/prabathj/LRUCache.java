package com.prabathj;

import java.util.HashMap;

public class LRUCache {

	int capacity=0;
	int size=0;
	HashMap<Integer, CacheNode> map;
	CacheNode mostRecent=new CacheNode(0, 0, null, null);
	CacheNode leastRecent=new CacheNode(0, 0, null, null);
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public LRUCache(int capacity) {
    	map=new HashMap<>();
    	this.capacity=capacity;
        mostRecent.prv=leastRecent;
        leastRecent.nxt=mostRecent;
    }
    
    public void remove(CacheNode a) {
    	a.prv.nxt=a.nxt;
    	a.nxt.prv=a.prv;
    }
    
    public void insert(CacheNode a) {
    	a.prv=mostRecent.prv;
    	mostRecent.prv.nxt=a;
    	mostRecent.prv=a;
    	a.nxt=mostRecent;
    	
    }
    
    
    public int get(int key) {
        
    	CacheNode a = map.get(key);
    	if(a!=null) {
    		
    		this.remove(a);
    		this.insert(a);
    		return a.value;
    	}else
    		return -1;
    }
    		
    
    public void put(int key, int value) {
        
    	if(capacity>size) {
    		CacheNode cacheNode = map.get(key);
    		if(cacheNode==null) {
    			CacheNode N=new CacheNode(value, key, null, null);
    			map.put(key, N);
    			this.insert(N);
    			size++;
    		}else {
    			cacheNode.value=value;
    			//map.put(key, cacheNode);
        		this.remove(cacheNode);
        		this.insert(cacheNode);    			
    			
    		}	
    		
    	}else {
    		
    		CacheNode cacheNode = leastRecent.nxt;
    		this.remove(cacheNode);
    		CacheNode N=new CacheNode(value, key, null, null);
    		map.put(key, N);
    		this.insert(N);
    		map.remove(cacheNode.key);
    		
    	}  		
    }	
    
    

}
	class CacheNode{
		
		int value;
		int key;
		CacheNode prv;
		CacheNode nxt;
		
		public CacheNode(int value, int key, CacheNode prv, CacheNode nxt) {
			super();
			this.value = value;
			this.key = key;
			this.prv = prv;
			this.nxt = nxt;
		}
		
		
		
		
	}