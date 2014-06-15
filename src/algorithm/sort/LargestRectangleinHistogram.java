package algorithm.sort;
import java.util.Stack;
import java.util.Arrays;
//http://www.cnblogs.com/lichen782/p/leetcode_Largest_Rectangle_in_Histogram.html
public class LargestRectangleinHistogram {

	
	    public int largestRectangleArea(int[] height) {
	      
	       
	        Stack<Integer> stack = new Stack<Integer>();
	        int i = 0;
	        int maxArea = 0;
	        int[] h = new int[height.length + 1];
	        h = Arrays.copyOf(height, height.length + 1);
	        while(i < h.length){
	            if(stack.isEmpty() || h[stack.peek()] <= h[i]){
	                stack.push(i++);
	            }else {
	                int t = stack.pop();
	                maxArea = Math.max(maxArea, h[t] * (stack.isEmpty() ? i : i - stack.peek() - 1));
	            }
	        }
	        return maxArea;
	    }
	    }  
	    

