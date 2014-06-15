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
	/*�����������м俼��ʱ����ˮ��������ɣ����˽�С�ĸ߶ȣ�����������֮��Ŀ�ȣ������ġ�
	 * ��¼�ʼ�ĳ�ˮ���Ϊans1��Ȼ��L�����˶���R�����˶�����ֹ������L >= R,
	 * ���Ҽ�¼��ˮ�����ans��ȡ���ֵ

��L�����˶�Ϊ��������ȼ�Сʱ����������󣬱�Ȼ�߶�Ҫ���ӣ�
���Lֻ��ȡ��ǰһ��L���ֵ���ɣ���ʼL�ĸ߶�ΪL1��R�����˶�ͬ��*/
	 
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

