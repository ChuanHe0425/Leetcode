package algorithm.sort;

public class RemoveElem {
	 public int removeElement(int[] A, int elem) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        int i=0, j=0;
	        while(j<A.length){
	            if(A[j]!=elem){
	                A[i]=A[j];
	                i++; 
	            }
	            j++;
	        }
	        return i;
	    }
}
