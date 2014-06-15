package algorithm.sort;

public class ContaintheMostWater {
	 public int maxArea(int[] height) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        int start=0, end=height.length-1, res=0;
	        while(start<end){
	            int min = Math.min(height[start],height[end]);
	            res=Math.max(res,(end-start)*min);
	            if(height[start]<height[end]){
	                while(start<end && height[start]<=min) start++;
	            }else if(height[start]>height[end]){
	                  while(start<end && height[end]<=min) end--;
	            }else{
	                  while(start<end && height[start]<=min) start++;
	                  while(start<end && height[end]<=min) end--;
	            }
	        }
	        return res;
	    }
	 //======================================
	/*当从两边向中间考虑时，乘水的面积是由（两端较小的高度）×（两个板之间的宽度）决定的。
	 * 记录最开始的乘水面积为ans1，然后L向右运动，R向左运动，截止条件是L >= R,
	 * 并且记录乘水的面积ans，取最大值

以L向左运动为例，当宽度减小时，如果面积变大，必然高度要增加，
因此L只需取比前一个L大的值即可，初始L的高度为L1。R向右运动同理*/
	 
		    public int maxAreaB(int[] height) {
		        int i, j, lh, rh, area, tmp, len = height.length;

		        lh = height[0];
		        rh = height[len - 1];
		        area = Math.min(height[0], height[len - 1]) * (len - 1);

		        for (i = 1, j = len - 2; i < j;) {
		            while (i < j && height[i] <= lh) {
		                i++;
		            }
		            if (i < j) {
		                lh = height[i];
		            }

		            while (j < j && height[j] <= rh) {
		                j--;
		            }
		            if (i < j) {
		                rh = height[j];
		            }

		            tmp = Math.min(lh, rh) * (j - i);

		            if (tmp > area) {
		                area = tmp;
		            }
		        }

		        return area;
		    }
		} 

