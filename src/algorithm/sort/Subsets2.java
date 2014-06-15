package algorithm.sort;

import java.util.Arrays;

public class Subsets2 {

		    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
	        
	    
	        
	        if(num==null) return null;
	        Arrays.sort(num);
	        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	        ArrayList<ArrayList<Integer>> prev = new ArrayList<ArrayList<Integer>>();   
	            
	        for(int i=num.length-1;i>=0;i--){
	            if(i==num.length-1||num[i]!=num[i+1]||prev.size()==0){           
	                prev = new ArrayList<ArrayList<Integer>>();
	                for(int j=0;j<res.size();j++){
	                        prev.add(new ArrayList<Integer>(res.get(j)));
	                }
	            }
	            
	            for(ArrayList<Integer> temp:prev){
	                 temp.add(0,num[i]);
	            }
	                
	            if(i==num.length-1||num[i]!=num[i+1]){
	                ArrayList<Integer> temp1 = new ArrayList<Integer>();
	                temp1.add(num[i]);
	                prev.add(temp1);    
	            }
	            
	            for(ArrayList<Integer> temp:prev){
	                res.add(new ArrayList<Integer>(temp));
	            }
	        }
	        res.add(new ArrayList<Integer>());
	        return res;
	    }
	}
