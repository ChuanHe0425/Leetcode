package algorithm.sort;
//http://blog.csdn.net/jie1991liu/article/details/8778893
//http://blog.csdn.net/huaweidong2011/article/details/7727482
public class EditDIstance {

	/*"Take advantage of dp"
	"declare a matrix with one extral row and column "
	"make the first row from 0->word2.length and first column from 0->word1.length"
	"then iterate from matrix[1][1] tp matrix[m][n] if word1.charAt(i-1)=word2.charAt(j-1) then matrix[i][j]=matrix[i-1][j-1]"
	"else matix[i][j]=min(matrix[i-1][j]+1, matrix[i][j-1]+1, matrix[i-1][j-1]+1)"
	 
	"Time complexity:O(mn)"*/
	 
		    public int minDistance(String word1, String word2) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        int m=word1.length();
	        int n=word2.length();
	        
	        int[][] matrix=new int[m+1][n+1];
	        
	        for (int i=0; i<m+1; i++){
	            
	            matrix[i][0]=i;
	        }
	        for (int j=0; j<n+1; j++){
	            
	            matrix[0][j]=j;
	        }
	        for(int i=1; i<m+1; i++){
	            for (int j=1; j<n+1; j++){
	                
	                if (word1.charAt(i-1)==word2.charAt(j-1)){
	                    
	                     // current char in word1 is equal to char in word2, mean no change at this step.
	                     //nums[i][j] is nums[i-1][j-1](mean the min times of change word1 to word2 without considering current chars)
	                    matrix[i][j]=matrix[i-1][j-1];
	                }
	                else{
	                     // nums[i-1][j-1] +1 is times of using  replacement at this step
	                     // nums[i-1][j]+1 is times of using insert at this step
	                     // nums[i][j-1]+1 is times of using delete at this step
	                    matrix[i][j]=Math.min(matrix[i-1][j-1]+1,
	                                          Math.min(matrix[i-1][j]+1, matrix[i][j-1]+1));
	                }
	            }
	            
	        }
	        return matrix[m][n];
	    }
	}

