package com.prabathj;

public class SearchA2DMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(SearchA2DMatrix.searchMatrix(new int[][] {{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 30));
	}
	
    public static boolean searchMatrix(int[][] matrix, int target) {
        
    	
    	int row=searchRow(0,matrix.length -1,matrix,target);
    	if(row==-1)
    		return false;
    	else
    		return true;
    }
    
	/*
	 * This will look for possible row as if we get matrix[row][0] it is also a sorted array {1,10,23}
	 	so we can do a binary search to identify which row this value might be
	 	Here we need to clear when binary search move to left side and end at left side [0][0] 
	 	it means the value is out of the matrix[0][0]  
	 	{1,3,5,7},{10,11,16,20},{23,30,34,60} 
	 	
	 	find 55  [0,6,3] [4,6,5],[4,4,4],[5,4] return -1 and the 55 is in the 4th row so return end
	 	find 27  [0,6,3] [0,2,1],[2,2,2],[3,2] return -1 and the 27 is in the 2th row so return end
	 	
	 */
    
    public static int searchRow(int start,int end,int[][] matrix, int target) {
    	
    	if(start>end)
    		return -1;
    	
    	int mid=(start+end)/2;
    	
    	if(matrix[mid][0] > target) {
    		int ret =searchRow(start,mid-1,matrix,target);
    		if(ret==-1) {
    			if(mid==0)
    				return mid-1;
    			else
    				return searchValue(0,matrix[0].length-1,matrix,target,mid-1);
    		}else
    			return ret;
    		
    	}else if(matrix[mid][0] < target) {
    		int ret =searchRow(mid+1,end,matrix,target);
    		if(ret==-1)
    			//find 55  [0,6,3] [4,6,5],[4,4,4],[5,4] return -1 and the 55 is in the 4th row so return end as Row
    			return searchValue(0,matrix[0].length-1,matrix,target,end);    
    		else
    			return ret;    		
    	}else
    		return mid;
    	
    	
    	
    }
    
    public static int searchValue(int start,int end,int[][] matrix, int target,int row) {
    
    	if(start>end)
    		return -1;
    	
    	int mid=(start+end)/2;
    	
    	if(matrix[row][mid] > target) {
    		return searchValue(start,mid-1,matrix,target,row);

    		
    	}else if(matrix[row][mid] < target) {
    		return searchValue(mid+1,end,matrix,target,row);

    	}else
    		return mid;   
    
    }
    
    
}
