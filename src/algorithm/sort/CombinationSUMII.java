package algorithm.sort;

import java.util.Arrays;
import java.util.ArrayList;
/*For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
A solution set is: 
[1, 7] 
[1, 2, 5] 
[2, 6] 
[1, 1, 6] */
public class CombinationSUMII {
	public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
	Arrays.sort(num);
    ArrayList<ArrayList<Integer>> prev = new ArrayList<ArrayList<Integer>>();
    prev.add(new ArrayList<Integer>());
    return combinationSum(num,target,0,prev);
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
        if(j==i || candidates[j]!=candidates[j-1]){    
            for(ArrayList<Integer> temp:prev)
                temp.add(candidates[j]);    
            ArrayList<ArrayList<Integer>> next = combinationSum(candidates,target-candidates[j],j+1,prev);
            if(next.size()>0)
                res.addAll(next);
            for(ArrayList<Integer> temp:prev)
                temp.remove(temp.size()-1);
        }
    }
    return res;

}
//================================================================
public ArrayList<ArrayList<Integer>> combinationSum2b(int[] num, int target) {
 //Apply DFS continually check every combination, if any one meet the target 
	//put it into result arraylist.
   
    ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
    if (num==null||num.length==0){
        return result;
    }
    
    ArrayList<Integer> current=new ArrayList<Integer>();
  
    int start=0;
    
    Arrays.sort(num);
    
    buildResult(num,start, target, current, result);
    
    return result;
    
}

private void buildResult(int[] num, int start, int target, ArrayList<Integer> current, ArrayList<ArrayList<Integer>> result){
    if (target==0){

        ArrayList<Integer> temp=new ArrayList<Integer>(current);
        result.add(temp);
        
        return;
    }

    
    for (int i=start; i<num.length; i++){
        if (num[i]>target){
            continue;
        }
        
        current.add(num[i]);
        buildResult(num,i+1, target-num[i], current,result);
        current.remove(current.size()-1);
        while(i+1<num.length && num[i]==num[i+1]){
            i++;
        }
    }
    
}

}
