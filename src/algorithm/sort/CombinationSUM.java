package algorithm.sort;

import java.util.Arrays;

import java.util.ArrayList;
/*given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7] 
[2, 2, 3] 
*/
public class CombinationSUM {

		    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
	      Arrays.sort(candidates);
	        ArrayList<ArrayList<Integer>> prev = new ArrayList<ArrayList<Integer>>();
	        prev.add(new ArrayList<Integer>());
	        return combinationSum(candidates,target,0,prev);
	    }
	    
	    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target, int i, ArrayList<ArrayList<Integer>> prev){
	        ArrayList<ArrayList<Integer>> res = new  ArrayList<ArrayList<Integer>>();
	        if(target==0){
	            for(ArrayList<Integer> temp:prev){
	                ArrayList<Integer> temp1 = new ArrayList<Integer>(temp);   
	                res.add(temp1);
	            }    
	            return res;
	        }    
	        for(int j=i;j<candidates.length;j++){
	            if(candidates[j]>target)
	                break;
	            for(ArrayList<Integer> temp:prev)
	                temp.add(candidates[j]);    
	            ArrayList<ArrayList<Integer>> next = combinationSum(candidates,target-candidates[j],j,prev);
	            if(next.size()>0)
	                res.addAll(next);
	            for(ArrayList<Integer> temp:prev)
	                temp.remove(temp.size()-1);
	            }
	        return res;
	    }
	}
	  
	    