package com.prabathj;

public class HeapImplementaion {

	public int[] heap;
	public int maxSize;
	private static final int FRONT = 1;
	public int size;
	
	public static void main(String[] args) {
		
		HeapImplementaion obj=new HeapImplementaion(8);
		obj.addNode(16);
		obj.addNode(8);
		obj.addNode(20);
		obj.addNode(30);
		obj.addNode(15);
		obj.addNode(10);
		obj.addNode(60);
		obj.addNode(50);

		for (int i : obj.heap) {
			System.out.print(i+",");
		}
		
		//obj.delete();
		System.out.println();
		
		int position=obj.size;
		
		for (int i=1;i<=position;i++) {
			obj.heapSort();
		}		
		
		for (int i : obj.heap) {
			System.out.print(i+",");
		}		
		
	}

	public HeapImplementaion(int size) {
		heap=new int[size+1];					//We arrange Array index to be from 1 to size+1 ignoring 0 index
		heap[0]=Integer.MAX_VALUE;				//Not used
		maxSize=size;
		this.size=0;
	}
	
	//Max-Heap ->Add to tail ->move upward
	public void addNode(int value) {
		
		//This is to avoid any OutOfBound exception when pointer come to 9 index we want increment
		//Else in deleting or reading when Array is full pointer will be at 10 		
		if(size>=maxSize)
			return; 
		
		//Add to the tail of the HEAP
		heap[++size]=value;
		
		int current=size;
	
		
		//Move upward checking parent each time 
		while(heap[this.parent(current)]<value) {
			this.swap(current);
			current=this.parent(current);
		}
		


	}
	
	public void swap(int child) {
		
		int tmp=heap[this.parent(child)];
		heap[this.parent(child)]=heap[child];
		heap[child]=tmp;
	}
	
	public int parent(int current) {
		
		//if index 0 -size    return (current-1)/2
		
		return current/2;
		
	}
	
	public int leftChild(int current) {
		
		//if index 0 -size    return 2*current +1
		
		return 2*current;
		
	}
	
	public int rightChild(int current) {
		
		//if index 0 -size    return 2*current +2
		
		return 2*current +1;
		
	}	
	
	public boolean isLeafNode(int pos) {
		
		//To be a leaf node at least should have no left  2*pos >size
		//if index 0 -size if(2*pos+1 >= size) return true
		
		if(2*pos> size) {
			return true;
		}
		
		return false;
		
		
	}
	
	
	//Delete from ROOT   delete root -> replace with tail -> move downward
	public void delete() {
		
		if(size<=FRONT)
			return;
		
		//Replace Root with tail node
		heap[FRONT]=heap[size];
		size--;
		int current=size;
		int parent=FRONT;
		int swapPointer=FRONT;
	
		/*
		 * while(parent<current) {
		 * 
		 * if(!this.isLeafNode(swapPointer)) {
		 * 
		 * //swap with the minimum of the two children // to check if right child
		 * exists. Otherwise default value will be '0' // and that will be swapped with
		 * parent node.
		 * 
		 * if(this.rightChild(swapPointer)<=size) {
		 * 
		 * if(heap[this.leftChild(swapPointer)] > heap[this.rightChild(swapPointer)])
		 * swapPointer=this.leftChild(swapPointer); else
		 * swapPointer=this.rightChild(swapPointer);
		 * 
		 * }else swapPointer=this.leftChild(swapPointer);
		 * 
		 * if(heap[swapPointer]>heap[parent]) { swap(swapPointer); parent=swapPointer;
		 * }else break;
		 * 
		 * }else break;
		 * 
		 * }
		 */	
		while(!this.isLeafNode(swapPointer)) {
				
				//swap with the minimum of the two children
			    // to check if right child exists. Otherwise default value will be '0'
			    // and that will be swapped with parent node.				
				
				if(this.rightChild(swapPointer)<=size) {
					
					if(heap[this.leftChild(swapPointer)] > heap[this.rightChild(swapPointer)])
						swapPointer=this.leftChild(swapPointer);
					else
						swapPointer=this.rightChild(swapPointer);					
					
				}else
					swapPointer=this.leftChild(swapPointer);
				
				if(heap[swapPointer]>heap[parent]) {
					swap(swapPointer);
					parent=swapPointer;
				}else
					break;

			
		}		
		
	}
	
	
	public void heapSort() {
		
		if(size<=FRONT)
			return;		
		
		//Replace Root with tail node
		int shortNode=heap[FRONT];
		heap[FRONT]=heap[size];
		heap[size]=shortNode;
		size--;
		int current=size;
		int parent=FRONT;
		int swapPointer=FRONT;
	
		/*
		 * while(parent<current) {
		 * 
		 * if(!this.isLeafNode(swapPointer)) {
		 * 
		 * //swap with the minimum of the two children // to check if right child
		 * exists. Otherwise default value will be '0' // and that will be swapped with
		 * parent node.
		 * 
		 * if(this.rightChild(swapPointer)<=size) {
		 * 
		 * if(heap[this.leftChild(swapPointer)] > heap[this.rightChild(swapPointer)])
		 * swapPointer=this.leftChild(swapPointer); else
		 * swapPointer=this.rightChild(swapPointer);
		 * 
		 * }else swapPointer=this.leftChild(swapPointer);
		 * 
		 * if(heap[swapPointer]>heap[parent]) { swap(swapPointer); parent=swapPointer;
		 * }else break;
		 * 
		 * }else break;
		 * 
		 * }
		 */
		
		while(!this.isLeafNode(swapPointer)) {
				
				//swap with the minimum of the two children
			    // to check if right child exists. Otherwise default value will be '0'
			    // and that will be swapped with parent node.				
				
				if(this.rightChild(swapPointer)<=size) {
					
					if(heap[this.leftChild(swapPointer)] > heap[this.rightChild(swapPointer)])
						swapPointer=this.leftChild(swapPointer);
					else
						swapPointer=this.rightChild(swapPointer);					
					
				}else
					swapPointer=this.leftChild(swapPointer);
				
				if(heap[swapPointer]>heap[parent]) {
					swap(swapPointer);
					parent=swapPointer;
				}else
					break;

		}		

	}	
	
}
