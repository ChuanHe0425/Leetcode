package algorithm.sort;

import java.util.Arrays;

public class MinPathSum {
	// DP, O(n^2) time, O(n^2) space
		    public int minPathSum(int[][] grid) {
	        int row = grid.length;
	        int col = grid[0].length;
	         
	        int[][] res = new int[row][col];
	        // init
	        res[0][0] = grid[0][0];
	         
	        // left
	        for(int i = 1; i < row; i++) {
	            res[i][0] = res[i - 1][0] + grid[i][0];
	        }
	        // top
	        for(int j = 1; j < col; j++) {
	            res[0][j] = res[0][j - 1] + grid[0][j];
	        }
	         
	        // rest elements
	        for(int i = 1; i < row; i++) {
	            for(int j = 1; j < col; j++) {
	                res[i][j] = grid[i][j] + Math.min(res[i - 1][j], res[i][j - 1]);
	            }
	        }
	         
	        return res[row - 1][col - 1];
	    }
//=============================================================================
		    
		 // DP, O(n^2) time, O(n) space
		    public class Solution {
		        public int minPathSum(int[][] grid) {
		            int row = grid.length;
		            int col = grid[0].length;
		             
		            int[] res = new int[col];
		            // init
		            Arrays.fill(res, Integer.MAX_VALUE);
		            res[0] = 0;
		             
		            // rest elements
		            for(int i = 0; i < row; i++) {
		                // init the 0th sum = old 0th element + the new 0th element
		                // just init the 0th column every time dynamically
		                res[0] = res[0] + grid[i][0];
		                 
		                // loop through each element of each row
		                for(int j = 1; j < col; j++) {
		                    res[j] = grid[i][j] + Math.min(res[j], res[j - 1]);
		                }
		            }
		             
		            return res[col - 1];
		        }

}
//====================================================================
		    //水印人生答案
		    public class Solution2{
		        public int minPathSum(int[][] grid) {
		            // Start typing your Java solution below
		            // DO NOT write main() function
		            int[] row = new int[grid[0].length];
		            
		            for(int i=0;i<grid.length;i++){
		                for(int j=0;j<grid[0].length;j++){
		                    if(j>0)
		                        row[j]=i>0?Math.min(row[j-1],row[j]):row[j-1];
		                    row[j]+=grid[i][j];
		                }
		            }
		            return row[grid[0].length-1];
		        }
		    }

}
