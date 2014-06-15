package algorithm.sort;

public class RemoveDuplicatedFromSortedArray {
	public int removeDuplicate(int[] A){
	if(A.length<2) return A.length;
	  int j = 0;
      int i = 1;

      while(i < A.length){
          if(A[i] == A[j]){
              i++;
          }else{
              A[++j] = A[i++];
          }    
      }

      return j+1;
  }
//=========================================
	/*duplicates are allowed at most twice?

	For example,
	Given sorted array A = [1,1,1,2,2,3],

	Your function should return length = 5, and A is now [1,1,2,2,3].*/

public int removeDuplicates(int[] A) {
		if (A == null || A.length == 0)
			return 0;
 
		int pre = A[0];
		boolean flag = false;
		int count = 0;
 
		// index for updating
		int o = 1;
 
		for (int i = 1; i < A.length; i++) {
			int curr = A[i];
 
			if (curr == pre) {
				if (!flag) {
					flag = true;
					A[o++] = curr;
 
					continue;
				} else {
					count++;
				}
			} else {
				pre = curr;
				A[o++] = curr;
				flag = false;
			}
		}
 
		return A.length - count;
	}
//==============================================================
//Better Solution
public int removeDuplicatesB(int[] A) {
	if (A.length <= 2)
		return A.length;

	int prev = 1; // point to previous
	int curr = 2; // point to current

	while (curr < A.length) {
		if (A[curr] == A[prev] && A[curr] == A[prev - 1]) {
			curr++;
		} else {
			prev++;
			A[prev] = A[curr];
			curr++;
		}
	}

	return prev + 1;
}

//============================================
//水印人生答案

public int removeDuplicatesC(int[] A) {
    // Start typing your Java solution below
    // DO NOT write main() function
    if(A.length<=2) return A.length;
    int i=2, j=1;
    int[] buf = new int[2];
    buf[0] = A[0];
    buf[1] = A[1];
    
    while(i<A.length){
        if(A[i]>buf[1] || (A[i]==buf[1] && A[i]>buf[0])){
            if(A[i]==buf[1]) buf[0]=A[i];
            buf[1]=A[i];
            i++;
            j=Math.max(1,j-1);
        }else if(i+j<A.length){
                int temp=A[i+j];
                A[i+j]=A[i];
                A[i]=temp;
                j++;
        }else break;
    }
    return i;
}
}


