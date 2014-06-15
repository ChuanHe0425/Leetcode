package algorithm.sort;

import java.util.HashMap;

public class SingleNumberInArray {

	public class Solution {
	    public int singleNumber(int[] A) {
	            HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	        for(int i = 0; i < A.length; i++){
	             int index = 0;
	             int number = 0;

	            number = A[i];
	            if (map.containsKey(number)) {
	                index = map.get(number);
	                ++index;
	            } else {
	                ++index;
	            }
	            map.put(number, index);
	        }
	        int solution = 0;
	        for (int j = 0; j < A.length; j++){
	            if(map.get(A[j]) == 1){
	                 solution = A[j];
	            }
	        }
	        return solution;
	    }

	}
}

	        
	        
	    
