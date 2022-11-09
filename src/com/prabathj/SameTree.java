package com.prabathj;

public class SameTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public boolean isSameTree(TreeNode p, TreeNode q) {
    	
    	 if(p==null && q==null)
             return true;
    	 
    	 if(p==null || q==null || q.val!=p.val)
    		 return false;

    	boolean val=true;
    	
    	val=isSameTree(p.left,q.left);
        if(val==false)
            return val;
        
    	val=isSameTree(p.right,q.right);
        
    	return val;     
    	
    }
    
    
    
    
    
}
