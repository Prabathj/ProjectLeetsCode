package com.prabathj;

public class InvertBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public TreeNode invertTree(TreeNode root) {
        if(root==null)
        	return null;
        
        invertTree(root.left);
        invertTree(root.right);
        return swap(root);
        
    }
    
    
    public TreeNode swap(TreeNode root) {
    	
    	if(root.left==null && root.right==null) {
    		
    	}else if(root.left!=null && root.right==null) {
    		root.right=root.left;
    		root.left=null;
    	}else if(root.left==null && root.right!=null) {
    		root.left=root.right;
    		root.right=null;
    	}else {
    		TreeNode r=root.right;
    		root.right=root.left;
    		root.left=r;
    		
    	}
    	return root;
    }
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode() {}
	TreeNode(int val) { this.val = val; }
	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}
