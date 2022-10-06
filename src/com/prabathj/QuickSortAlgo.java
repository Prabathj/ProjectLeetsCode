package com.prabathj;

public class QuickSortAlgo {
	
	
	//Submit the index
	public int partition(int L,int H,int a[]) {

		
		int left=L;
		int right=H;		
		/* a[H]=Integer.MAX_VALUE This is to represent end of the Array 
		 * If we do not set this then 
		 * do { 
		 * 	right++; 
		 * }while(start<a[right]); 
		 * for right cannot be done as it increase right++ without checking
		 */	
		int start=a[L];
		
		while(left<right) {
			
			//we let the loop to run even at left>right condition and it stop because of a[H+1]=INFINIT
			do {
				left++;
				
			}while(a[left]<=start);			//left side keep the start=a[left] values
			
			
			//we let the loop to run even at left>right condition and it stop because at a[L]
			do {

				right--;				
			}while(a[right]>start);
			
			//swap
			if(left<right) {
				int m=a[left];
				a[left]=a[right];
				a[right]=m;
			}
		}
		
		//Swap the start value at 
		a[L]=a[right];
		a[right]=start;
		
		return right;
	}
	
	
	//Without 
	
	public int partitionOne(int L,int H,int a[]) {

		
		int left=L;
		int right=H;		

		int start=a[L];
		
		while(left<right) {
			
			
			while(a[left]<=start) {			//left side keep the start=a[left] values
				
				if(left>=right)
					break;
				else
					left++;
				
			}		
			
			while(a[right]>start) {
				
				if(left>right)
					break;
				else
					right--;
				
			}
			
			//swap
			if(left<right) {
				int m=a[left];
				a[left]=a[right];
				a[right]=m;
			}
		}
		
		//Swap the start value at 
		a[L]=a[right];
		a[right]=start;
		
		return right;
	}	
	
	public void quicksortOne(int L,int H,int[] array) {
		
		if(L<H) {
		
			int newL=this.partitionOne(L, H, array);
			this.quicksort(L, newL-1, array);
			this.quicksort(newL+1, H, array);
		}
		
		
	}

	public void quicksort(int L,int H,int[] array) {
		
		if(L<H) {
		
			int newL=this.partition(L, H, array);
			this.quicksort(L, newL, array);
			this.quicksort(newL+1, H, array);
		}
		
		
	}	
	public static void main(String[] args) {
		
		QuickSortAlgo algo=new QuickSortAlgo();
		
		//Method 1
		int[] listO= {10,8,21,5,12,2,10,13,7};		//Ok
		int[] listA= {2, 8, 7, 5, 10, 10, 12, 13, 21 };	//Ok
		int[] list= {21, 8, 7, 5, 4, 12, 12, 13,10 };	//Ok

		algo.quicksortOne(0, 8, list);
		
		for (int i : list) {
			System.out.print(i+" ");
		}
		
		System.out.println();
		//////////////////////////////////////////////
		
		int[] listOM= {10,8,21,5,12,2,10,13,7};		//Ok
		int[] listAM= {2, 8, 7, 5, 10, 10, 12, 13, 21 };	//Ok
		int[] listM= {21, 8, 7, 5, 4, 12, 12, 13,10 };	// Not Ok
		//a[H]=Integer.MAX_VALUE This is to represent end of the Array 
		int[] listMM= {21, 8, 7, 5, 4, 12, 12, 13,10,Integer.MAX_VALUE};			//Ok
		
		algo.quicksort(0, 9, listMM);
		
		for (int i : listMM) {
			System.out.print(i+" ");
		}
		
		
		/////////////////////////////////////////

	}

}
