package algorithm.sort;

public class FirstMissingPos {
/*这道题要求用线性时间和常量空间，思想借鉴到了Counting sort中的方法，
	不了解的朋友可以参见Counting sort - Wikipedia。既然不能用额外空间，
	那就只有利用数组本身，跟Counting sort一样，利用数组的index来作为数字本身的索引，
	把正数按照递增顺序依次放到数组中。即让A[0]=1, A[1]=2, A[2]=3, ... , 
	这样一来，最后如果哪个数组元素违反了A[i]=i+1即说明i+1就是我们要求的第一个缺失的正数。
	对于那些不在范围内的数字，我们可以直接跳过，比如说负数，0，或者超过数组长度的正数，
	这些都不会是我们的答案。*/
	    public int firstMissingPositive(int[] A) {
	        
	    if (A == null || A.length == 0) return 1;  
	          
	        for (int i = 0; i < A.length; i++) {  
	            while (A[i] != i + 1) {  
	                //A[i] == A[A[i] - 1] handles the case where there are two identical values  
	                // like A = [1, 1]  
	                if (A[i] <= 0 || A[i] >= A.length || A[i] == A[A[i] - 1]) 
	                	break;  
	                int temp = A[i];  
	                A[i] = A[temp - 1];  
	                A[temp -1]= temp;  
	            }  
	        }  
	          
	        for (int i = 0; i < A.length; i++) {  
	            if (A[i] != i + 1) {  
	                return i+1;  
	            }  
	        }  
	        return A.length + 1;          
	    }  
	}  
/*实现中还需要注意一个细节，就是如果当前的数字所对应的下标已经是对应数字了，那么我们也需要跳过，
因为那个位置的数字已经满足要求了，否则会出现一直来回交换的死循环。这样一来我们只需要扫描数组两遍，
时间复杂度是O(2*n)=O(n)，而且利用数组本身空间，只需要一个额外变量，所以空间复杂度是O(1)。*/

