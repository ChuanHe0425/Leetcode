package algorithm.sort;
import java.util.Random;
public class NextPermutatio{
//Ë®Ó¡ÈËÉú
	

		    public void nextPermutation(int[] num) {
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

