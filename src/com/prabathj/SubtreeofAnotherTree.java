package com.prabathj;

public class SubtreeofAnotherTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
     
    	if(root==null || subRoot==null)
    		return false;
    	
    	boolean x=false;
    	
    	x= x | isSubtree(root.left, subRoot);
    	x= x | this.compare(root.left, subRoot);	
    		
    	x= x | isSubtree(root.right, subRoot);
    	x= x | this.compare(root.right, subRoot);	    		
    	
    	return x;
    	
    }
    
    public boolean compare(TreeNode root, TreeNode subRoot) {
    	
    	if(root==null && subRoot==null)
    		return true;
    	
    	if(root==null || subRoot==null || root.val!=subRoot.val)
    		return false;
    	
    	return compare(root.left, subRoot.left) & compare(root.right,subRoot.left);
    	
    }
    
}
