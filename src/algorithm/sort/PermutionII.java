package algorithm.sort;
import java.util.ArrayList;
import java.util.Arrays;
public class PermutionII {
    //==========================================================
	//Ë®Ó¡ÈËÉú
	public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
	       Arrays.sort(num);
	        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	        
	        int i=num.length-1;
	        res.add(convert(num));
	        while(i>0){
	            int j=i-1;
	            while(j>=0 && num[j]>=num[j+1])
	                j--;
	            if(j>=0){
	                i=num.length-1;
	                for(int m=j;m<i-1;m++){
	                    for(int k=i;k>m+1;k--){
	                        if(num[k]<num[k-1]){
	                            int temp=num[k];
	                            num[k]=num[k-1];
	                            num[k-1]=temp;
	                        }
	                    }
	                }
	                int m=j+1;
	                while(num[m]<=num[j])
	                    m++;
	                int temp=num[m];
	                num[m]=num[j];
	                num[j]=temp;
	                res.add(convert(num));
	            }else{
	                i--;
	            }
	        }
	        return res;
	    }
	    
	    public ArrayList<Integer> convert(int[] num){
	        ArrayList<Integer> res = new ArrayList<Integer>();
	        for(int i=0;i<num.length;i++)
	            res.add(num[i]);
	        return res;
	    }
 //=======================================================================
	    //ProgramCreek
	    public ArrayList<ArrayList<Integer>> permuteUniqueB(int[] num) {
	    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	    	permuteUnique(num, 0, result);
	    	return result;
	    }
	     
	    private void permuteUnique(int[] num, int start, ArrayList<ArrayList<Integer>> result) {
	     
	    	if (start >= num.length ) {
	    		ArrayList<Integer> item = convertArrayToList(num);
	    		result.add(item);
	    	}
	     
	    	for (int j = start; j <= num.length-1; j++) {
	    		if (containsDuplicate(num, start, j)) {
	    			swap(num, start, j);
	    			permuteUnique(num, start + 1, result);
	    			swap(num, start, j);
	    		}
	    	}
	    }
	     
	    private ArrayList<Integer> convertArrayToList(int[] num) {
	    	ArrayList<Integer> item = new ArrayList<Integer>();
	    	for (int h = 0; h < num.length; h++) {
	    		item.add(num[h]);
	    	}
	    	return item;
	    }
	     
	    private boolean containsDuplicate(int[] arr, int start, int end) {
	    	for (int i = start; i <= end-1; i++) {
	    		if (arr[i] == arr[end]) {
	    			return false;
	    		}
	    	}
	    	return true;
	    }
	     
	    private void swap(int[] a, int i, int j) {
	    	int temp = a[i];
	    	a[i] = a[j];
	    	a[j] = temp;
	    }

	    
	    
	    
	}
	 
	    
	    