package algorithm.sort;

public class NextPermutation {

	/*
http://blog.csdn.net/fightforyourdream/article/details/16859757

      1. 从后往前找falling edge，下降沿。（下降之后的那个元素）
　　2. 从下降沿开始往后找出替换它的元素。（就是第一个比它小的前一个元素）
　　3. 反转后面所有元素，让他从小到大sorted（因为之前是从大到小sorted的）
　　例如 “547532“
　　1. “547532”， 4是下降沿。
　　2. “547532”， 5是要替换的元素， 替换后得到 “ 557432”
     3. "557432",   7432反转，得到 “552347”。
*/

	/**
	 * Next Permutation
	 * 
	 *  Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

	If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

	The replacement must be in-place, do not allocate extra memory.

	Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
	1,2,3 → 1,3,2
	3,2,1 → 1,2,3
	1,1,5 → 1,5,1
	 *
	 */
	
		public static void main(String[] args) {

		}
		
		public void nextPermutation(int[] num) {
	        if(num.length <= 1){
	        	return;
	        }
	        
	        // 1. 从后往前找falling edge，下降沿。（下降之后的那个元素）
	        int edge = -1;
	        for(int i=num.length-2; i>=0; i--){
	        	if(num[i] < num[i+1]){
	        		edge = i;
	        		break;
	        	}
	        }
	        
	        if(edge > -1){
	        	// 2. 从下降沿开始往后找出替换它的元素。（就是第一个比它小的前一个元素）
	        	for(int i=edge+1; i<num.length; i++){
	        		if(num[edge] >= num[i]){
	        			nextPermutationSwap(num, edge, i-1);
	        			break;
	        		}
	        		if(i == num.length-1){
	        			nextPermutationSwap(num, edge, i);
	        			break;
	        		}
	        	}
	        }
	        
	        // 3. 反转后面所有元素，让他从小到大sorted（因为之前是从大到小sorted的）
	        for(int i=edge+1, j=num.length-1; i<=edge+(num.length-edge-1)/2; i++, j--){
	        	nextPermutationSwap(num, i, j);
	        }
	        
	    }
		
		public void nextPermutationSwap(int[] num, int i, int j){
			int tmp = num[i];
			num[i] = num[j];
			num[j] = tmp;
		}

	}
//====================================================
import java.util.Random;

//水印人生
    public void nextPermutationB(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(num.length<=1) return;
        int i=num.length-1;
        while(i>0 && num[i]<=num[i-1])
            i--;
        int j=i-1;
        quickSort(num,i,num.length-1);
         if(i>0){
            while(num[j]>=num[i]) i++;
            swap(num,j,i);
        }
    }
    
    public void quickSort(int[] num, int start, int end){
        if(start>=end) return ;
        int pivot = (new Random()).nextInt(end-start+1)+start;
        swap(num,pivot,end);
        int i=start, j=end-1;
        while(i<=j){
            while(i<end && num[i]<=num[end])i++;
            while(j>=start && num[j]>num[end])j--;
            if(i<j){
                swap(num,i,j);
                i++;
                j--;
            }
        }
        swap(num,end,i);
        quickSort(num,start,i-1);
        quickSort(num,i+1,end);
    }
    
    public void swap(int[] num, int a, int b){
        int temp = num[a];
        num[a] = num[b];
        num[b] = temp;
    }
}

