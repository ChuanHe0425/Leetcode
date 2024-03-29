package algorithm.sort;

public class UniquePaths {
//loop, similar as min path sum, O(n^2) time & space

	 public int uniquePaths(int m, int n) {
	        int[][] res = new int[m][n];
	         
	        // init left
	        for(int i = 0; i < m; i++) {
	            res[i][0] = 1;
	        }
	        // init top
	        for(int j = 0; j < n; j++) {
	            res[0][j] = 1;
	        }
	         
	        // add values
	        for(int i = 1; i < m; i++) {
	            for(int j = 1; j < n; j++) {
	                res[i][j] = res[i - 1][j] + res[i][j - 1];
	            }
	        }
	         
	        return res[m - 1][n - 1];
	    }
//loop, O(n^2) time, O(n) space
	
 // loop, similar as min path sum, O(n^2) time, O(n) space
			 public class Solution {
			     public int uniquePaths(int m, int n) {
			         int[] res = new int[n];
			          
			         // init array
			         for(int j = 0; j < n; j++) {
			             res[j] = 1;
			         }
			          
			         // add values
			         for(int i = 1; i < m; i++) {
			             // reset the head to 1 (simulate the next row head)
			             // similar to set all left most elements in a 2D array to 1
			             res[0] = 1;
			             for(int j = 1; j < n; j++) {
			                 res[j] = res[j - 1] + res[j];
			             }
			         }
			          
			         return res[n - 1];
			     }
			 }


}
