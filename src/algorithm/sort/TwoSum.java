package algorithm.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class TwoSum {
/*public int[] twoSum(int[] numbers, int target) {
       for(int i = 0; i< numbers.length-1; i++){
    	   if(numbers[i] <=target/2){
    		   int first = numbers[i];
    		   int index1 = i;
    		   int second = target - first;
    		   return index1;
    	   }
    	   
    	   
    	   }
              
       for(int j = index1; j< numbers.length-1; j++){
    	   if(numbers[j] = second){
    		   
    		   int index2 = j;
    		   
   
    }
}
*/
	//===========================
	//利用hashmap的O(n)的算法，原理和暴力搜索没有本质区别，只不过hashmap的搜索速度是O(1)。
	public int[] twoSumB(int[] numbers, int target) {
	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	int[] result = new int[2];
 
	for (int i = 0; i < numbers.length; i++) {
		if (map.containsKey(numbers[i])) {
			int index = map.get(numbers[i]);
			result[0] = index+1 ;
			result[1] = i+1;
			break;
		} else {
			map.put(target - numbers[i], i);
		}
	}
 
	return result;
    }
	//===================   
	//===================   
	    public class Element{
	        int val;
	        int index;
	        Element(int val, int index){
	            this.val=val;
	            this.index=index;
	        }
	    }
	 
	    public int[] twoSum(int[] numbers, int target) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        Element[] e = new Element[numbers.length];
	        for(int i=0;i<numbers.length;i++){
	            e[i]=new Element(numbers[i],i);
	        }
	        Arrays.sort(e, new Comparator<Element>(){public int compare(Element a, Element b){ return a.val>b.val?1:(a.val==b.val?0:-1);}});
	        
	        int i=0,j=numbers.length-1;
	        int[] res = new int[2];
	        while(i<j){
	            int temp = e[i].val+e[j].val;
	            if(temp==target){
	                res[0]=Math.min(e[i].index,e[j].index)+1;
	                res[1]=Math.max(e[i].index,e[j].index)+1;
	                return res;
	            }else if(temp>target)
	                j--;
	            else
	                i++;
	        }
	        return res;
	    }
	}

