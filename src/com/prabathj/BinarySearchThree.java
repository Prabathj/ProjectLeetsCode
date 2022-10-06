package com.prabathj;

public class BinarySearchThree {

	public static void main(String[] args) {
		
		
		//Root
		Node root = new Node(50, null, null);
		BinarySearchThree obj=new BinarySearchThree();
		
		obj.insert(root, 30);
		obj.insert(root, 70);
		obj.insert(root, 40);
		obj.insert(root, 20);
		obj.insert(root, 60);
		obj.insert(root, 80);
		obj.insert(root, 10);
		obj.insert(root, 25);
		obj.insert(root, 90);
		obj.insert(root, 67);
		obj.insert(root, 64);
		obj.insert(root, 65);

		obj.preOrderTraverse(root);
		System.out.println();
		obj.inOrderTraverse(root);
		System.out.println();
		obj.postOrderTraverse(root);
		System.out.println();
		
		Node search = obj.search(root, 80);
		System.out.println(search.key);
		
		//root = obj.delete(root, 90);
		
		//obj.preOrderTraverse(root);
		//obj.insert(root, 90);
		
		//System.out.println();
		
		//root = obj.delete(root, 30);
		//obj.preOrderTraverse(root);
		
		System.out.println();
		root = obj.delete(root, 50);
		obj.preOrderTraverse(root);
		
		//obj.preOrderTraverse(root);
	}

	
	public Node insert(Node root, int key) {
		
		if(root==null) {
			return new Node(key,null,null);
		}
		
		if(root.key > key) {
			
			root.left=insert(root.left,key);

		}else if(root.key<key) {
			
			root.right=insert(root.right,key);

		}

		return root;
		
	}
	
	//ROOT -LEFT -RIGHT for each sub tree
	public void preOrderTraverse(Node root) {
		
		if(root==null)
			return;
		else
			System.out.print(root.key+" ");
		
		if(root.left!=null) {
			preOrderTraverse(root.left);
		}
		
		if(root.right!=null) {
			preOrderTraverse(root.right);
		}
		
		return;
		
	}
	
	
	//LEFT -ROOT -RIGHT for each sub tree  <SORTED>
	
	public void inOrderTraverse(Node root) {
		
		if(root==null)
			return;

		if(root.left!=null)
			inOrderTraverse(root.left);
		
		System.out.print(root.key+" ");
		
		if(root.right!=null)
			inOrderTraverse(root.right);
		
		return;
	}
	
	//LEFT -RIGHT -ROOT for each sub tree 
	public void postOrderTraverse(Node root) {
		
		if(root==null)
			return;
		
		if(root.left!=null)
			postOrderTraverse(root.left);
		
		if(root.right!=null)
			postOrderTraverse(root.right);
		
		System.out.print(root.key+" ");
		
	}
	
	public Node search(Node root,int key) {
		
		if(root==null)
			return null;
		
		if(root.key==key) {
			
			return root;
			
		}else if(root.key>key) {
			return search(root.left,key);
		}else {
			return search(root.right,key);
			
		}
				
	}
	
	public Node delete(Node root,int key) {
		
		if(root==null)
			return null;
		else {
			if(root.key>key) {
				root.left=this.delete(root.left, key);
				return root;
				
			}else if(root.key<key) {
				root.right=this.delete(root.right, key);
				return root;
			}else {		//found
				
				if(root.left==null && root.right==null) {  		//No children
					return null;
				}else if(root.left==null && root.right!=null) {	//One child
					Node tmp=root.right;
					root.right=null;
					return tmp;
					
				}else if(root.left!=null && root.right==null) { 
					Node tmp=root.left;
					root.left=null;
					return tmp;
					
				}else {		//Have left & right children
					
					Node min = min(root.right);				//Find most suitable replacement on right side
					//Node max = max(root.left);				//Find most suitable replacement on left side
					
					root.key=min.key;						//Replace the key with the existing Node so the links will be the same	
					root.right=delete(root.right, min.key);		//Delete the same key value node from the Right side sub tree
					return root;
				}
				
			}
			
		}
		
	}
	
	//Need to find maximum value of the sub tree, so need to move along right side of the tree
	public Node max(Node root) {
			
		if(root.right!=null) {
			return max(root.right);
		}else {
			return root;			
		}

	}
	
	//Need to find minimum value of the sub tree, so need to move along left side of the tree
	public Node min(Node root) {
			
		if(root.left!=null) {
			return min(root.left);
		}else {
			return root;			
		}

	}	
	
}
