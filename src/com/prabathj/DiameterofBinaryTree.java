package com.prabathj;

public class DiameterofBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public int diameterOfBinaryTree(TreeNode root) {
    	if(root==null)
    		return 0;        
    	
    	int[] diameter=new int[1];
    	diameter[0]=0;
    	this.depthOfBT(root, diameter);
    	return diameter[0];
    	
    	
    }	
	
    public int depthOfBT(TreeNode root,int[] diameter) {
    	
    	if(root==null)
    		return -1;
    	
    	int x=0,y=0;
    	
    	x=depthOfBT(root.left,diameter);
    	x++;
    	y=depthOfBT(root.right,diameter);
    	y++;
    	
    	diameter[0]=Math.max((x+y), diameter[0]);
    	
    	if(x>y)
    		return x;
    	else
    		return y;
    	
    	
    }
    
}
