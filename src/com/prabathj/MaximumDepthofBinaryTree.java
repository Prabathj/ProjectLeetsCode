package com.prabathj;

public class MaximumDepthofBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int maxDepth(TreeNode root) {
        
    	if(root==null)
    		return 0;
    	
    	int x=0,y=0;
    	
    	x=maxDepth(root.left);
    	x++;
    	y=maxDepth(root.right);
    	y++;
    	
    	if(x>y)
    		return x;
    	else
    		return y;
    }
}
