package algorithm.sort;

public class NextPermutation {

	/*
http://blog.csdn.net/fightforyourdream/article/details/16859757

      1. �Ӻ���ǰ��falling edge���½��ء����½�֮����Ǹ�Ԫ�أ�
����2. ���½��ؿ�ʼ�����ҳ��滻����Ԫ�ء������ǵ�һ������С��ǰһ��Ԫ�أ�
����3. ��ת��������Ԫ�أ�������С����sorted����Ϊ֮ǰ�ǴӴ�Сsorted�ģ�
�������� ��547532��
����1. ��547532���� 4���½��ء�
����2. ��547532���� 5��Ҫ�滻��Ԫ�أ� �滻��õ� �� 557432��
     3. "557432",   7432��ת���õ� ��552347����
*/

	/**
	 * Next Permutation
	 * 
	 *  Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

	If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

	The replacement must be in-place, do not allocate extra memory.

	Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
	1,2,3 �� 1,3,2
	3,2,1 �� 1,2,3
	1,1,5 �� 1,5,1
	 *
	 */
	
		public static void main(String[] args) {

		}
		
		public void nextPermutation(int[] num) {
	        if(num.length <= 1){
	        	return;
	        }
	        
	        // 1. �Ӻ���ǰ��falling edge���½��ء����½�֮����Ǹ�Ԫ�أ�
	        int edge = -1;
	        for(int i=num.length-2; i>=0; i--){
	        	if(num[i] < num[i+1]){
	        		edge = i;
	        		break;
	        	}
	        }
	        
	        if(edge > -1){
	        	// 2. ���½��ؿ�ʼ�����ҳ��滻����Ԫ�ء������ǵ�һ������С��ǰһ��Ԫ�أ�
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
	        
	        // 3. ��ת��������Ԫ�أ�������С����sorted����Ϊ֮ǰ�ǴӴ�Сsorted�ģ�
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

//ˮӡ����
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

