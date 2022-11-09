package com.prabathj;

public class BalancedBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public boolean isBalanced(TreeNode root) {
     
    	boolean[] ret=new boolean[1];
    	ret[0]=true;
    	
    	return ret[0];
    }	
    
    
    public int height(TreeNode root, boolean rest[]) {
    	
    	if(root==null) {
    		return -1;
    	}
    	
    	int x=0,y=0;
    	
    	x=height(root.left,rest);
    	x++;
    	y=height(root.right,rest);
    	y++;
    	
    	int z=x-y;
    	
    	if(z!=-1 && z!=1 && z!=0) {
    		rest[0]=false;
    	}
    	
    	return Math.max(y, x);
    	
    	
    }
	
}
