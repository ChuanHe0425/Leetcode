package algorithm.sort;

public class SpiralOrderGeneration2 {

			public int[][] generateMatrix(int n) {
			int[][] matrix = new int[n][n];
			int min = 0;
			int max = n - 1;
			int num = 1;
			while (min <= max) {
				for (int i = min; i <= max; ++i) {
					matrix[min][i] = num++;
				}
				for (int i = min + 1; i <= max; ++i) {
					matrix[i][max] = num++;
				}
				if (min != max) {
					for (int i = max - 1; i >= min; --i) {
						matrix[max][i] = num++;
					}
				}
				for (int i = max - 1; i > min; --i) {
					matrix[i][min] = num++;
				}

				++min;
				++max;
			}
			return matrix;
		}
//===========================================================
			public int[][] generateMatrixB(int n) {
			    if(n<0)
			        return null;
			    int[][] res = new int[n][n];
			    int levelNum = n/2;
			    int num = 1;
			    for(int l=0;l<levelNum;l++)
			    {
			        for(int i=l;i<n-l;i++)
			        {
			            res[l][i] = num++;
			        }
			        for(int i=l+1;i<n-l;i++)
			        {
			            res[i][n-1-l] = num++;
			        }
			        for(int i=n-2-l;i>=l;i--)
			        {
			            res[n-1-l][i] = num++;
			        }
			        for(int i=n-2-l;i>l;i--)
			        {
			            res[i][l] = num++;
			        }
			    }
			    if(n%2==1)
			    {
			        res[levelNum][levelNum] = num;
			    }
			    return res;
			}		
	}