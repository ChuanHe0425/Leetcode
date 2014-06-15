package algorithm.sort;

public class SearchInsertPosition {
//O(n)
	public int searchInsert(int[] A, int target) {
		 if(A==null||A.length==0) return 0;

	    if(target <=A[0]) return 0;
	   
	    	for(int i = 0; i <= A.length -1;i++)  {
	    
	    	 if(target > A[i] && target <= A[i+1]){
	    		return i+1;
	    	 }
	     }
	    
		return A.length;
	    }
//===========================================================
	//O(nlogn)
	public int searchInsert2(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A==null||A.length==0)
            return 0;
        return searchInsert(A,target,0,A.length-1);
    }
    
    public int searchInsert(int[] A, int target, int start, int end){
        int mid=(start+end)/2;
        if(target==A[mid]) 
            return mid;
        else if(target<A[mid]) 
            return start<mid?searchInsert(A,target,start,mid-1):start;
        else 
            return end>mid?searchInsert(A,target,mid+1,end):(end+1);
    }
}
