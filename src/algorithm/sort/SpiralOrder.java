package algorithm.sort;
import java.util.ArrayList;
public class SpiralOrder {

	public ArrayList<Integer> spiralOrder(int[][] matrix) {  
	       if(matrix==null){  
	            return null;  
	        }  
	        int row = matrix.length;  
	        ArrayList<Integer> ans = new ArrayList<Integer>();  
	        if(row==0){  
	            return ans;  
	        }  
	          
	        int col = matrix[0].length;  
	        return spiraluseme(matrix,row,col,0,0,ans);  
	    }  
	  
	    private ArrayList<Integer> spiraluseme(int[][] matrix,  
	            int row,int col, int starti, int startj, ArrayList<Integer> ans) {  
	        if(row==0||col==0) {  
	            return ans;  
	        }  
	        else if(row==1) {  
	            for(int j=startj;j<startj+col;j++)  
	                ans.add(matrix[starti][j]);  
	            return ans;  
	        }  
	        else if(col==1){  
	            for(int i=starti;i<starti+row;i++){  
	                ans.add(matrix[i][startj]);  
	            }  
	            return ans;  
	        }  
	        for(int j=startj;j<startj+col-1;j++){  
	              
	            ans.add(matrix[starti][j]);  
	        }  
	        for(int i=starti;i<starti+row-1;i++){  
	            ans.add(matrix[i][startj+col-1]);  
	        }  
	        for(int j=startj+col-1;j>startj;j--){  
	            ans.add(matrix[starti+row-1][j]);  
	        }  
	        for(int i=starti+row-1;i>starti;i--){  
	            ans.add(matrix[i][startj]);  
	        }  
	          
	        return spiraluseme(matrix,row-2,col-2,starti+1,startj+1,ans);  
	    }  
	}  
