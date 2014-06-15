package algorithm.sort;

public class SearchATwoDimMartix {
/*This is a typical problem of binary search.

You may try to solve this problem by finding the row first and then the column. 
There is no need to do that. Because of the matrix¡¯s special features, 
the matrix can be considered as a sorted array. Your goal is to find one element 
in this sorted array by using binary search.
*/
	public class Solution {
	    public boolean searchMatrix(int[][] matrix, int target) {
	        if(matrix==null || matrix.length==0 || matrix[0].length==0) 
	            return false;
	 
	        int m = matrix.length;
	        int n = matrix[0].length;
	 
	        int start = 0;
	        int end = m*n-1;
	 
	        while(start<=end){
	            int mid=(start+end)/2;
	            int midX=mid/n;
	            int midY=mid%n;
	 
	            if(matrix[midX][midY]==target) 
	                return true;
	 
	            if(matrix[midX][midY]<target){
	                start=mid+1;
	            }else{
	                end=mid-1;
	            }
	        }
	 
	        return false;
	    }

	}
}
