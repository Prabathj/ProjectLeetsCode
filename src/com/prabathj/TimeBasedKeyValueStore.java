package com.prabathj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeBasedKeyValueStore {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class NodeS{
	
	public String value;
	public int timestamp;
	public NodeS(String value, int timestamp) {
		super();
		this.value = value;
		this.timestamp = timestamp;
	}
	
	
	
}

class TimeMap {

	public Map<String,List<NodeS>> timeMap;
	
    public TimeMap() {
        timeMap=new HashMap<>();
    	
    }
    
    public void set(String key, String value, int timestamp) {
        
    	if(timeMap.containsKey(key)) {
    		 List<NodeS> list = timeMap.get(key);
    		 list.add(new NodeS(value,timestamp));

    	}else {
    		List<NodeS> list=new ArrayList<>();
    		list.add(new NodeS(value,timestamp));
    		timeMap.put(key, list);
    	}
    	
    	
    	
    }
    
    public String get(String key, int timestamp) {
    	
    	if(timeMap.containsKey(key)) {
    		List<NodeS> list = timeMap.get(key);
    		int maxI= search(0,list.size()-1,list,timestamp,-1);
    		
    		if(maxI==-1)
    			return "";
    		else
    			return list.get(maxI).value;

    	}else {
    		return "";
    	}

    }
    
    
    public int search(int s,int e, List<NodeS> values,int timestamp,int maxI) {
    	
    	if(s>e) {
    		return maxI;
    	}
    	
    	int m=(s+e)/2;
    	
    	if(values.get(m).timestamp>timestamp) {
    		return search(s,m-1,values,timestamp,maxI);
    		
    	}else if(values.get(m).timestamp<timestamp) {
    		maxI=Math.max(maxI, m);
    		
    		return search(m+1,e,values,timestamp,maxI);
    	}else {
    		return m;

    	}
    }
    	
    
    
    
    
    
}