package algorithm.sort;

public class SetMatrixZeroes {

	/*
	    public void setZeroes(int[][] matrix) {
	     
	        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
	        
	        boolean isColHasZero = false;
	        boolean isRowHasZero = false;
	        
	        for (int i = 0; i < matrix[0].length; i++) {
	            if (matrix[0][i] == 0) {
	                isColHasZero = true;
	                break;
	            }
	        }
	        
	        for (int i = 0; i < matrix.length; i++) {
	            if (matrix[i][0] == 0) {
	                isRowHasZero = true;
	                break;
	            }
	        }
	        
	        for (int i = 1; i < matrix.length; i++) {
	            for (int j = 1; j < matrix[0].length; j++) {
	                if (matrix[i][j] == 0) {
	                    matrix[0][j] = 0;
	                    matrix[i][0] = 0;
	                }        
	            }
	        }
	        
	        for (int i = 1; i < matrix.length; i++) {
	            for (int j = 1; j < matrix[0].length; j++) {
	                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
	                    matrix[i][j] = 0;
	                }        
	            }
	        }
	        
	        if (isColHasZero == true) {
	            for (int i = 0; i < matrix[0].length; i++) {
	                matrix[0][i] = 0;
	            }
	        }
	        
	        if (isRowHasZero == true) {
	            for (int i = 0; i < matrix.length; i++) {
	                matrix[i][0] = 0;
	            }
	        }
	    }*/
	 public static void main(String[] args) {  
	        int[][] matrix = {{0,0,0,5},  
	                                {4,3,1,4},  
	                                {0,1,1,4},  
	                                {1,2,1,3},  
	                                {0,0,1,1}};  
	          
	        setZeroes(matrix);  
	    }  
	      
	    public static void setZeroes(int[][] matrix) {  
	          
	        // 用来标记第一行和第一列是否在一开始就有0的存在  
	        boolean rowZero = false, colZero = false;  
	          
	        for(int i=0; i<matrix.length; i++){  
	            if(matrix[i][0] == 0){  
	                colZero = true;  
	                break;  
	            }  
	        }  
	          
	        for(int j=0; j<matrix[0].length; j++){  
	            if(matrix[0][j] == 0){  
	                rowZero = true;  
	                break;  
	            }  
	        }  
	          
	        // 在矩阵中查找0，标记在行头和列头  
	        for(int i=1; i<matrix.length; i++){  
	            for(int j=1; j<matrix[0].length; j++){  
	                if(matrix[i][j] == 0){  
	                    matrix[i][0] = 0;  
	                    matrix[0][j] = 0;  
	                }  
	            }  
	        }  
	          
	        // 根据列头，把矩阵相应位置置零  
	        for(int i=1; i<matrix.length; i++){  
	            if(matrix[i][0] == 0){  
	                for(int j=1; j<matrix[0].length; j++){  
	                    matrix[i][j] = 0;  
	                }  
	            }  
	        }  
	          
	        // 根据行头，把矩阵相应位置置零  
	        for(int j=1; j<matrix[0].length; j++){  
	            if(matrix[0][j] == 0){  
	                for(int i=1; i<matrix.length; i++){  
	                    matrix[i][j] = 0;  
	                }  
	            }  
	        }  
	          
	        // 处理第一行  
	        if(rowZero){  
	            for(int j=0; j<matrix[0].length; j++){  
	                matrix[0][j] = 0;  
	            }  
	        }  
	          
	        // 处理第一列  
	        if(colZero){  
	            for(int i=0; i<matrix.length; i++){  
	                matrix[i][0] = 0;  
	            }  
	            
	        }  
	    }  
	

}
