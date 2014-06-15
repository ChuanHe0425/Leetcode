package algorithm.sort;

/*
Given an array of non-negative integers, you are initially positioned 
at the first index of the array.
 
Each element in the array represents your maximum jump length at that 
position.
 
Your goal is to reach the last index in the minimum number of jumps.
 
For example:
Given array A = [2,3,1,1,4]
 
The minimum number of jumps to reach the last index is 2. 
(Jump 1 step from index 0 to 1, then 3 steps to the last index.)
*/
/* Greedy Algorithm. the main idea is try to find the longest distance
 *  by each jump can reach and check if this distance can pass the total 
 *  length of this array, of course we should have a variable to keep 
 *  record of the current steps. if this distance cannot pass the total
 *   length of this array, then we should go through all the position 
 *   within this distance to see if it can pass the array by jumping from
 *    there
 */

 
 
public class JumpGameII {
    public int jump(int[] A) {
        if (A==null||A.length==0){
            return -1;
        }
        
        if (A.length==1){
            return 0;
        }
        
        int minStep=0;
        
        int start=0;
        // current longest distance the jump can reach
        int end=A[start];
        
        // if current longest distance plus current postion passed the length of array
        // then return current minStep + 1;
        if (start+end>=A.length-1){
            return minStep+1;
        }
        
        while(end<A.length-1){
            minStep++;
            
            // record farest position can be reached by jump from position within current farest position
            int max=0;
            
            for (int i=start; i<=end; i++){
                int current=i+A[i];
                // pass the total length, return minStep+1, 
                
                if (current>=A.length-1){
                    return minStep+1;
                }
                
                max=Math.max(max, current);
            }
            // update start position(items in array are not negative, so end+1 is exist)
            start=end+1;
            // update the most far position can reached for next jump
            end=max;
        }
 
        return minStep;
    }
}
