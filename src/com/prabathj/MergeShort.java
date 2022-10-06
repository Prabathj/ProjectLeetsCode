package com.prabathj;

public class MergeShort {

	public static void main(String[] args) {
		
		MergeShort obj =new MergeShort();

		int[] array= {2,5,20,8,17,3,19,15,12,9,18};
		obj.mergerShort(array, 0, array.length-1);
		
		for (int i : array) {
			System.out.println(i+",");
		}
		
	}
	
	
	public void mergerShort(int array[],int L, int H ) {
		
		if(L<H) {
			
			int mid=(L+H)/2;
			
			mergerShort(array,L,mid);
			mergerShort(array,mid+1,H);
			merge(array,L,H,mid);
		}
		
	}
	
	
	public void merge(int array[],int L,int H,int M) {
		
		int sizeF=M-L+1;
		int sizeS=H-M;
		
		int[] first=new int[sizeF];   //Total size H-L+1 = H-M + M-L+1
		int[] second=new int[sizeS];
		
		int f=L,s=M;
		
		for(int i=0;i<sizeF;i++) {
			first[i]=array[f++];
		}
		
		for(int i=0;i<sizeS;i++) {
			second[i]=array[++s];
		}		
		
		f=0;
		s=0;
		
		
		while(f<sizeF && s<sizeS) {
			
			int pointF=first[f];
			int pointS=second[s];
			
			if(pointF<=pointS) {
				array[L]=pointF;
				f++;
			}else {
				array[L]=pointS;
				s++;				
			}
			L++;
		}
		
		while(f<sizeF) {
			array[L]=first[f];
			L++;
			f++;
		}
		
		while(s<sizeS) {
			array[L]=second[s];
			L++;
			s++;
		}		
		
	}
	
	
}
