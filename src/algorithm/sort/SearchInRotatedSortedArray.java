package algorithm.sort;
/* Analysis:
First of all, I don't think the description of this problem is really clear.
  If there is not followup item or additional requirement we can just linear
   search the target value in the array.  
   
   But that's weir cause it could not 
   differentiate applicants as it is an interview question.  
   After reviewing the discussion of this problem in leetcode, 
   this problem becomes how to apply binary search approach, 
   so that the time complexity can be O(log n).
In this case, we could not first determine the pivot point
 then apply binary search in either half of the array 
 (this approach would be > O(log n)).  Rather than that, 
 we can have a sorted half of the array by comparing the value 
 of middle element with the left most element.  For example,
input: 4 5 6 7 0 1
left most: 4
middle: 6
then the upper half of this array is sorted (4 5)
Another example,
Input: 7 0 1 4 5 6
middle: 1
then the bottom half of this array is sorted (4 5 6).
Accordingly, we can apply binary search directly without
 finding the pivot

*/
public class SearchInRotatedSortedArray {
	public int search(int[] A, int target) {  
        // special case  
        if(A.length==0) return -1;  
        if(A.length==1) {  
            if(A[0] != target) return -1;  
            else return 0;  
        }  
          
        int left = 0;  
        int right = A.length-1;  
        int middle = 0;  
          
        while (left<=right){  
            middle = (left+right)/2;  
            if (A[middle] == target) return middle;  
              
            if (A[middle] >= A[left]){ // upper half sorted  
                if(target < A[middle] && target >= A[left]) right = middle-1;   
                else left = middle+1;  
            }  
              
            else{ // bottom half sorted  
                if (target>A[middle] && target <= A[right]) left = middle+1;  
                else right = middle-1;  
            }  
        }  
          
        return -1;  
    }  
//======================================================
/*	 One more case that is not covered in the solution of Search in Rotated Sorted Array. 
	 Which is the middle element is a duplicate of the left element.  
	 In this case, the target value can be in the upper half of the array 
	 or the bottom part of the array.  For example:
		 input: 1 1 1 3 1 or 1 3 1 1 1
		 left: 1
		 right: 1
		 middle: 1
	 In both cases, value of middle element is equal to the left, so we could not 
	 determine either search the upper half of bottom half as the followup action.
	 
	To  deal with this case, we can simply move the left pointer to the its next element. 
    Because we have the middle pointer pointing its duplicate, removing the left would 
   not change the result.  
   
   Note that we need to separate this additional case from the 
  ordinary case that both the left and middle pointer point to the same element
*/
	//Dublicate!!!!!!!!!
	public boolean search2(int[] A, int target) {  
        if(A.length == 0) return false;  
        if(A.length == 1){  
            if(A[0] == target) return true;  
            else return false;  
        }  
          
        int left = 0;  
        int right = A.length-1;  
          
        while(left<=right){  
            int middle = (left+right)/2;  
            if(A[middle] == target) return true;  
            
            if (A[middle]<A[left]){  
                if(target>A[middle] && target<=A[right]) left = middle+1;  
                else right= middle -1;  
            }  
            
            else{  
                // case of A[middle] is a duplicate of left most element  
                if(A[middle] == A[left] && middle != left){  
                    left++;  
                    continue;  
                }   
                if(target<A[middle] && target>=A[left]) right= middle-1;  
                else left = middle+1;  
            }
            
        }  
        return false;  
    }  
//==========================================================
	//Dublicates B
	public boolean searchB(int[] A, int target) {
		int low = 0;
		int high = A.length - 1;
		int mid = 0;
		while (low <= high) {
			mid = (low + high) / 2;
			if (A[mid] == target)
				return true;
			else if (A[low] != A[high]) {
				if (A[low] <= A[mid]) {
					if (target >= A[low] && target < A[mid]) {
						high = mid - 1;
					} else {
						low = mid + 1;
					}
				} else {
					if (target <= A[high] && target > A[mid]) {
						low = mid + 1;
					} else {
						high = mid - 1;
					}
				}
			} else {
				for (int k = low; k < high; k++) {
					if (A[k] == target)
						return true;
				}
				return false;
			}
		}
		return true;
	}
}