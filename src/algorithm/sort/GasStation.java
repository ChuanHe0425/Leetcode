package algorithm.sort;

public class GasStation {
/*
This question is prrety like the longest consecutive sequence problem. 
 
To check if car can go through the gas stations, we have to check two points,
 
first, if total gas is enough for total cost, this point can be easily checked by sum all 
gas[i]-cost[i].
second point, what is the start point? it is a little bit harder to finish in O (n).
however, we can consider this problem in another angel which is if the gas[i]-cost[i]<0 which
mean the i can not been an start point. 
 
So we assume start point at 0, and we also declare two varibles which are sum and total, sum is used
to record the total   from gas[i]-cost[i], 0<=i<=n, unitl  i position . if sum <0 which mean before i can not be start
point, then we increase start pont one position and sum changed back to 0. 
 
However, at the end , if the final start point is what we want? maybe, it is also decided by the
total valuable. total is the sum of all gas[i]-cost[i]. our final start point is
an valid one  only when total>= 0,  or we should return -1;
 
*/
		    public int canCompleteCircuit(int[] gas, int[] cost) {
	       if (gas==null|| cost==null||gas.length==0||cost.length==0||gas.length!=cost.length){
	            return -1;
	        }
	        
	        int sum=0;
	        
	        int start=0;
	        
	        int total=0;
	        
	        for (int i=0; i<gas.length; i++){
	            sum+=gas[i]-cost[i];
	            total+=sum;
	            if (sum<0){
	                start=i+1;
	                sum=0;
	            }
	            
	        }
	        
	        if (total<0){
	            return -1;
	        }
	        
	        return start;
	        
	    }
	  
	    }
